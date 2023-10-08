<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<br>
<jsp:useBean id="mealToList" scope="request" type="java.util.List<ru.javawebinar.topjava.model.MealTo>"/>
<jsp:useBean id="formatter" scope="request" type="java.time.format.DateTimeFormatter"/>
<table>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <c:forEach var="mealTo" items="${mealToList}">
        <tr>
            <c:set var="td_color" scope="session" value="#008000FF"/>
            <c:if test="${mealTo.excess == true}">
                <c:set var="td_color" scope="session" value="#FF0000"/>
            </c:if>
            <td style="color:${td_color};"><c:out value="${mealTo.dateTime.format(formatter)}"/></td>
            <td style="color:${td_color};"><c:out value="${mealTo.description}"/></td>
            <td style="color:${td_color};"><c:out value="${mealTo.calories}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>