<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
    <h1>Star Pattern</h1>

    <%
        for(int i = 1; i <= 5; i++) {
            for(int j = 1; j <= i; j++) {
                out.print("* ");   
            }
            out.print("<br>");     
        }
    %>

</body>
</html>
