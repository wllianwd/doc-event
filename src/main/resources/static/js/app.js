(function() {

    /**
     * Main app
     * This file is imported in the index.html
     */
    var app = angular.module('app', ["ngRoute"]);

    /**
     * Routing by #/<url>
     */
    app.config(function ($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl: 'templates/home/home.html',
            controller: 'HomeController'
        }).otherwise('/');
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    });

    /**
     * Navigation Controller
     */
    app.controller('NavigationController', function ($rootScope, $scope, $http, $location) {

    });

    /**
     * Home Controller
     */
    app.controller('HomeController', function ($rootScope, $scope, $http, $location) {
        $rootScope.greeting = 'Hello';
    });

}).call(this);