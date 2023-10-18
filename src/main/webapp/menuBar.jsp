<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Sidebar Dashboard Template</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <style>
            body{
                margin: 0;
                padding: 0;
                font-family: "Roboto", sans-serif;
            }

            header{
                position: fixed;
                background: #22242A;
                padding: 20px;
                width: 100%;
                height: 30px;
            }

            .left_area h3{
                color: #fff;
                margin: 0;
                text-transform: uppercase;
                font-size: 22px;
                font-weight: 900;
            }

            .left_area span{
                color: #19B3D3;
            }

            .logout_btn{
                padding: 5px;
                background: #19B3D3;
                text-decoration: none;
                float: right;
                margin-top: -30px;
                margin-right: 40px;
                border-radius: 2px;
                font-size: 15px;
                font-weight: 600;
                color: #fff;
                transition: 0.5s;
                transition-property: background;
            }

            .logout_btn:hover{
                background: #0B87A6;
            }

            .sidebar {
                background: #2f323a;
                padding-top: 30px;
                position: fixed;
                left: 0;
                width: 240px;
                height: 100%;
                transition: 0.5s;
                transition-property: left;
            }

            .sidebar .profile_image{
                width: 100px;
                height: 100px;
                border-radius: 100px;
                margin-bottom: 10px;
                margin-right: 40px;
            }

            .sidebar h4{
                color: #ccc;
                margin-top: 0;
                margin-bottom: 20px;
            }

            .sidebar a{
                color: #fff;
                display: block;
                width: 100%;
                line-height: 60px;
                text-decoration: none;
                padding-left: 40px;
                box-sizing: border-box;
                transition: 0.5s;
                transition-property: background;
            }

            .sidebar a:hover{
                background: #19B3D3;
            }

            .sidebar i{
                padding-right: 10px;
            }

            label #sidebar_btn{
                z-index: 1;
                color: #fff;
                position: fixed;
                cursor: pointer;
                left: 300px;
                font-size: 20px;
                margin: 5px 0;
                transition: 0.5s;
                transition-property: color;
            }

            label #sidebar_btn:hover{
                color: #19B3D3;
            }

            #check:checked ~ .sidebar{
                left: -190px;
            }

            #check:checked ~ .sidebar a span{
                display: none;
            }

            #check:checked ~ .sidebar a{
                font-size: 20px;
                margin-left: 170px;
                width: 80px;
            }

            .content{
                margin-left: 250px;
                background: url(background.png) no-repeat;
                background-position: center;
                background-size: cover;
                height: 100vh;
                transition: 0.5s;
            }

            #check:checked ~ .content{
                margin-left: 60px;
            }

            #check{
                display: none;
            }
            .list-group-item.inactive {
                background-color: #22242A;
                border-color: transparent;
                color: #ccc;
            }
            .list-group-item.active {
                border-color: #fd7e14;
                background-color: #fd7e14;
                color: #ccc;
            }


        </style>
    </head>
    <body>

        <input type="checkbox" id="check">
        <!--header area start-->
        <!--header area end-->
        <!--sidebar start-->
        <div class="sidebar">

            <a class="home" href="/PRJProject/home"><i class="fas fa-home"></i><span>Home</span></a>
            <ul class="list-group category_block">
                    <li class="list-group-item ${mana != null ? 'active' : 'inactive'}">
                        <a href="/PRJProject/manager">
                            <i class="fas fa-home"></i>
                            <span>Manager</span>
                        </a>
                    </li>
                    <li class="list-group-item ${cus != null ? 'active' : 'inactive'}">
                        <a href="/PRJProject/manager/top5Customer">
                            <i class="fas fa-desktop"></i>
                            <span>Top 5 Khach Hang</span>
                        </a>
                    </li>
                    <li class="list-group-item  ${ord != null ? 'active' : 'inactive'}">
                        <a href="/PRJProject/manager/ShowOrder">
                            <i class="fas fa-cogs"></i>
                            <span>Quan Ly Hoa Don</span>
                        </a>
                    </li>
                    <li class="list-group-item ${ac != null ? 'active' : 'inactive'}">
                        <a href="/PRJProject/manager/Account">
                            <i class="fas fa-table"></i>
                            <span>Quan Ly Tai Khoan</span>
                        </a>
                    </li>
                    <li class="list-group-item ${mth != null ? 'active' : 'inactive'}">
                        <a href="/PRJProject/manager/monthRevenue">
                            <i class="fas fa-sliders-h"></i>
                            <span>Doanh Thu Theo Thang</span>
                        </a>
                    </li>
            </ul>
        </div>
        <!--sidebar end-->
    </body>
</html>
