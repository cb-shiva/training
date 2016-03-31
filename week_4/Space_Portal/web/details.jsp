<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page import="org.mypackage.helper.User" %>

<%
    
    if(!"logged_in".equals(session.getAttribute("status"))){
        response.sendRedirect("index.jsp");
    }
    
%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="details-styles.css">
        <script>
             function check(){
                 var dirty_bit = document.getElementById('page_is_dirty');
                
                 if (dirty_bit.value === '1') {
                     window.location.reload();
                 }
                 else{
                     dirty_bit.value = '1';
                 }
             }
        </script>
</head>
<body onload="check()">
	<%
            String email = (String)session.getAttribute("user");
            User userObj = new User(email);
        %>
	<div id="header">
		<div id="app-name">Space Portal</div>
		<div id="block"></div>
		<div id="right-buttons">
			<div id="user-name">
                            Hi <% out.print(userObj.getFirstName()); %>
                        </div>
                        <input type="submit" id="deactivate-button-box" onClick="parent.location='deactivate'" value="Deactivate!"/>
                        <input type="submit" id="logout-button-box" onClick="parent.location='index.jsp'" value="Logout">
		</div>
	</div>
	<div id="app-container">
		<div id="app-welcome-container">
			Welcome to the Space Portal
		</div>
		<div id="details-container">
			<div id="name-block">
				<div id="name-label-box">Name:</div>
				<div id="name-box">
                                    <%
                                        out.print(userObj.getFirstName()+" "+userObj.getLastName()); 
                                    %>
                                </div>
			</div>
			<div id="email-block">
				<div id="email-label-box">Email:</div>
				<div id="email-box"><% out.print(email); %></div>
			</div>
			<div id="address-block">
				<div id="address-label-box">Address</div>
				<div id="address-box">
					<% 
			            if(!userObj.addressExists()){
			                out.print(" N/A ");
			            }
			            else{
			                out.print("<p>"+userObj.getAddressLine1()+"</p>");
			                out.print("<p>"+userObj.getAddressLine2()+"</p>");
			                out.print("<p>"+userObj.getCity()+"</p>");
			                out.print("<p>"+userObj.getState()+"</p>");
			                out.print("<p>"+userObj.getCountry()+"</p>");
			                out.print("<p>"+userObj.getZip()+"</p>");
			            }
			        %>
				</div>
			</div>
			<div id = "edit-details-box">
				<input type="submit" class="submit-btn" onClick="parent.location='edit_details.jsp'" value="Edit details">
			</div>
		</div>
	</div>
        <form name="ignore_me">
            <input type="hidden" id="page_is_dirty" name="page_is_dirty" value="0" />
        </form>
</body>
</html>