<!DOCTYPE html>
<%
           // Check if this is new comer on your web page.
           String loginMessage = "";
           String passwordMessage = "",attemptedEmail="";
           if(!session.isNew()){
               if("logged_in".equals(session.getAttribute("status"))){
                   response.sendRedirect("details.jsp");
               }
               else if("incorrect_email".equals(session.getAttribute("status"))){
                   loginMessage = "The email does not exist, please sign up";                 
               }
               else if("incorrect_password".equals(session.getAttribute("status"))){
                   attemptedEmail = (String) session.getAttribute("attempted_email");
                   passwordMessage = "Incorrect password,try again";                  
               }
           }
%>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="login-styles.css">
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
	<div id="main-container">
		<div id="sub-container">
			<div id="app-name-container">
				<div id="app-name">
					Space Portal
				</div>
				<div id="function">
					Login
				</div>
			</div>
			<div id="login-box">

				<form name="login-form" action="login" method="POST">
					<div id="user-input-login-box">
						<input type="email" class="input-box" value = "<% out.print(attemptedEmail); %>" name="email_id" placeholder="Username" required></input>
					</div>
					<div id="login-error-message-box">
						<% out.print(loginMessage); %>
					</div>


					<div id="user-input-password-box">
						<input type="password" class="input-box" name="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;" required></input>
					</div>
					<div id="password-error-message-box">
						<% out.print( passwordMessage); %>
					</div>

					<div id="submit-button-box">
						<input type="submit" class="submit-btn" value="Login">
					</div>
				</form>
			</div>
		</div>
			<input type="submit" onClick="parent.location='signup.jsp'" id="sign-up-box" value="New around here?">

	</div>
        <form name="ignore_me">
            <input type="hidden" id="page_is_dirty" name="page_is_dirty" value="0" />
        </form>                              
</body>
</html>