<%-- 
    Document   : header.jsp
    Created on : Jul 6, 2023, 9:08:40 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <!-- Core theme CSS (includes Bootstrap)-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <link href="/PRJProject/css/styles.css" rel="stylesheet" />
    </head>

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
        .my-5 {
            margin-top: 2rem !important;
            margin-bottom: 1rem !important;
        }
    </style>

    <body>
        <header class="fixed-top">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">

                <div class="container px-4 px-lg-5">
                    <a class="navbar-brand" href="/PRJProject/home"><img src="/PRJProject/LogoPC02.png"></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                            <li class="nav-item"><a class="nav-link active" aria-current="page" href="/PRJProject/home">Home</a></li>

                            <c:forEach items="${listC}" var="o">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="/PRJProject/category/${o.category_id}">
                                        ${o.category_name}
                                    </a>
                                </li>
                            </c:forEach>


                            <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#!">All Products</a></li>
                                    <li><hr class="dropdown-divider" /></li>
                                    <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                    <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                                </ul>
                            </li>

                        </ul>

                        <form action="/PRJProject/showcart" method="post">
                            <button class="btn btn-outline-dark" type="submit">
                                <i class="bi-cart-fill me-1"></i>
                                Cart
                                <span id="cartQuantity" class="badge bg-dark text-white ms-1 rounded-pill">${size}</span>
                            </button>
                        </form>

                        <c:if test="${sessionScope.quantri == null}">
                            <button class="btn btn-outline-dark" type="submit" value="Login" name="btnLogin" id="btnLogin">
                                <a class="nav-link" href="/PRJProject/login">Login</a>
                            </button>
                        </c:if>

                        <c:if test="${sessionScope.quantri != null}">
                            <button class="btn btn-outline-dark" type="submit" value="Login" name="btnLogin" id="btnLogin">
                                <a class="nav-link" href="/PRJProject/infoAccount"><i class='bx bxs-user-account'></i> ${sessionScope.quantri.fullname}</a>
                            </button>
                            <button class="btn btn-outline-dark" type="submit" value="Login" name="btnLogin" id="btnLogin">
                                <a class="nav-link" href="/PRJProject/changepass">Change Password</a>
                            </button>
                            <button class="btn btn-outline-dark" type="submit" value="Login" name="btnLogin" id="btnLogin">
                                <a class="nav-link" href="/PRJProject/logout">Logout</a>
                            </button>
                            <c:if test="${sessionScope.quantri.isAdmin == 1}">
                                <button class="btn btn-outline-dark" type="submit" value="Login" name="btnLogin" id="btnLogin">
                                    <a class="nav-link" href="/PRJProject/manager">Manager Product</a>
                                </button>
                            </c:if>
                        </c:if>

                        <form action="/PRJProject/search" method="post" class="search-bar ml-3">
                            <input oninput="searchByName(this)" value="${txtS}" name="txt" type="text" placeholder="Search..." />
                            <button  type="submit"><i class="bx bx-search"></i></button>
                        </form>
                        <div class="container">
                            <div class="color-content">
                                <h3>Select Color</h3>
                                <div class="color-groups">
                                    <a class="color color-white active-color" href="/PRJProject/search/white"></a>
                                    <a class="color color-black" href="/PRJProject/search/black"></a>
                                    <a class="color color-yellow" href="/PRJProject/search/yellow"></a>
                                    <a class="color color-blue" href="/PRJProject/search/blue"></a>
                                    <a class="color color-red" href="/PRJProject/search/red"></a>
                                    <a class="color color-brown" href="/PRJProject/search/brown"></a>
                                    <a class="color color-pink" href="/PRJProject/search/pink"></a>
                                    <a class="color color-orange" href="/PRJProject/search/orange"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </header>

        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Best product in our store</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Trendy Products, Factory Prices, Excellent Service</p>
                </div>
            </div>
        </header>
    </body>
</html>
