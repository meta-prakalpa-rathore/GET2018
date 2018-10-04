var errors = new Map();

function firstNameValidate() {
	var text = document.getElementById("fname");
	var nameRegEx = /^[a-zA-Z\s]*$/;
    
    if(text.value == "") {
        text.style.border = "solid thin red";
		fnameErr.innerHTML = "This field is required";
        errors.set("First Name", "First Name is required");
		return false;
    }
	else if (text.value.length < 2 || !nameRegEx.test(text.value)) {
		text.style.border = "solid thin red";
		fnameErr.innerHTML = "Invalid first name";
        errors.set("First Name", "Invalid first name");
		return false;
	}
	else {
		fnameErr.innerHTML = "";
		text.style.borderColor = "";
        
        if(errors.has("First Name")) {
            errors.delete("First Name");
        }
		return true;
	}
}
			
function lastNameValidate() {
	var text = document.getElementById("lname");
	var nameRegEx = /^[a-zA-Z]*$/;
    
	if(text.value == "") {
        text.style.border = "solid thin red";
		lnameErr.innerHTML = "This field is required";
        errors.set("Last Name", "Last Name is required");
		return false;
    }
	else if (text.value.length < 2 || !nameRegEx.test(text.value)) {
		text.style.border = "solid thin red";
		lnameErr.innerHTML = "Invalid last name";
        errors.set("Last Name", "Invalid last name");
		return false;
	}
	else {
		lnameErr.innerHTML = "";
		text.style.borderColor = "";
        
        if(errors.has("Last Name")) {
            errors.delete("Last Name");
        }
        
		return true;
	}
}

function emailValidate() {
	var text = document.getElementById("email");
	var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
	if(text.value == "") {
        text.style.border = "solid thin red";
		emailErr.innerHTML = "This field is required";
        errors.set("E-Mail", "E-Mail is required");
		return false;
    }
	else if (!emailRegEx.test(text.value)) {
		text.style.border = "solid thin red";
		emailErr.innerHTML = "Invalid email";
        errors.set("E-Mail", "Invalid email");
		return false;
	}
	else {
		emailErr.innerHTML = "";
		text.style.borderColor = "";
        
        if(errors.has("E-Mail")) {
            errors.delete("E-Mail");
        }
        
		return true;
	}
}

function phoneValidate() {
	var text = document.getElementById("phone");
	var contactRegEx = /^[0-9]*$/;
    
    if(text.value == "") {
        text.style.border = "";
		phoneErr.innerHTML = "";
        
        if(errors.has("Phone")) {
            errors.delete("Phone");
        }
        
		return true;
    }
	else if (text.value.length < 8 || !contactRegEx.test(text.value)){
		text.style.border = "solid thin red";
		phoneErr.innerHTML = "Invalid contact number";
        errors.set("Phone", "Invalid contact number");
		return false;
	}
	else {
		phoneErr.innerHTML = "";
		text.style.borderColor = "";
        
        if(errors.has("Phone")) {
            errors.delete("Phone");
        }
        
		return true;
	}
}

function cityValidate() {
	var text = document.getElementById("city");
	var nameRegEx = /^[a-zA-Z\s]*$/;
    
	if(text.value == "") {
        text.style.border = "";
		cityErr.innerHTML = "";
        
        if(errors.has("City")) {
            errors.delete("City");
        }
        
		return true;
    }
	else if (text.value.length < 2 || !nameRegEx.test(text.value)) {
		text.style.border = "solid thin red";
		cityErr.innerHTML = "Invalid city";
        errors.set("City", "Invalid City");
		return false;
	}
	else {
		cityErr.innerHTML = "";
		text.style.borderColor = "";
        
        if(errors.has("City")) {
            errors.delete("City");
        }
        
		return true;
	}
}

function stateValidate() {
    var text = document.getElementById("state");
    
    if (text.value == "") {
        text.style.border = "solid thin red";
		stateErr.innerHTML = "This field is required";
        errors.set("State", "State is required");
		return false;
    }
    else {
        stateErr.innerHTML = "";
        text.style.borderColor = "";
        
        if(errors.has("State")) {
            errors.delete("State");
        }
        
        return true;
    }
}

function zipcodeValidate() {
    var text = document.getElementById("zipcode");
    
    if (text.value == "") {
        text.style.border = "solid thin red";
		zipcodeErr.innerHTML = "This field is required";
        errors.set("Zip Code", "Zip Code is required");
		return false;
    }
    else {
        zipcodeErr.innerHTML = "";
        text.style.borderColor = "";
        
        if(errors.has("Zip Code")) {
            errors.delete("Zip Code");
        }
        
        return true;
    }
}

function projectValidate() {
    var text = document.getElementById("project_description");
    
    if (text.value == "") {
        text.style.border = "solid thin red";
		projectErr.innerHTML = "This field is required";
        errors.set("Project Description", "Project Description is required");
		return false;
    }
    else {
        projectErr.innerHTML = "";
        text.style.borderColor = "";
        
        if(errors.has("Project Description")) {
            errors.delete("Project Description");
        }
        
        return true;
    }
}

function websiteValidate() {
	var text = document.getElementById("website");
	var websiteRegEx = /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/;
    
    if(text.value == "") {
        text.style.border = "";
		websiteErr.innerHTML = "";
        
        if(errors.has("Website or domain name")) {
            errors.delete("Website or domain name");
        }
        
		return true;
    }
	else if (!websiteRegEx.test(text.value)){
		text.style.border = "solid thin red";
		websiteErr.innerHTML = "Invalid website or domain name";
        errors.set("Website or domain name", "Invalid Website or domain name");
		return false;
	}
	else {
		websiteErr.innerHTML = "";
		text.style.borderColor = "";
        
        if(errors.has("Website or domain name")) {
            errors.delete("Website or domain name");
        }
        
		return true;
	}
}

function stateChange() {
    var text = document.getElementById("state");
    var referenceNode = text.parentNode.parentNode.parentNode;
    
    var zipcode = document.createElement('div');
        zipcode.className = "form-element";
        zipcode.innerHTML = "<div class='input-label'>Zip Code<span>*</span></div><div class='input-group'><div class='icon'><i class='fa fa-home'></i></div><div class='input-field'><input type='text' id='zipcode' placeholder='Zip Code' onblur='zipcodeValidate()'><p id='zipcodeErr'></p></div></div>";
    
    var website = document.createElement('div');
        website.className = "form-element";
        website.innerHTML = "<div class='input-label'>Website or domain name</div><div class='input-group'><div class='icon'><i class='fa fa-globe'></i></div><div class='input-field'><input type='text' id='website' placeholder='Website or domain name' onblur='websiteValidate()'><p id='websiteErr'></p></div></div>";
    
    var hosting = document.createElement('div');
        hosting.className = "form-element";
        hosting.innerHTML = "<div class='input-label'>Do you have hosting?</div><div class='input-group'><div class='input-radio-field'><label class='radio-label'><input type='radio' id='yes_hosting' value='yes'> Yes</label><label class='radio-label'><input type='radio' id='no_hosting' value='no'> No</label></div></div>";
    
    var project = document.createElement('div');
        project.className = "form-element";
        project.innerHTML = "<div class='input-label'>Project Description<span>*</span></div><div class='input-group'><div class='icon'><i class='fa fa-pencil'></i></div><div class='input-field'><textarea id='project_description' rows='3' placeholder='Project Description' onblur='projectValidate()'></textarea><p id='projectErr'></p></div></div>";
    
    var countChildren = document.getElementById("contactForm").children.length;
    
    if(countChildren == 10) {
        var parentForm = document.getElementById("contactForm");
        var item1 = parentForm.childNodes[14];
        var item2 = parentForm.childNodes[15];
        
        parentForm.removeChild(item1);
        parentForm.removeChild(item2);
    }
                          
    if(text.value == "Rajasthan") {
        referenceNode.parentNode.insertBefore(project, referenceNode.nextSibling);
        
        referenceNode.parentNode.insertBefore(website, referenceNode.nextSibling);
    }
    else if(text.value == "Haryana") {
        referenceNode.parentNode.insertBefore(hosting, referenceNode.nextSibling);
        
        referenceNode.parentNode.insertBefore(zipcode, referenceNode.nextSibling);
    }
    else if(text.value == "Maharashtra") {
        referenceNode.parentNode.insertBefore(project, referenceNode.nextSibling);
        
        referenceNode.parentNode.insertBefore(zipcode, referenceNode.nextSibling);
    }
}

function submitForm(){
    
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
        
        var state = document.getElementById("state");
        localStorage.setItem("State", state.value);
        
        if(state.value == "Rajasthan") {
            localStorage.setItem("Project Description", document.getElementById("project_description").value);
            
            var website = document.getElementById("website");
            if(website.value != "") {
                localStorage.setItem("Website or domain name", website.value);
            }
        }
        else if(state.value == "Haryana") {
            localStorage.setItem("Zip Code", document.getElementById("zipcode").value);
            
            var yesHosting = document.getElementById("yes_hosting");
            var noHosting = document.getElementById("no_hosting");
            
            if(yesHosting.checked) {
                localStorage.setItem("Has Hosting", yesHosting.value);
            }
            else if(noHosting.checked) {
                localStorage.setItem("Has Hosting", noHosting.value);
            }
        }
        else {
            localStorage.setItem("Zip Code", document.getElementById("zipcode").value);
            
            localStorage.setItem("Project Description", document.getElementById("project_description").value);
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