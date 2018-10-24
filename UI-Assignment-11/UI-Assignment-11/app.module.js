var shoppingCart = angular.module('shoppingCart', [
  'itemList', 'shoppingCartList', 'ngRoute', 'shippingDetails', 'orderSuccess', 'orderList'
]);

shoppingCart.controller('MainController', function MainController($rootScope, $scope, $http) {
    $rootScope.cartCount = 0;

    $http.get('http://localhost:3000/cart').then(function (response) {
        var cartItems = response.data;
        var item;
        for (item in cartItems) {
            $rootScope.cartCount += cartItems[item].count;
        }
    });

});
