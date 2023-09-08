<%--
  Created by IntelliJ IDEA.
  User: quoct
  Date: 9/2/2023
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Villa Manage</title>
    <link rel="stylesheet" href="css_villa/villa_page_css.css">
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
<div id="villa-list"></div>

<input id="input-detail-picture" style="display: none" class="inps" onchange="handleUpload(0)" type="file" multiple>
<input id="inputfile" type="file" style="display: none" class="inp" onchange="handleUpload(1)">

<form id="edit-board" class="backgroundcolor-2 boxshadow-outset" action="/main-page-controller?action=edit-villa" method="post">
    <div id="picture" class="boxshadow-inset"></div>
    <div id="map-picture" class="boxshadow-inset">
        <div id="map-detail-picture">
            <img src="css_villa/icon/changeimg.png" onclick="changeMap()">
        </div>
        <div id="map-change">
            <div class="imageUpload"></div>
        </div>
    </div>
    <input id="villaId" type="hidden" name="villa-id">
    <input id="deleteimg" type="hidden" name="img-delete">
    <input id="inputMap" type="hidden" name="img-map">
    <input id="inputDetailPic" type="hidden" name="img-detail">

    <div id="area"><p>Diện tích (m<sup>2</sup>)</p><input required id="input-area" name="area" type="number" step="any"></div>
    <div id="width"><p>Chiều dài (m)</p><input required id="input-width" name="width" type="number" step="any"></div>
    <div id="deep"><p>Chiều sâu (m)</p><input required id="input-deep" name="deep" type="number" step="any"></div>
    <div id="price"><p>Giá thuê (VND)</p><input required id="input-price" name="price" type="number"></div>

    <div id="level"><p>Số tầng</p><input required id="input-level" name="level" type="number"></div>
    <div id="garage"><p>Số hầm</p><input required id="input-garage" name="garage" type="number"></div>
    <div id="gym"><p>Phòng gym</p><input required id="input-gym" name="gym" type="number"></div>
    <div id="relax"><p>Phòng giải trí</p><input required id="input-relax" name="relax" type="number"></div>
    <div id="toilet"><p>Toilet</p><input required id="input-toilet" name="toilet" type="number"></div>
    <div id="living"><p>Phòng khách</p><input required id="input-living" name="living" type="number"></div>
    <div id="kitchen"><p>Bếp ăn</p><input required id="input-kitchen" name="kitchen" type="number"></div>
    <div id="bedroom"><p>Phòng ngủ</p><input required id="input-bedroom" name="bedroom" type="number"></div>
    <div id="capacity"><p>Sức chứa</p><input required id="input-capacity" name="capacity" type="number"></div>

    <button id="button-close" class="hover backgroundcolor-4" type="reset" onclick="closeEditBoard()">Hủy</button>
    <button id="button-finish" onclick="alertEditVilla()" class="hover backgroundcolor-4" type="button">Hoàn thành</button>
    <button id="actionEdit" type="submit" style="display: none"></button>
</form>

<form id="delete-board" action="/main-page-controller?action=delete-villa" method="post"
      class="backgroundcolor-2 boxshadow-outset">
    <div id="warning-delete-villa"></div>
    <h2 id="alert-delete-board">Bạn muốn xóa <span id="villa-delete-id"></span> ???</h2>
    <input id="villa-delete" name="villa-id" type="hidden">
    <button id="delete-delete-board" class="backgroundcolor-4 hover boxshadow-inset" type="submit">Xóa</button>
    <button id="close-delete-board" class="backgroundcolor-4 hover boxshadow-inset" type="button" onclick="closeDeleteBoard()">Trở lại</button>
</form>
<div id="logout-board" class="backgroundcolor-4">
    <div id="logout-alert">
        <p>Sau khi đăng xuất, bạn không thể sử dụng các chức năng</p>
        <p>Tự động đăng xuất sau <span id="count-down">10</span> giây</p>
    </div>
    <button id="logout-now" onclick="logoutNow()">Đăng xuất</button>
    <button onclick="cancelLogout()">Hủy</button>
</div>
<div id="alert-choose-picture" class="backgroundcolor-4">
    <p>Phải có ít nhất 1 hình minh họa cho Villa</p>
    <button onclick="closeAlertChooseAllPicture()">Đóng</button>
</div>
<div id="alert-edit-villa" class="backgroundcolor-4">
    <p id="alert-edit-p1">Xác nhận thay đổi thông tin</p>
    <p id="alert-edit-p2">** Hành động này không thể hoàn tác **</p>
    <button id="alert-edit-b1" onclick="closeAlertEditVilla()">Hủy</button>
    <button id="alert-edit-b2" onclick="confirmEditVilla()">Xác nhận</button>
</div>
</body>
<script type="module" src="css_villa/firebase.js"></script>
<script src="css_index/villaclass.js"></script>
<script src="css_villa/villadata.js"></script>
<script src="css_villa/boardsetup.js"></script>
<script>
    let stringVilla = '${data}';
    var dataVilla = eval(stringVilla);
    showVillaList();
    document.getElementById("userName").innerHTML = "${user_name}";
</script>


</html>
