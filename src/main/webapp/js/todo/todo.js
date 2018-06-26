// todoApp 모듈 생성
// todoApp 모듈이 사용할 ngRoute 모듈 제공받기

var app = angular.module("todoApp", ['ngRoute']);

// ngRoute 모듈에 정의된 $routeProvider 서비스 제공받기
app.config(function($routeProvider) {
	
	// url 라우팅하기
	$routeProvider
		.when("/", {
			templateUrl: 'js/todo/tmpl/todoList.html',
			controller: 'todoListCtrl'
		})
		.when("/todoList", {
			templateUrl: 'js/todo/tmpl/todoList.html',
			controller: 'todoListCtrl'
		})
		// :뒤에 값이 올건데 no라는 이름으로 받아먹겠다.
		.when("/todoDetail/:no", {
			templateUrl: 'js/todo/tmpl/todoDetail.html',
			controller: 'todoDetailCtrl'
		})
});

