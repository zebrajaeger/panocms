module.exports = function(paths, gulp, plugins) {
    return function () {
        gulp.src(plugins.path.resolve(paths.src, 'javascript/vendor/**/*.js'))
            .pipe(plugins.concat('vendor.js'))
            .pipe(plugins.prod(plugins.uglify()))
            .pipe(plugins.prod(plugins.rename('vendor.min.js')))
            .pipe(gulp.dest(plugins.path.resolve(paths.tmp, 'js')));
    }
};
