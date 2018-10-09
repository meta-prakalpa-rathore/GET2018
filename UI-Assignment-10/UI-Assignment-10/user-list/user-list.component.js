angular.
  module('userList').
  component('userList', {
    templateUrl: 'user-list/user-list.template.html',
    controller: ['$http', '$scope',  function UserListController($http, $scope) {
        var self = this;
        self.user = {
            name : null,
            phone : null,
            address : null,
            picture: "images/user-image.png",
            userIndex : null
        }

        $scope.addUser = function() {
            if(self.user.userIndex != null)
                self.users[self.user.userIndex] = self.user;
            else
                self.users.push(self.user);
        }
        
        $scope.searchUser = function() {
            self.query = document.getElementById("searchKeyword").value;
        }
        
        $scope.setUser = function(userIndex) {
            if(userIndex != null) {
                self.user.name = self.users[userIndex].name;
                self.user.phone = self.users[userIndex].phone;
                self.user.address = self.users[userIndex].address;
                self.user.userIndex = userIndex;
            }
            else {
                self.user.userIndex = null;
                self.user.name = null;
                self.user.phone = null;
                self.user.address = null;
            }
        }

        $http.get('users/users.json').then(function(response) {
          self.users = response.data;
        });

      }]
  });