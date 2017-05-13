module.exports = function(paths, gulp, plugins) {
    return function() {
        var files = [plugins.path.resolve(paths.tmp, 'js/**/*.js'), '!' + plugins.path.resolve(paths.tmp, 'js/**/*.min.js')];
        if (plugins.prod()) {
            files = plugins.path.resolve(paths.tmp, 'js/**/*.min.js');
        }
        gulp.src(files)
            .pipe(plugins.dev(gulp.dest(plugins.path.resolve(paths.env, 'build/assets/js'))))
            .pipe(plugins.prod(plugins.order([
                'bower.min.js',
                'vendor.min.js',
                '**/*.min.js'
            ])))
            .pipe(plugins.prod(plugins.concat('all.min.js')))
            .pipe(plugins.prod(gulp.dest(plugins.path.resolve(paths.env,'dist/assets/js'))));
    };
};
