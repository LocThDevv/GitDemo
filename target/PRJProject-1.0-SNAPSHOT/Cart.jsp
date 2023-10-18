<%-- 
    Document   : Cart
    Created on : Jul 6, 2023, 9:04:57 PM
    Author     : Admin
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="/PRJProject/css/styles.css" rel="stylesheet" />
    </head>
    <body>

        <jsp:include page="header.jsp" />

        <div class="shopping-cart">
            <c:if test="${mesCheck != null}">
                <div class="container">
                    <div class="alert alert-success" role="alert">
                        <h4 class="alert-heading">Chúc mừng!</h4>
                        <p>Thành công! Đơn hàng của bạn đã được đặt thành công. Xin cảm ơn vì đã chọn chúng tôi là đối tác mua sắm của bạn.</p>
                        <hr>
                        <p class="mb-0">Thông tin đơn hàng đã được gửi vào email của bạn. Vui lòng kiểm tra thư mục "Hộp thư đến" hoặc "Spam" nếu bạn không nhận được email trong hộp thư chính.</p>
                    </div>
                </div>
            </c:if>
            <div class="px-4 px-lg-0">

                <div class="pb-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                <!-- Shopping cart table -->
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="p-2 px-3 text-uppercase">No.</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Đơn Giá</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Số Lượng</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Total</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Xóa</div>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="o" value="${requestScope.cart}"></c:set>
                                            <c:forEach var="i" items="${o.items}" varStatus="status">
                                                <tr>
                                                    <td class="align-middle"><strong>${status.index +1}</strong></td>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="${i.product.product_pic}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${i.product.product_name}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong>${i.price} $</strong></td>

                                                    <td class="align-middle">
                                                        <a href="process?num=-1&id=${i.product.product_id}"><button class="btnSub">-</button></a> 
                                                        <strong>${i.quantity}</strong>
                                                        <a href="process?num=1&id=${i.product.product_id}"><button class="btnSub">+</button></a>
                                                    </td>
                                                    <td class="align-middle"><fmt:formatNumber pattern="##.#" value="${(i.price * i.quantity)}"/></td>
                                                    <td class="align-middle">
                                                        <form action="process" method="post">
                                                            <input type="hidden" name="id" value="${i.product.product_id}" />
                                                            <button type="submit" class="btn btn-danger">Delete</button>
                                                        </form>
                                                    </td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                        <form action="/PRJProject/checkout" method="post">
                            <div class="row py-5 p-4 bg-white rounded shadow-sm">
                                <div class="col-lg-6">

                                    <div class="bg-light text-center rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thông tin khách hàng</div>
                                    <div class="p-4">
                                        <ul class="list-unstyled mb-4">
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tên khách hàng</strong><strong><input name="cname" class="border-0" required type="text" ></strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">email</strong><strong><input name="cemail" class="border-0" required type="text" ></strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Số điện thoại</strong><strong><input name="cphone" class="border-0" required type="text" ></strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted"> Địa chỉ</strong>
                                                <textarea required name="caddress" class=" border-0" type="text"></textarea>  
                                            </li>
                                    </div>

                                </div>
                                <div class="col-lg-6">
                                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                                    <div class="p-4">
                                        <ul class="list-unstyled mb-4">
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${o.totalPrice} $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>${o.totalPrice * 0.1} $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                                <textarea readonly  class="font-weight-bold border-0 text-end">${o.totalPrice + (o.totalPrice * 0.1)} $</textarea>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <footer class="py-5 bg-dark pt-0 d-flex text-center justify-content-center align-items-center">
            <div class="container"><p class="m-0 text-center text-white">CÔNG TY CỔ PHẦN THƯƠNG MẠI GIÀY SPACE<br>Địa chỉ: 123 Nguyễn Văn Cừ , phường An Bình , quận Ninh Kiều, Cần Thơ <br> Điện thoại : 01245666672 </p></div>
        </footer>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
