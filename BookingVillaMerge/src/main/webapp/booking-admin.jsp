<%--
  Created by IntelliJ IDEA.
  User: myhanh
  Date: 06/09/2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <img id="logo" src="https://drive.google.com/uc?id=1cH2mCtzpEW1JtCt0qkxoD6PtEGbuT35c" alt=""
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
        <h2>QUẢN LÍ BOOKING</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Tên villa</th>
                <th>Ngày nhận</th>
                <th>Ngày trả</th>
                <th>Ngày booking</th>
                <th>Giá</th>
                <th>Đặt cọc</th>
                <th>Người đặt</th>
                <th>Số điện thoại người đặt</th>
                <th>Mã khách hàng</th>
                <th>Duyệt</th>
                <th>Xoá</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="b" items="${list}">
                <tr>
                    <td>Villa <c:out value="${b.villaId}"/></td>
                    <td><c:out value="${b.checkIn}"/></td>
                    <td><c:out value="${b.checkOut}"/></td>
                    <td><c:out value="${b.bookingDate}"/></td>
                    <td>
                        <fmt:formatNumber value="${b.price}" type="currency" currencySymbol="" maxFractionDigits="0" />
                    </td>
                    <td>
                        <fmt:formatNumber value="${b.deposit}" type="currency" currencySymbol="" maxFractionDigits="0" />
                    </td>
                    <td><c:out value="${b.checkInPersonName}"/></td>
                    <td><c:out value="${b.checkInPersonPhoneNumber}"/></td>
                    <td><c:out value="${b.customerCode}"/></td>
                    <td>
                        <button ${b.pending == 'true' ? '' : 'disabled'} onclick="sendInForToModalApproved('${b.id}')" type="button" class="btn btn-warning"
                                data-bs-toggle="modal" data-bs-target = "#exampleModal1">
                            <c:out value="${b.pending == 'true' ? ' Duyệt' : 'Đã duyệt'}"/>
                        </button>
                    </td>
                    <td>
                        <button  onclick="sendInForToModal('${b.id}')" type="button" class="btn btn-danger"
                                class="btn btn-outline-success"
                                data-bs-toggle="modal" data-bs-target = "#exampleModal">Xoá
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/admin-booking?action=deleteBooking" method="post">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Xoá booking</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="id_delete" name="id_delete">
                        Bạn có muốn xoá <span id="name_delete" class="text-danger"></span> không ?
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

    <!-- Modal -->
    <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/admin-booking?action=updateBooking" method="post">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModal1Label">Duyệt booking</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="bookingIdApproved" name="bookingIdApproved">
                        Bạn có muốn duyệt Booking <span id="id_bookingIdApproved" class="text-danger"></span> không ?
                        <br><br>
                        <span style="color: red">(Lưu ý: Hành động này không thể hoàn tác !)</span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                        <button type="submit" class="btn btn-primary">Duyệt</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
</div>
<script>
    function sendInForToModal(bookingId) {
        document.getElementById("name_delete").innerText = "MÃ BOOKING " + bookingId;
        document.getElementById("id_delete").value = bookingId;
    }
    function sendInForToModalApproved(bookingId) {
        document.getElementById("id_bookingIdApproved").innerText = "MÃ BOOKING " + bookingId;
        document.getElementById("bookingIdApproved").value = bookingId;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>

</body>
</html>
