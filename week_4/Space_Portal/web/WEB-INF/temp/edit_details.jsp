<%-- 
    Document   : edit_details
    Created on : Feb 23, 2016, 12:46:03 PM
    Author     : cb-shiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.hello.User" %>
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
    <form name="signup_form" method="POST" action="edit_detail" >
		First name:<input type="text" name="firstname" value="<% out.print(userObj.getFirstName()); %>" required><br>
		Last Name:<input type="text" name="lastname" value="<% out.print(userObj.getLastName()); %>" required><br>
		Email:<input type="email" name="email_id" value="<% out.print(userObj.getEmail()); %>" readonly><br>               
                Address line 1:<input type="text" name="address_line_1" required>
                Address line 2:<input type="text" name="address_line_2" required>
                City<input type="text" name="city" required>
                State:<input type="text" name="state" required>
                Zip:<input type="text" name="zip" required>
                Country:<input type="text" name="country" required>
		<input type ="submit" value="submit">
    </form>
    </body>
</html>
