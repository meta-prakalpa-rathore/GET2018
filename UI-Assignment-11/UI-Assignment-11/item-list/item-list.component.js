angular.
module('itemList').
component('itemList', {
    templateUrl: 'item-list/item-list.template.html',
    controller: ['$http', '$scope', '$rootScope', function ItemListController($http, $scope, $rootScope) {
        var self = this;

        $http.get('http://localhost:3000/items').then(function (response) {
            self.items = response.data;
        });

        $scope.addItemToCart = function (item) {
            $rootScope.cartCount = $rootScope.cartCount + 1;

            $http.get('http://localhost:3000/items/' + item.id).then(function successCallback(response) {
                response.data.count += 1;

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
