module.exports = function(paths, gulp, plugins) {
    // Return module
    return function(callback) {
        var files = [
            plugins.path.resolve(paths.tmp, '**/bower.*'),
            plugins.path.resolve(paths.env, 'build/assets/**/bower.*')
        ];

        return require('del')(files, {'force': true}, callback);
    };
};
