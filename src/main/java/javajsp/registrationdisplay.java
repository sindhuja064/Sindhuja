package javajsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrationdisplay")
public class registrationdisplay extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form values
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbcservlet", "root", "Sagar@1211");

            // Create table if it does not exist
            Statement stmt = con.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS servlet (" +
                                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                                    "name VARCHAR(100) NOT NULL," +
                                    "phone VARCHAR(20) NOT NULL," +
                                    "email VARCHAR(100) NOT NULL," +
                                    "password VARCHAR(100) NOT NULL," +
                                    "gender VARCHAR(10) NOT NULL)";
            stmt.execute(createTableSQL);
            stmt.close();

            // Insert form data
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO servlet(name, phone, email, password, gender) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, gender);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h3 style='color:green;'>Data Inserted Successfully...</h3>");
            } else {
                out.println("<h3 style='color:red;'>Failed to Insert.</h3>");
            }

            ps.close();

            // Fetch all records from table
            Statement selectStmt = con.createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT * FROM servlet");

            out.println("<h4>All Inserted Data:</h4>");
            out.println("<table border='1' cellpadding='5'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Phone</th><th>Email</th><th>Password</th><th>Gender</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("gender") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            rs.close();
            selectStmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            out.println("<h3 style='color:red;'>JDBC Driver not found: " + e.getMessage() + "</h3>");
        } catch (SQLException e) {
            out.println("<h3 style='color:red;'>Database Error: " + e.getMessage() + "</h3>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registration.jsp"); // redirect GET requests to your form
    }
}
