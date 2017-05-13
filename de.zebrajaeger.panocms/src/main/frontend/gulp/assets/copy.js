module.exports = function(paths, gulp, plugins) {
    return function() {
        var files = [plugins.path.resolve(paths.tmp, 'assets/**/*'), plugins.path.resolve(paths.src, 'assets/**/*')];
        return gulp.src(files)
            .pipe(plugins.dev(gulp.dest(plugins.path.resolve(paths.env, 'build/assets'))))
            .pipe(plugins.prod(gulp.dest(plugins.path.resolve(paths.env,'dist/assets'))));
    };
};
