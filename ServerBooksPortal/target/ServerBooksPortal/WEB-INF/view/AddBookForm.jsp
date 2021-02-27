<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add book </title>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <style type="text/css">
        body,html{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            height: 100vh;
            background: #efefef;
        }

        .wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 25%;
            margin: auto;
            padding-top: 5rem;
            padding-bottom: 1rem;
        }
        .buttons{
            display: flex;
            justify-content: center;
            padding: 1rem;
        }
    </style>
</head>
<body>

<c:url value="/addBookFormAction" var="formUrl" />
<div class="wrapper">
    <form:form modelAttribute="booksInfo" action="${formUrl}" method="POST" class="ui form">
        <h1 class="ui center aligned header">Add Book Form</h1>
        <div class="ui container">
            <div class="ui one column grid">
                <div class="field required column">
                    <label>bookId</label>
                    <form:input path="bookId" maxlength="4" readonly="true" />
                    <form:errors path="bookId" class="ui pointing red prompt basic label"></form:errors>
                </div>
                <div class="field required column">
                    <label>bookName</label>
                    <form:input path="bookName" maxlength="100" placeholder="book Name"/>
                    <form:errors path="bookName" class="ui pointing red prompt basic label"></form:errors>
                </div>
                <div class="field required column">
                    <label>bookAuthor</label>
                    <form:input path="bookAuthor" maxlength="50" placeholder="Book Author"/>
                    <form:errors path="bookAuthor" class="ui pointing red prompt basic label"></form:errors>
                </div>
                <div class="field required column">
                    <label>bookDesc</label>
                    <form:input path="bookDesc" maxlength="500"  placeholder="book Desc"/>
                    <form:errors path="bookDesc" class="ui pointing red prompt basic label"></form:errors>
                </div>
                <div class="field required column">
                    <label>INR price</label>
                    <form:input path="inPrice"  type="number"  />
                    <form:errors path="inPrice" class="ui pointing red prompt basic label"></form:errors>
                </div>
                <div class="field required column">
                    <label>USD price</label>
                    <form:input path="usPrice" type="number"   />
                    <form:errors path="usPrice" class="ui pointing red prompt basic label"></form:errors>
                </div>
            </div>
            <div class="buttons row">

                <button type="submit" class="ui button linkedin">Register</button>
                <a href="index.jsp" type="submit" class="ui button linkedin">Back</a>

            </div>
        </div>
    </form:form>
</div>
</body>
</html>


