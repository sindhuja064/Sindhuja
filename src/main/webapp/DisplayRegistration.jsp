<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Registration Data</title>
</head>
<body>
    <h2>Registration Details</h2>

    <%
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
    %>

    <p><b>Name:</b> <%= name %></p>
    <p><b>Phone:</b> <%= phone %></p>
    <p><b>Email:</b> <%= email %></p>
    <p><b>Password:</b> <%= password %></p>
    <p><b>Gender:</b> <%= gender %></p>

</body>
</html>
