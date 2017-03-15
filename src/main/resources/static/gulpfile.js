var gulp                = require('gulp');
var rename              = require('gulp-rename');
var less                = require('gulp-less');

gulp.task('less', function () {
    gulp.src('./assets/less/colors.less')
        .pipe(less())
        .pipe(rename("styles.css"))
        .pipe(gulp.dest('./assets/css'));
});

gulp.task('default', ['less'], function () {
    gulp.watch('./assets/less/**/*.less', ['less']);
});
