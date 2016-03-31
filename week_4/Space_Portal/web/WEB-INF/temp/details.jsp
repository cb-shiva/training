<%-- 
    Document   : details
    Created on : Feb 22, 2016, 6:34:55 PM
    Author     : cb-shiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page import="org.mypackage.hello.User" %>

<%
    
    if(!"logged_in".equals(session.getAttribute("status"))){
        response.sendRedirect("index.jsp");
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String email = (String)session.getAttribute("user");
            User userObj = new User(email);
        %>
        
        <h2>First name:</h2><% out.print(userObj.getFirstName()); %>    
        <h2>Last name:</h2><% out.print(userObj.getLastName()); %>
        <h2>Email:</h2><% out.print(email); %>
        <% 
            out.print(userObj.addressExists());
            if(!userObj.addressExists()){
                out.print("<h2>Address:</h2> N/A  <form><input type=\"button\" value=\"Add address\" onClick=\"parent.location='add_address.html'\"></form>");
            }
            else{
                out.print("<h2>Address line 1</h2>"+userObj.getAddressLine1());
                out.print("<h2>Address line 2</h2>"+userObj.getAddressLine2());
                out.print("<h2>City</h2>"+userObj.getCity());
                out.print("<h2>State</h2>"+userObj.getState());
                out.print("<h2>Country</h2>"+userObj.getCountry());
                out.print("<h2>Zip</h2>"+userObj.getZip());
            }
        %>
        <form>
            <input type="button" value="Edit details" onClick="parent.location='edit_details.jsp'">
        </form>
        <form>
            <input type="button" value="Logout" onClick="parent.location='index.jsp'">
        </form>
        
    </body>
</html>
