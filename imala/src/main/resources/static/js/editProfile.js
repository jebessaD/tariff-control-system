// import swal from 'sweetalert';
let p_form =document.querySelector("#changePassword");
const password =document.querySelector("#psw_1");
const c_password =document.querySelector("#psw_2");
let error_msg =document.querySelector(".error-message");

error_msg.style.display= "none";
p_form.addEventListener("submit",(e)=>{
        if (password.value !==c_password.value ){
                e.preventDefault();
                error_msg.style.display="inline"
                
            }
        else{
            //  e.preventDefault();
              window.location.href = 'signup.html';
            //   window.location.replace("signup.html");
             
            // e.preventDefault();
            // swal("Good job!", "You clicked the button!", "success");
            // swal({

            //     position:'top-end',
            //     icon: 'success',
            //     title: 'Your password has been changed!',
            //     showConfirmButton: false,
            //     timer: 2000,
            //     button: false,
                
            // })
            // .then(function() {
            //     window.location.href = 'login.html';
            // });
            
            // window.location.href = 'login.html';

            // return true;
            
        }
     

        });

        // outer scope
//         hasSubmitted = false;
//         //...
//         p_form.submit(function(e) {
//         if(hasSubmitted)return;
//         hasSubmitted = true;
//         //...
//         })

// console.log(hasSubmitted);