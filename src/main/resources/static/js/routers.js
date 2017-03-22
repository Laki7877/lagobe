/**
 * Created By: Laki Sik
 * Email: mr.laki.sik@gmail.com
 * Phone: +66874414008
 */

function mainConfig($urlRouterProvider, $stateProvider, $locationProvider){
    "ngInject";

//    $locationProvider.html5Mode(true);

//    $locationProvider.html5Mode({
//        enabled: true,
//        requireBase: false
//    });



    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state("boilerplate", {
            templateUrl: "templates/boilerplate.html",
            controller: "MainController",
            controllerAs: "main",
        })
        .state("boilerplate.main", {
            url: "/",
            templateUrl: "templates/main.html",
            controller: "MainController",
            controllerAs: "main",
        })
        .state("boilerplate.privacy", {
            url: "/privacy",
            templateUrl: "templates/privacy.html",
//            controller: "UserController",
//            controllerAs: "user",
            data: {
                css: "assets/css/privacy.css"
            }
        })
//        .state("dashboard", {
//            url: "/",
//            templateUrl: "templates/dashboard.html",
//            controller: "MainController",
//            controllerAs: "main",
//        })
        .state("signup", {
            url: "/signup",
            templateUrl: "templates/signup.html",
            controller: "UserController",
            controllerAs: "user",
            data: {
                css: "assets/css/signup.css"
            }
        });
}

angular.module('MainApp')
.config(mainConfig);
