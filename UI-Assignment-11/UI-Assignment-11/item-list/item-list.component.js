angular.
module('itemList').
component('itemList', {
    templateUrl: 'item-list/item-list.template.html',
    controller: ['$http', '$scope', '$rootScope', function ItemListController($http, $scope, $rootScope) {
        var self = this;

        $http.get('http://localhost:3000/items').then(function (response) {
            self.items = response.data;
        });

      }]
});
