angular.module('todoApp', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider
			.when('/', {
				templateUrl: 'tmpl/todoList.html',
				controller: 'todoListCtrl'
			})
			.when('/todoList', {
				templateUrl: 'tmpl/todoList.html',
				controller: 'todoListCtrl'
			})
			.when('/todoDetail/:todoNo', {
				templateUrl: 'tmpl/todoDetail.html',
				controller: 'todoDetailCtrl'
			})
			.otherwise({
				redirectTo:'/todo'
			})
	})