module.exports = function(paths, gulp, plugins) {
    return function() {
        var files = plugins.path.resolve(paths.tmp, 'html/**/*.html');
        var options = JSON.parse(plugins.fs.readFileSync('.prettifyrc'));
        return gulp.src(files)
            .pipe(plugins.prettify(options))
            .pipe(plugins.prod(plugins.htmlmin({
                'removeComments': true
            })))
            .pipe(plugins.dev(gulp.dest(plugins.path.resolve(paths.env, 'build'))));
            // .pipe(plugins.prod(gulp.dest(plugins.path.resolve(paths.env, 'dist'))));
    };
};
