<%--
  Created by IntelliJ IDEA.
  User: quoct
  Date: 9/2/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tạo mới Villa</title>
    <link rel="stylesheet" href="css_createVilla/create_villa_css.css">
</head>
<body class="backgroundcolor-2">
<div id="header" class="boxshadow-outset">
    <img onclick="backToMainPage()" src="https://drive.google.com/uc?id=1cH2mCtzpEW1JtCt0qkxoD6PtEGbuT35c" width="100%"/>
    <div></div>
    <div id="sign">
        <div id="userName"></div>
        <a onclick="logout()" id="logout" class="backgroundcolor-4 hover">Đăng xuất</a>
    </div>
</div>
<form id="formCreate" action="/main-page-controller?action=createVilla" method="post" class="boxshadow-inset">
    <div id="map-picture"></div>
    <div id="array-picture"></div>
    <div id="data-input">
        <table>
            <tr>
                <td id="area"><p>Diện tích (m<sup>2</sup>)</p><input required id="input-area" name="area" type="number" step="any"></td>
                <td id="width"><p>Chiều dài (m)</p><input required id="input-width" name="width" type="number" step="any"></td>
                <td id="deep"><p>Chiều sâu (m)</p><input required id="input-deep" name="deep" type="number" step="any"></td>
                <td id="price"><p>Giá thuê (VND)</p><input required id="input-price" name="price" type="number"></td>
                <td id="level"><p>Số tầng</p><input required id="input-level" name="level" type="number"></td>
            </tr>
            <tr>
                <td id="garage"><p>Số hầm</p><input required id="input-garage" name="garage" type="number"></td>
                <td id="gym"><p>Phòng gym</p><input required id="input-gym" name="gym" type="number"></td>
                <td id="relax"><p>Phòng giải trí</p><input required id="input-relax" name="relax" type="number"></td>
                <td id="toilet"><p>Toilet</p><input required id="input-toilet" name="toilet" type="number"></td>
                <td id="living"><p>Phòng khách</p><input required id="input-living" name="living" type="number"></td>
            </tr>
            <tr>
                <td id="kitchen"><p>Bếp ăn</p><input required id="input-kitchen" name="kitchen" type="number"></td>
                <td id="bedroom"><p>Phòng ngủ</p><input required id="input-bedroom" name="bedroom" type="number"></td>
                <td id="capacity"><p>Sức chứa</p><input required id="input-capacity" name="capacity" type="number"></td>
            </tr>
        </table>
    </div>
    <div id="button-create">
        <button id="button-close" class="hover backgroundcolor-4" type="reset">Đặt lại</button>
        <button id="button-finish" onclick="alertCreateVilla()" class="hover backgroundcolor-4" type="button">Hoàn thành</button>
        <button id="actionEdit" type="submit" style="display: none"></button>
    </div>
    <div id="alert-create-villa" class="backgroundcolor-4">
        <p id="alert-create-p1">Xác nhận tạo mới Villa</p>
        <button id="alert-create-b1" onclick="closeAlertBoard()">Hủy</button>
        <button id="alert-create-b2" onclick="submitCreateVilla()">Xác nhận</button>
    </div>
</form>

<div id="logout-board" class="backgroundcolor-4">
    <div id="logout-alert">
        <p>Sau khi đăng xuất, bạn không thể sử dụng các chức năng</p>
        <p>Tự động đăng xuất sau <span id="count-down">10</span> giây</p>
    </div>
    <button id="logout-now" onclick="logoutNow()">Đăng xuất</button>
    <button onclick="cancelLogout()">Hủy</button>
</div>
</body>
<script src="css_createVilla/createvilla.js"></script>
<script>
    document.getElementById("userName").innerHTML = "${user_name}";
</script>
</html>
