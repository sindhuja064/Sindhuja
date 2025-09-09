<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Even or Odd</title>
</head>
<body>
 <form>
        Enter a number: <input type="text" name="num"><br>
        <input type="submit" value="Check">
 </form>

    <%
        // to change the text to Number
        String n = request.getParameter("num");
        if(n != null) {
            int num = Integer.parseInt(n);
            if(num % 2 == 0) {
                out.print(num + " is Even");
            } else {
                out.print(num + " is Odd");
            }
        }
    %>

</body>
</html>
