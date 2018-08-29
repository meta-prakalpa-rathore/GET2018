function firstNameValidate(){
	var text = document.getElementById("fname");
	var nameRegEx = /^[a-zA-Z\s]*$/;
	if(text.value.length < 2 || !nameRegEx.test(text.value)){
		text.style.border = "solid thin red";
		err1.innerHTML = "Invalid first name";
		return false;
	}
	else{
		err1.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}
			
function lastNameValidate(){
	var text = document.getElementById("lname");
	var nameRegEx = /^[a-zA-Z]*$/;
	if(text.value.length < 2 || !nameRegEx.test(text.value)){
		text.style.border = "solid thin red";
		err2.innerHTML = "Invalid last name";
		return false;
	}
	else{
		err2.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function emailValidate(){
	var text = document.getElementById("email");
	var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!emailRegEx.test(text.value)){
		text.style.border = "solid thin red";
		err3.innerHTML = "Invalid email";
		return false;
	}
	else{
		err3.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function passValidate(){
	var text = document.getElementById("pass");
	var passRegEx = /^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	if(!passRegEx.test(text.value)){
		text.style.border = "solid thin red";
		return false;
	}
	else{
		text.style.borderColor = "";
		return true;
	}
}

function cpassValidate(){
	var text = document.getElementById("cpass");
	if(document.getElementById("pass").value != text.value){
		text.style.border = "solid thin red";
		err5.innerHTML = "Passwords do'nt match!";
		return false;
	}
	else{
		err5.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function contactValidate(){
	var text = document.getElementById("contact");
	var contactRegEx = /^[0-9]*$/;
	if(text.value.length < 8 || !contactRegEx.test(text.value)){
		text.style.border = "solid thin red";
		err6.innerHTML = "Invalid contact number";
		return false;
	}
	else{
		err6.innerHTML = "";
		text.style.borderColor = "";
		return true;
	}
}

function submitForm(){
	if(firstNameValidate() && lastNameValidate() && emailValidate() && passValidate() && cpassValidate() && contactValidate()){
		signup.submit();
	}
}

function submitLogin(){
	if(emailValidate() && passValidate()){
		login.submit();
	}
}