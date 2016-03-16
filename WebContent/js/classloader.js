/**
 * 
 */
var myApp = angular.module('myApp', []);

myApp.controller('myController', ['$scope', '$http', function($scope, $http){
    //$scope.items = [
      //              {"classloader":"Baseloader","totalloaded":"100","loadedClassesDetails":[{"classname":"adsfadsfsagasgafsgfsa"},{"classname":"fsfsdfsfsdfsadfs"}]}
        //            ,{"classloader":"Baseloader","totalloaded":"100","loadedClassesDetails":[{"classname":"adsfadsfsagasgafsgfsa"},{"classname":"fsfsdfsfsdfsadfs"}]}];
    
    
    $scope.getClassloaderInfo = function() {

		p = $http({
			//url : 'data/servers.json',
			url : 'GetClassLoadersServlet',
			method : 'get',
			cache : 'false'
		}).success(function(data, status, headers, config) {
			console.log('Success fired!');
			console.log('Status: ' + status);
			$scope.items = data;							
		}).error(function(data, status, headers, config) {
			console.error('Error fired!');
			console.log(data);
			console.log('Status: ' + status);
		});

	};
}]);