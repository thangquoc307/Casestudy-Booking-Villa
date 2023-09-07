<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css_admin/form.css">
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<a href="/employee">
    <button type="button" class="btn btn-outline-success">
        Trở về
    </button>
</a>
<div class="container">
    <div class="employee-table">
        <div class="employee-form">
            <h2>Thêm nhân viên</h2>
            <form action="/employee?action=createEmployee" method="POST">

                <label for="name">Họ và tên:</label>
                <input type="text" id="name" name="name" required>

                <label for="identity_number">Số CMND:</label>
                <input type="text" id="identity_number" name="identity_number" required>

                <label for="birthday">Ngày sinh:</label>
                <input type="date" id="birthday" name="birthday" required>

                <label for="gender">Giới tính:</label>
                <select id="gender" name="gender" required>
                    <option value="0">Nam</option>
                    <option value="1">Nữ</option>
                </select>

                <label for="phone_number">Số điện thoại:</label>
                <input type="text" id="phone_number" name="phone_number">

                <label for="email">Email:</label>
                <input type="email" id="email" name="email">

                <label for="user_name">Tên tài khoản:</label>
                <input type="text" id="user_name" name="user_name">

                <label for="password_account">Mật khẩu:</label>
                <input type="password" id="password_account" name="password_account">

                <button type="submit">Thêm</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>