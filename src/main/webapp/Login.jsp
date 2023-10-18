<%-- 
    Document   : dangnhap
    Created on : Jun 14, 2023, 12:06:25 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/PRJProject/css/styles.css" rel="stylesheet" />
        <script src="/PRJProject/js/code.jquery.com_jquery-3.7.0.min.js"></script>
        <script src="DataTables/DataTables-1.13.4/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
        <link rel="stylesheet" href="DataTables/DataTables-1.13.4/css/jquery.dataTables.min.css">
        <title>LOGIN</title>
        <script>
            $(document).ready(function () {
                $("form").submit(function (event) {
                    // Xóa thông báo lỗi trước đó
                    $(".error").remove();
                    // Thực hiện kiểm tra dữ liệu
                    var username = $("#username").val();
                    var password = $("#password").val();
                    var isValid = true;
                    if (username.trim() === "") {
                        isValid = false;
                        $("#username").after("<div style='color: red; class='error'>Vui lòng nhập tên đăng nhập.</div>");
                        event.preventDefault();
                    }
                    if (password.trim() === "") {
                        isValid = false;
                        $("#password").after("<div style='color: red; class='error'>Vui lòng nhập mật khẩu.</div>");
                        event.preventDefault();
                    }
                    // Nếu kiểm tra không hợp lệ, dừng lại
                    if (!isValid) {
                        return;
                    }
                    // Nếu kiểm tra hợp lệ, submit form
                    $(this).unbind("submit").submit();
                });
            });
        </script>
    </head>
    <body>

        <section class="vh-75 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">

            <div class="mask d-flex align-items-center h-75 gradient-custom-3">
                <div class="container py-5 h-100">

                    <div class="row d-flex justify-content-center align-items-center h-100">

                        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                            <div class="card bg-dark text-white transition-background" style="border-radius: 1rem;">
                                <div class="card-body p-5 text-center">

                                    <div class="mb-md-2 ">

                                        <form action="login" method="post">
                                            <p class="text-danger ">${mess}</p>
                                            <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                            <p class="text-white-50 mb-5">Please enter your login and password!</p>

                                            <div class="form-outline form-white mb-4">
                                                <input type="text" id="typeEmailX username" class="form-control form-control-lg" required name="user" />
                                                <label class="form-label" for="typeEmailX">UserName</label>
                                            </div>

                                            <div class="form-outline form-white mb-4">
                                                <input type="password" id="typePasswordX password" class="form-control form-control-lg" required name="pass" />
                                                <label class="form-label" for="typePasswordX">Password</label>
                                            </div>

                                            <input class="form-check-input" type="checkbox" name="chkRem" value="1"/>Remember me?

                                            <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="forgotpass">Forgot password?</a></p>

                                            <button name="btnSubmit" value="Login" class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                                        </form>

                                    </div>

                                    <div>
                                        <p class="mb-0">Don't have an account? <a href="signup" class="text-white-50 fw-bold">Sign Up</a>
                                        </p>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div></div>
        </section>
    </body>
</html>
