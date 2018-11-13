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

        $scope.placeOrder = function () {
            $rootScope.cartCount = 0;
            var order = {
                "customerName": $rootScope.customerName,
                "date": new Date()
            }

            $http({
                method: 'POST',
                url: 'http://localhost:3000/orders/',
                data: order,
                dataType: 'json'
            });

            $http.get('http://localhost:3000/cart').then(function (response) {
                self.cartItems = response.data;

                self.cartItems.forEach(item => {
                    $http.get('http://localhost:3000/items/' + item.id).then(function successCallback(response) {
                        response.data.count = 0;

                        $http({
                            method: 'PUT',
                            url: 'http://localhost:3000/items/' + item.id,
                            data: response.data,
                            dataType: 'json'
                        });
                    });

                    $http({
                        method: 'DELETE',
                        url: 'http://localhost:3000/cart/' + item.id
                    });
                });
            });
            
            window.location.href="#!/order-success";
        }
}]
});
