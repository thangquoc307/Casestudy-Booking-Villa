function login(userName){
    let data = `<div  id="userName"><a href="/login?action=showInformationUser">${userName}</a></div>
                <a onclick="logout()" id="logout" class="backgroundcolor-4 hover">Đăng xuất</a>`
    document.getElementById("sign").innerHTML = data;
}
function displayButton(role){
    let data = "";
    switch (role){
        case "1":
            data = `<button onclick="doGetByButton('my profile')" class="backgroundcolor-2 hover">Tài khoản</button>
                    <button onclick="doGetByButton('my booked')" class="backgroundcolor-2 hover">Đã đặt</button>
                    <button onclick="doGetByButton('contact')" class="backgroundcolor-2 hover">Liên hệ</button>
                    <button onclick="doGetByButton('feedback')" class="backgroundcolor-2 hover">Phản hồi</button>`
            break;
        case "2":
            data = `<button onclick="doGetByButton('my profile')" class="backgroundcolor-2 hover">Tài khoản</button>
                    <button onclick="doGetByButton('accept booking')" class="backgroundcolor-2 hover">Duyệt booking</button>
                    <button onclick="doGetByButton('customer account')" class="backgroundcolor-2 hover">Khách hàng</button>`
            break;
        case "3":
            data = `<button onclick="doGetByButton('my profile')" class="backgroundcolor-2 hover">Tài khoản</button>
                    <button onclick="doGetByButton('villa manage')" class="backgroundcolor-2 hover">Villa</button>
                    <button onclick="doGetByButton('accept booking')" class="backgroundcolor-2 hover">Duyệt booking</button>
                    <button onclick="doGetByButton('customer account')" class="backgroundcolor-2 hover">Khách hàng</button>
                    <button onclick="doGetByButton('employee account')" class="backgroundcolor-2 hover">Nhân viên</button>`
            break;
        default:
            data = `<button onclick="doGetByButton('contact')" class="backgroundcolor-2 hover">Liên hệ</button>
                    <button onclick="doGetByButton('feedback')" class="backgroundcolor-2 hover">Phản hồi</button>`
            break;
    }
    document.getElementById("button-list").innerHTML = data;
}

function doGetByButton(action){
    switch (action){
        case 'my profile':
            window.location.href = "/login?action=showInformationUser";
            break;
        case 'my booked':
            window.location.href = "/booking";
            break;
        case 'contact':
            window.open('tel:0764843894', '_blank');
            break;
        case 'feedback':
            window.location.href = 'mailto:lequocthang307@gmail.com';
            break;
        case 'accept booking':
            window.location.href = "/admin-booking?action=getAllBooking"
            break;
        case 'customer account':
            window.location.href = "/customer?action=getAllCustomer"
            break;
        case 'employee account':
            window.location.href = "/employee"
            break;
        case 'villa manage':
            window.location.href = "/main-page-controller?action=villaManage"
            break;
    }
}
let countdownInterval;
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