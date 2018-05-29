angular.module('todoApp')
	.factory('todoSvc', function($http, $q) {
		
		return {
			getAllTodos: function() {
				return $http.get("/todos/")
					.then(function(response) {
						return response.data;
					});
				
			},
			getTodo: function(todoNo) {
				return $http.get("/todos/" + todoNo)
					.then(function(response) {
						return response.data;
					})
			}
		}
	});