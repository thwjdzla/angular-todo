angular.module('todoApp')
.controller('todoListCtrl', function($scope, $location, todoSvc) {
	
	$scope.todos = [];
	
	$scope.todo = {
			sort:'title',
			rows: "5"
	};
	
	var promise = todoSvc.getAllTodos();
	promise.then(function(data) {
		$scope.todos = data;
	})
	
	// $scope.$watch('표현식', callback, 객체를 비교할지 여부)
	$scope.$watch('todos', function() {
		var uncompletedTodos = $scope.todos.filter(function(todo) {
			return !todo.completed;
		});
		$scope.uncompletedTodosCount = uncompletedTodos.length; 
	}, true)
	
	// $scope --> 접착제(글루)라고 부른다. 화면하고 컨트롤러하고 이어주는 역할
	$scope.goDetail = function(no) {
		// url 이동시키기
		$location.url("/todoDetail/" + no);
	}
});


