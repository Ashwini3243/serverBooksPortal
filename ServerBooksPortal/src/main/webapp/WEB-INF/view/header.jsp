

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">

    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <title>
        server home
    </title>
    <style>
        body {
            background-color: whitesmoke;
        }

        .left_menu{
            position:fixed;
            background: #b3c6ff !important;
            top:100px;
        }
        font{
            position:absolute;
            left: 100px;
            top:25px;
            font-size:35px;
            color:black;
            font-weight: bold;
        }
        img{
            height: 100px;
            width: 100px;
            left: 500px;
            top:100%;
            border-radius: 70%;
        }
        a
        {
            text-decoration: none;
        }
        a:hover
        {
            color: cornflowerblue;
            font-size:15px;
        }

    </style>
</head>
<body>

<div class="ui medium image img">
    <img src="<c:url value="/images/logo.PNG"/>"/>
    <font>Corona Fighters</font>

    <div class="ui eight item  menu left_menu">
        <a class=" item">
            <i class="home icon"></i>
        </a>
        <a class="item" href="home">
            about us
        </a>
        <a class="item" href="#">
            preventive measure
        </a>
        <a class="item" href="#">
            corona meter
        </a>
        <a class="item" href="#">
            buy vaccine
        </a>
        <a class="item" href="#">
            FAQ
        </a>
        <a class="ui item">
            <i class="sign in icon"></i>
            Login
        </a>
        <a class="ui item">
            <i class="user plus icon"></i>
            Sign Up
        </a>

    </div>

</body>
</html>


