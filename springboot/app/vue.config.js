module.exports = {
    lintOnSave: false,
    devServer: {
        proxy: {
            "/api": {
                target: 'http://gmall-h5-api.atguigu.cn'
            },
            '/owner-api': {
                target: 'http://localhost:9090',
            },
        }
    }
}
