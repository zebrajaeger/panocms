module.exports = function(paths, gulp, plugins) {
    // Return module
    return function(callback) {
        var files = plugins.path.resolve(paths.tmp, 'js/**/vendor.*');
        return require('del')(files, {'force': true}, callback);
    };
};
