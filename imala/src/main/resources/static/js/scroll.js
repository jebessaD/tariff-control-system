
let head = document.getElementById("header");
let lastScrollY = window.scrollY;
let lastScrollDirection = -1;

function scrollhide() {
    let scrolledY = window.scrollY;
    let scrollDirection = (scrolledY - lastScrollY) / Math.abs(scrolledY - lastScrollY);
    lastScrollY = scrolledY;
    if (lastScrollDirection == scrollDirection) {
        return;
    } else if (scrollDirection == -1) {
        head.style.transform = "translateY(0)";
        
    } else {
        head.style.transform = "translateY(-100%)";
        head.style.transition="0.8s"
    }
    lastScrollDirection *= -1;
}
window.onscroll = scrollhide;