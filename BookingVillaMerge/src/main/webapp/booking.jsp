<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 05/09/2023
  Time: 10:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Booking villa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="bg-dark">
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand p-0" href="/main-page-controller?action=backToMain">
            <img src="img_booking/logo.png" alt="logo.png" height="56px"/>
        </a>
    </div>
</nav>
<div style="background: #EAE7D6; width: 100%; height: 400px; text-align: center">
    <div class="text-success" style="text-align: center; padding-top: 50px">
        <h2 style="font-size: 50px; font-weight: bold">C0523G1 - GROUP1</h2>
        <h1 style="font-size: 70px; font-weight: bold">ĐẶT VILLA</h1>
    </div>

</div>
<%--<div class="col-12 ratio ratio-4x3" style="--%>
<%--                    background-image: url('https://img6.thuthuatphanmem.vn/uploads/2022/03/15/mau-background-trang-nha-trong-nha_075707308.jpg') ;--%>
<%--                    background-size: contain;background-position: center; background-repeat: no-repeat">--%>
<%--<div style="padding-top: -130px">--%>
    <div class="p-5 bg-light" style="margin: -130px 10%; border: 1px solid #EAE7D6; border-radius: 2%;background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(30px);">
        <div class="row col-12">
            <div class="col-12">
                <label class="form-label fw-bold">Thông tin người đặt</label>
                <input type="hidden" name="customerCode" value="${customerCode}">
            </div>
            <div class="col-md-6">
                <label for="name" class="form-label">Họ và tên</label>
                <input type="text" name="name" class="form-control" id="name" disabled value="${name}">
            </div>
            <div class="col-md-6 mb-2">
                <label for="phoneNumber" class="form-label">Số điện thoại</label>
                <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" disabled
                       value="${phoneNumber}">
            </div>
            <div class="col-12">
                <div class="form-check ml-1">
                    <input type="checkbox" class="form-check-input" id="signUpForSomeoneElse"
                           onclick="showPersonCheckIn()">
                    <label for="signUpForSomeoneElse" class="form-check-label">Đăng kí hộ</label>
                </div>
            </div>
        </div>

        <div class="row col-12 mt-2" id="informPersonCheckIn" hidden>
            <div class="col-12">
                <label class="form-label fw-bold">Thông tin người nhận</label>
            </div>
            <div class="col-md-6">
                <label for="checkInName" class="form-label">Họ và tên</label>
                <input type="text" name="checkInName" class="form-control" id="checkInName" value="${name}" maxlength="50">
            </div>
            <div class="col-md-6">
                <label for="checkInPhoneNumber" class="form-label">Số điện thoại</label>
                <input type="text" name="checkInPhoneNumber" class="form-control" id="checkInPhoneNumber"
                       value="${phoneNumber}" maxlength="20" pattern="^0{1}[0-9]{9}$">
            </div>
        </div>

        <div class="row col-12 mt-3">
            <div class="col-12">
                <label class="form-label fw-bold">Thời gian</label>
            </div>
            <div class="col-md-6">
                <label for="checkIn" class="form-label">Ngày nhận</label>
                <input type="date" name="checkIn" class="form-control" id="checkIn"
                       placeholder="dd/mm/yyyy" onchange="timeUsed('${villa.price}')" required max="2040-12-31">
                <p id="noteCheckIn" hidden class="text-danger mt-3"></p>
            </div>
            <div class="col-md-6">
                <label for="checkOut" class="form-label">Ngày trả</label>
                <input type="date" name="checkOut" class="form-control" id="checkOut"
                       placeholder="dd/mm/yyyy" onchange="timeUsed('${villa.price}')" required max="2040-12-31">
                <p id="noteCheckOut" hidden class="text-danger mt-3"></p>
            </div>
        </div>

        <div class="row col-12 mt-3">
            <div class="col-12">
                <label class="form-label fw-bold">Thông tin villa ${villa.villaId}</label>
                <input type="hidden" name="villaId" value="${villa.villaId}">
            </div>

            <div class="col-md-6">
                <div class="mb-3" style="height: 308px; background-image: url('${villa.map}');
                        background-size: contain;background-repeat: no-repeat;background-position: center"></div>
                <div class="row mb-3">
                    <label for="relaxRoom" class="col-sm-6 col-form-label">Số phòng thư giãn</label>
                    <div class="col-sm-6">
                        <input type="text" name="relaxRoom" class="form-control" id="relaxRoom" disabled
                               value="${villa.relax}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="gymRoom" class="col-sm-6 col-form-label">Số phòng gym</label>
                    <div class="col-sm-6">
                        <input type="text" name="gymRoom" class="form-control" id="gymRoom" disabled
                               value="${villa.gym}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="garage" class="col-sm-6 col-form-label">Số ga-ra</label>
                    <div class="col-sm-6">
                        <input type="text" name="garage" class="form-control" id="garage" disabled
                               value="${villa.garage}">
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="row mb-3">
                    <label for="deep" class="col-sm-6 col-form-label">Chiều dài</label>
                    <div class="col-sm-6">
                        <input type="text" name="deep" class="form-control" id="deep" disabled
                               value="${villa.deep}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="width" class="col-sm-6 col-form-label">Chiều rộng</label>
                    <div class="col-sm-6">
                        <input type="text" name="width" class="form-control" id="width" disabled
                               value="${villa.width}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="level" class="col-sm-6 col-form-label">Số tầng</label>
                    <div class="col-sm-6">
                        <input type="text" name="level" class="form-control" id="level" disabled
                               value="${villa.level}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="area" class="col-sm-6 col-form-label">Diện tích sử dụng</label>
                    <div class="col-sm-6">
                        <input type="text" name="area" class="form-control" id="area" disabled
                               value="${villa.area}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="livingRoom" class="col-sm-6 col-form-label">Số phòng khách</label>
                    <div class="col-sm-6">
                        <input type="text" name="livingRoom" class="form-control" id="livingRoom" disabled
                               value="${villa.living}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="kitchenRoom" class="col-sm-6 col-form-label">Số phòng bếp</label>
                    <div class="col-sm-6">
                        <input type="text" name="kitchenRoom" class="form-control" id="kitchenRoom" disabled
                               value="${villa.kitchen}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="bedRoom" class="col-sm-6 col-form-label">Số phòng ngủ</label>
                    <div class="col-sm-6">
                        <input type="text" name="bedroom" class="form-control" id="bedroom" disabled
                               value="${villa.bedroom}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="toilet" class="col-sm-6 col-form-label">Số phòng WC</label>
                    <div class="col-sm-6">
                        <input type="text" name="toilet" class="form-control" id="toilet" disabled
                               value="${villa.toilet}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="capacity" class="col-sm-6 col-form-label">Số người tối đa</label>
                    <div class="col-sm-6">
                        <input type="text" name="capacity" class="form-control" id="capacity" disabled
                               value="${villa.capacity}">
                    </div>
                </div>
            </div>
        </div>

        <div class="row col-12">
            <div class="col-12">
                <label class="form-label fw-bold">Đặt cọc</label>
            </div>

            <div class="col-md-6">
                <div class="row mb-3">
                    <label for="totalPayment" class="col-sm-4 col-form-label">Tổng tiền thanh toán</label>
                    <div class="col-sm-8">
                        <input type="text" name="totalPayment" class="form-control" id="totalPayment" readonly
                               style="background: #e9ecef">
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="row mb-3">
                    <label for="deposit" class="col-sm-4 col-form-label">Tiền phải đặt cọc (10%)</label>
                    <div class="col-sm-8">
                        <input type="text" name="deposit" class="form-control" id="deposit" readonly
                               style="background: #e9ecef">
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <label class="form-label">
                    Bạn cần đặt cọc để hoàn thành đặt villa. Số tiền chuyển khoản phải lớn hơn hoặc bằng số tiền đặt
                    cọc.
                    Sau khi chuyển khoản đặt cọc thành công, vui lòng đánh dấu vào ô "Đã chuyển khoản đặt cọc" sau
                    đó
                    nhấn "Đặt villa".
                    <br>
                    Chúng tôi sẽ tiến hành kiểm duyệt và sẽ thông báo đến bạn trong thời gian sớm nhất. Xin cảm ơn!
                    <br>
                    - Tên ngân hàng: Ngân hàng TMCP Xuất Nhập khẩu Việt Nam (Eximbank) - Chi nhánh Nam Đà Nẵng
                    <br>
                    - Tên người nhận: Tập đoàn C0523G1 Group1
                    <br>
                    - Số tài khoản: 0000 9356 23056
                </label>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="transferred" onclick="confirmDeposit()">
                    <label for="transferred" class="form-check-label">Đã chuyển khoản đặt cọc</label>
                </div>
            </div>
            <div class="col-md-4 text-center m-auto">
                <img src="img_booking/licensed-image.png" style="height: 200px;width: 200px;text-align: center"/>
            </div>
        </div>

        <div class="col-12">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#bookingModal"
                    id="bookingVilla" onclick="booking()" disabled>Đặt villa
            </button>
        </div>
    </div>
<%--</div>--%>
<div class="modal fade" id="bookingModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">>
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/booking?action=createBooking" method="post">
                <div class="modal-header bg-success">
                    <h5 class="modal-title text-light">Đặt villa thành công</h5>
                    <%--                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" id="checkInBooking" name="checkInBooking">
                    <input hidden="hidden" id="checkOutBooking" name="checkOutBooking">
                    <input hidden="hidden" id="priceBooking" name="priceBooking">
                    <input hidden="hidden" id="depositBooking" name="depositBooking">
                    <input hidden="hidden" id="checkInNameBooking" name="checkInNameBooking">
                    <input hidden="hidden" id="checkInPhoneNumberBooking" name="checkInPhoneNumberBooking">
                    <input hidden="hidden" id="villaIdBooking" name="villaIdBooking" value="${villa.villaId}">
                    <input hidden="hidden" id="customerCodeBooking" name="customerCodeBooking" value="${customerCode}">
                    <p>Bạn đã đặt <b>villa ${villa.villaId}</b>
                        từ ngày <b id="checkInModal"></b> đến ngày <b id="checkOutModal"></b>
                        thành công
                    </p>
                    <br>
                    <p>
                        <u>Lưu ý:</u><br>
                        - Bạn chỉ có thể hủy đặt villa trước 2 ngày so với ngày nhận villa.<br>
                        - Bạn sẽ phải mất toàn bộ tiền cọc nếu hủy đặt villa.<br>
                        - Mọi phát sinh hoặc thắc mắc xin vui lòng liên hệ SĐT: 089093134 (Ms. Hạnh) để được giải
                        đáp.<br>
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-success" data-bs-toggle="modal"
                            data-bs-target="#bookingSuccessModal"
                            id="" onclick="confirmBooking()">OK
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function timeUsed(price) {
        document.getElementById("totalPayment").value = 0;
        let checkIn = new Date(document.getElementById("checkIn").value);
        let checkOut = new Date(document.getElementById("checkOut").value);
        let timeUsed = 1 + (checkOut.getTime() - checkIn.getTime()) / (24 * 3600 * 1000);
        let currentDate = new Date();
        let timeCheckIn = (checkIn.getTime() - currentDate) / (24 * 3600 * 1000);
        let timeCheckOut = (checkOut.getTime() - currentDate) / (24 * 3600 * 1000);
        document.getElementById("totalPayment").value = price * timeUsed;
        document.getElementById("deposit").value = document.getElementById("totalPayment").value / 10;
        if(timeCheckIn < 1){
            document.getElementById('checkIn').focus();
            document.getElementById('noteCheckIn').hidden = false;
            document.getElementById('noteCheckIn').textContent = "Bạn phải đặt villa trước 2 ngày so với ngày nhận phòng";
        } else if(timeUsed<1) {
            document.getElementById('checkIn').focus();
            document.getElementById('noteCheckIn').hidden = false;
            document.getElementById('noteCheckIn').textContent = "Ngày nhận villa phải nhỏ hơn hoặc bằng ngày trả villa";
        } else {
            document.getElementById('noteCheckIn').hidden = true;
        }
        if(timeCheckOut < 1 && document.getElementById("checkIn").value === ""){
            document.getElementById('checkOut').focus();
            document.getElementById('noteCheckOut').hidden = false;
            document.getElementById('noteCheckOut').textContent = "Bạn phải đặt villa trước 2 ngày so với ngày nhận trả villa";
        } else if(timeUsed<1) {
            document.getElementById('checkOut').focus();
            document.getElementById('noteCheckOut').hidden = false;
            document.getElementById('noteCheckOut').textContent = "Ngày trả villa phải lớn hơn hoặc bằng ngày nhận villa";
        } else {
            document.getElementById('noteCheckOut').hidden = true;
        }
    }

    function showPersonCheckIn() {
        if (document.getElementById("signUpForSomeoneElse").checked) {
            document.getElementById("informPersonCheckIn").hidden = false
        } else {
            document.getElementById("informPersonCheckIn").hidden = true
        }
    }

    function confirmDeposit() {
        // if(document.getElementById("checkIn").value === ""){
        //     document.getElementById("CheckIn").focus();
        //     document.getElementById("noteCheckIn").hidden = false;
        //     document.getElementById("noteCheckIn").value = "Bạn chưa chọn ngày nhận villa"
        //     document.getElementById("transferred").checked = false;
        // }
        // if(document.getElementById("checkOut").value === "" && document.getElementById("checkIn").value !== ""){
        //     document.getElementById("CheckOut").focus();
        //     document.getElementById("noteCheckOut").hidden = false;
        //     document.getElementById("noteCheckOut").value = "Bạn chưa chọn ngày trả villa"
        //     document.getElementById("transferred").checked = false;
        // }
        if(document.getElementById("noteCheckIn").hidden === true && document.getElementById("noteCheckOut").hidden === true) {
            if (document.getElementById("transferred").checked) {
                document.getElementById("bookingVilla").disabled = false
            } else {
                document.getElementById("bookingVilla").disabled = true
            }
        }
    }

    function booking() {
        document.getElementById("checkInModal").textContent = document.getElementById("checkIn").value;
        document.getElementById("checkOutModal").textContent = document.getElementById("checkOut").value;
        document.getElementById("checkInBooking").value = document.getElementById("checkIn").value;
        document.getElementById("checkOutBooking").value = document.getElementById("checkOut").value;
        document.getElementById("priceBooking").value = document.getElementById("totalPayment").value;
        document.getElementById("depositBooking").value = document.getElementById("deposit").value;
        document.getElementById("checkInNameBooking").value = document.getElementById("checkInName").value;
        document.getElementById("checkInPhoneNumberBooking").value = document.getElementById("checkInPhoneNumber").value;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous">
</script>
</body>
</html>
