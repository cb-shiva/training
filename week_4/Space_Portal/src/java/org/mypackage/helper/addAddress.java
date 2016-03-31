/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.helper;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-shiva
 */
public class addAddress extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/space_portal?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("user");
            PreparedStatement updateQuery = con.prepareStatement("update user_details set address_line_1 = ?, address_line_2 = ?, city = ?, state = ?, zip = ?, country = ? where email like ?");
            updateQuery.setString(1, request.getParameter("address_line_1"));
            updateQuery.setString(2, request.getParameter("address_line_2"));
            updateQuery.setString(3, request.getParameter("city"));
            updateQuery.setString(4, request.getParameter("state"));
            updateQuery.setString(5, request.getParameter("zip"));
            updateQuery.setString(6, request.getParameter("country"));
            updateQuery.setString(7, email);
            updateQuery.executeUpdate();
            response.sendRedirect("details.jsp");
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

}
