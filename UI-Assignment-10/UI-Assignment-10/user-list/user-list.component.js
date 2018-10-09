angular.
  module('userList').
  component('userList', {
    templateUrl: 'user-list/user-list.template.html',
    controller: ['$http', '$scope',  function UserListController($http, $scope) {
        var self = this;
        
        $scope.resetUser = function() {
            self.user = {
                name : null,
                phone : null,
                address : null,
                picture: "images/user-image.png",
                userIndex : null
            }
            self.header = "Add";
        }
        
        $scope.resetUser();

        $scope.addUser = function() {
            if(self.user.userIndex != null)
                self.users[self.user.userIndex] = angular.copy(self.user);
            else
                self.users.push(angular.copy(self.user));
        }
        
        $scope.searchUser = function() {
            self.query = document.getElementById("search-keyword").value;
        }
        
        $scope.setUser = function(userIndex) {
            self.user = self.users[userIndex];
            self.user.userIndex = userIndex;
            self.header = "Edit";
        }
        
        $http.get('users/users.json').then(function(response) {
          self.users = response.data;
        });

      }]
  });