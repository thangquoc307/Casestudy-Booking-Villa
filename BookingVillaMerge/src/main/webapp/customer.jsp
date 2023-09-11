<%--
  Created by IntelliJ IDEA.
  User: myhanh
  Date: 04/09/2023
  Time: 00:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css_admin/admin.css">
<meta charset="UTF-8">
<title>Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous">
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
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
        <h2>QUẢN LÍ KHÁCH HÀNG</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Tên</th>
                <th>Căn cước công dân</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Địa chỉ</th>
                <th>Tên tài khoản</th>
                <th>Xoá</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${list}">
                <tr>
                    <td><c:out value="${c.name}"/></td>
                    <td><c:out value="${c.identity_number}"/></td>
                    <td><c:out value="${c.birthday}"/></td>
                    <c:if test="${c.gender == 0}">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${c.gender == 1}">
                        <td>Nữ</td>
                    </c:if>
                    <td><c:out value="${c.phone_number}"/></td>
                    <td><c:out value="${c.email}"/></td>
                    <td><c:out value="${c.address}"/></td>
                    <td><c:out value="${c.user_name}"/></td>
                    <td>
                        </button>
                        <button onclick="sendInForToModal('${c.customer_code}','${c.name}')" type="button"
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

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/customer?action=deleteCustomer" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xoá tài khoản khách hàng</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="id_delete" name="id_delete">
                    Bạn có muốn xoá khách hàng <span style="text-transform: uppercase" id="name_delete" class="text-danger"></span> không ?
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
    function sendInForToModal(customer_code, name) {
        document.getElementById("name_delete").innerText = name;
        document.getElementById("id_delete").value = customer_code;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous">
</script>
</body>
</html>
