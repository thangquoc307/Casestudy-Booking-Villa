<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/5/2023
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin</title>
    <link rel="stylesheet" href="css_user/css/login_sign_up.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="css_index/main_page_css.css">
</head>
<body  style="background-image: url('css_user/css/logo/img4.jpg');background-size: cover">
<section class="bg-image">
    <div class="mask d-flex align-items-center">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6" style="margin-top: 10%">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <div class="form-outline mb-4">
                                <h3 style="text-align: center">Sửa thông tin</h3>
                            </div>
                            <form action="/login?action=update" method="post">
                                <p class="text-danger" role="alert">${updateError}</p>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="fullName">Họ và tên</label>
                                    <input type="text" id="fullName" name="fullName" value="${sessionScope.userName}" class="form-control form-control-lg" required/>
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="birthday">Ngày sinh</label>
                                    <input  type="date" id="birthday" name="birthday" value="${sessionScope.dateOfBirth}" class="form-control form-control-lg" required/>
                                </div>

                                <div class="form-outline mb-4">
                                    <label for="gender">Giới tính:</label>
                                    <select name="gender" id="gender">
                                        <option ${sessionScope.gender == "Nam"  ? "selected" :''} value="Nam">Nam</option>
                                        <option ${sessionScope.gender == "Nữ"  ? "selected" :''} value="Nữ">Nữ</option>
                                    </select>
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="address">Địa chỉ</label>
                                    <input type="text" value="${sessionScope.address}" id="address" name="address" class="form-control form-control-lg" required />
                                </div>

                                <div class="form-outline mb-4">
                                    <a style="float: right" href="/user-information.jsp" class="fw-bold text-body"><u>Trở về</u></a>
                                </div>
                                <div>
                                    <button  id="submitButton"  type="submit" class="backgroundcolor-2 hover btn-login">Hoàn thành</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<script src="/css_user/javascript/validate_form.js"></script>
