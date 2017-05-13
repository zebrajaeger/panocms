module.exports = function(paths, gulp, plugins) {
    // Return module
    return function(callback) {
        var files = [
            plugins.path.resolve(paths.tmp, 'assets/*'),
            plugins.path.resolve(paths.env, 'build/assets/*'),
            '!' + plugins.path.resolve(paths.env, 'build/assets/css/**'),
            '!' + plugins.path.resolve(paths.env, 'build/assets/js/**')
        ];
        if (plugins.prod()) {
            files.push(plugins.path.resolve(paths.env,'dist/assets/*'));
            files.push('!' + plugins.path.resolve(paths.env,'dist/assets/css/**'));
            files.push('!' + plugins.path.resolve(paths.env,'dist/assets/js/**'));
        }
        return require('del')(files, {'force': true}, callback);
    };
};
