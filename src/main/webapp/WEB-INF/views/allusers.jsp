<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>Richest user:
        <td>${richestUser.fullName()}</td>
    </tr>
    <tr>Sum all accounts:
        <td>${sum}</td>
    </tr>
</table>

<form action="/" method="GET">
    <input type="text" value="${richestUser.fullName()}" readonly>
    <button type="submit">get</button>
</form>


<%--<form action="/" method="GET">
    <input type="text" value="${sum}" readonly>
    <button type="submit">get</button>
</form>--%>

<table>
    <tr>
        <td>| Id </td><td>| Name </td><td>| Surename</td><td>|</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>| ${user.user_id}</td>
            <td>| ${user.name}</td>
            <td>| ${user.sure_name}</td>
            <td>|</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
