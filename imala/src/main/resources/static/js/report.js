let form = document.querySelector(".form-report");
form.addEventListener("submit",(e)=>{
    e.preventDefault();
            // swal("Good job!", "You clicked the button!", "success");
    swal({

        position:'top-end',
        icon: 'success',
        title: 'Your records has been saved',
        showConfirmButton: false,
        timer: 2000,
        button: false,
        


    })
    return true;

})
    
    // ).then(function() {
    //     window.location.href = 'login.html';
    // });