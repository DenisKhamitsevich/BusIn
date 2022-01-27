const email = document.getElementById("email");
const password = document.getElementById("new_password");
const length = document.getElementById("invalid_length");
const letter = document.getElementById("invalid_letter");
const number = document.getElementById("invalid_number");
const capital = document.getElementById("invalid_upper");
const sign_up_button = document.getElementById("sign_up_button_value");




//2 section
email.addEventListener("input", function (event) {
    if (email.validity.typeMismatch) {
        email.setCustomValidity("Введите правильный адрес электронной почты!");
    } else {
        email.setCustomValidity("");
    }

});



password.onfocus = function() {
    document.getElementById("invalid_password_message").style.display = "block";
}




password.onkeyup = function() {
    // Validate lowercase letters
    const lowerCaseLetters = /[a-z]/g;
    let wtemp = document.getElementById("w_letter_set");
    let rtemp = document.getElementById("r_letter_set");
    let prev=""
    let next=""

    if(password.value.match(lowerCaseLetters)) {
        letter.classList.remove("invalid");
        letter.classList.add("valid");
        prev="wrong_set";
        next="right_set";


    } else {
        letter.classList.remove("valid");
        letter.classList.add("invalid");
        prev="right_set";
        next="wrong_set";


    }
    wtemp.classList.remove(prev);
    wtemp.classList.add(next);
    rtemp.classList.remove(next);
    rtemp.classList.add(prev);

    // Validate capital letters
    const upperCaseLetters = /[A-Z]/g;
    wtemp = document.getElementById("w_upper_set");
    rtemp = document.getElementById("r_upper_set");
    if(password.value.match(upperCaseLetters)) {
        capital.classList.remove("invalid");
        capital.classList.add("valid");
        prev="wrong_set";
        next="right_set";

    } else {
        capital.classList.remove("valid");
        capital.classList.add("invalid");
        prev="right_set";
        next="wrong_set";

    }

    wtemp.classList.remove(prev);
    wtemp.classList.add(next);
    rtemp.classList.remove(next);
    rtemp.classList.add(prev);

    // Validate numbers
    const numbers = /[0-9]/g;
    wtemp = document.getElementById("w_number_set");
    rtemp = document.getElementById("r_number_set");
    if(password.value.match(numbers)) {
        number.classList.remove("invalid");
        number.classList.add("valid");
        prev="wrong_set";
        next="right_set";

    } else {
        number.classList.remove("valid");
        number.classList.add("invalid");
        prev="right_set";
        next="wrong_set";

    }
    wtemp.classList.remove(prev);
    wtemp.classList.add(next);
    rtemp.classList.remove(next);
    rtemp.classList.add(prev);

    // Validate length
    wtemp = document.getElementById("w_length_set");
    rtemp = document.getElementById("r_length_set");
    if((password.value.length >= 8)&&(password.value.length<=16)) {
        length.classList.remove("invalid");
        length.classList.add("valid");
        prev="wrong_set";
        next="right_set";

    } else {
        length.classList.remove("valid");
        length.classList.add("invalid");
        prev="right_set";
        next="wrong_set";

    }
    wtemp.classList.remove(prev);
    wtemp.classList.add(next);
    rtemp.classList.remove(next);
    rtemp.classList.add(prev);
}






