angular.
module('orderList').
component('orderList', {
    templateUrl: 'order-list/order-list.template.html',
    controller: ['$http', '$scope', '$rootScope', function OrderListController($http, $scope, $rootScope) {
        var self = this;

        $http.get('http://localhost:3000/orders').then(function (response) {
            self.orders = response.data;
        });

      }]
});
