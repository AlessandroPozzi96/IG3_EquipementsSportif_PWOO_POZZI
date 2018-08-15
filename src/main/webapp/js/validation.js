
login = document.getElementById("login");
password = document.getElementById("password");
loginError = document.getElementById("loginError");
passwordError = document.getElementById("passwordError");
h1 = login.parentElement.previousElementSibling;

function getMessage(champ) {
    lang = "fr";
    if (h1.innerHTML == "Sign in") {
        lang = "en";
    }

    if (champ == "login") {
        if (lang == "fr") {
            return "Login invalide ! \n Min 3 caractères - max 50 caractères";
        }
        else
        {
            return "Error login ! \n Min 3 characters - max 50 characters";
        }
    }
    else
    {
        if (lang == "fr") {
            return "Mot de passe invalide ! \n Min 6 caractères - max 32 caractères";
        }
        else
        {
            return "Error password ! Min 6 characters - max 32 characters";
        }
    }
}

function loginValide ()
{
    if (login.value.length < 3 || login.value.length > 50) {
        loginError.innerHTML = getMessage("login");
    }
    else
    {
        loginError.innerHTML = "";
    }
}

function passwordValide() {

    if (password.value.length < 6 || password.value.length > 32)
    {
        passwordError.innerHTML = getMessage("password");
    }
    else
    {
        passwordError.innerHTML = "";
    }
}