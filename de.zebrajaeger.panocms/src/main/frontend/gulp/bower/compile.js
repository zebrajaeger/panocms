module.exports = function(paths, gulp, plugins) {
    var map = require(plugins.path.resolve('', 'bower.mapper.json'));

    function translateBowerMap(map) {
        var basePath = plugins.path.resolve(paths.src + 'vendor/bower');
        var objComponentGroups = {};
        for (var pluginName in map) {
            var components = map[pluginName];
            var componentPath =  basePath + '/' + pluginName + '/';

            for (var componentType in components) {
                var sources = components[componentType];

                if (objComponentGroups[componentType] === undefined) objComponentGroups[componentType] = [];

                if (plugins.prod()) {
                    if (sources.min !== undefined) {
                        if (typeof sources.min === "string") {
                            if (plugins.fileExists(componentPath + sources.min)) {
                                objComponentGroups[componentType].push(componentPath + sources.min);
                            } else {
                                console.log('"' + componentPath + sources.min + '" doesn\'t exist!');
                            }
                        } else {
                            for (var file in sources.min) {
                                if (plugins.fileExists(componentPath + sources.min[file])) {
                                    objComponentGroups[componentType].push(componentPath + sources.min[file]);
                                } else {
                                    console.log('"' + componentPath + sources.min[file] + '" doesn\'t exist!');
                                }
                            }
                        }
                    } else {
                        if (typeof sources.src === "string") {
                            if (plugins.fileExists(componentPath + sources.src)) {
                                objComponentGroups[componentType].push(componentPath + sources.src);
                            } else {
                                console.log('"' + componentPath + sources.src + '" doesn\'t exist!');
                            }
                        } else {
                            for (var file in sources.src) {
                                if (plugins.fileExists(componentPath + sources.src[file])) {
                                    objComponentGroups[componentType].push(componentPath + sources.src[file]);
                                } else {
                                    console.log('"' + componentPath + sources.src[file] + '" doesn\'t exist!');
                                }
                            }
                        }
                    }
                } else {
                    if (typeof sources.src === "string") {
                        if (plugins.fileExists(componentPath + sources.src)) {
                            objComponentGroups[componentType].push(componentPath + sources.src);
                        } else {
                            console.log('"' + componentPath + sources.src + '" doesn\'t exist!');
                        }
                    } else {
                        for (var file in sources.src) {
                            if (plugins.fileExists(componentPath + sources.src[file])) {
                                objComponentGroups[componentType].push(componentPath + sources.src[file]);
                            } else {
                                console.log('"' + componentPath + sources.src[file] + '" doesn\'t exist!');
                            }
                        }
                    }
                }
            }
        }
        return objComponentGroups;
    }

    function buildStream(componentType, component) {
        var stream;
        switch (componentType) {
            case 'css':
                stream = gulp.src(component)
                    .pipe(plugins.concat('bower.css'))
                    .pipe(plugins.prod(plugins.rename('bower.min.css')))
                    .pipe(gulp.dest(plugins.path.resolve(paths.tmp + 'css/')));
                break;
            case 'js':
                stream = gulp.src(component)
                    .pipe(plugins.concat('bower.js'))
                    .pipe(plugins.prod(plugins.rename('bower.min.js')))
                    .pipe(gulp.dest(plugins.path.resolve(paths.tmp + 'js/')));
                break;
            case 'fonts':
                stream = gulp.src(component)
                    .pipe(gulp.dest(plugins.path.resolve(paths.tmp + 'assets/fonts')));
                break;
        }
        return stream;
    }

    // Return module
    return function() {
        var bowerComponents = translateBowerMap(map);
        var streams = [];

        for (var componentType in bowerComponents) {
            streams.push(buildStream(componentType, bowerComponents[componentType]));
        }

        return plugins.eventStream.merge(streams);
    };
};
