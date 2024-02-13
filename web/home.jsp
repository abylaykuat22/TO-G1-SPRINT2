<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 13.02.2024
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table cellpadding="10px">
        <thead>
            <th>ID</th>
            <th>EMAIL</th>
            <th>FULL NAME</th>
            <th>CITY NAME</th>
            <th>CITY CODE</th>
            <th>COUNTRY NAME</th>
            <th>COUNTRY CODE</th>
        </thead>
        <tbody>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                for (User user : users) {
            %>
            <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getFullName()%></td>
                <td><%=user.getCity().getName()%></td>
                <td><%=user.getCity().getCode()%></td>
                <td><%=user.getCity().getCountry().getName()%></td>4
                <td><%=user.getCity().getCountry().getCode()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
