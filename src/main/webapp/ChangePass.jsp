<%-- 
    Document   : ChangePass
    Created on : Jul 4, 2023, 7:11:33 PM
    Author     : Admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="stylesheet" />
        <title>Change Password</title>
    </head>
    <body>
        <section class="vh-75 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
            <div class="mask d-flex align-items-center h-75 gradient-custom-3">

                <div class="container">
                    <div class="row d-flex justify-content-center align-items-center">
                        <div class="col-md-6">
                            <div class="card rounded-3">
                                <div class="card-body p-4">
                                    <c:if test="${messCP != null}">
                                        <p class="text-bg-success text-center">${messCP}</p>
                                        <div class="d-grid">
                                            <button  name="btnSubmit" value="changePass" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"><a class="text-decoration-none text-dark" href="login">Login</a></button>
                                        </div>
                                    </c:if>

                                    <c:if test="${messCPF != null}">
                                        <p class="text-bg-danger text-center">${messCPF}</p>
                                        <div class="d-grid">
                                            <button  name="btnSubmit" value="changePass" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"><a class="text-decoration-none text-dark" href="/PRJProject/home">Trang Chủ</a></button>
                                        </div>
                                    </c:if>


                                    <c:if test="${messCP == null && messCPF == null}">
                                        <h2 class="text-center mb-4">Change Password</h2>
                                        <form action="changepass" method="post">
                                            <div class="mb-3">
                                                <label for="password" class="form-label">Current Password</label>
                                                <input type="password" required id="password" class="form-control" name="expass"/>
                                            </div>

                                            <div class="mb-3">
                                                <label for="confirm-password" class="form-label">New Password</label>
                                                <input type="password" required id="confirm-password" class="form-control" name="newpass" />
                                            </div>

                                            <div class="mb-3">
                                                <label for="confirm-password" class="form-label">Confirm New Password</label>
                                                <input type="password" required id="confirm-password" class="form-control"name="re_newpass" />
                                            </div>

                                            <div class="d-grid">
                                                <button type="submit" name="btnSubmit" value="changePass" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Change Password</button>
                                            </div>
                                        </form>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>
