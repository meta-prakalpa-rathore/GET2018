angular.
module('shoppingCart').
config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');

        $routeProvider.
        when('/home', {
            template: '<item-list></item-list>'
        }).
        when('/cart', {
            template: '<shopping-cart-list></shopping-cart-list>'
        }).
        when('/check-out', {
            template: '<shipping-details></shipping-details>'
        }).
        when('/order-success', {
            template: '<order-success></order-success>'
        }).
        when('/my-orders', {
            template: '<order-list></order-list>'
        }).
        otherwise('/home');
    }
  ]);
