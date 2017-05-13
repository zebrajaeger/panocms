module.exports = function(paths, gulp, plugins) {
    // Return module
    return function(callback) {
        var files = [
            plugins.path.resolve(paths.tmp, 'js/**/*.js'),
            '!' + plugins.path.resolve(paths.tmp, 'js/**/bower.js'),
            '!' + plugins.path.resolve(paths.tmp, 'js/**/bower.min.js')
        ];
        if (plugins.prod()) {
            files.push(plugins.path.resolve(paths.env,'dist/assets/js/**/*'));
        }
        return require('del')(files, {'force': true}, callback);
    };
};
