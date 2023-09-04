function login(userName){
    let data = `<div id="userName">${userName}</div>
                <a href="/main-page-controller?action=logout" id="logout" class="backgroundcolor-4 hover">Đăng xuất</a>`
    document.getElementById("sign").innerHTML = data;
}
function displayButton(role){
    let data = "";
    switch (role){
        case "1":
            data = `<button onclick="doGetByButton('my profile')" class="backgroundcolor-2 hover">Tài khoản</button>
                    <button onclick="doGetByButton('my booked')" class="backgroundcolor-2 hover">Đã đặt</button>
                    <button onclick="doGetByButton('new booking')" class="backgroundcolor-2 hover">Đặt mới</button>
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
            break;
        case 'my booked':
            break;
        case 'new booking':
            break;
        case 'contact':
            break;
        case 'feedback':
            break;
        case 'accept booking':
            break;
        case 'customer account':
            break;
        case 'employee account':
            break;
        case 'villa manage':
            window.location.href = "/main-page-controller?action=villaManage"
            break;
    }
}