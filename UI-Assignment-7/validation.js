var errors = new Map();

function firstNameValidate() {
	var firstNameElement = document.getElementById("fname");
	var nameRegEx = /^[a-zA-Z\s]*$/;
    
    if(firstNameElement.value == "") {
        firstNameElement.style.border = "solid thin red";
		fnameErr.innerHTML = "This field is required";
        errors.set("First Name", "First Name is required");
		return false;
    }
	else if (firstNameElement.value.length < 2 || !nameRegEx.test(firstNameElement.value)) {
		firstNameElement.style.border = "solid thin red";
		fnameErr.innerHTML = "Invalid first name";
        errors.set("First Name", "Invalid first name");
		return false;
	}
	else {
		fnameErr.innerHTML = "";
		firstNameElement.style.borderColor = "";
        
        if(errors.has("First Name")) {
            errors.delete("First Name");
        }
		return true;
	}
}
			
function lastNameValidate() {
	var lastNameElement = document.getElementById("lname");
	var nameRegEx = /^[a-zA-Z]*$/;
    
	if(lastNameElement.value == "") {
        lastNameElement.style.border = "solid thin red";
		lnameErr.innerHTML = "This field is required";
        errors.set("Last Name", "Last Name is required");
		return false;
    }
	else if (lastNameElement.value.length < 2 || !nameRegEx.test(lastNameElement.value)) {
		lastNameElement.style.border = "solid thin red";
		lnameErr.innerHTML = "Invalid last name";
        errors.set("Last Name", "Invalid last name");
		return false;
	}
	else {
		lnameErr.innerHTML = "";
		lastNameElement.style.borderColor = "";
        
        if(errors.has("Last Name")) {
            errors.delete("Last Name");
        }
        
		return true;
	}
}

function emailValidate() {
	var emailElement = document.getElementById("email");
	var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
	if(emailElement.value == "") {
        emailElement.style.border = "solid thin red";
		emailErr.innerHTML = "This field is required";
        errors.set("E-Mail", "E-Mail is required");
		return false;
    }
	else if (!emailRegEx.test(emailElement.value)) {
		emailElement.style.border = "solid thin red";
		emailErr.innerHTML = "Invalid email";
        errors.set("E-Mail", "Invalid email");
		return false;
	}
	else {
		emailErr.innerHTML = "";
		emailElement.style.borderColor = "";
        
        if(errors.has("E-Mail")) {
            errors.delete("E-Mail");
        }
        
		return true;
	}
}

function phoneValidate() {
	var phoneElement = document.getElementById("phone");
	var contactRegEx = /^[0-9]*$/;
    
    if(phoneElement.value == "") {
        phoneElement.style.border = "";
		phoneErr.innerHTML = "";
        
        if(errors.has("Phone")) {
            errors.delete("Phone");
        }
        
		return true;
    }
	else if (phoneElement.value.length < 8 || !contactRegEx.test(phoneElement.value)){
		phoneElement.style.border = "solid thin red";
		phoneErr.innerHTML = "Invalid contact number";
        errors.set("Phone", "Invalid contact number");
		return false;
	}
	else {
		phoneErr.innerHTML = "";
		phoneElement.style.borderColor = "";
        
        if(errors.has("Phone")) {
            errors.delete("Phone");
        }
        
		return true;
	}
}

function cityValidate() {
	var cityElement = document.getElementById("city");
	var nameRegEx = /^[a-zA-Z\s]*$/;
    
	if(cityElement.value == "") {
        cityElement.style.border = "";
		cityErr.innerHTML = "";
        
        if(errors.has("City")) {
            errors.delete("City");
        }
        
		return true;
    }
	else if (cityElement.value.length < 2 || !nameRegEx.test(cityElement.value)) {
		cityElement.style.border = "solid thin red";
		cityErr.innerHTML = "Invalid city";
        errors.set("City", "Invalid City");
		return false;
	}
	else {
		cityErr.innerHTML = "";
		cityElement.style.borderColor = "";
        
        if(errors.has("City")) {
            errors.delete("City");
        }
        
		return true;
	}
}

function stateValidate() {
    var stateElement = document.getElementById("state");
    
    if (stateElement.value == "") {
        stateElement.style.border = "solid thin red";
		stateErr.innerHTML = "This field is required";
        errors.set("State", "State is required");
		return false;
    }
    else {
        stateErr.innerHTML = "";
        stateElement.style.borderColor = "";
        
        if(errors.has("State")) {
            errors.delete("State");
        }
        
        return true;
    }
}

function zipcodeValidate() {
    var zipcodeElement = document.getElementById("zipcode");
    
    if (zipcodeElement.value == "") {
        zipcodeElement.style.border = "solid thin red";
		zipcodeErr.innerHTML = "This field is required";
        errors.set("Zip Code", "Zip Code is required");
		return false;
    }
    else {
        zipcodeErr.innerHTML = "";
        zipcodeElement.style.borderColor = "";
        
        if(errors.has("Zip Code")) {
            errors.delete("Zip Code");
        }
        
        return true;
    }
}

function projectValidate() {
    var projectElement = document.getElementById("project_description");
    
    if (projectElement.value == "") {
        projectElement.style.border = "solid thin red";
		projectErr.innerHTML = "This field is required";
        errors.set("Project Description", "Project Description is required");
		return false;
    }
    else {
        projectErr.innerHTML = "";
        projectElement.style.borderColor = "";
        
        if(errors.has("Project Description")) {
            errors.delete("Project Description");
        }
        
        return true;
    }
}

function websiteValidate() {
	var websiteElement = document.getElementById("website");
	var websiteRegEx = /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/;
    
    if(websiteElement.value == "") {
        websiteElement.style.border = "";
		websiteErr.innerHTML = "";
        
        if(errors.has("Website or domain name")) {
            errors.delete("Website or domain name");
        }
        
		return true;
    }
	else if (!websiteRegEx.test(websiteElement.value)){
		websiteElement.style.border = "solid thin red";
		websiteErr.innerHTML = "Invalid website or domain name";
        errors.set("Website or domain name", "Invalid Website or domain name");
		return false;
	}
	else {
		websiteErr.innerHTML = "";
		websiteElement.style.borderColor = "";
        
        if(errors.has("Website or domain name")) {
            errors.delete("Website or domain name");
        }
        
		return true;
	}
}

function handleStateChange() {
    var stateElement = document.getElementById("state");
    var state = stateElement.value;
    var referenceNode = stateElement.parentNode.parentNode.parentNode;    
    var optionalElements = document.getElementsByClassName("optionalElement");
   
    while (optionalElements.length > 0) {
        optionalElements[0].parentNode.removeChild(optionalElements[0]);
    }
                          
    if(state == "Rajasthan") {
        referenceNode.parentNode.insertBefore(getProject(), referenceNode.nextSibling);
        
        referenceNode.parentNode.insertBefore(getWebsite(), referenceNode.nextSibling);
    }
    else if(state == "Haryana") {
        referenceNode.parentNode.insertBefore(getHosting(), referenceNode.nextSibling);
        
        referenceNode.parentNode.insertBefore(getZipCode(), referenceNode.nextSibling);
    }
    else if(state == "Maharashtra") {
        referenceNode.parentNode.insertBefore(getProject(), referenceNode.nextSibling);
        
        referenceNode.parentNode.insertBefore(getZipCode(), referenceNode.nextSibling);
    }
}

function getWebsite() {
    var website = document.createElement('div');
        website.className = "form-element optionalElement";
        website.innerHTML = "<div class='input-label'>Website or domain name</div><div class='input-group'><div class='icon'><i class='fa fa-globe'></i></div><div class='input-field'><input type='text' id='website' placeholder='Website or domain name' onblur='websiteValidate()'><p id='websiteErr'></p></div></div>";
    
    return website;
}

function getHosting() {
    var hosting = document.createElement('div');
        hosting.className = "form-element optionalElement";
        hosting.innerHTML = "<div class='input-label'>Do you have hosting?</div><div class='input-group'><div class='input-radio-field'><label class='radio-label'><input type='radio' name='has_hosting' id='yes_hosting' value='yes'> Yes</label><label class='radio-label'><input type='radio' name='has_hosting' id='no_hosting' value='no'> No</label></div></div>";
    
    return hosting;
}

function getZipCode() {
    var zipcode = document.createElement('div');
        zipcode.className = "form-element optionalElement";
        zipcode.innerHTML = "<div class='input-label'>Zip Code<span>*</span></div><div class='input-group'><div class='icon'><i class='fa fa-home'></i></div><div class='input-field'><input type='text' id='zipcode' placeholder='Zip Code' onblur='zipcodeValidate()'><p id='zipcodeErr'></p></div></div>";
    
    return zipcode;
}

function getProject() {
    var project = document.createElement('div');
        project.className = "form-element optionalElement";
        project.innerHTML = "<div class='input-label'>Project Description<span>*</span></div><div class='input-group'><div class='icon'><i class='fa fa-pencil'></i></div><div class='input-field'><textarea id='project_description' rows='3' placeholder='Project Description' onblur='projectValidate()'></textarea><p id='projectErr'></p></div></div>";
    
    return project;
}

function submitForm(){
    
    errors.clear();
    var state = document.getElementById("state");
    var flag = false;
    
    if(state.value == "Rajasthan" && (projectValidate() & websiteValidate())) {
        flag = true;
    }
    else if(state.value == "Haryana" && zipcodeValidate()) {
        flag = true;
    }
    else if(state.value == "Maharashtra" && (zipcodeValidate() & projectValidate())) {
        flag = true;
    }
    
	if(firstNameValidate() & lastNameValidate() & emailValidate() & phoneValidate() & cityValidate() & stateValidate() & flag) {
		
        localStorage.clear();
        
        localStorage.setItem("First Name", document.getElementById("fname").value);
        localStorage.setItem("Last Name", document.getElementById("lname").value);
        localStorage.setItem("Email", document.getElementById("email").value);
        localStorage.setItem("State", document.getElementById("state").value);
        
        var phoneNumber = document.getElementById("phone");
        if(phoneNumber.value != "") {
            localStorage.setItem("Phone #", phoneNumber.value);
        }
        
        var address = document.getElementById("address");
        if(address.value != "") {
            localStorage.setItem("Address", address.value);
        }
        
        var city = document.getElementById("city");
        if(city.value != "") {
            localStorage.setItem("City", city.value);
        }
                    
        var project = document.getElementById("project_description");
        if(project != null) {
            localStorage.setItem("Project Description", project.value);
        }            
        
        var website = document.getElementById("website");
        if(website != null && website.value != "") {
            localStorage.setItem("Website or domain name", website.value);
        }
        
        var zipcode = document.getElementById("zipcode");
        if(zipcode != null) {
            localStorage.setItem("Zip Code", zipcode.value);
        }
        
        var yesHosting = document.getElementById("yes_hosting");
        var noHosting = document.getElementById("no_hosting");

        if(yesHosting != null && yesHosting.checked) {
            localStorage.setItem("Has Hosting", yesHosting.value);
        }
        else if(noHosting != null && noHosting.checked) {
            localStorage.setItem("Has Hosting", noHosting.value);
        }
        
        return true;
	}
    else {
        
        var errorKeys = errors.keys();
        var message = "";
        
        for(var key of errorKeys) {
            message = message + key + "-" + errors.get(key) + "\n";
        }
        
        alert(message);
        return false;
    }
}