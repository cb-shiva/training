/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import phonedirectory.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-shiva
 */
public class deactivate extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/phone_books?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        User user = new User(email);
        
        PrintWriter out = response.getWriter();
        try{
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement updatestmt = con.prepareStatement("delete from user_phone_book where user_id = ?");
            user.fetchDetails();
            updatestmt.setString(1, user.getUserId());
            updatestmt.executeUpdate();
            updatestmt = con.prepareStatement("delete from user_details where user_id = ?");
            updatestmt.setString(1, user.getUserId());
            updatestmt.executeUpdate();
            response.sendRedirect("index.jsp");
        }
        catch(Exception e){
            out.print(e.getMessage());
        }
    }

}
