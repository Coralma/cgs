angular.module('oaApp', ['restangular','ui.router','startup.controller',
    'ng-bootstrap-grid','formatDate','infinite-scroll'])
    .config(function ($stateProvider, $urlRouterProvider,RestangularProvider,$httpProvider) {
        RestangularProvider.setBaseUrl('/fastweb');
        $httpProvider.defaults.withCredentials = true;
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

        $stateProvider
            .state('startup', {
                url: '/startup',
                controller: function($scope, $rootScope) {
                    $rootScope.mainTitle = "启动成功"
                },
                templateUrl: 'app/startup/startup.html'
            });
        $urlRouterProvider.otherwise('/startup');
    });