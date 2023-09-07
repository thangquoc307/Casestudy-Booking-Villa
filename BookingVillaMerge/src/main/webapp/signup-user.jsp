<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 8/31/2023
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="css_user/css/login_sign_up.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="css_index/main_page_css.css">
</head>
<body>
<section class="bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');background-size:cover">
    <div class="mask d-flex align-items-center gradient-custom-3">
        <div class="container">
            <div class="row d-flex justify-content-center align-items-center">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <div class="form-outline mb-4"><img style="width: 100%; height: auto; margin-bottom: 6%" src="css_user/css/logo/logo.png" alt=""></div>
                            <form action="/signup" method="post" id="form-1">
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="fullName">Họ và tên</label>
                                    <input type="text" id="fullName" name="fullName" class="form-control form-control-lg" required/>
                                </div>

                                <p class="text-danger" role="alert">${identityNumberError}</p>
                                <span id="identityNumberFormatError" class="text-danger" role="alert"></span>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="identityNumber">CMND/CCCD</label>
                                    <input onfocus="clearErrorIdentityNumber()" onblur="validateIdentityNumber()" type="text" name="identityNumber" id="identityNumber" class="form-control form-control-lg" required/>
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="dateOfBirth">Ngày sinh</label>
                                    <input type="date" name="dateOfBirth" id="dateOfBirth" class="form-control form-control-lg" required/>
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label">Giới tính</label>
                                    <select name="gender" id="gender">
                                        <option value="male">Nam</option>
                                        <option value="female">Nữ</option>
                                        <option value="other">Khác</option>
                                    </select>
                                </div>

                                <p class="text-danger" role="alert">${emailError}</p>
                                <span id="emailFormatError" class="text-danger" role="alert"> </span>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="email">Email</label>
                                    <input onblur="validateEmail()" onfocus="clearErrorEmail()" type="text" id="email" name="email" class="form-control form-control-lg" required/>
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="address">Địa chỉ</label>
                                    <input type="text" id="address" name="address" class="form-control form-control-lg" required/>
                                </div>

                                <p class="text-danger" role="alert">${phoneNumberError}</p>

                                <span id="phoneNumberFormatError" class="text-danger" role="alert"> </span>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="phoneNumber">Số điện thoại</label>
                                    <input onblur="validatePhoneNumber()" onfocus="clearErrorPhoneNumber()" type="text" id="phoneNumber" name="phoneNumber" class="form-control form-control-lg" required/>
                                </div>

                                <hr style="margin: 15% 0%">

                                <p class="text-danger" role="alert">${userNameError}</p>

                                <span id="userNameFormatError" class="text-danger" role="alert"> </span>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="userName">Tên tài khoản</label>
                                    <input onblur="validateUserName()" onfocus="clearErrorUserName()" type="text" name="userName" id="userName" class="form-control form-control-lg" required/>
                                </div>

                                <p class="text-danger" role="alert">${passwordError}</p>

                                <span id="passwordFormatError" class="text-danger" role="alert"> </span>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="password">Mật khẩu</label>
                                    <input onblur="validatePassword()" onfocus="clearErrorPassword()" type="password" id="password" name="password" class="form-control form-control-lg" required/>
                                    <span class="form-message"></span>
                                </div>

                                <p class="text-danger" role="alert"> ${passwordConfirmError} </p>
                                <span id="passwordConfirmFormatError" class="text-danger" role="alert"> </span>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="passwordConfirm">Nhập lại mật khẩu</label>
                                    <input onblur="validatePasswordConfirm()" onfocus="clearErrorPasswordConfirm()" type="password" id="passwordConfirm" name="passwordConfirm" class="form-control form-control-lg" required/>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button  onclick="validatePhoneNumber()" id="submitButton" style="border-radius: 50px; margin-top: 5%" type="submit" class="backgroundcolor-2 hover btn-sign-up">Đăng ký</button>
                                </div>
                                <p class="text-center text-muted mt-5 mb-0">Đã có tài khoản?
                                    <a href="login.jsp" class="fw-bold text-body"><u>Nhấn vào để đăng nhập</u></a></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="/css_user/javascript/validate_form.js"> </script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
