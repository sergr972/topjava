<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<style>
    table, td, th {
        border: 2px solid black;
    }

    table {
        border-collapse: collapse;
    }

    th {
        font-weight: bold;
        padding: 12px;
    }

    td {
        padding: 12px;
    }
</style>
<head>
    <title>Meals</title>
</head>
<body>
<hr>
<h2>Meals</h2>
<h3><a href="index.html">Home</a></h3>
<a href="meals?action=add">Add new</a>
<br>
<br>
<table>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Update</th>
        <th>Delete</th>

    </tr>
    <tbody>
    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr style="color:${meal.excess ? "red": "green"}">
            <td>${f:replace(meal.dateTime, "T", " ")}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?id=${meal.id}&action=update">Update</a></td>
            <td><a href="meals?id=${meal.id}&action=delete">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>


</table>
</body>
</html>