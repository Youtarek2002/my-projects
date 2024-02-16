module.exports = {
  transpileDependencies: true,
  devServer: {
    port: 3000,
    proxy: {
      '/cal': {
        target: 'http://localhost:8081',
        ws: true,
        changeOrigin: true,
      },
    },
  },
};