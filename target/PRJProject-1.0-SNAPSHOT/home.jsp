<%-- 
    Document   : home
    Created on : Jun 13, 2023, 11:09:43 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>PC SPACE - Home</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/PRJProject/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <!-- Core theme CSS (includes Bootstrap)-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <link href="/PRJProject/css/styles.css" rel="stylesheet" />
        <!--                <script>
                            window.onload = function () {
                                if (window.performance) {
                                    if (performance.navigation.type === 1) {
                                        // Người dùng tải lại trang
                                        window.location.href = "/PRJProject/home"; // Chuyển hướng đến trang home.jsp
                                    }
                                }
                            };
                        </script>-->

        <style>
            .search-bar{
                width: 250px;
                height: 45px;
                background: transparent;
                border: 2px solid #e4e4e4;
                border-radius: 6px;
                display: flex;
                align-items: center;
            }
            .search-bar input{
                width: 100%;
                background: transparent;
                border: none;
                outline: none;
                font-size: 16px;
                color: #e4e4e4;
                padding-left: 10px;
            }

            .search-bar input::placeholder{
                color: #e4e4e4;
            }
            .search-bar button {
                width: 40px;
                height: 100%;
                background: transparent;
                border: none;
                outline: none;
                display: flex;
                align-items: center;
                justify-content: center;
                cursor: pointer;
            }

            .search-bar button i{
                font-size: 22px;
                color: #e4e4e4;
            }
            .section_gap {
                padding: 100px 0;
            }
            @media (max-width: 991px) {
                .section_gap {
                    padding: 80px 0;
                }
            }

            .section_gap_top_75 {
                padding: 75px 0;
            }
            @media (max-width: 991px) {
                .section_gap_top_75 {
                    padding: 70px 0;
                }
            }

            .section_gap_75 {
                padding: 75px 0;
            }
            @media (max-width: 991px) {
                .section_gap_75 {
                    padding: 70px 0;
                }
            }

            .section_gap_top {
                padding-top: 100px;
            }
            @media (max-width: 991px) {
                .section_gap_top {
                    padding-top: 80px;
                }
            }

            .section_gap_bottom {
                padding-bottom: 100px;
            }
            @media (max-width: 991px) {
                .section_gap_bottom {
                    padding-bottom: 80px;
                }
            }
            @media (max-width: 768px) {
                .features-area {
                    padding-top: 0;
                }
            }
            .features-area .col-lg-3:last-child .single-features {
                border-right: 0;
            }
            @media (max-width: 575px) {
                .features-area .col-lg-3:last-child .single-features {
                    margin-top: 30px;
                }
            }
            .features-area .col-lg-3:nth-child(3) .single-features,
            .features-area .col-lg-3:nth-child(4) .single-features {
                margin-bottom: 0;
            }

            .features-inner {
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
                padding: 40px 0;
            }

            .single-features {
                text-align: center;
                border-right: 1px solid #eeeeee;
            }
            @media (max-width: 991px) {
                .single-features {
                    border-right: none;
                    margin-bottom: 30px;
                }
            }
            .single-features .f-icon {
                margin-bottom: 20px;
            }
            .single-features .f-icon img {
                -webkit-transition: all 0.3s ease 0s;
                -moz-transition: all 0.3s ease 0s;
                -o-transition: all 0.3s ease 0s;
                transition: all 0.3s ease 0s;
            }
            .single-features h6 {
                font-size: 16px;
                margin-bottom: 0;
            }
            .single-features p {
                margin-bottom: 0;
            }
            .single-features:hover .f-icon img {
                opacity: .5;
            }
            .gray-bg {
                background: #f9f9ff;
            }

            .single-deal {
                position: relative;
                margin-bottom: 30px;
            }
            .single-deal .overlay {
                position: absolute;
                left: 0;
                top: 0;
                height: 100%;
                width: 100%;
                content: "";
                background: #000;
                opacity: 0;
                visibility: hidden;
                -webkit-transition: all 0.3s ease 0s;
                -moz-transition: all 0.3s ease 0s;
                -o-transition: all 0.3s ease 0s;
                transition: all 0.3s ease 0s;
            }
            .single-deal .deal-details {
                position: absolute;
                left: 50%;
                top: 115%;
                display: inline-block;
                text-align: center;
                -webkit-transform: translate(-50%, -50%);
                -moz-transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                -o-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
                opacity: 0;
                visibility: hidden;
                -webkit-transition: all 0.3s ease 0s;
                -moz-transition: all 0.3s ease 0s;
                -o-transition: all 0.3s ease 0s;
                transition: all 0.3s ease 0s;
            }
            .single-deal .deal-details h6 {
                color: #fff;
                text-transform: uppercase;
            }
            .single-deal:hover .overlay {
                opacity: .5;
                visibility: visible;
            }
            .single-deal:hover .deal-details {
                top: 50%;
                opacity: 1;
                visibility: visible;
            }


            .single-product {
                margin-bottom: 50px;
            }
            .single-product img {
                margin-bottom: 20px;
                width: 100%;
            }
            .single-product .product-details h6 {
                font-size: 16px;
                text-transform: uppercase;
            }
            .single-product .product-details .price h6 {
                font-size: 14px;
                display: inline-block;
                padding-right: 15px;
                margin: 0;
            }
            .single-product .product-details .price .l-through {
                text-decoration: line-through;
                color: #cccccc;
                margin-bottom: 0;
            }
            .single-product .product-details .prd-bottom {
                position: relative;
                margin-top: 20px;
            }
            .single-product .product-details .prd-bottom .social-info {
                position: relative;
                display: inline-block;
                width: 35px;
                -webkit-transition: all 0.3s ease 0s;
                -moz-transition: all 0.3s ease 0s;
                -o-transition: all 0.3s ease 0s;
                transition: all 0.3s ease 0s;
                overflow: hidden;
            }
            .single-product .product-details .prd-bottom .social-info span {
                position: relative;
                height: 30px;
                width: 30px;
                line-height: 30px;
                text-align: center;
                background: #828bb2;
                border-radius: 50%;
                display: inline-block;
                color: #fff;
                -webkit-transition: all 0.3s ease 0s;
                -moz-transition: all 0.3s ease 0s;
                -o-transition: all 0.3s ease 0s;
                transition: all 0.3s ease 0s;
                z-index: 1;
            }
            .single-product .product-details .prd-bottom .social-info span:after {
                position: absolute;
                left: 0;
                top: 0;
                height: 100%;
                width: 100%;
                content: "";
                border-radius: 50%;
                opacity: 0;
                visibility: hidden;
                z-index: -1;
            }
            .single-product .product-details .prd-bottom .social-info .hover-text {
                position: absolute;
                left: 0;
                top: 3px;
                width: 100px;
                left: -40px;
                text-transform: uppercase;
                font-family: "Poppins", sans-serif;
                font-weight: 500;
                font-size: 12px;
                color: #222222;
                -webkit-transition: all 0.3s ease 0s;
                -moz-transition: all 0.3s ease 0s;
                -o-transition: all 0.3s ease 0s;
                transition: all 0.3s ease 0s;
                opacity: 0;
                visibility: hidden;
            }
            .single-product .product-details .prd-bottom .social-info:hover {
                width: 115px;
            }
            .single-product .product-details .prd-bottom .social-info:hover span:after {
                opacity: 1;
                visibility: visible;
            }
            .single-product .product-details .prd-bottom .social-info:hover .hover-text {
                opacity: 1;
                visibility: visible;
                left: 40px;
            }

            .active-product-area {
                padding-top: 70px;
                padding-bottom: 50px;
            }
            .active-product-area .owl-nav div {
                position: absolute;
                left: 35%;
                top: 7%;
                opacity: .3;
            }
            @media (max-width: 1440px) {
                .active-product-area .owl-nav div {
                    left: 30%;
                }
            }
            @media (max-width: 1200px) {
                .active-product-area .owl-nav div {
                    left: 28%;
                }
            }
            @media (max-width: 991px) {
                .active-product-area .owl-nav div {
                    top: 3%;
                    left: 25%;
                }
            }
            @media (max-width: 870px) {
                .active-product-area .owl-nav div {
                    left: 15%;
                }
            }
            @media (max-width: 767px) {
                .active-product-area .owl-nav div {
                    left: 10%;
                    top: 2%;
                    margin-top: -25px;
                }
            }
            @media (max-width: 570px) {
                .active-product-area .owl-nav div {
                    left: 37%;
                    top: 1%;
                    margin-top: -25px;
                }
            }
            @media (max-width: 480px) {
                .active-product-area .owl-nav div {
                    margin-top: -20px;
                    left: 28%;
                }
            }
            .active-product-area .owl-nav div:hover {
                opacity: 1;
            }
            .active-product-area .owl-nav .owl-next {
                left: auto;
                right: 35%;
            }
            @media (max-width: 1440px) {
                .active-product-area .owl-nav .owl-next {
                    right: 30%;
                }
            }
            @media (max-width: 1200px) {
                .active-product-area .owl-nav .owl-next {
                    right: 28%;
                }
            }
            @media (max-width: 991px) {
                .active-product-area .owl-nav .owl-next {
                    top: 3%;
                    right: 25%;
                }
            }
            @media (max-width: 870px) {
                .active-product-area .owl-nav .owl-next {
                    right: 15%;
                }
            }
            @media (max-width: 767px) {
                .active-product-area .owl-nav .owl-next {
                    right: 10%;
                    top: 2%;
                    margin-top: -25px;
                }
            }
            @media (max-width: 570px) {
                .active-product-area .owl-nav .owl-next {
                    right: 37%;
                    top: 1%;
                    margin-top: -25px;
                }
            }
            @media (max-width: 480px) {
                .active-product-area .owl-nav .owl-next {
                    margin-top: -20px;
                    right: 28%;
                }
            }

            .ti-bag:before {
                content: "\e655";
            }
            .ti-move:before {
                content: "\e656";
            }
            .color-content{
                margin-top: 3.2rem;
            }
            .color-content h3{
                text-transform: uppercase;
                font-size: 1.6rem;
            }
            .color{
                width: 35px;
                height: 35px;
                background: none;
                border-radius: 50%;
                -webkit-border-radius: 50%;
                -moz-border-radius: 50%;
                -ms-border-radius: 50%;
                -o-border-radius: 50%;
                margin-right: 12px;
                cursor: pointer;
                transition: all 0.5s ease;
                -webkit-transition: all 0.5s ease;
                -moz-transition: all 0.5s ease;
                -ms-transition: all 0.5s ease;
                -o-transition: all 0.5s ease;
            }
            .color-black{
                background-color: #242424;
            }
            .color-blue{
                background-color: #085ea0;
            }
            .color-yellow{
                background-color: #FDE74C;
            }
            .color-red{
                background-color: #EB283B;
            }
            .color-white{
                background-color: #ededed;
            }
            .color-brown{
                background-color: rgb(147, 38, 38);
            }
            .color-pink{
                background-color: rgb(203, 105, 199);
            }
            .color-orange{
                background-color: rgb(212, 68, 20);
            }
            .color:hover{
                width: 45px;
                height: 45px;
                box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
            }
            .active-color{
                box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
            }
            .color-groups{
                padding: 1rem 0;
                display: flex;
            }
        </style>
    </head>
    <body>

        <!-- Navigation-->
        <jsp:include page="header.jsp"/>

        <c:if test="${cate == null}">
            <section class="features-area section_gap">
                <div class="container">
                    <div class="row features-inner">
                        <!-- single features -->
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-features">
                                <div class="f-icon">
                                    <img src="/PRJProject/img/features/f-icon1.png" alt="">
                                </div>
                                <h6>Free Delivery</h6>
                                <p>Free Shipping on all order</p>
                            </div>
                        </div>
                        <!-- single features -->
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-features">
                                <div class="f-icon">
                                    <img src="/PRJProject/img/features/f-icon2.png" alt="">
                                </div>
                                <h6>Return Policy</h6>
                                <p>Free Shipping on all order</p>
                            </div>
                        </div>
                        <!-- single features -->
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-features">
                                <div class="f-icon">
                                    <img src="/PRJProject/img/features/f-icon3.png" alt="">
                                </div>
                                <h6>24/7 Support</h6>
                                <p>Free Shipping on all order</p>
                            </div>
                        </div>
                        <!-- single features -->
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-features">
                                <div class="f-icon">
                                    <img src="/PRJProject/img/features/f-icon4.png" alt="">
                                </div>
                                <h6>Secure Payment</h6>
                                <p>Free Shipping on all order</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Navigation-->

            <!-- Start category Area -->
            <section class="category-area">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-8 col-md-12">
                            <div class="row">
                                <div class="col-lg-8 col-md-8">
                                    <div class="single-deal">
                                        <div class="overlay"></div>
                                        <img class="img-fluid w-100" src="/PRJProject/img/category/c1.jpg" alt="">
                                        <a href="img/category/c1.jpg" class="img-pop-up" target="_blank">
                                            <div class="deal-details">
                                                <h6 class="deal-title">Sneaker for Sports</h6>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <div class="single-deal">
                                        <div class="overlay"></div>
                                        <img class="img-fluid w-100" src="/PRJProject/img/category/c2.jpg" alt="">
                                        <a href="img/category/c2.jpg" class="img-pop-up" target="_blank">
                                            <div class="deal-details">
                                                <h6 class="deal-title">Sneaker for Sports</h6>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <div class="single-deal">
                                        <div class="overlay"></div>
                                        <img class="img-fluid w-100" src="/PRJProject/img/category/c3.jpg" alt="">
                                        <a href="img/category/c3.jpg" class="img-pop-up" target="_blank">
                                            <div class="deal-details">
                                                <h6 class="deal-title">Product for Couple</h6>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-8 col-md-8">
                                    <div class="single-deal">
                                        <div class="overlay"></div>
                                        <img class="img-fluid w-100" src="/PRJProject/img/category/c4.jpg" alt="">
                                        <a href="img/category/c4.jpg" class="img-pop-up" target="_blank">
                                            <div class="deal-details">
                                                <h6 class="deal-title">Sneaker for Sports</h6>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="single-deal">
                                <div class="overlay"></div>
                                <img class="img-fluid w-100" src="/PRJProject/img/category/c5.jpg" alt="">
                                <a href="img/category/c5.jpg" class="img-pop-up" target="_blank">
                                    <div class="deal-details">
                                        <h6 class="deal-title">Sneaker for Sports</h6>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>


            <!-- Section-->
            <section class="py-5">

                <div class="container px-4 px-lg-5 mt-5">
                    <div class="row justify-content-center">
                        <div class="col-lg-6 text-center">
                            <div class="section-title">
                                <h1>Latest Products</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                    dolore
                                    magna aliqua.</p>
                            </div>
                        </div>
                    </div>
                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                        <c:forEach items="${list4P}" var="o">
                            <div class="col mb-5">
                                <div class="card h-100">
                                    <!-- Sale badge-->
                                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                                    <!-- Product image-->
                                     <a href="/PRJProject/details/${o.product_id}"><img class="card-img-top" src="${o.product_pic}"  alt="..."></a>
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder"><a class="text-decoration-none text-dark" href="/PRJProject/details/${o.product_id}">${o.product_name}</a></h5>
                                            <!-- Product price-->
                                            <span class="text-muted text-decoration-line-through">$80.00</span>
                                            $${o.price}
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center"><a class="addToCartButton btn btn-outline-dark mt-auto" href="/PRJProject/buy?id=${o.product_id}&num=1">Add to cart</a></div>
                                    </div>
                                </div> 
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
        </c:if>

        <!-- Section-->
        <section class="owl-carousel active-product-area section_gap">
            <div class="single-product-slider">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-6 text-center">
                            <div class="section-title">
                                <h1>New Products</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                    dolore
                                    magna aliqua.</p>
                            </div>
                            <a href="/PRJProject/home">1</a>
                            <c:forEach begin="2" end="${endP}" var="i">
                                <a href="/PRJProject/listproduct/${i}">${i}</a>
                            </c:forEach>

                        </div>
                    </div>
                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" id="content">
                        <!-- single product -->
                        <c:forEach items="${listP}" var="o">
                            <div class="product col mb-5">
                                <div class="card h-100">
                                    <!-- Sale badge-->
                                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                                    <!-- Product image-->
                                     <a href="/PRJProject/details/${o.product_id}"><img class="card-img-top" src="${o.product_pic}"  alt="..."></a>
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder"><a class="text-decoration-none text-dark" href="/PRJProject/details/${o.product_id}">${o.product_name}</a></h5>
                                            <!-- Product price-->
                                            <span class="text-muted text-decoration-line-through">$80.00</span>
                                            $${o.price}
                                            <h5 class="fw-bolder">${o.product_color}</h5>
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/PRJProject/buy?id=${o.product_id}&num=1">Add to cart</a></div>
                                    </div>
                                </div> 
                            </div>
                        </c:forEach>

                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><button onclick="loadMore()" class="loadMoreButton btn btn-outline-dark mt-auto">Xem Thêm</button></div>
                    </div>
                    <div class="justify-content-center text-center">
                        <a href="/PRJProject/home">1</a>
                        <c:forEach begin="2" end="${endP}" var="i">
                            <a href="/PRJProject/listproduct/${i}">${i}</a>
                        </c:forEach>
                    </div>
                </div> 
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">CÔNG TY CỔ PHẦN THƯƠNG MẠI GIÀY SPACE<br>Địa chỉ: 123 Nguyễn Văn Cừ , phường An Bình , quận Ninh Kiều, Cần Thơ <br> Điện thoại : 01245666672 </p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script>

                            function loadMore() {
                                var amount = document.getElementsByClassName("product").length;
                                $.ajax({
                                    url: "/PRJProject/loadproduct",
                                    type: "get",
                                    data: {
                                        exits: amount
                                    },
                                    success: function (data) {
                                        var row = document.getElementById("content");
                                        row.innerHTML += data;
                                    }
                                });
                            }

                            function searchByName(param) {
                                var txtSearch = param.value;
                                $.ajax({
                                    url: "/PRJProject/searchAjax",
                                    type: "get",
                                    data: {
                                        txt: txtSearch
                                    },
                                    success: function (data) {
                                        var row = document.getElementById("content");
                                        row.innerHTML = data;
                                    }
                                });
                            }

        </script>
    </body>
</html>
