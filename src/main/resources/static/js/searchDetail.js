let app = new Vue({
    el: '#app',
    data: {
        urls: {
            getMoviesByName: 'http://localhost:8666/api/movie/getMoviesByName',
            getRecommendMovies: 'http://localhost:8666/api/movie/getRecommendMovies',
            getRelatedMovies: 'http://localhost:8666/api/movie/getRelatedMovies'
            //todo wh:打分URL
        },
        page: {
            userName: '',
            show: false
        },
        table: {
            searchResult: [],
            props: {
                searchKey: '',
                pageIndex: 1,
                pageSize: 10,
                total: 0
            }
        },
        dialog: {
            show: false,
            movie: {},
            rating: 0,
            relatedMovies: []
        },
        recommendMovies: []
    },
    methods: {
        search: function () {
            let app = this;
            window.open("./searchDetail.html?" + app.table.props.searchKey)
        },
        logout: function () {
            delSessionStorage('userName');
            this.$message({
                message: "您已成功退出",
                type: 'success'
            });
            setTimeout(function () {
                window.open("./welcome.html", "_self")
            }, 2000);
        },
        getRelatedMovies: function (movie) {
            //获取相似电影推荐
            ajaxPostJSON(
                this.urls.getRelatedMovies,
                {id: movie.id},
                function (result) {
                    if (result.code === 'success') {
                        app.table.props.total = result.total;
                        result.data.resultList.forEach(function (r) {
                            app.dialog.relatedMovies.push(r)
                        })
                    } else
                        app.$message({
                            message: '服务器错误，原因\n' + result.data,
                            type: 'error'
                        });
                },
                function () {
                    app.$message({
                        message: '获取相似电影推荐失败',
                        type: 'error'
                    });
                }
            )
        },
        openDetailDialog: function (movie) {
            this.dialog.movie = movie;
            this.getRelatedMovies(movie);
            this.dialog.show = true;

        },
        closeDetailDialog: function () {
            this.dialog.show = false;
            this.dialog.movie = {};
            this.dialog.relatedMovies = [];
        },
        onRating:function () {
            //todo wh:打分
        }
    },
    created: function () {
        let userName = getSessionStorage('userName');
        if (userName !== null) {
            let app = this;
            this.page.userName = userName;
            let queryMovie = window.location.search.substring(1);
            this.table.props.searchKey = queryMovie;
            let data = {
                page: app.table.props,
                movieName: queryMovie
            };

            //获取搜索结果
            ajaxPostJSON(
                this.urls.getMoviesByName,
                data,
                function (result) {
                    if (result.code === 'success') {
                        app.table.props.total = result.total;
                        result.data.resultList.forEach(function (r) {
                            app.table.searchResult.push(r)
                        })
                    } else
                        app.$message({
                            message: '服务器错误，原因\n' + result.data,
                            type: 'error'
                        });
                },
                function () {
                    app.$message({
                        message: '获取查询结果失败',
                        type: 'error'
                    });
                }
            )

            //获取推荐结果
            ajaxPost(
                app.urls.getRecommendMovies,
                {userName: userName},
                function (result) {
                    if (result.code === 'success') {
                        result.data.resultList.forEach(function (r) {
                            app.recommendMovies.push(r)
                        })
                    } else
                        app.$message({
                            message: '服务器错误，原因\n' + result.data,
                            type: 'error'
                        });
                },
                function () {
                    app.$message({
                        message: '获取推荐结果失败',
                        type: 'error'
                    });
                }
            )

            this.page.show = true;
            return;
        }
        this.$message({
            message: "请登录",
            type: 'error'
        });
        setTimeout(function () {
            window.open("./welcome.html", "_self")
        }, 2000);
    }
})