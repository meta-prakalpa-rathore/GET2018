angular.
module('orderSuccess').
component('orderSuccess', {
    templateUrl: 'order-success/order-success.template.html',
    controller: ['$http', '$scope', '$rootScope', function OrderSuccessController($http, $scope, $rootScope) {
        var self = this;
        $rootScope.cartCount = 0;

        var objToday = new Date(),
            months = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'),
            curMonth = months[objToday.getMonth()],
            curYear = objToday.getFullYear();
        var today = curMonth + " " + objToday.getDate() + ", " + curYear;
        var order = {
            "customerName": $rootScope.customerName,
            "date": today
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
            console.log(item);
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

}]
});
