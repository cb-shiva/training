<%@page import="phonedirectory.Contact"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page import="phonedirectory.User" %>

<%
    
    if(!"logged_in".equals(session.getAttribute("status"))){
        response.sendRedirect("index.jsp");
    }
%>

<html>
<head>
	<title>Edit details</title>
	<link rel="stylesheet" type="text/css" href="edit_contacts_styles.css">
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
            User user = new User(email);
            user.fetchDetails();
            String phoneId = (String)request.getParameter("phone_book_id");
            Contact contact = new Contact(phoneId);
        %>
	<div id="header">
		<div id="app-name">Phone directory</div>
		<div id="block"></div>
		<div id="right-buttons">
			<div id="user-name">
                            Hi <%out.print(user.getFirstName());%>
                        </div>
                        <input type="submit" id="deactivate-button-box" onClick="parent.location='deactivate'" value="Deactivate!"/>
                        <input type="submit" id="logout-button-box" onClick="parent.location='index.jsp'" value="Logout">
		</div>
	</div>
	</div>
	<div id="app-container">
		<div id="app-welcome-container">
			Edit details
		</div>
		<div id="edit-container">
			<form name="login-form" method="POST" action="update_contact">
				<div id="name-block">
					<div id="name-label-box">Name:</div>
					<div i="name-box">
						<div id="user-input-firstname-box">
                                                    <input type="text" class="input-box" name="firstname" maxlength="10" value="<%out.print(contact.getFirstName());%>" placeholder="First Name" required>
						</div>
						<div id="user-input-lastname-box">
							<input type="text" class="input-box" name="lastname" maxlength="10" value="<%out.print(contact.getLastName());%>" placeholder="Last Name" required>
						</div>
					</div>
				</div>
				
				<div id="address-block">
					<div id="address-label-box">Address</div>
					<div id="address-box">
						<div id="address-line">
                                                    <input type="text" class="address-input-box" name="address_line_1" value="<%out.print(contact.getAddressLine1());%>" placeholder="Address Line 1" required>
						</div>
						<div id="address-line">
							<input type="text" class="address-input-box" name="address_line_2" value="<%out.print(contact.getAddressLine2());%>" placeholder="Address Line 2" required>
						</div>
						<div id="address-line">
							<input type="text" style="font-size:80%;" class="input-box" name="city" value="<%out.print(contact.getCity());%>" placeholder="City" required>
							<select name="state" style="font-size:80%;" class="input-box" required>
                                                          <option value="" disabled selected>State</option>
							  <option value="Karnataka">Karnataka</option>
							  <option value="Tamil nadu">Tamil nadu</option>
							  <option value="Kerala">Kerala</option>
							  <option value="Orissa">Orissa</option>
							</select>
						</div>
						<div id="address-line">
							<input type="text" style="font-size:80%;" class="input-box" maxlength="10" name="zip" value="<%out.print(contact.getZip());%>" placeholder="Zip" required>
							<select name="country" style="font-size:80%;" class="input-box" required>
                                                           <option value="" disabled selected>Country</option>
							  <option value="India">India</option>
							  <option value="U.S.A">U.S.A</option>
							  <option value="Sri Lanka">Sri Lanka</option>
							</select>
						</div>
					</div>
				</div>
				<div id="numbers-block">
					<div id="number-label-block" >Numbers</div>
					<input type="text" class="address-input-box" value="<%out.print(contact.getMobileNumber());%>" name="mobile_number" placeholder="Mobile number"required>
					<br>
					<input type="text" class="address-input-box" value="<%out.print(contact.getHomeNumber());%>" name="home_number" placeholder="Home number" required>
					<br>
					<input type="text" class="address-input-box" value="<%out.print(contact.getWorkNumber());%>" name="work_number" placeholder="Work number" required>
					<input type="hidden" value="<% out.print(phoneId);%>" name="phone_book_id">
				</div>
				<div id = "edit-details-box">
					<input type="submit" class="save-btn" value="Save details">
				</div>
			</form>
		</div>
	</div>
        <form name="ignore_me">
            <input type="hidden" id="page_is_dirty" name="page_is_dirty" value="0" />
        </form> 
</body>
</html>