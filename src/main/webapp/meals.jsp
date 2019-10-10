<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %><%--
  Created by IntelliJ IDEA.
  User: Лепехи.Ноут
  Date: 09.10.2019
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<body>
<table border="1">
    <tr>
        <th>Время</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr class="${meal.excess ? color="green" : color="red"}">
            <td>
                <%=TimeUtil.toString(meal.getDateTime)%>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</body>
</html>
