<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main-page</title>
    <link rel="stylesheet" href="css_index/main_page_css.css">
</head>
<body class="backgroundcolor-2">
<div id="header" class="boxshadow-outset">
    <img src="https://drive.google.com/uc?id=1cH2mCtzpEW1JtCt0qkxoD6PtEGbuT35c" width="100%"/>
    <div></div>
    <div id="sign">
        <button onclick="quickLogin()" id="buttonLogin" class="backgroundcolor-2 hover">Đăng nhập</button>
        <button onclick="regist()" id="buttonSignUp" class="backgroundcolor-2 hover">Đăng ký</button>

        <div id="login" class="backgroundcolor-3 boxshadow-outset">
            <form action="/main-page-controller?action=login" method="post">
                <input type="text" name="id" placeholder="số điện thoại đăng ký">
                <br>
                <input type="password" name="password" placeholder="password">
                <br>
                <button type="submit">Đăng nhập</button>
            </form>
            <button onclick="closeLogin()">Đóng</button>

            <c:choose>
                <c:when test="${loginfail == '1'}">
                    <p style="color: red">ID hoặc PASS không đúng</p>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>
<div id="context" class="boxshadow-outset">
    <div id="clock">00:00:00</div>
    <div id="button-list"></div>
    <div id="slide" class="backgroundcolor-2"></div>
    <div id="picture-main">
        <img src="https://drive.google.com/uc?id=1Ye2HDuK6y2fMEOPw0fdaed150tBaQFpB" width="100%"/>

        <div id="calendar">
            <div class="month backgroundcolor-3">
                <p>Tháng</p>
                <p id="month-detail"></p>
                <p id="year-detail"></p>
            </div>
            <div class="weekdays backgroundcolor-2">
                <table id="calendar-table"></table>
            </div>
        </div>
    </div>
</div>
<div id="booking">
    <div>
        <div id="contact" class="boxshadow-outset">
            <p id="contact-title">Thông tin liên hệ</p>
            <table id="contact-table">
                <tr>
                    <td class="contact-avata" style="background-image: url('https://drive.google.com/uc?id=1uRPquTfLUv3jx0sTTEy2_LAAUXViv6Mh')"></td>
                    <td><p class="contact-name hover backgroundcolor-2">Lê Quốc Thắng</p></td>
                </tr>
                <tr>
                    <td class="contact-avata" style="background-image: url('https://drive.google.com/uc?id=1HxtkGn9nNafE1CovHX85OZJzSbmqsMLO')"></td>
                    <td><p class="contact-name hover backgroundcolor-2">Nguyễn Thị Mỹ Hạnh</p></td>
                </tr>
                <tr>
                    <td class="contact-avata" style="background-image: url('https://drive.google.com/uc?id=12_VFCxVbGmm3BxlkTqUJqGR63Azqoydv')"></td>
                    <td><p class="contact-name hover backgroundcolor-2">Nguyễn Khánh Nhật</p></td>
                </tr>
                <tr>
                    <td class="contact-avata" style="background-image: url('https://drive.google.com/uc?id=1JOiSRDjJKZ71FM8i070eyQPMJcN8Dw8Y')"></td>
                    <td><p class="contact-name hover backgroundcolor-2">Nguyễn Chính Đạt</p></td>
                </tr>
            </table>
            <div id="back-to-top">
                <p class="backgroundcolor-4 hover" onclick="backToTop()">Đầu trang</p>
            </div>
        </div>
    </div>
    <div id="villa-list"></div>
</div>
<div id="footer" class="boxshadow-outset">
    <div>
        <img src="https://drive.google.com/uc?id=1kc2ZP6vHnB9rmLls1w9JMboFfZ7Tk9yK"/>
        <p>Cùng nhau... chúng ta qua Module !!!</p>
        <img src="https://drive.google.com/uc?id=1cH2mCtzpEW1JtCt0qkxoD6PtEGbuT35c"/>
    </div>
</div>
<div id="detail-board">
    <div id="detail-board-picture-array" class="align-board">
        <div id="detail-board-picture-array-branch" class="boxshadow-inset"></div>
        <div id="detail-board-picture-array-main" class="boxshadow-outset"></div>
    </div>
    <div id="detail-board-sd" class="align-board">
        <div id="map" class="boxshadow-outset"></div>
    </div>
    <div id="detail-board-description" class="align-board">
        <table id="table-description"></table>
    </div>
    <div id="detail-board-booking" class="align-board"></div>
    <div id="close-detail-board" class="backgroundcolor-3 hover boxshadow-outset" onclick="close_detail_board()"></div>
</div>


<div id="logout-board" class="backgroundcolor-4">
    <div id="logout-alert">
        <p>Sau khi đăng xuất, bạn không thể sử dụng các chức năng</p>
        <p>Tự động đăng xuất sau <span id="count-down">10</span> giây</p>
    </div>
    <button id="logout-now" onclick="logoutNow()">Đăng xuất</button>
    <button onclick="cancelLogout()">Hủy</button>
</div>
</body>

<script src="css_index/calendar.js"></script>
<script src="css_index/clock.js"></script>
<script src="css_index/setup.js"></script>
<script src="css_index/villaclass.js"></script>
<script src="css_index/backtop.js"></script>
<script src="css_index/datalist.js"></script>
<script src="css_index/login.js"></script>
<script>
    let role = '${role}';
    let userName = '${user_name}';
    var checkRole = (role == "1" || role == "2" || role == "3");
    let timesBooking = '${seenBooking}';

    if (role == "0"){
        loginDisplay();
    } else if (checkRole) {
        login(userName);
    }
    displayButton(role, timesBooking);

    let stringVilla = '${data}';
    let alertLogin = '${loginfail}';
    if (alertLogin == '1'){
        quickLogin();
    }

    if (stringVilla === '') {
        window.location.href = "/main-page-controller?action=getdata";
    } else {
        var dataVilla = eval(stringVilla);
        updateVillaList();
    }


</script>

</html>