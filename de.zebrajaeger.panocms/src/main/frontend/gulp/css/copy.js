module.exports = function(paths, gulp, plugins) {
    return function() {
        var files = plugins.path.resolve(paths.tmp, 'css/**/!(*.min.css)');
        if (plugins.prod()) {
            files = [
                plugins.path.resolve(paths.tmp, 'css/bower.min.css'),
                plugins.path.resolve(paths.tmp, 'css/vendor.min.css'),
                plugins.path.resolve(paths.tmp, 'css/**/*.min.css')
            ]
        }
        return gulp.src(files)
            .pipe(plugins.dev(gulp.dest(plugins.path.resolve(paths.env, 'build/assets/css'))))
            .pipe(plugins.dev(plugins.browserSync.stream({match: '**/*.css'})))
            .pipe(plugins.prod(plugins.concat('all.min.css')))
            .pipe(plugins.prod(gulp.dest(plugins.path.resolve(paths.env,'dist/assets/css'))));
    };
};
