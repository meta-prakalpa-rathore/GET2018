var shoppingCart = angular.module('shoppingCart', [
  'itemList', 'shoppingCartList', 'ngRoute', 'shippingDetails', 'orderSuccess', 'orderList'
]);

shoppingCart.controller('MainController', function MainController($rootScope, $scope, $http) {
    $rootScope.cartCount = 0;
    $rootScope.cartTotal = 0;

    $http.get('http://localhost:3000/cart').then(function (response) {
        $rootScope.cartItems = response.data;
        var item;
        for (item in $rootScope.cartItems) {
            $rootScope.cartCount += $rootScope.cartItems[item].count;
            $rootScope.cartTotal += $rootScope.cartItems[item].price;
        }
    });

    $rootScope.addItemToCart = function (item) {
        $rootScope.cartCount = $rootScope.cartCount + 1;

        $http.get('http://localhost:3000/items/' + item.id).then(function successCallback(response) {
            response.data.count += 1;
            $rootScope.cartTotal += response.data.price;

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
        }, function errorCallback(response) {

            item.count = 1;
            var cartItem = {
                "id": item.id,
                "name": item.name,
                "price": item.price,
                "imagePath": item.imagePath,
                "count": 1
            }

            $http({
                method: 'POST',
                url: 'http://localhost:3000/cart/',
                data: cartItem,
                dataType: 'json'
            });

        });
    }

    $rootScope.removeItemFromCart = function (item) {
        $rootScope.cartCount = $rootScope.cartCount - 1;

        $http.get('http://localhost:3000/items/' + item.id).then(function successCallback(response) {
            response.data.count -= 1;
            $rootScope.cartTotal -= response.data.price;

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

});
