<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 06/09/2023
  Time: 9:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Danh sách booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <style>
        /*body {*/
        /*    margin: 0 50px;*/
        /*}*/

        tbody tr:nth-child(odd) {
            background: gainsboro;
        }

        table {
            border: 1px solid gainsboro;
            width: 100%;
        }

        th, td {
            width: 14.28%;
            height: 60px;
            padding-left: 10px;
            border-collapse: collapse;
        }

        tbody tr:hover{
            background: lightgray;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <div class="container-fluid">
        <a class="navbar-brand p-0" href="/booking">
            <img src="img_booking/logo.png" alt="logo.png" height="56px"/>
        </a>
        <div class="d-flex">
            <form action="/booking?action=searchByCountry" method="post" class="d-flex m-auto" role="search">
                <input class="form-control me-2" type="search" placeholder="Nhập tên villa" aria-label="Search"
                       name="villaIdSearch" id="villaIdSearch" oninput="villaSearch()" value="${villaIdSearch}">
                <button class="btn btn-outline-success" type="submit" id="searchCountry" style="width: 150px">Tìm kiếm</button>
            </form>
            <a href="/booking?action=showInformationUser">
                <img src="img_booking/user-profile-icon-free-vector.png" style="width: 56px; height: 56px">
            </a>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="btn-group" style="width: 100%">
        <a href="/booking?action=showListPending" class="btn btn-outline-secondary rounded-0">Chưa duyệt</a>
        <a href="/booking?action=showListApproved" class="btn btn-outline-secondary rounded-0">Đã duyệt</a>
        <a href="/booking?action=showListDelete" class="btn btn-outline-secondary rounded-0">Đã hủy</a>
    </div>
    <table>
        <thead>
        <tr>
            <th>Stt</th>
            <th>Mã số villa</th>
            <th>Ngày nhận</th>
            <th>Ngày trả</th>
            <th>Giá</th>
            <th>Đặt cọc</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="booking" items="${bookingList}" varStatus="ordinalNumber">
            <tr>
                <td><c:out value="${ordinalNumber.count}"/></td>
                <td><c:out value="Villa ${booking.villaId}"/></td>
                <td><c:out value="${booking.checkIn}"/></td>
                <td><c:out value="${booking.checkOut}"/></td>
                <td><fmt:formatNumber value="${booking.price}"/></td>
                <td><fmt:formatNumber value="${booking.deposit}"/></td>
                <td><button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal"
                             onclick="sendInformToModalUpdate('${booking.bookingId}','${booking.villaId}',
                                     '${booking.checkIn}','${booking.checkOut}',
                                     '${booking.checkInPersonName}','${booking.checkInPersonPhoneNumber}')">Sửa
                </button>

                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal"
                            onclick="sendInformToModalDelete('${booking.bookingId}','${booking.villaId}',
                                    '${booking.checkIn}','${booking.checkOut}')">Hủy
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div id="updateModal" class="modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/booking?action=updateBooking" method="post">
                <div class="modal-header bg-warning">
                    <h5 class="modal-title">Thay đổi thông tin đặt villa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Thông tin đặt <b>villa <span id="villaIdUpdate"></span></b>
                        từ ngày <span id="checkInUpdate" class="fw-bold"></span> đến ngày <span id="checkOutUpdate" class="fw-bold"></span></p>
                    <input type="hidden" id="bookingIdUpdate" name="bookingIdUpdate">
                    <div class="mb-3">
                        <label for="checkInPersonNameUpdate" class="form-label">Người nhận</label>
                        <input id="checkInPersonNameUpdate" name="checkInPersonNameUpdate" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="checkInPersonPhoneNumberUpdate" class="form-label">Số điện thoại</label>
                        <input id="checkInPersonPhoneNumberUpdate" name="checkInPersonPhoneNumberUpdate" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-outline-warning">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="deleteModal" class="modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/booking?action=deleteBooking" method="post">
                <div class="modal-header bg-danger">
                    <h5 class="modal-title text-light">Hủy đặt villa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Bạn chắc chắn muốn hủy đặt <b class="text-danger">villa <span id="villaIdDelete"></span></b>
                    từ ngày <span id="checkInDelete" class="fw-bold"></span> đến ngày <span id="checkOutDelete" class="fw-bold"></span></p>
                    <input type="hidden" id="bookingIdDelete" name="bookingIdDelete">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-outline-danger">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous">
</script>
<script>
    function clickShowListPending() {
        document.getElementById('showListPending').style.background = "gray";
    }

    function sendInformToModalDelete(bookingIdDelete, villaIdDelete, checkInDelete, checkOutDelete) {
        document.getElementById("villaIdDelete").textContent = villaIdDelete;
        document.getElementById("checkInDelete").textContent = checkInDelete;
        document.getElementById("checkOutDelete").textContent = checkOutDelete;
        document.getElementById("bookingIdDelete").value = bookingIdDelete;
    }

    function sendInformToModalUpdate(bookingIdUpdate, villaIdUpdate, checkInUpdate, checkOutUpdate,
                                     checkInPersonNameUpdate, checkInPersonPhoneNumberUpdate) {
        document.getElementById("villaIdUpdate").textContent = villaIdUpdate;
        document.getElementById("checkInUpdate").textContent = checkInUpdate;
        document.getElementById("checkOutUpdate").textContent = checkOutUpdate;
        document.getElementById("bookingIdUpdate").value = bookingIdUpdate;
        document.getElementById("checkInPersonNameUpdate").value = checkInPersonNameUpdate;
        document.getElementById("checkInPersonPhoneNumberUpdate").value = checkInPersonPhoneNumberUpdate;
    }

    <%--function inputSearch() {--%>
    <%--    document.getElementById("searchCountry").click();--%>
    <%--}--%>

    <%--window.onload = function () {--%>
    <%--    document.getElementById("countrySearch").focus();--%>
    <%--    document.getElementById("countrySearch").value = '${countrySearch}';--%>
    <%--}--%>
</script>
</body>
</html>
