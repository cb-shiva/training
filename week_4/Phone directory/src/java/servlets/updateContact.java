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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-shiva
 */
public class updateContact extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/phone_books?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        try{
                String phoneId="";
                Class.forName(JDBC_DRIVER);
                Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
                HttpSession session = request.getSession();
            
                PreparedStatement updateQuery = con.prepareStatement("update phone_book set address_line_1 = ?,address_line_2 = ?,"
                        + "city = ?,state = ?,zip = ?,first_name = ?,"
                        + "mobile_number = ?,home_number = ?,last_name = ?,work_number = ?"
                        + "where phone_book_id like ?");
                updateQuery.setString(1, request.getParameter("address_line_1"));
                updateQuery.setString(2, request.getParameter("address_line_2"));
                updateQuery.setString(3, request.getParameter("city"));
                updateQuery.setString(4, request.getParameter("state"));
                updateQuery.setString(5, request.getParameter("zip"));
                updateQuery.setString(6, request.getParameter("firstname"));
                updateQuery.setString(8, request.getParameter("mobile_number"));
                updateQuery.setString(9, request.getParameter("home_number"));
                updateQuery.setString(7, request.getParameter("lastname"));
                updateQuery.setString(10, request.getParameter("work_number"));
                updateQuery.setString(11, request.getParameter("phone_book_id"));
                if(updateQuery.executeUpdate() == 1){
                    response.sendRedirect("show-contacts.jsp");
                }
        }
        catch(Exception s){
                out.print(s.getMessage());
        }
    }


}
