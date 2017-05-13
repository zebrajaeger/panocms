module.exports = function(paths, gulp, plugins) {
    // Return bundles
    return {
        app: [
            plugins.path.resolve(paths.src, 'javascript/app/**/*.js')
        ]
    };
};
