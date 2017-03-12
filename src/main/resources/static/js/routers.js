/**
 * Created By: Laki Sik
 * Email: mr.laki.sik@gmail.com
 * Phone: +66874414008
 */

angular.module('app')
.config(function($routeProvider,$locationProvider) {
	'use strict';
	$locationProvider.hashPrefix('');
	$routeProvider
	.when('/', {
		templateUrl : 'templates/main.html',
		controller : 'mainController'
	})
	.otherwise({
		redirectTo: '/'
	});
});