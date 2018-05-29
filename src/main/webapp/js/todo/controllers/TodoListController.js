angular.module('todoApp')
	.controller('todoListCtrl', function($scope, $location, $filter, todoSvc) {
		$scope.todos = [];
		
		$scope.getAllTodos = function() {
			todoSvc.getAllTodos()
			.then(function(todos) {
				$scope.todos = todos;
			});
		}
		
		$scope.goDetail = function(todoNo) {
			$location.url('/todoDetail/' + todoNo);
		}
		
		$scope.$watch('todos', function() {
			$scope.remainingCount = $filter('filter')($scope.todos, { completed: false }).length;;
			$scope.completedCount = $scope.todos.length - $scope.remainingCount;
			$scope.allChecked = !$scope.remainingCount;
		}, true);
		
		$scope.getAllTodos();
		
	})