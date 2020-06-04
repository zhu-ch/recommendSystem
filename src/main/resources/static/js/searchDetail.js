let app = new Vue({
    el: '#app',
    data: {
        urls: {
            getMoviesByName: 'http://localhost:8666/api/movie/getMoviesByName'
        },
        page: {
            userName: '',
            show: false
        },
        searchMovieName: '',
        searchResult: [],
        recommendMovie: {}
    },
    methods: {
        search: function () {
            let app = this;
            window.open("./searchDetail.html?" + app.searchMovieName)
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
        }
    },
    created: function () {
        let userName = getSessionStorage('userName');
        if (userName !== null) {
            let app=this;
            this.page.userName = userName;
            let queryMovie = window.location.search.substring(1);
            ajaxPostJSON(
                this.urls.getMoviesByName,
                {'movieName': queryMovie},
                function (result) {
                    if (result.code === 'success') {
                        result.data.resultList.forEach(function (r) {
                            app.searchResult.push(r)
                        })
                    } else
                        app.$message({
                            message: '服务器错误，原因\n' + result.data,
                            type: 'error'
                        });
                },
                function () {
                    app.$message({
                        message: '未知错误',
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