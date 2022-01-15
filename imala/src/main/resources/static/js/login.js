let loginError = document.querySelector(".login-error");
let form =document.querySelector(".form-login");
loginError.style.display="none";
form.addEventListener("submit",(e)=>{
    e.preventDefault();

    window.location.href = '../index.html';
    return true;
        
    
    });
