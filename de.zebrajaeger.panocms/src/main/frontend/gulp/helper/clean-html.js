module.exports = function(paths, gulp, plugins) {
    // Return module
    return function(callback) {
        var files = [plugins.path.resolve(paths.tmp, 'html/**/*.html'), plugins.path.resolve(paths.env, 'build/**/*.html')];
        // if (plugins.prod()) {
        //     files.push(plugins.path.resolve(paths.env, 'staging/**/*.html'));
        // }
        return require('del')(files, {'force': true}, callback);
    };
};
