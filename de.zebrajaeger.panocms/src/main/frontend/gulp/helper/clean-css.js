module.exports = function(paths, gulp, plugins) {
    // Return module
    return function(callback) {
        var files = [
            plugins.path.resolve(paths.tmp, 'css/**/*.css'),
            '!' + plugins.path.resolve(paths.tmp, 'css/**/bower.css'),
            '!' + plugins.path.resolve(paths.tmp, 'css/**/bower.min.css'),
            '!' + plugins.path.resolve(paths.tmp, 'css/**/vendor.css'),
            '!' + plugins.path.resolve(paths.tmp, 'css/**/vendor.min.css')
        ];
        if (plugins.prod()) {
            files.push(plugins.path.resolve(paths.env,'dist/assets/css/**/*'));
        }
        return require('del')(files, {'force': true}, callback);
    };
};
