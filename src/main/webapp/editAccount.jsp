<%-- 
    Document   : SIgnUp
    Created on : Jun 14, 2023, 7:57:32 AM
    Author     : admin
--%>


<%@page import="Models.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/PRJProject/css/styles.css" rel="stylesheet" />
        <title>Edit Account</title>
    </head>
    <body>
        <%
            Account ac = (Account) session.getAttribute("quantri");
        %>
        <section class="vh-75 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
            <div class="mask d-flex align-items-center h-75 gradient-custom-3">
                <div class="container">
                    <div class="row d-flex justify-content-center align-items-center">
                        <div class="col-md-6">
                            <div class="card rounded-3">
                                <div class="card-body p-4">
                                    <c:if test="${messAdd != null}">
                                        <p class="text-bg-success text-center">${messAdd}</p>
                                        <div class="d-grid">
                                            <button  name="btnSubmit" value="changePass" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"><a class="text-decoration-none text-dark" href="login">Login</a></button>
                                        </div>
                                    </c:if>
                                    <c:if test="${messAdd == null}">
                                        <h2 class="text-center mb-4">Chỉnh sửa thông tin</h2>

                                        <form action="/PRJProject/infoAccount" method="post">

                                            <div class="mb-3">
                                                <label for="password" class="form-label">Họ và tên:</label>
                                                <input type="text" required value="<%= ac.getFullname()%>" id="fullname" class="form-control" name="fullname"/>
                                            </div>

                                            <div class="mb-3">
                                                <label for="email" class="form-label">Your Email</label>
                                                <input type="email" required value="<%= ac.getEmail()%>" id="email" class="form-control" name="email"/>
                                            </div>

                                            <div class="mb-3">
                                                <label for="name" class="form-label">Phone Number</label>
                                                <input type="tel" required value="<%= ac.getPhone_number()%>" id="phone" class="form-control" name="phone"/>
                                            </div>

                                            <input
                                                type="submit"
                                                value="Update"
                                                name="btnSubmit"
                                                class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"
                                                />
                                            <a href="/PRJProject/infoAccount">
                                                <button class="btn btn-success btn-block btn-lg gradient-custom-3 text-body" type="button" class="btn btn-primary bg-primary">Cancel</button>
                                            </a>
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
