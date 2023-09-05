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
        <a href="/main-page-controller?action=logout" id="logout" class="backgroundcolor-4 hover">Đăng xuất</a>
    </div>
</div>
<div id="villa-list"></div>

<form id="edit-board" class="backgroundcolor-2 boxshadow-outset" action="/main-page-controller?action=edit-villa" method="post">
    <div id="picture" class="boxshadow-inset"></div>
    <div id="map-picture" class="boxshadow-inset">
        <div id="map-detail-picture"></div>
        <div id="map-change">
            <h3>Tải ảnh thay thế</h3>
            <input type="file" name="change-map">
        </div>
    </div>
    <input id="villaId" type="hidden" name="villa-id">

    <div id="area"><p>Diện tích (m<sup>2</sup>)</p><input required id="input-area" name="area" type="number"></div>
    <div id="width"><p>Chiều dài (m)</p><input required id="input-width" name="width" type="number"></div>
    <div id="deep"><p>Chiều sâu (m)</p><input required id="input-deep" name="deep" type="number"></div>
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
    <button id="button-finish" class="hover backgroundcolor-4" type="submit">Hoàn thành</button>
</form>

<form id="delete-board" action="/main-page-controller?action=delete-villa" method="post"
      class="backgroundcolor-2 boxshadow-outset">
    <h2 id="alert-delete-board">Bạn muốn xóa Villa ???</h2>
    <input id="villa-delete" name="villa-id" type="hidden">
    <button id="delete-delete-board" class="backgroundcolor-3 hover boxshadow-inset" type="submit">Xóa</button>
    <button id="close-delete-board" class="backgroundcolor-3 hover boxshadow-inset" type="button" onclick="closeDeleteBoard()">Trở lại</button>
</form>

</body>
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
