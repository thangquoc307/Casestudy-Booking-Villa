function backToMainPage(){
    window.location.href = "/main-page-controller?action=backToMain";
}
function logout(){
    document.getElementById("count-down").innerHTML = "10";
    let logoutBoard = document.getElementById("logout-board");
    logoutBoard.style.display = "grid";

    let buttonElement = document.getElementById("logout-now");
    let countdown = 10;

    countdownInterval = setInterval(function() {
        countdown--;
        document.getElementById("count-down").innerHTML = countdown;

        if (countdown === 0) {
            clearInterval(countdownInterval);
            buttonElement.removeAttribute('disabled');
            buttonElement.click();
        }
    }, 1000);
}
function logoutNow(){
    window.location.href = "/main-page-controller?action=logout";
}
function cancelLogout(){
    clearInterval(countdownInterval);
    let logoutBoard = document.getElementById("logout-board");
    logoutBoard.style.display = "none";
}
function alertCreateVilla(){
    let board = document.getElementById("alert-create-villa");
    board.style.display = "grid";
}

function setup(){
    let form = document.getElementById("formCreate");
    form.style.height = window.innerHeight * 0.8 + "px";
}
setup();
function closeAlertBoard(){
    let board = document.getElementById("alert-create-villa");
    board.style.display = "none";
}
function submitCreateVilla(){
    document.getElementById("actionEdit").click();
}