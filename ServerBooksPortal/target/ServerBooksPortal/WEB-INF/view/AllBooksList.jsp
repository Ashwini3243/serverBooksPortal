<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkmagenta" > books List</h1>
<table border="2" cellspacing="0" cellpadding="8" style="border-color: darkblue" >
    <tr >
        <th>bookId</th>
        <th>bookName</th>
        <th>bookAuthor</th>
      &lt;%&ndash;  <th>bookDesc</th>&ndash;%&gt;
 &lt;%&ndash;       <th>price</th>
        <th>language</th>&ndash;%&gt;
    </tr>
    <c:forEach items="${BooksList}" var="bl">
        <tr>
            <td><a href="getBooksById/${bl.bookId}">${bl.bookId}</a></td>
            <td>${bl.bookName}</td>
            <td>${bl.bookAuthor}</td>
           &lt;%&ndash; <td>${bl.bookDesc}</td>&ndash;%&gt;
           &lt;%&ndash; <td>${bl.price}</td>
            <td>${bl.language}</td>&ndash;%&gt;

        </tr>
    </c:forEach>

</table><br><br>
<a href="index.jsp"><input type="button" value="home" style="color: springgreen" ></a>

--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>bookList</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">

    <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        table tr th{
            font-weight: 900;
            font-size: 15px;
            text-align: center;
        }
        .wrapper{
            padding-top: 2rem;
        }
    </style>
</head>
<body>
<div class="ui container wrapper">
    <h1 class="ui header divided" > Books list</h1>
    <table cellspacing="0" cellpadding="8" class="ui table striped celled" >

        <tr >

            <th>Book Name</th>
            <th>Book Author</th>
            <th>view</th>
        </tr>
        <c:forEach items="${BooksList}" var="data">

            <tr>
                <td>${data.bookName}</td>
                <td>${data.bookAuthor}</td>
                <td><a href="getBooksById/${data.bookId}" >view</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp" class="ui button linkedin">Back</a>

</div>
</body>
</html>


