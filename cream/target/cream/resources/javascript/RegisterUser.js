var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

var otherInput = document.getElementById("rpsw");
var otherLetter = document.getElementById("other_letter");
var otherCapital = document.getElementById("other_capital");
var otherNumber = document.getElementById("other_number");
var otherLength = document.getElementById("other_length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

otherInput.onfocus = function() {
  document.getElementById("other_message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

otherInput.onblur = function() {
  document.getElementById("other_message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}

otherInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(otherInput.value.match(lowerCaseLetters)) {  
    otherLetter.classList.remove("other_invalid");
    otherLetter.classList.add("other_valid");
  } else {
    otherLetter.classList.remove("other_valid");
    otherLetter.classList.add("other_invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(otherInput.value.match(upperCaseLetters)) {  
    otherCapital.classList.remove("other_invalid");
    otherCapital.classList.add("other_valid");
  } else {
    otherCapital.classList.remove("other_valid");
    otherCapital.classList.add("other_invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(otherInput.value.match(numbers)) {  
    otherNumber.classList.remove("other_invalid");
    otherNumber.classList.add("other_valid");
  } else {
    otherNumber.classList.remove("other_valid");
    otherNumber.classList.add("other_invalid");
  }
  
  // Validate length
  if(otherInput.value.length >= 8) {
    otherLength.classList.remove("other_invalid");
    otherLength.classList.add("other_valid");
  } else {
    otherLength.classList.remove("other_valid");
    otherLength.classList.add("other_invalid");
  }
}


// Function to check Whether both passwords 
            // is same or not. 
            function checkPassword(form) { 
                password1 = form.psw.value; 
                password2 = form.rpsw.value; 
  
                // If password not entered 
                if (password1 == '') 
                    alert ("Please enter Password"); 
                      
                // If confirm password not entered 
                else if (password2 == '') 
                    alert ("Please enter confirm password"); 
                      
                // If Not same return False.     
                else if (password1 != password2) { 
                    alert ("\nPassword did not match: Please try again...") 
                    return false; 
                } 
  
                // If same return True. 
                else{ 
                    alert("User Registered") 
                    return true; 
                } 
            }