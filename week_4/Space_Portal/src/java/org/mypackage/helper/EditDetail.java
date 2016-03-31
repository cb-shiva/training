/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-shiva
 */
@WebServlet(name = "EditDetail", urlPatterns = {"/edit_detail"})
public class EditDetail extends HttpServlet {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/space_portal?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
                try{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
                        PreparedStatement updateQuery = con.prepareStatement("update user_details set address_line_1 = ?, address_line_2 = ?, city = ?, state = ?, zip = ?, country = ?,firstname = ?,lastname = ? where email like ?");
                        updateQuery.setString(1, request.getParameter("address_line_1"));
                        updateQuery.setString(2, request.getParameter("address_line_2"));
                        updateQuery.setString(3, request.getParameter("city"));
                        updateQuery.setString(4, request.getParameter("state"));
                        updateQuery.setString(5, request.getParameter("zip"));
                        updateQuery.setString(6, request.getParameter("country"));
                        updateQuery.setString(7, request.getParameter("firstname"));
                        updateQuery.setString(8, request.getParameter("lastname"));
                        updateQuery.setString(9, request.getParameter("email_id"));
                        if(updateQuery.executeUpdate() == 1){
                            response.sendRedirect("details.jsp");
                        }
                        //response.sendRedirect("details.jsp");
                }
                catch(Exception s){
                        out.print(s.getMessage());
                }
    }

}
