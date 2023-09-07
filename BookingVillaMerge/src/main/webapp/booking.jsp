<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 05/09/2023
  Time: 10:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking villa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand p-0" href="/booking">
            <img src="img_booking/logo.png" alt="logo.png" height="56px"/>
        </a>
    </div>
</nav>
<div style="background: #EAE7D6; height: 40px">
    <h5 style="line-height: 40px">Đặt phòng villa</h5>
</div>

<div class="col-12 bg-image" style=" width: 100%; height: 293px; margin: auto;
                    background-size: cover"></div>

<div class="p-5 bg-light" style="margin: -100px 10%; border: 1px solid #EAE7D6; border-radius: 2%;background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(30px);">
    <form class="row g-3 justify-content-center" action="/booking?action=createBooking">
        <div class="row col-12">
            <div class="col-12">
                <label class="form-label fw-bold">Thông tin người đặt</label>
            </div>
            <div class="col-md-6">
                <label for="name" class="form-label" >Họ và tên</label>
                <input type="text" name="name" class="form-control" id="name" disabled value="${account.userName}">
            </div>
            <div class="col-md-6 mb-2">
                <label for="phoneNumber" class="form-label">Số điện thoại</label>
                <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" disabled value="${account.userName}">
            </div>
            <div class="col-12">
                <div class="form-check ml-1">
                    <input type="checkbox" class="form-check-input" id="signUpForSomeoneElse">
                    <label for="signUpForSomeoneElse" class="form-check-label">Đăng kí hộ</label>
                </div>
            </div>
        </div>

        <div class="row col-12 mt-2">
            <div class="col-12">
                <label class="form-label fw-bold">Thông tin người nhận</label>
            </div>
            <div class="col-md-6">
                <label for="checkInName" class="form-label" >Họ và tên</label>
                <input type="text" name="checkInName" class="form-control" id="checkInName">
            </div>
            <div class="col-md-6">
                <label for="checkInPhoneNumber" class="form-label">Số điện thoại</label>
                <input type="text" name="checkInPhoneNumber" class="form-control" id="checkInPhoneNumber">
            </div>
        </div>

        <div class="row col-12 mt-3">
            <div class="col-12">
                <label class="form-label fw-bold">Thời gian</label>
            </div>
            <div class="col-md-6">
                <label for="checkIn" class="form-label" >Ngày nhận</label>
                <input type="date" name="checkIn" class="form-control" id="checkIn" placeholder="dd/mm/yyyy">
            </div>
            <div class="col-md-6">
                <label for="checkOut" class="form-label">Ngày trả</label>
                <input type="date" name="checkOut" class="form-control" id="checkOut" placeholder="dd/mm/yyyy">
            </div>
        </div>

        <div class="row col-12 mt-3">
            <div class="col-12">
                <label class="form-label fw-bold">Thông tin villa</label>
            </div>

            <div class="col-md-6">
                <div class="col-sm-6 mb-3" style="height: 308px">

                </div>
                <div class="row mb-3">
                    <label for="relaxRoom" class="col-sm-6 col-form-label">Số phòng thư giãn</label>
                    <div class="col-sm-6">
                        <input type="text" name="relaxRoom" class="form-control" id="relaxRoom" disabled value="${Villa.relaxRoom}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="gymRoom" class="col-sm-6 col-form-label">Số phòng gym</label>
                    <div class="col-sm-6">
                        <input type="text" name="gymRoom" class="form-control" id="gymRoom" disabled value="${Villa.gymRoom}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="garage" class="col-sm-6 col-form-label">Số ga-ra</label>
                    <div class="col-sm-6">
                        <input type="text" name="garage" class="form-control" id="garage" disabled value="${Villa.garage}">
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="row mb-3">
                    <label for="deep" class="col-sm-6 col-form-label" >Chiều dài</label>
                    <div class="col-sm-6">
                        <input type="text" name="deep" class="form-control" id="deep" disabled value="${Villa.deep}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="width" class="col-sm-6 col-form-label">Chiều rộng</label>
                    <div class="col-sm-6">
                        <input type="text" name="width" class="form-control" id="width" disabled value="${Villa.width}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="level" class="col-sm-6 col-form-label">Số tầng</label>
                    <div class="col-sm-6">
                        <input type="text" name="level" class="form-control" id="level" disabled value="${Villa.level}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="area" class="col-sm-6 col-form-label">Diện tích sử dụng</label>
                    <div class="col-sm-6">
                        <input type="text" name="area" class="form-control" id="area" disabled value="${Villa.area}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="livingRoom" class="col-sm-6 col-form-label">Số phòng khách</label>
                    <div class="col-sm-6">
                        <input type="text" name="livingRoom" class="form-control" id="livingRoom" disabled value="${Villa.livingRoom}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="kitchenRoom" class="col-sm-6 col-form-label">Số phòng bếp</label>
                    <div class="col-sm-6">
                        <input type="text" name="kitchenRoom" class="form-control" id="kitchenRoom" disabled value="${Villa.kitchenRoom}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="bedRoom" class="col-sm-6 col-form-label">Số phòng ngủ</label>
                    <div class="col-sm-6">
                        <input type="text" name="bedRoom" class="form-control" id="bedRoom" disabled value="${Villa.bedRoom}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="toilet" class="col-sm-6 col-form-label">Số phòng WC</label>
                    <div class="col-sm-6">
                        <input type="text" name="toilet" class="form-control" id="toilet" disabled value="${Villa.toilet}">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="capacity" class="col-sm-6 col-form-label">Số người tối đa</label>
                    <div class="col-sm-6">
                        <input type="text" name="capacity" class="form-control" id="capacity" disabled value="${Villa.capacity}">
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
                    <label for="price" class="col-sm-4 col-form-label">Tổng tiền thanh toán</label>
                    <div class="col-sm-8">
                        <input type="text" name="price" class="form-control" id="price" disabled value="${Villa.price}">
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="row mb-3">
                    <label for="deposit" class="col-sm-4 col-form-label">Tiền phải đặt cọc</label>
                    <div class="col-sm-8">
                        <input type="text" name="deposit" class="form-control" id="deposit" disabled>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <label class="form-label">
                    Bạn cần đặt cọc để hoàn thành đặt villa. Số tiền chuyển khoản phải lớn hơn hoặc bằng số tiền đặt cọc.
                    Sau khi chuyển khoản đặt cọc thành công, vui lòng đánh dấu vào ô "Đã chuyển khoản đặt cọc" sau đó nhấn "Đặt villa".
                    <br>
                    Chúng tôi sẽ tiến hành kiểm duyệt và sẽ thông báo đến bạn trong thời gian sớm nhất. Xin cảm ơn!
                    <br>
                    - Tên ngân hàng: Ngân hàng TMCP Xuất Nhập khẩu Việt Nam (Eximbank) - Chi nhánh Nam Đà Nẵng
                    <br>
                    - Tên người nhận: Tập đoàn C0523G1 Group1
                    <br>
                    - Số tài khoản: 0000 9356 23056
                </label>
                <div class="form-check ml-1">
                    <input type="checkbox" class="form-check-input" id="">
                    <label for="signUpForSomeoneElse" class="form-check-label">Đã chuyển khoản đặt cọc</label>
                </div>
            </div>
            <div class="col-md-4 text-center m-auto">
                <img src="img_booking/licensed-image.png" style="height: 200px;width: 200px;text-align: center" />
            </div>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Đặt villa</button>
        </div>
    </form>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <script>
        document.getElementById("deposit").value = document.getElementById("price").value/10;
    </script>
</body>
</html>
