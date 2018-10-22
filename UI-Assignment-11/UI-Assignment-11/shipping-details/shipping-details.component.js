angular.
module('shippingDetails').
component('shippingDetails', {
    templateUrl: 'shipping-details/shipping-details.template.html',
    controller: ['$http', '$scope', '$rootScope', function ShippingDetailsController($http, $scope, $rootScope) {
        var self = this;
        
        $http.get('http://localhost:3000/cart').then(function (response) {
            self.cartItems = response.data;
        });
}]
});
