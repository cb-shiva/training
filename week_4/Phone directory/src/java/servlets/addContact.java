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
public class addContact extends HttpServlet {
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
                PreparedStatement getPhoneId = con.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables " +
                                                                    "WHERE table_name = 'phone_book'" +
                                                                    "AND table_schema = DATABASE( )");
                ResultSet r = getPhoneId.executeQuery();
                if(r.next()){
                    phoneId = r.getString("AUTO_INCREMENT");
                }
                HttpSession session = request.getSession();
                String email = (String) session.getAttribute("user");
                User user = new User(email);
                user.fetchDetails();
                PreparedStatement updateQuery = con.prepareStatement("insert into phone_book (address_line_1,address_line_2,"
                        + "city,state,zip,first_name,last_name,mobile_number,home_number,work_number) values "
                        + "(?,?,?,?,?,?,?,?,?,?)");
                updateQuery.setString(1, request.getParameter("address_line_1"));
                updateQuery.setString(2, request.getParameter("address_line_2"));
                updateQuery.setString(3, request.getParameter("city"));
                updateQuery.setString(4, request.getParameter("state"));
                updateQuery.setString(5, request.getParameter("zip"));
                updateQuery.setString(6, request.getParameter("firstname"));
                updateQuery.setString(7, request.getParameter("lastname"));
                updateQuery.setString(8, request.getParameter("mobile_number"));
                updateQuery.setString(9, request.getParameter("home_number"));
                updateQuery.setString(10, request.getParameter("work_number"));
                        
                PreparedStatement updatePhoneUserQuery = con.prepareStatement("insert into user_phone_book (user_id,phone_book_id) values (?,?) ");
                out.print("here "+user.getUserId());
                updatePhoneUserQuery.setString(1,user.getUserId());
                updatePhoneUserQuery.setString(2,phoneId);
                updatePhoneUserQuery.executeUpdate();
                if(updateQuery.executeUpdate() == 1 ){
                    response.sendRedirect("show-contacts.jsp");
                }
        }
        catch(Exception s){
                out.print(s.getMessage());
        }
    }


}
