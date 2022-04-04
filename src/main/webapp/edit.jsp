<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/3/2022
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Child Management Application</title>
</head>
<body>
<center>
    <h1>Child Management</h1>
    <h2>
        <a href="childs?action=childs">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Child
                </h2>
            </caption>
            <c:if test="${child != null}">
                <input type="hidden" name="idS" value="<c:out value='${child.idS}' />"/>
            </c:if>
            <tr>
                <th>Child Fullname:</th>
                <td>
                    <input type="text" name="fullname" size="45"
                           value="<c:out value='${child.fullname}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Child Age:</th>
                <td>
                    <input type="text" name="age" size="45"
                           value="<c:out value='${child.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" size="15"
                           value="<c:out value='${child.gender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>idF:</th>
                <td>
                    <input type="text" name="idF" size="15"
                           value="<c:out value='${child.idF}' />"
                    />
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
