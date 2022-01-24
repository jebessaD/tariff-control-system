
let e_form =document.querySelector("#form");

e_form.addEventListener("focusout",(e)=>{

    th = e_form.value
    //    e_form.submit()

    opt = document.getElementById("option")
    // start = document.getElementById("start")
    // console.log(start.value);
    opt.value=th
        console.log(opt.value);
    });





// opt = document.getElementById("option")
// start = document.getElementById("start")
// console.log(start.value);
// console.log(opt.value);