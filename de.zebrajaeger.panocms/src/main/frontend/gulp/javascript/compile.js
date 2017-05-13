module.exports = function(paths, gulp, plugins) {
    function processCompile(name, glob, options) {
        return gulp.src(glob)
            .pipe(plugins.dev(plugins.sourcemaps.init()))
            .pipe(plugins.eslint(options.eslint))
            .pipe(plugins.eslint.format())
            .pipe(plugins.eslint.failAfterError())
            .pipe(plugins.concat(name + '.js'))
            .pipe(plugins.prod(plugins.uglify()))
            .pipe(plugins.prod(plugins.rename(name + '.min.js')))
            .pipe(plugins.dev(plugins.sourcemaps.write('.', { sourceRoot: '/src/javascript/' + name + '/' })))
            .pipe(gulp.dest(plugins.path.resolve(paths.tmp, 'js')));
    }

    // Return module
    return function() {
        // Get base js config
        var config = plugins.getModule('javascript/config');

        // Module options
        var options = {
            eslint: {}
        };

        var bundles = [];
        for (var bundle in config) {
            bundles.push(processCompile(bundle, config[bundle], options));
        }

        return plugins.eventStream.merge(bundles);
    };
};
