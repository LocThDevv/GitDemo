<%-- 
    Document   : details
    Created on : Jul 5, 2023, 3:18:38 PM
    Author     : Admin
--%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" type="image/x-icon" href="/PRJProject/assets/favicon.ico" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="/PRJProject/css/styles.css" rel="stylesheet" />
    </head>
    <style>

        .product_image_area {
            padding-top: 120px;
        }

        .s_Product_carousel .owl-dots {
            position: absolute;
            right: 20px;
            top: 50%;
            transform: translateY(-50%);
        }
        .s_Product_carousel .owl-dots div {
            height: 5px;
            width: 20px;
            background: #dddddd;
            margin: 5px;
            display: block;
            content: "";
            border-radius: 50px;
        }
        .s_Product_carousel .owl-dots div.active {
            width: 30px;
        }

        .s_product_text {
            margin-left: -15px;
            margin-top: 65px;
        }
        @media (max-width: 575px) {
            .s_product_text {
                margin-left: 0px;
            }
        }
        .s_product_text h3 {
            font-size: 24px;
            font-weight: 500;
            color: #222222;
            margin-bottom: 10px;
        }
        .s_product_text h2 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 15px;
        }
        .s_product_text .list li {
            margin-bottom: 5px;
        }
        .s_product_text .list li a {
            font-size: 14px;
            font-family: "Roboto", sans-serif;
            font-weight: normal;
            color: #555555;
        }
        .s_product_text .list li a span {
            width: 90px;
            display: inline-block;
        }
        .s_product_text .list li a span:hover {
            color: #555;
        }
        .s_product_text .list li a.active span {
            color: #555;
            -webkit-text-fill-color: #555;
        }
        .s_product_text .list li:last-child {
            margin-bottom: 0px;
        }
        .s_product_text p {
            padding-top: 20px;
            border-top: 1px dotted #d5d5d5;
            margin-top: 20px;
            margin-bottom: 70px;
        }
        .s_product_text .card_area .primary-btn {
            line-height: 38px;
            padding: 0px 38px;
            text-transform: uppercase;
            margin-right: 10px;
            border-radius: 5px;
        }
        .s_product_text .card_area .icon_btn {
            position: relative;
            height: 40px;
            width: 40px;
            line-height: 40px;
            text-align: center;
            background: #828bb2;
            border-radius: 50%;
            display: inline-block;
            color: #fff;
            -webkit-transition: all 0.3s ease 0s;
            -moz-transition: all 0.3s ease 0s;
            -o-transition: all 0.3s ease 0s;
            transition: all 0.3s ease 0s;
            margin-right: 10px;
            z-index: 1;
        }
        .s_product_text .card_area .icon_btn:after {
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
        .s_product_text .card_area .icon_btn:hover:after {
            opacity: 1;
            visibility: visible;
        }

        .product_count {
            display: inline-block;
            position: relative;
            margin-bottom: 24px;
        }
        .product_count label {
            font-size: 14px;
            color: #777777;
            font-family: "Roboto", sans-serif;
            font-weight: normal;
            padding-right: 10px;
        }
        .product_count input {
            width: 76px;
            border: 1px solid #eeeeee;
            border-radius: 3px;
            padding-left: 10px;
        }
        .product_count button {
            border: none;
            border-radius: 7px;
            /*            background: transparent;
                        box-shadow: none;
                        cursor: pointer;
                        position: absolute;
                        right: 0px;
                        font-size: 14px;
                        color: #cccccc;
                        -webkit-transition: all 0.3s ease 0s;
                        -moz-transition: all 0.3s ease 0s;
                        -o-transition: all 0.3s ease 0s;
                        transition: all 0.3s ease 0s;*/
        }
        .product_count button:hover {
            color: #222222;
        }
        .product_count .increase {
            top: -4px;
        }
        .product_count .reduced {
            bottom: -8px;
        }

        .product_description_area {
            padding-bottom: 120px;
            margin-top: 60px;
        }
        .product_description_area .nav.nav-tabs {
            background: #e8f0f2;
            text-align: center;
            display: block;
            border: none;
            padding: 10px 0px;
        }
        .product_description_area .nav.nav-tabs li {
            display: inline-block;
            margin-right: 7px;
        }
        .product_description_area .nav.nav-tabs li:last-child {
            margin-right: 0px;
        }
        @media (max-width: 441px) {
            .product_description_area .nav.nav-tabs li:last-child {
                margin-top: 15px;
            }
        }
        .product_description_area .nav.nav-tabs li a {
            padding: 0px;
            border: none;
            line-height: 38px;
            background: #fff;
            border: 1px solid #eeeeee;
            border-radius: 0px;
            padding: 0px 30px;
            color: #222222;
            font-size: 13px;
            font-weight: normal;
        }
        @media (max-width: 570px) {
            .product_description_area .nav.nav-tabs li a {
                padding: 0 15px;
            }
        }
        .product_description_area .nav.nav-tabs li a.active {
            color: #fff;
            border: 1px solid transparent;
        }
        .product_description_area .tab-content {
            border-left: 1px solid #eee;
            border-right: 1px solid #eee;
            border-bottom: 1px solid #eee;

            padding: 30px;
        }
        .product_description_area .tab-content .total_rate .box_total {
            background: #e8f0f2;
            text-align: center;
            padding-top: 20px;
            padding-bottom: 20px;
        }
        .product_description_area .tab-content .total_rate .box_total h4 {
            font-size: 48px;
            font-weight: bold;
        }
        .product_description_area .tab-content .total_rate .box_total h5 {
            color: #222222;
            margin-bottom: 0px;
            font-size: 24px;
        }
        .product_description_area .tab-content .total_rate .box_total h6 {
            color: #222222;
            margin-bottom: 0px;
            font-size: 14px;
            color: #777777;
            font-weight: normal;
        }
        .product_description_area .tab-content .total_rate .rating_list {
            margin-bottom: 30px;
        }
        .product_description_area .tab-content .total_rate .rating_list h3 {
            font-size: 18px;
            color: #222222;
            font-family: "Roboto", sans-serif;
            font-weight: 500;
            margin-bottom: 10px;
        }
        .product_description_area .tab-content .total_rate .rating_list .list li a {
            font-size: 14px;
            color: #777777;
        }
        .product_description_area .tab-content .total_rate .rating_list .list li a i {
            color: #fbd600;
        }
        .product_description_area .tab-content .total_rate .rating_list .list li:nth-child a i:last-child {
            color: #eeeeee;
        }
        .product_description_area .tab-content .table {
            margin-bottom: 0px;
        }
        .product_description_area .tab-content .table tbody tr td {
            padding-left: 65px;
            padding-right: 65px;
            padding-top: 14px;
            padding-bottom: 14px;
        }
        .product_description_area .tab-content .table tbody tr td h5 {
            font-size: 14px;
            font-family: "Roboto", sans-serif;
            font-weight: normal;
            color: #777777;
            margin-bottom: 0px;
            white-space: nowrap;
        }
        .product_description_area .tab-content .table tbody tr:first-child td {
            border-top: 0px;
        }

        .review_item {
            margin-bottom: 15px;
        }
        .review_item:last-child {
            margin-bottom: 0px;
        }
        .review_item .media {
            position: relative;
        }
        .review_item .media .d-flex {
            padding-right: 15px;
        }
        .review_item .media .media-body {
            vertical-align: middle;
            align-self: center;
        }
        .review_item .media .media-body h4 {
            margin-bottom: 0px;
            font-size: 14px;
            color: #222222;
            font-family: "Roboto", sans-serif;
            margin-bottom: 8px;
        }
        .review_item .media .media-body i {
            color: #fbd600;
        }
        .review_item .media .media-body h5 {
            font-size: 13px;
            font-weight: normal;
            color: #777777;
        }
        .review_item .media .media-body .reply_btn {
            border: 1px solid #e0e0e0;
            padding: 0px 28px;
            display: inline-block;
            line-height: 32px;
            border-radius: 16px;
            font-size: 14px;
            font-family: "Roboto", sans-serif;
            color: #222222;
            position: absolute;
            right: 0px;
            top: 14px;
            @include transition;
        }
        .review_item .media .media-body .reply_btn:hover {
            background: #ffba00;
            border-color: #ffba00;
            color: #fff;
        }
        .review_item p {
            padding-top: 10px;
            margin-bottom: 0px;
        }
        .review_item.reply {
            padding-left: 28px;
        }

        .review_box h4 {
            font-size: 24px;
            color: #222222;
            margin-bottom: 20px;
        }
        .review_box p {
            margin-bottom: 0px;
            display: inline-block;
        }
        .review_box .list {
            display: inline-block;
            padding-left: 10px;
            padding-right: 10px;
        }
        .review_box .list li {
            display: inline-block;
        }
        .review_box .list li a {
            display: inline-block;
            color: #fbd600;
        }
        .review_box .contact_form {
            margin-top: 15px;
        }
        .review_box .primary-btn {
            line-height: 38px !important;
            padding: 0px 38px;
            text-transform: uppercase;
            margin-right: 10px;
            border-radius: 5px;
            border: none;
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
        body{
            margin-top:20px;
            background-color:#e9ebee;
        }

        .be-comment-block {
            margin-bottom: 50px !important;
            border: 1px solid #edeff2;
            border-radius: 2px;
            padding: 50px 70px;
            border:1px solid #ffffff;
        }

        .comments-title {
            font-size: 16px;
            color: #262626;
            margin-bottom: 15px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-img-comment {
            width: 60px;
            height: 60px;
            float: left;
            margin-bottom: 15px;
        }

        .be-ava-comment {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }

        .be-comment-content {
            margin-left: 80px;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-name {
            font-size: 13px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-comment-content a {
            color: #383b43;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-time {
            text-align: right;
        }

        .be-comment-time {
            font-size: 11px;
            color: #b4b7c1;
        }

        .be-comment-text {
            font-size: 13px;
            line-height: 18px;
            color: #7a8192;
            display: block;
            background: #f6f6f7;
            border: 1px solid #edeff2;
            padding: 15px 20px 20px 20px;
        }

        .form-group.fl_icon .icon {
            position: absolute;
            top: 1px;
            left: 16px;
            width: 48px;
            height: 48px;
            background: #f6f6f7;
            color: #b5b8c2;
            text-align: center;
            line-height: 50px;
            -webkit-border-top-left-radius: 2px;
            -webkit-border-bottom-left-radius: 2px;
            -moz-border-radius-topleft: 2px;
            -moz-border-radius-bottomleft: 2px;
            border-top-left-radius: 2px;
            border-bottom-left-radius: 2px;
        }

        .form-group .form-input {
            font-size: 13px;
            line-height: 50px;
            font-weight: 400;
            color: #black;
            width: 100%;
            height: 50px;
            padding-left: 20px;
            padding-right: 20px;
            border: 1px solid #edeff2;
            border-radius: 3px;
            background-color: #e0e0e0;

        }

        .form-group.fl_icon .form-input {
            padding-left: 70px;
        }

        .form-group textarea.form-input {
            height: 150px;
        }

    </style>

    <body>

        <jsp:include page="header.jsp" />

        <!--================Single Product Area =================-->
        <div class="product_image_area">
            <div class="container">

                <div class="row s_product_inner">
                    <div class="col-lg-6">
                        <div class="s_Product_carousel">
                            <div class="single-prd-item">
                                <img class="img-fluid" src="${Pdetails.product_pic}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5 offset-lg-1">
                        <div class="s_product_text">
                            <h3>${Pdetails.product_name}</h3>
                            <h2>$${Pdetails.price}</h2>
                            <ul class="list">
                                <li>
                                    <a class="active text-decoration-none" href="/PRJProject/category/${Pdetails.category_id}"><span>Category</span> :
                                        <c:choose>
                                            <c:when test="${Pdetails.category_id == 1}">
                                                ADIDAS
                                            </c:when>
                                            <c:when test="${Pdetails.category_id == 2}">
                                                NIKE
                                            </c:when>
                                            <c:when test="${Pdetails.category_id == 3}">
                                                BALENCIAGA
                                            </c:when>
                                            <c:when test="${Pdetails.category_id == 4}">
                                                CONVERSE
                                            </c:when>
                                            <c:otherwise>
                                                No brand
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </li>

                                <li><span>Availibility</span> : ${Pdetails.stock_quantity}</li>
                            </ul>
                            <p>${Pdetails.des}</p>



                            <div class="product_count">
                                <label for="qty">Quantity:</label>
                                <div class="quantity">
                                    <button  class="minus-btn text-danger">-</button>
                                    <input type="text" name="qty" id="sst" maxlength="12" value="1" title="Quantity:" readonly class="input-text qty">
                                    <button class="plus-btn">+</button>
                                </div>
                                <div class="card_area d-flex align-items-center mt-3">
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center"><a class="primary-btn btn btn-outline-dark mt-auto" href="/PRJProject/buy?id=${Pdetails.product_id}&num=">Add to Cart</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!--================End Single Product Area =================-->

            <!--================Product Description Area =================-->

            <section class="product_description_area">
                <div class="container">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link text-light bg-dark" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Description</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light bg-dark" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact"
                               aria-selected="false">Previews</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <p>${Pdetails.des}</p>
                        </div>
                        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">

                            <div class="row">
                                <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
                                <div class="container">
                                    <div class="be-comment-block">
                                        <h1 class="comments-title" id="comment-count">Comments (${totalCM})</h1>
                                        <c:forEach items="${commentList}" var="o">
                                            <div class="be-comment" id="comments-container">
                                                <div class="be-img-comment">	
                                                    <a href="blog-detail-2.html">
                                                        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="be-ava-comment">
                                                    </a>
                                                </div>
                                                <div class="be-comment-content">

                                                    <span class="be-comment-name">
                                                        <a href="blog-detail-2.html">${o.username}</a>
                                                    </span>
                                                    <span class="be-comment-time">
                                                        <i class="fa fa-clock-o"></i>
                                                        ${o.comment_date}
                                                    </span>

                                                    <p class="be-comment-text">
                                                        ${o.comment_text}
                                                    </p>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <form class="form-block" action="/PRJProject/details/Comment/${idDT}" method="post">
                                            <div class="row">
                                                <div class="col-xs-12">									
                                                    <div class="form-group">
                                                        <textarea id="comment-input" name="txtCm" class="form-input" required="" placeholder="${messC == null?"Your text":messC}"></textarea>
                                                    </div>
                                                </div>
                                                <a id="submit-button" ></a>
                                                <input type="submit" value="Comment" name="btnSubmit" class="btn btn-primary pull-right">
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--================End Product Description Area =================-->

            <!-- Start related-product Area -->
            <section class="related-product-area section_gap_bottom">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-6 text-center">
                            <div class="section-title">
                                <h1>Deals of the Week</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
                                    magna aliqua.</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-9">
                            <div class="row">

                                <c:forEach items="${list9P}" var="o">
                                    <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                        <div class="single-related-product d-flex">
                                            <a href="/PRJProject/details/${o.product_id}"><img src="${o.product_pic}" width="100px" height="100px" alt=""></a>
                                            <div class="desc">
                                                <a class="text-decoration-none text-dark fw-bold" href="/PRJProject/details/${o.product_id}" class="title">${o.product_name}</a>
                                                <div class="price">
                                                    <h6>$${o.price}</h6>
                                                    <h6 class="l-through">$210.00</h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="ctg-right">
                                <a href="#" target="_blank">
                                    <img class="img-fluid d-block mx-auto" src="/PRJProject/img/category/c5.jpg" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End related-product Area -->


            <script>
                $(document).ready(function () {
                    $('.minus-btn').click(function (e) {
                        e.preventDefault();
                        var input = $(this).siblings('input.qty');
                        var value = parseInt(input.val());

                        if (value > 1) {
                            value = value - 1;
                        } else {
                            value = 1;
                        }

                        input.val(value);
                    });

                    $('.plus-btn').click(function (e) {
                        e.preventDefault();
                        var input = $(this).siblings('input.qty');
                        var value = parseInt(input.val());

                        if (value < 10) {
                            value = value + 1;
                        } else {
                            value = 10;
                        }

                        input.val(value);
                    });

                    $('.primary-btn').click(function (e) {
                        e.preventDefault();
                        var quantity = $('.qty').val();
                        var addToCartLink = $(this).attr('href');
                        addToCartLink += quantity;
                        window.location.href = addToCartLink;
                    });
                });
            </script>
    </body>
</html>
