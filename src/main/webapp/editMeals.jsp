<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>
    <title>${meal.id == null ? "Add" : "Edit"} meal</title>
</head>
<body>
<div class="container">
    <h1>${meal.id == null ? "Add" : "Edit"} meal</h1>
    <h3><a href="index.html">Home</a></h3>
    <form method="post" action="meals">
        <input class="form-control" type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt>DateTime:</dt>
            <dd><label>
                <input
                        class="form-control"
                        type="datetime-local"
                        value="${meal.dateTime}"
                        name="dateTime"
                        required>
            </label></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><label>
                <input
                        class="form-control"
                        type="text"
                        value="${meal.description}"
                        name="description"
                        required>
            </label></dd>
        </dl>
        <dl>
            <dt>Calories:</dt>
            <dd><label>
                <input
                        class="form-control"
                        type="number"
                        name="calories"
                        value="${meal.calories == "0" ? "" : meal.calories}"
                        min="1"
                        required>
            </label>
        </dl>
        <button class="btn-primary" type="submit">Save</button>
        <button class="btn-secondary" onclick="window.history.back()" type="button">Cancel</button>
    </form>
</div>
</body>
</html>
