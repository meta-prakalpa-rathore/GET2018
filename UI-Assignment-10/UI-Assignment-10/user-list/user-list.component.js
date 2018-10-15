angular.
  module('userList').
  component('userList', {
    templateUrl: 'user-list/user-list.template.html',
    controller: ['$http', '$scope',  function UserListController($http, $scope) {
        var self = this;
        
        $scope.resetErrors = function() {
            nameErr.innerHTML = "";
            document.getElementById("name").style.borderColor = "";
            phoneErr.innerHTML = "";
            document.getElementById("phone").style.borderColor = "";
            addressErr.innerHTML = "";
            document.getElementById("address").style.borderColor = "";
        }
        
        $scope.resetUser = function() {
            self.user = {
                name : null,
                phone : null,
                address : null,
                picture: "images/user-image.png",
                userIndex : null
            }
            self.header = "Add";  
            $scope.resetErrors();
        }
        
        $scope.resetUser();

        $scope.addUser = function() {
            if($scope.nameValidate() & $scope.phoneValidate() & $scope.addressValidate()) {
                if(self.user.userIndex != null)
                    self.users[self.user.userIndex] = angular.copy(self.user);
                else
                    self.users.push(angular.copy(self.user));
                
                $('#addUserModal').modal('hide');
            }
        }
        
        $scope.searchUser = function() {
            self.query = document.getElementById("search-keyword").value;
        }
        
        $scope.setUser = function(userIndex) {
            self.user = self.users[userIndex];
            self.user.userIndex = userIndex;
            self.header = "Edit";
            $scope.resetErrors();
        }
        
        $scope.nameValidate = function() {
            var nameElement = document.getElementById("name");
            var nameRegEx = /^[a-zA-Z\s]*$/;

            if(nameElement.value == "") {
                nameElement.style.border = "solid thin red";
                nameErr.innerHTML = "This field is required";
                return false;
            }
            else if (nameElement.value.length < 2 || !nameRegEx.test(nameElement.value)) {
                nameElement.style.border = "solid thin red";
                nameErr.innerHTML = "Invalid name";
                return false;
            }
            else {
                nameErr.innerHTML = "";
                nameElement.style.borderColor = "";
                return true;
            }
        }
        
        $scope.phoneValidate = function() {
            var phoneElement = document.getElementById("phone");
            var contactRegEx = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/;

            if(phoneElement.value == "") {
                phoneElement.style.border = "solid thin red";
                phoneErr.innerHTML = "This field is required";
                return false;
            }
            else if (phoneElement.value.length < 8 || !contactRegEx.test(phoneElement.value)){
                phoneElement.style.border = "solid thin red";
                phoneErr.innerHTML = "Invalid contact number";
                return false;
            }
            else {
                phoneErr.innerHTML = "";
                phoneElement.style.borderColor = "";
                return true;
            }
        }
        
        $scope.addressValidate = function() {
            var addressElement = document.getElementById("address");

            if(addressElement.value == "") {
                addressElement.style.border = "solid thin red";
                addressErr.innerHTML = "This field is required";
                return false;
            }
            else {
                addressErr.innerHTML = "";
                addressElement.style.borderColor = "";
                return true;
            }
        }

        $http.get('users/users.json').then(function(response) {
          self.users = response.data;
        });

      }]
  });