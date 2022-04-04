<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/3/2022
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/childs?action=add">Add New Child</a>
        <br/>
        <a href="/childs?action=search">Find By Country</a>
        <br/>
        <a href="/childs?action=sort">Sort List By Name</a>
        <br/>
        <a href="/childs">Back to HomeTown</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Children</h2></caption>
        <tr>
            <th>ID</th>
            <th>FullName</th>
            <th>Age</th>
            <th>Gender</th>
            <th>IdF</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="child" items="${newlist}">
            <tr>
                <td><c:out value="${child.idS}"/></td>
                <td><c:out value="${child.fullname}"/></td>
                <td><c:out value="${child.age}"/></td>
                <td><c:out value="${child.gender}"/></td>
                <td><c:out value="${child.idF}"/></td>
                <td>
                    <a href="/childs?action=edit&idS=${child.idS}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>