module.exports = function(paths, gulp, plugins) {
    return function () {
        return gulp.src(plugins.path.resolve(paths.src, 'styles/css/**/*.css'))
            .pipe(plugins.concat('vendor.css'))
            .pipe(plugins.prod(plugins.cssnano()))
            .pipe(plugins.prod(plugins.rename('vendor.min.css')))
            .pipe(gulp.dest(plugins.path.resolve(paths.tmp, 'css')));
    }
};
