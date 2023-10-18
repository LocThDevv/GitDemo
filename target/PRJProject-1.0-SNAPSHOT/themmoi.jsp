<%-- 
    Document   : themmoi
    Created on : Jun 23, 2023, 12:19:41 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.File"%>
<%@page import="Models.Product"%>
<%@page import="DAOs.productDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
        <title>JSP Page</title>
        <link rel="stylesheet" href="/PRJProject/css/bootstrap.min.css">
        <script src="/PRJProject/js/code.jquery.com_jquery-3.7.0.min.js"></script>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

        <script>
            $(document).ready(function () {
                $("form").submit(function (event) {
                    // Xóa thông báo lỗi trước đó
                    $(".error").remove();

                    // Thực hiện kiểm tra dữ liệu
                    var pro_id = $("#pro_id").val().trim();
                    var pro_name = $("#pro_name").val().trim();
                    var pro_quan = $("#pro_quan").val().trim();
                    var pro_price = $("#pro_price").val().trim();
                    var pro_pic = $("#pro_pic").val().trim();
                    var pro_des = $("#pro_des").val().trim();
                    var isValid = true;

                    if (pro_id === "") {
                        isValid = false;
                        $("#pro_id").after("<div style='color: red;' class='error'>Vui lòng điền đầy đủ thông tin.</div>");
                        event.preventDefault();
                    }
                    if (pro_name === "") {
                        isValid = false;
                        $("#pro_name").after("<div style='color: red;' class='error'>Vui lòng điền đầy đủ thông tin.</div>");
                        event.preventDefault();
                    }
                    if (pro_quan === "") {
                        isValid = false;
                        $("#pro_quan").after("<div style='color: red;' class='error'>Vui lòng điền đầy đủ thông tin.</div>");
                        event.preventDefault();
                    }
                    if (pro_price === "") {
                        isValid = false;
                        $("#pro_price").after("<div style='color: red;' class='error'>Vui lòng điền đầy đủ thông tin.</div>");
                        event.preventDefault();
                    }
                    if (pro_pic === "") {
                        isValid = false;
                        $("#pro_pic").after("<div style='color: red;' class='error'>Vui lòng điền đầy đủ thông tin.</div>");
                        event.preventDefault();
                    }
                    if (pro_des === "") {
                        isValid = false;
                        $("#pro_des").after("<div style='color: red;' class='error'>Vui lòng điền đầy đủ thông tin.</div>");
                        event.preventDefault();
                    }
                    // Nếu kiểm tra không hợp lệ, dừng lại và ngăn chặn submit form
                    if (!isValid) {
                        return;
                    }
                });
            });
        </script>

    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            boolean foundCookie = false;
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("quantri")) {
                        foundCookie = true;
                        break;
                    }
                }
            }
//            if (!foundCookie && session.getAttribute("quantri") == null) {
//                response.sendRedirect("index.jsp");
//            }
        %>

        <div class="container">
            <div class="row justify-content-around">
                <form
                    action="/PRJProject/manager"
                    class="col-md-6 rounded-4 bg-light p-3 my-3"
                    id="form"
                    method="post"
                    enctype="multipart/form-data"
                    >
                    <h2 class="text-center text-uppercase py-3">Add New Product!</h2>
                    <div class="mb-3">
                        <label for="pro_name">Ten San Pham: </label>
                        <input type="text" required class="form-control" name="pro_name" id="pro_name" />
                    </div>
                    <div class="mb-3">
                        <label for="pro_pic">File hinh anh: </label>
                        <input type="file" required name="pro_pic" accept=".jpg, .png, .webp" class="form-control" id="pro_pic" multiple />

                    </div>
                    <div class="mb-3">
                        <label for="pro_quan">Color: </label>
                        <input type="text"  required name="pro_color" class="form-control" id="pro_color" />
                    </div>
                    <div class="mb-3">
                        <label for="pro_price">Gia San Pham: </label>
                        <input type="number" required name="pro_price" class="form-control" id="pro_price" />
                    </div>
                    <div class="mb-3">
                        <label for="pro_quan">So Luong: </label>
                        <input type="number" required name="pro_quan" class="form-control" id="pro_quan" />
                    </div>
                    <div class="mb-3">
                        <label for="pro_des">Mo ta san pham: </label>
                        <input type="text" required name="pro_des" class="form-control" id="pro_des"/>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listC}" var="o">
                                <option value="${o.category_id}">${o.category_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input
                        type="submit"
                        value="Add"
                        name="btnSubmit"
                        class="btn-primary btn w-100 mx-auto"
                        />
                </form>
            </div>
        </div>
    </body>
</html>
