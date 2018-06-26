angular.module('todoApp')
.controller('todoDetailCtrl', function($scope, $location, $routeParams, todoSvc) {
	
	// 라우팅 url에서 조회할 todo번호 가져오기
	// localhost/#!/todoDetail/10000001
	// .when('/todoDetail/:no') <----- 라우팅 설정
	var no = $routeParams.no;
	
	todoSvc.getTodo(no)
		.then(function(data) {
			$scope.todo = data;
		})
	
	$scope.goTodo = function() {
		$location.url("/todoList")
	}
})


