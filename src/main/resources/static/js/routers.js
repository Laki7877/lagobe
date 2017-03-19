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
        .state("main", {
            url: "/",
            templateUrl: "templates/main.html",
            controller: "MainController",
            controllerAs: "main",
        })
    
        .state("test", {
            url: "/test",
            templateUrl: "templates/test.html",
            controller: "MainController",
            controllerAs: "main",
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