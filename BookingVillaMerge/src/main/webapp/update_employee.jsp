<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css_admin/form.css">
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<a href="/employee">
    <button type="button" class="btn btn-outline-success">Trở về
    </button>
</a>
    <div class="container">
        <div class="employee-table">
            <div class="employee-form">
                <h2>Sửa nhân viên</h2>
                <form action="/employee?action=updateEmployee" method="POST">
                    <c:if test="${employee != null}">
                        <input type="hidden" name="employee_code" value="<c:out value='${employee.employee_code}' />"/>
                    </c:if>

                    <label for="name">Họ và tên:</label>
                    <input type="text" id="name" name="name"
                           value="${employee.name}"/>

<%--                    <label for="identity_number">Số CMND:</label>--%>
                    <input type="hidden" id="identity_number" name="identity_number"
                           value="<c:out value='${employee.identity_number}'/>"/>

                    <label for="birthday">Ngày sinh:</label>
                    <input type="date" id="birthday" name="birthday"
                           value="<c:out value='${employee.birthday}'/>"/>

                    <label for="gender">Giới tính:</label>
                    <select name="gender" id="gender">
                        <option ${employee.gender == 1  ? "selected" : ""} value="1">Nữ</option>
                        <option ${employee.gender == 0  ? "selected" : ""} value="0">Nam</option>
                    </select>

                    <label for="phone_number">Số điện thoại:</label>
                    <input type="text" id="phone_number" name="phone_number"
                           value="<c:out value='${employee.phone_number}'/>"/>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email"
                           value="<c:out value='${employee.email}'/>"/>

                    <label for="user_name">Tên tài khoản:</label>
                    <input type="user_name" id="user_name" name="user_name"
                           value="<c:out value='${employee.user_name}'/>"/>

                    <label for="password_account">Mật khẩu:</label>
                    <input type="password" id="password_account" name="password_account"
                           value="<c:out value='${employee.password_account}'/>"/>


                    <button type="submit">Sửa</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>