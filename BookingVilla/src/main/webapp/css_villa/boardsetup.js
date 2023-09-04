function setup(){
    let width = window.innerWidth;
    let height = window.innerHeight;

    let board = document.getElementById("edit-board");
    board.style.width = width * 0.8 + "px";
    board.style.height = height * 0.8 + "px";
    board.style.left = width * 0.2 / 2 + "px";
    board.style.top = height * 0.2 / 2 + "px";

}
setup();
window.addEventListener('resize', function() {
    setup();
});
