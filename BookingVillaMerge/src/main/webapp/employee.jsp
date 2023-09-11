<%--
  Created by IntelliJ IDEA.
  User: myhanh
  Date: 04/09/2023
  Time: 07:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css_admin/admin.css">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<html>
<head>
    <title>
    </title>
</head>
<body id="body">
<div id="l-navbar">
    <div id="nav1">
        <a href="/main-page-controller?action=backToMain" class="nav_logo">
            <img id="logo" src="https://drive.google.com/uc?id=1cH2mCtzpEW1JtCt0qkxoD6PtEGbuT35c"
                 alt=""
                 class="nav_logo-icon">
        </a>
        <br><br>
        <ul>
            <a style="text-decoration: none" href="/employee?action=getAllEmployee" class="nav_link">
                <ion-icon name="people-outline"></ion-icon>
                Quản lí nhân viên</a>
            <a style="text-decoration: none" href="/customer?action=getAllCustomer" class="nav_link">
                <ion-icon name="person-circle-outline"></ion-icon>
                Quản lí khách hàng</a>
            <a style="text-decoration: none" href="/admin-booking?action=getAllBooking" class="nav_link">
                <ion-icon name="pencil-outline"></ion-icon>
                Duyệt booking</a>
        </ul>
    </div>
    <div id="nav2">
        <h2>QUẢN LÍ NHÂN VIÊN</h2>
        <a style="" href="/employee?action=createEmployee">
            <button type="button" class="btn btn-primary">Thêm</button>
        </a>
        <div class="header">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Tên</th>
                    <th>Căn cước công dân</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Tên tài khoản</th>
                    <th>Sửa</th>
                    <th>Xoá</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="b" items="${list}">
                    <tr>
                        <td><c:out value="${b.name}"/></td>
                        <td><c:out value="${b.identity_number}"/></td>
                        <c:set var="dateString" value="${b.birthday}"/>
                        <fmt:parseDate value="${dateString}" var="date" pattern="yyyy-MM-dd"/>
                        <td>
                            <fmt:formatDate value="${date}" pattern="dd/MM/yyyy"/>
                        </td>
                        <c:if test="${b.gender == 0}">
                            <td>Nam</td>
                        </c:if>
                        <c:if test="${b.gender == 1}">
                            <td>Nữ</td>
                        </c:if>
                        <td><c:out value="${b.phone_number}"/></td>
                        <td><c:out value="${b.email}"/></td>
                        <td><c:out value="${b.user_name}"/></td>
                        <td>
                            <a href="/employee?action=updateEmployee&id=${b.getEmployee_code()}">
                                <button type="button" class="btn btn-warning">Sửa
                                </button>
                            </a>
                        </td>
                        <td>
                            <button onclick="sendInForToModal('${b.employee_code}','${b.name}')" type="button"
                                    class="btn btn-danger"
                                    data-bs-toggle="modal" data-bs-target="#exampleModal">Xoá
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/employee?action=deleteEmployee" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xoá Nhân Viên</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="id_delete" name="id_delete">
                    Bạn có muốn xoá nhân viên <span style="text-transform: uppercase" id="name_delete"
                                                    class="text-danger"></span> không ?
                    <br><br>
                    <span style="color: red">(Lưu ý: Hành động này không thể hoàn tác !)</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button type="submit" class="btn btn-primary">Xoá</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function sendInForToModal(employee_code, name) {
        document.getElementById("name_delete").innerText = name;
        document.getElementById("id_delete").value = employee_code;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</body>
</html>
