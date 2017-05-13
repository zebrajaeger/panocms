'use strict';

/*
* VARIABLES + CONSTANTS
* */
const gulp = require('gulp');
const plugins = require('gulp-load-plugins')();
const http = require('http');

plugins.sassGlob = plugins.sassGlob2;
plugins.fs = require('fs');
plugins.path = require('path');
plugins.fileExists = require('file-exists');
plugins.eventStream = require('event-stream');
plugins.runSequence = require('run-sequence');
plugins.browserSync = require('browser-sync').create();
plugins.dev = plugins.environments.development;
plugins.prod = plugins.environments.production;

var config = require('./.project.json');

plugins.getModule = function(task) {
    return require(plugins.path.resolve(config.paths.tasks, task))(config.paths, gulp, plugins);
};

/*
* CHILD TASKS
* */

// CLEANUP
gulp.task('clean-tmp', plugins.getModule('helper/clean-tmp'));
gulp.task('clean-css', plugins.getModule('helper/clean-css'));
gulp.task('clean-vendor-css', plugins.getModule('helper/clean-vendor-css'));
gulp.task('clean-vendor-js', plugins.getModule('helper/clean-vendor-js'));
gulp.task('clean-js', plugins.getModule('helper/clean-js'));
gulp.task('clean-bower', plugins.getModule('helper/clean-bower'));
gulp.task('clean-html', plugins.getModule('helper/clean-html'));
gulp.task('clean-assets', plugins.getModule('helper/clean-assets'));

// COMPILING
gulp.task('compile-css',  plugins.getModule('css/compile'));
gulp.task('vendor-css', plugins.getModule('css/vendor'));
gulp.task('compile-js', plugins.getModule('javascript/compile'));
gulp.task('vendor-js', plugins.getModule('javascript/vendor'));
gulp.task('compile-bower', plugins.getModule('bower/compile'));
gulp.task('compile-html', plugins.getModule('html/compile'));

// LINTING
gulp.task('lint-scss', plugins.getModule('css/lint'));

// COPYING
gulp.task('copy-bower', plugins.getModule('bower/copy'));
gulp.task('copy-css', plugins.getModule('css/copy'));
gulp.task('copy-js', plugins.getModule('javascript/copy'));
//gulp.task('copy-html', plugins.getModule('html/copy'));
gulp.task('copy-assets', plugins.getModule('assets/copy'));

/*
* MAIN TASKS
* */
gulp.task('build-js', function(callback){
    plugins.runSequence(
        'clean-bower',
        'compile-bower',
        'copy-bower',
        ['clean-js', 'clean-vendor-js'],
        ['compile-js', 'vendor-js'],
        'copy-js',
        callback
    );
});

gulp.task('build-css', ['lint-scss'], function(callback){
    plugins.runSequence(
        'clean-bower',
        'compile-bower',
        'copy-bower',
        ['clean-css', 'clean-vendor-css'],
        ['compile-css', 'vendor-css'],
        'copy-css',
        callback
    );
});

gulp.task('build-html', function(callback){
    plugins.runSequence(
        'clean-html',
        'compile-html',
        'copy-html',
        callback
    );
});

gulp.task('build-assets', function(callback){
    plugins.runSequence(
        'clean-bower',
        'compile-bower',
        'copy-bower',
        'copy-assets',
        callback
    );
});

gulp.task('build', ['lint-scss'], function(callback){
    plugins.runSequence(
        'clean-bower',
        'compile-bower',
        'copy-bower',
        ['clean-js', 'clean-vendor-js'],
        ['compile-js', 'vendor-js'],
        'copy-js',
        ['clean-css', 'clean-vendor-css'],
        ['compile-css', 'vendor-css'],
        'copy-css',
    //    'clean-html',
    //    'compile-html',
    //    'copy-html',
        'copy-assets',
        callback
    );
});

gulp.task('watch', ['build'], function(){
    gulp.watch('src/styles/scss/**/*.scss', function(){
        plugins.runSequence('build-css');
    });
    gulp.watch('src/javascript/**/*.js', function(){
        plugins.runSequence('build-js');
    });
    gulp.watch(['src/templates/**/*.hbs', 'src/templates/data/**/*.json'], function(){
        plugins.runSequence('build-html');
    });
    gulp.watch('src/assets/**/*', function(){
        plugins.runSequence('build-assets');
    });
});

gulp.task('bs-reload', function(){
    return plugins.browserSync.reload();
});

gulp.task('serve', ['build'], function(){
    var folders = process.cwd().split(plugins.path.sep);
    var urlSegments = [
        folders[(folders.length - 5)],
        folders[(folders.length - 6)],
        'static',
        'locdev'
    ];
    var proxyHost = urlSegments.join('.');
    var httpOptions = {
        host: proxyHost,
        port: 80
    };

    http.get(httpOptions, function(res){
        plugins.browserSync.init({
            proxy: 'http://' + proxyHost,
            host: proxyHost,
            open: 'external'
        });
    }).on('error', function(e){
        plugins.browserSync.init({
            server: '../../../target/build'
        });
    });

    gulp.watch('src/styles/scss/**/*.scss', function(){
        plugins.runSequence('build-css');
    });
    gulp.watch('src/javascript/**/*.js', function(){
        plugins.runSequence('build-js', 'bs-reload');
    });
    gulp.watch(['src/templates/**/*.hbs', 'src/templates/data/**/*.json'], function(){
        plugins.runSequence('build-html', 'bs-reload');
    });
    gulp.watch('src/assets/**/*', function(){
        plugins.runSequence('build-assets', 'bs-reload');
    });
});

gulp.task('default', ['serve']);
