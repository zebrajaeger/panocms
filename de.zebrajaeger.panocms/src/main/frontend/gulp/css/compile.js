module.exports = function(paths, gulp, plugins) {
    var autoprefixer = require('autoprefixer');

    function processCompile(name, glob, options) {
        var cssTasks = [
            autoprefixer(options.autoprefixer)
        ];

        return gulp.src(glob)
            .pipe(plugins.dev(plugins.sourcemaps.init()))
            .pipe(plugins.sassGlob())
            .pipe(plugins.sass(options.sass).on('error', plugins.sass.logError))

            // Process PostCSS
            .pipe(plugins.postcss(cssTasks))

            .pipe(plugins.prod(plugins.cssnano()))
            .pipe(plugins.prod(plugins.concat(name + '.min.css')))
            .pipe(plugins.dev(plugins.sourcemaps.write('.', { sourceRoot: '/src/styles/scss/' })))
            .pipe(gulp.dest(plugins.path.resolve(paths.tmp, 'css')));
    }

    // Return module
    return function() {
        // Get base css config
        var config = plugins.getModule('css/config');

        // Module options
        var options = {

            autoprefixer: {
                browsers: ['> 2%', 'IE >= 10', 'iOS >= 8'],
                cascade: false,
                map: true,
                remove: true
            },

            sass: {
                errLogToConsole: true,
                includePaths: [
                    'node_modules'
                ],
                outputStyle: 'expanded'
            }
        };

        var bundles = [];
        for (var bundle in config) {
            bundles.push(processCompile(bundle, config[bundle], options));
        }

        return plugins.eventStream.merge(bundles);
    };
};
