angular.
module('shippingDetails').
component('shippingDetails', {
    templateUrl: 'shipping-details/shipping-details.template.html',
    controller: ['$http', '$scope', '$rootScope', function ShippingDetailsController($http, $scope, $rootScope) {
        var self = this;
        self.cartTotal = 0;

        $http.get('http://localhost:3000/cart').then(function (response) {
            self.cartItems = response.data;
            var item;

            for (item in self.cartItems) {
                self.cartTotal += self.cartItems[item].price * self.cartItems[item].count;
            }
        });
}]
});
