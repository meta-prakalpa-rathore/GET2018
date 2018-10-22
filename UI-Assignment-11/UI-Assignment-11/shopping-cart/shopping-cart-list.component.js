angular.
module('shoppingCartList').
component('shoppingCartList', {
    templateUrl: 'shopping-cart/shopping-cart-list.template.html',
    controller: ['$http', '$scope', '$rootScope', function ShoppingListController($http, $scope, $rootScope) {
        var self = this;

        $http.get('http://localhost:3000/cart').then(function (response) {
            self.cartItems = response.data;
        });
}]
});
