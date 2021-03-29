angular.module('customer-invite', [])
  .controller('CustomerController', function($scope,$http) {
  $scope.customers = [];
   $http.get('/getCustomerInRange/').success(function(data) {
       $scope.customers = data;
     })
})