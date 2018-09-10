function firstNameValidate(){
	var text = document.getElementById("fname");
	var nameRegEx = /^[a-zA-Z\s]*$/;
	if(text.value.length < 2 || !nameRegEx.test(text.value)){
		text.style.border = "solid thin red";
		fnameErr.innerHTML = "Invalid first name";
		return false;
	}
	else{
		fnameErr.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}
			
function lastNameValidate(){
	var text = document.getElementById("lname");
	var nameRegEx = /^[a-zA-Z]*$/;
	if(text.value.length < 2 || !nameRegEx.test(text.value)){
		text.style.border = "solid thin red";
		lnameErr.innerHTML = "Invalid last name";
		return false;
	}
	else{
		lnameErr.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function dobValidate(){
	var date1 = document.querySelector('input[type="date"]');
	var today = new Date();
	var date = new Date(date1.value);
	
//	if (date == "") {
//		date1.style.border = "solid thin red";
//		dobErr.innerHTML = "Please enter the Date..!!";
//        return false;
//    }
//	else if (date > today) {
//		date1.style.border = "solid thin red";
//		dobErr.innerHTML = "Current or future date is not allowed";
//        return false;
//    }
//	else{
//		dobErr.innerHTML = "";
//		date1.style.borderColor = "";
//		return true;
//	}	
	return true;
}

function emailValidate(){
	var text = document.getElementById("email");
	var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!emailRegEx.test(text.value)){
		text.style.border = "solid thin red";
		emailErr.innerHTML = "Invalid email";
		return false;
	}
	else{
		emailErr.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function passValidate(){
	var text = document.getElementById("pass");
	var passRegEx = /^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
	if(!passRegEx.test(text.value)){
		text.style.border = "solid thin red";
		passErr.innerHTML = "password must contain an uppercase letter, a lowercase letter, a number and length should be minimum 8 characters";
		return false;
	}
	else{
		passErr.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function cpassValidate(){
	var text = document.getElementById("cpass");
	if(document.getElementById("pass").value != text.value){
		text.style.border = "solid thin red";
		cpassErr.innerHTML = "Passwords don't match!";
		return false;
	}
	else{
		cpassErr.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function contactValidate(){
	var text = document.getElementById("contact");
	var contactRegEx = /^[0-9]*$/;
	if(text.value.length < 8 || !contactRegEx.test(text.value)){
		text.style.border = "solid thin red";
		contactErr.innerHTML = "Invalid contact number";
		return false;
	}
	else{
		contactErr.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function submitForm(){
	if(firstNameValidate() & lastNameValidate() & emailValidate() & passValidate() & cpassValidate() & contactValidate() & dobValidate()){
		register.submit();
	}
}

function submitUser(){
	if(firstNameValidate() & lastNameValidate() & emailValidate() & contactValidate()){
		userForm.submit();
	}
}