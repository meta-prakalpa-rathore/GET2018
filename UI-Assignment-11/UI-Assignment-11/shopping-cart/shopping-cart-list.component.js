angular.
module('shoppingCartList').
component('shoppingCartList', {
    templateUrl: 'shopping-cart/shopping-cart-list.template.html',
    controller: ['$http', '$scope', '$rootScope', function ShoppingListController($http, $scope, $rootScope) {
        var self = this;
        self.cartTotal = 0;

        $http.get('http://localhost:3000/cart').then(function (response) {
            self.cartItems = response.data;
            var item;

            for (item in self.cartItems) {
                self.cartTotal += self.cartItems[item].price * self.cartItems[item].count;
            }
        });

        $scope.addItemToCart = function (item) {
            $rootScope.cartCount = $rootScope.cartCount + 1;

            $http.get('http://localhost:3000/items/' + item.id).then(function successCallback(response) {
                response.data.count += 1;
                self.cartTotal += response.data.price;

                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/items/' + item.id,
                    data: response.data,
                    dataType: 'json'
                });
            });

            $http.get('http://localhost:3000/cart/' + item.id).then(function successCallback(response) {
                response.data.count += 1;
                item.count += 1;

                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/cart/' + item.id,
                    data: response.data,
                    dataType: 'json'
                });
            });
        }

        $scope.removeItemFromCart = function (item) {
            $rootScope.cartCount = $rootScope.cartCount - 1;

            $http.get('http://localhost:3000/items/' + item.id).then(function successCallback(response) {
                response.data.count -= 1;
                self.cartTotal -= response.data.price;

                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/items/' + item.id,
                    data: response.data,
                    dataType: 'json'
                });
            });

            $http.get('http://localhost:3000/cart/' + item.id).then(function successCallback(response) {
                response.data.count -= 1;
                item.count -= 1;

                if (response.data.count != 0) {

                    $http({
                        method: 'PUT',
                        url: 'http://localhost:3000/cart/' + item.id,
                        data: response.data,
                        dataType: 'json'
                    });
                } else {
                    $http({
                        method: 'DELETE',
                        url: 'http://localhost:3000/cart/' + item.id
                    });
                }

            });
        }
}]
});
