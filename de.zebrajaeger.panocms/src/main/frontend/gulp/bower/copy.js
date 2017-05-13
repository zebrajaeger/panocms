module.exports = function(paths, gulp, plugins) {
    return function() {
        if (plugins.dev()) {
            gulp.src(plugins.path.resolve(paths.tmp, 'css/**/bower.css'))
                .pipe(gulp.dest(plugins.path.resolve(paths.env, 'build/assets/css')));
            gulp.src(plugins.path.resolve(paths.tmp, 'js/**/bower.js'))
                .pipe(gulp.dest(plugins.path.resolve(paths.env, 'build/assets/js')));
        }
    };
};
