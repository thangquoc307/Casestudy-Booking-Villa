<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Log In</title>
    <link rel="stylesheet" href="css_user/css/login_sign_up.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="css_index/main_page_css.css">
</head>
<body style="background-image: url('css_user/css/logo/img4.jpg');background-size:cover">
<section class="bg-image">
    <div class="mask d-flex align-items-center">
        <div class="container ">
            <div class="row d-flex justify-content-center align-items-center">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6" style="margin-top: 10%">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <div class="form-outline mb-4"><img
                                    style="width: 100%; height: auto; margin-bottom:6%; align-items: center"
                                    src="/css_user/css/logo/logo.png" alt=""></div>
                            <form action="/login?action=login" method="post">

                                <p class="text-danger" role="alert">${message}</p>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="phoneNumber">Số điện thoại</label>
                                    <input type="text" id="phoneNumber" name="phoneNumber"
                                           class="form-control form-control-lg" required/>
                                </div>

                                <span id="passwordFormatError" class="text-danger" role="alert"> </span>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="password">Mật khẩu</label>
                                    <input type="password" id="password" name="password"
                                           class="form-control form-control-lg" required/>
                                </div>
                                <div class="form-outline mb-4">
                                    <a style="float: left" href="signup-user.jsp" class="fw-bold text-body"><u>Đăng
                                        ký</u></a>
                                    <a style="float:  right" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                       class="fw-bold text-body"><u>Quên mật khẩu?</u></a>
                                </div>
                                <div>
                                    <button id="submitButton" type="submit" class="backgroundcolor-2 hover btn-login">
                                        Đăng nhập
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Nhập email đã đăng ký tại trang web</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/forgot-password">
                <input name="action" value="sendEmail" hidden="">
                <div class="modal-body">
                    <input style="width: 100%;border-radius:50px;padding: 5px" type="email" name="email" id="email">
                </div>
                <div class="modal-footer">
                    <button id="btn-email" type="submit" class="btn btn-primary">Gửi đi</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    let button = document.getElementById('btn-email');
    let emailInput = document.getElementById('email');
    let lastEmailTime = null;
    let contentCreationTime = null;

    button.addEventListener('click', function(event) {
        let currentTime = new Date().getTime();
        let elapsedTime = currentTime - lastEmailTime;

        if (lastEmailTime === null || elapsedTime >= 2 * 60 * 1000) {
            button.disabled = true;

            let xhr = new XMLHttpRequest();
            xhr.open('GET','/forgot-password?action=sendEmail&email=' + emailInput.value, true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        let response = JSON.parse(xhr.responseText);
                        let attributeValue = response.attribute;
                        alert(attributeValue);

                        lastEmailTime = new Date().getTime();
                        contentCreationTime = lastEmailTime;
                        button.disabled = true;
                    } else {
                        alert('Email không tồn tại trong hệ thống hoặc sai định dạng.');
                        button.disabled = false;
                    }
                }
            };
            xhr.send();
        }
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<script src="/css_user/javascript/validate_form.js"></script>
</body>
</html>
