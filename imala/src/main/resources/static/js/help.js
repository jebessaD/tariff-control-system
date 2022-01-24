taxiArrow = document.querySelector('#abouttaxi');
busArrow = document.querySelector('#aboutbus');
reportArrow = document.querySelector('#aboutreport');
loginArrow = document.querySelector('#aboutlogin');
checkArrow = document.querySelector('#aboutcreport')
arrowDirection = 1;

function arrowChanger(arrow, arrowDirection) {

    arrow.addEventListener("click", () => {
        if (arrowDirection === 1) {
            arrow.className = "fas fa-angle-up";
            arrowDirection *= -1;
        } else {
            arrow.className = "fas fa-angle-down";
            arrowDirection *= -1;

        }
    })
}


arrowChanger(taxiArrow, 1);
arrowChanger(busArrow, 1);
arrowChanger(reportArrow, 1);
arrowChanger(loginArrow, 1);
arrowChanger(checkArrow, 1);