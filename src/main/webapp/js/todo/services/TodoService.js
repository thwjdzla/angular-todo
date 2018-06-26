angular.module('todoApp')
.factory('todoSvc', function($http) {
	
	var todoService = {
		// 서버로부터 전체 데이터 조회
		getAllTodos: function() {
			/* 아래와 코딩이 같다
			var promise1 = $http.get('/todos/');
			var promise2 = promise1.then(function(response) {
				return response.data;
			});
			return promise2;
			*/
			return $http.get('/todos/')
					.then(function(response) {
						return  response.data;
					})
		},
		// 서버로부터 지정된 번호에 해당하는 데이터 조회
		getTodo: function(no) {
			return $http.get('/todos/' + no)
					.then(function(response) {
						return response.data;
					})
		},
		deleteTodo: function(no) {
			
		},
		deleteAllTodo: function() {
			
		},
		updateTodo: function() {
			
		}
	}
	
	return todoService;
})



