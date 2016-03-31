/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author cb-shiva
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/phone_books?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        PrintWriter out = response.getWriter();
        try{
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            String inputUserEmail = request.getParameter("email_id");
            String inputPassword = request.getParameter("password"), dbPassword;
            HttpSession session = request.getSession();
            PreparedStatement passQuery = con.prepareStatement("Select password from user_details where email like ?");
            passQuery.setString(1,inputUserEmail);
            out.print(inputUserEmail);
            ResultSet r = passQuery.executeQuery();

            if(r.next()){
                dbPassword = r.getString("password");
                if(dbPassword.equals(inputPassword)){
                    session.setAttribute("user", inputUserEmail);
                    session.setAttribute("status","logged_in");
                    response.sendRedirect("show-contacts.jsp");
                }
                else{
                    session.setAttribute("user", "invalid");
                    session.setAttribute("status","incorrect_password");
                    session.setAttribute("attempted_email",inputUserEmail);
                    response.sendRedirect("Login.jsp");
                }
            }
            else{
                session.setAttribute("user", "invalid");
                session.setAttribute("status","incorrect_email");
                response.sendRedirect("Login.jsp");
            }
            
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
    }

}
