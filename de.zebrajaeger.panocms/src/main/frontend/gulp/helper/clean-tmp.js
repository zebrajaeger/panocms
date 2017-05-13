module.exports = function(paths, gulp, plugins) {
    // Return module
    return function(callback) {
        var files = plugins.path.resolve(paths.tmp, '*');
        return require('del')(files, {'force': true}, callback);
    };
};
