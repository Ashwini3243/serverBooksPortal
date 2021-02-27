
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">

<style>
    table tbody tr td:nth-child(1){
        width: 100px;
        font-weight: 600;
    }

</style>
<div class="ui container" style="padding-top: 5rem;">

    <table class="ui table striped celled book_details">
        <thead>
        <tr>
            <th colspan="2">
                Book Details
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>BookId</td>
            <td>${bookById.bookId}</td>
        </tr>
        <tr>
            <td>Book Name</td>
            <td>${bookById.bookName}</td>
        </tr>
        <tr>
            <td>Book Author</td>
            <td>${bookById.bookAuthor}</td>
        </tr>
        <tr>
            <td>Book desc</td>
            <td>${bookById.bookDesc}</td>
        </tr>
        <tr>
            <td>INR Price</td>
            <td>${bookById.inPrice}</td>
        </tr>
        <tr>
            <td>USD Price</td>
            <td>${bookById.usPrice}</td>
        </tr>
        </tbody>
    </table>
    <a href="../getBooksList" class="ui button linkedin">back</a>
    <a href="../index.jsp" class="ui button linkedin"> home </a>
</div>