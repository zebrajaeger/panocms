module.exports = function(paths, gulp, plugins) {
    // Return bundles
    return {
        app: [
            plugins.path.resolve(paths.src, 'styles/scss/app.scss')
        ],
        vendor: [
            plugins.path.resolve(paths.src, 'styles/scss/vendor.scss')
        ]
    };
};
