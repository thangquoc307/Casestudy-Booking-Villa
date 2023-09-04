function setup(){
    let factor = 0.95;
    let width = window.innerWidth * factor;
    let height = window.innerHeight * factor;
    let top = window.innerHeight * ((1 - factor) / 2);
    let left = window.innerWidth * ((1 - factor) / 2);
    let paddingTopArray = 0.05;

    let detailboard = document.getElementById("detail-board");
    let closedetailboard = document.getElementById("close-detail-board");
    let arrayPicture = document.getElementById("detail-board-picture-array-branch");

    detailboard.style.width = width + "px";
    detailboard.style.height = height + "px";
    detailboard.style.top = top + "px";
    detailboard.style.left = left + "px";
    closedetailboard.style.width = "40px";
    closedetailboard.style.height = "40px";
    closedetailboard.style.top = top + 10 + "px";
    closedetailboard.style.left = ( left + width - 15 - 40) + "px";
    arrayPicture.style.height = window.innerHeight * 0.97 * 0.8 * (1 - paddingTopArray * 2) + "px";
    arrayPicture.style.marginTop = window.innerHeight * 0.97 * 0.8 * (paddingTopArray) + "px";
}
setup();
window.addEventListener('resize', function() {
    setup();
});
