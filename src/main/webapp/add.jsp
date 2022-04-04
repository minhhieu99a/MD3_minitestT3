<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/3/2022
  Time: 5:52 PM
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
        <a href="childs?action=child">List All Children</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Child</h2>
            </caption>
            <tr>
                <th> FullName:</th>
                <td>
                    <input type="text" name="fullname" id="fullname" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Age:</th>
                <td>
                    <input type="text" name="age" id="age" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" id="gender" size="15"/>
                </td>
            </tr>
            <tr>
                <th>idF:</th>
                <td>
                    <input type="text" name="idF" id="idF" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
