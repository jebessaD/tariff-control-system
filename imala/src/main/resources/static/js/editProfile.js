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
        });

arrow =document.querySelectorAll(".fa-angle-down");
arrowDirection=1;


for(let i=0;i<arrow.length;i++){
  arrow[i].addEventListener("click", ()=>{
    if (arrowDirection===1){
    arrow[i].className="fas fa-angle-up";
    arrowDirection*=-1;
    }else{
      arrow[i].className="fas fa-angle-down";
      arrowDirection*=-1;
  
    }
  })
}