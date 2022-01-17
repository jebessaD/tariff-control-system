// import swal from 'sweetalert';
let form =document.querySelector(".form");
const password =document.querySelector("#psw_1");
const c_password =document.querySelector("#psw_2");
let error_msg =document.querySelector(".error-message");


error_msg.style.display= "none";
form.addEventListener("submit",(e)=>{
        if (password.value !==c_password.value ){
                e.preventDefault();
                error_msg.style.display="inline"
                
            }
        else{
             
            // e.preventDefault();
            // alert("ggg")
            // swal("Good job!", "You clicked the button!", "success");
            // swal({

            //     position:'top-end',
            //     icon: 'success',
            //     title: 'You have successfully registered',
            //     showConfirmButton: false,
            //     timer: 2000,
            //     button: false,
                
            // })
            // .then(function() {
            //     return true;
            //     // e.returnValue = true;
            //     // window.location.href = 'login.html';
            // });
            
            window.location.href = 'signup.html';
            
            // return true;
            
        }
        });

