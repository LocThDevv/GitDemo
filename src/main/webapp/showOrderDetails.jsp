<%-- 
    Document   : info
    Created on : Jun 23, 2023, 2:03:23 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Models.Product"%>
<%@page import="DAOs.productDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    </head>
    <body>

        <%
            if (session.getAttribute("quantri") == null) {
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
//                if (!foundCookie && session.getAttribute("quantri") == null) {
//                    response.sendRedirect("/listProduct");
//                }
            }
        %>

        <div class="container mt-4">
            <div class="row">
                <div class="col-md-3"><jsp:include page="menuBar.jsp"/></div>
                <div class="col-md-9">
                    <h1 class="text-center">Thông Tin Chi Tiết Hóa Ðơn</h1>
                    <c:if test="${messAdd != null}">
                        <p class="text-success bg-light fw-bold text-center">${messAdd}</p>
                    </c:if>
                    <a href="/PRJProject/manager/ShowOrder/Details/fileExcel/${sessionScope.proID}">
                        <button type="button" class="bg-success btn btn-success mb-2">Xuất File Excel</button>
                    </a>
                    <table id="example">
                        <thead>
                            <tr>
                                <th class="align-middle">NO</th>
                                <th class="align-middle">OrderID</th>
                                <th class="align-middle">ProductID</th>
                                <th class="align-middle">Product Name</th>
                                <th class="align-middle">Color</th>
                                <th class="align-middle">Unit Price</th>
                                <th class="align-middle">Quantity</th>

                                <!--<th class="align-middle">Category</th>-->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listTails}" var="o" varStatus="status">
                                <tr >
                                    <th class="align-middle">${status.index+1}</th>
                                    <th class="align-middle">${o.order_id}</th>
                                    <th class="align-middle">${o.product_id}</th>
                                    <th class="align-middle">${infoProduct[status.index].product_name}</th>
                                    <th class="align-middle">${infoProduct[status.index].product_color}</th>
                                    <td class="align-middle"><p>${o.unit_price}</p></td>
                                    <td class="align-middle"><p>${o.quantity}</p></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="/PRJProject/manager/ShowOrder">
                        <button type="button" class="btn btn-primary bg-primary">Back</button>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
