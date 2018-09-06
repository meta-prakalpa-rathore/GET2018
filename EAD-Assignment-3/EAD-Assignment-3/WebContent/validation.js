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

function ageValidate(){
	var text = document.getElementById("age");
	var contactRegEx = /^[0-9]*$/;
	if(text.value < 18 || text.value > 80 || !contactRegEx.test(text.value)){
		text.style.border = "solid thin red";
		ageErr.innerHTML = "Invalid age";
		return false;
	}
	else{
		ageErr.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function submitForm(){
	if(firstNameValidate() & lastNameValidate() & emailValidate() & ageValidate()){
		employeeForm.submit();
	}
}