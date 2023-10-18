<%-- 
    Document   : infoAccount
    Created on : Jul 8, 2023, 7:25:39 PM
    Author     : Admin
--%>

<%@page import="DAOs.accountDAO"%>
<%@page import="Models.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Thông tin tài khoản</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>

        <%  //tao session dua tren cookie
            boolean foundCookie = false;
            String us = "";
            Cookie[] cook = request.getCookies();
            if (session.getAttribute("quantri") == null) {

                if (cook != null) {
                    for (Cookie c : cook) {
                        if (c.getName().equals("quantri")) {
                            foundCookie = true;
                            us = c.getValue();
                            break;
                        }
                    }
                    accountDAO acdao = new accountDAO();
                    Account ac = acdao.getAccountByUS(us);
                    if (ac != null) {
                        if (ac.getIsAdmin() == 1) {
                            session.setAttribute("quantri", ac);
                        } else {
                            response.sendRedirect("/PRJProject/home");
                        }
                    }
                }
            }
        if (!foundCookie && session.getAttribute("quantri") == null) {
                response.sendRedirect("/PRJProject/home");
            }
            Account ac = (Account) session.getAttribute("quantri");
        %>

        <div class="container">
            <h1 class="mt-5">Thông tin tài khoản</h1>
            <table class="table mt-4">
                <tr>
                    <th>Tên tài khoản:</th>
                    <td><%= ac.getUsername()%></td>
                </tr>
                <tr>
                    <th>Họ và tên:</th>
                    <td><%= ac.getFullname()%></td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td><%= ac.getEmail()%></td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td><%= ac.getPhone_number()%></td>
                </tr>

            </table>
            <a href="/PRJProject/infoAccount/Edit" class="btn ">
                <i class="bx bx-edit-alt"></i> Chỉnh sửa
            </a>
            <a href="/PRJProject/home">
                <button type="button" class="btn btn-primary bg-primary">Back</button>
            </a>
        </div>
    </body>
</html>
