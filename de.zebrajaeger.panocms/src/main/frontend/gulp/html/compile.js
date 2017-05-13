module.exports = function(paths, gulp, plugins) {
    var handlebarsHelpers = require('handlebars-helpers');
    var handlebarsLayouts = require('handlebars-layouts');

    return function() {
        return gulp.src(plugins.path.resolve(paths.src, 'templates/pages/**/*.hbs'))
            .pipe(plugins.extname())
            .pipe(plugins.frontMatter({
                "property": "data.page"
            }))
            .pipe(plugins.hb({
                'cwd': plugins.path.resolve()
            })
                .data(plugins.path.resolve(paths.src, 'templates/data/**/*.json'))
                .data({
                    "assets": "/assets",
                    "timestamp": Date.now()
                })
                .partials(plugins.path.resolve(paths.src, 'templates/partials/**/*.hbs'))
                .helpers(plugins.path.resolve(paths.tasks, 'html/helpers/*.js'))
                .helpers(handlebarsHelpers)
                .helpers(handlebarsLayouts)
            )
            .pipe(gulp.dest(plugins.path.resolve(paths.tmp, 'html')));
    }
};
