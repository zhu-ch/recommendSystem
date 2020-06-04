let app = new Vue({
    el: '#app',
    data: {
        urls: {
            getHomepageMovies: 'http://localhost:8666/api/movie/getHomepageMovies'
        },
        page: {
            userName: '',
            show: false
        },
        searchMovieName: '',
        movieList: []
    },
    methods: {
        search: function () {
            let app = this;
            window.open("./searchDetail.html?" + app.searchMovieName, "_self")
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
        //检查登录状态
        let userName = getSessionStorage('userName');
        if (userName !== null) {
            this.page.userName = userName;
            ajaxPostJSON(
                this.urls.getHomepageMovies,
                null,
                function (result) {
                    if (result.code === 'success') {
                        result.data.resultList.forEach(function (r) {
                            app.movieList.push(r)
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
            window.open("./welcome.html")
        }, 2000);
    }
})