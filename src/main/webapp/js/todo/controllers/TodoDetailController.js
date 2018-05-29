angular.module('todoApp')
	.controller('todoDetailCtrl', function($scope, $location, $routeParams, todoSvc) {
		
		$scope.todo = {};
		
		todoSvc.getTodo($routeParams.todoNo)
			.then(function(todo) {
				console.log(todo);
				$scope.todo = todo;
			});
		
		$scope.goTodo = function() {
			$location.url('/todoList/');
		}
	})