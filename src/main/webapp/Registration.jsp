<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
    <h2>Simple Registration Form</h2>

    <form action="registrationdisplay" method="post">
        <label>Name: <input type="text" name="name" required></label><br><br>
        <label>Phone: <input type="text" name="phone" pattern="[0-9]{10}" title="Enter 10 digit number" required></label><br><br>
        <label>Email: <input type="email" name="email" required></label><br><br>
        <label>Password: <input type="password" name="password" required></label><br><br>
        Gender: 
        <input type="radio" name="gender" value="Male" required> Male
        <input type="radio" name="gender" value="Female"> Female <br><br>
        <input type="submit" value="Register">
    </form>

</body>
</html>
