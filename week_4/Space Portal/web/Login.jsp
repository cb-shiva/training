<!DOCTYPE html>
<%
           // Check if this is new comer on your web page.
           String defaultLogin = "";
           String loginMessage = "";
           String passwordMessage = "",attemptedEmail="";
           if (session.isNew()){
              defaultLogin = "email";
           }
           else{
               if("logged_in".equals(session.getAttribute("status"))){
                   response.sendRedirect("http://localhost:9999/WebApplication3/details.jsp");
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
	<title>Sign up</title>
	<script type="text/javascript">
		function myfunc() {
			alert("Hello");
		}
		function validateForm() {
			document.ContactForm.email;
			var firstname = document.forms["signup_form"]["firstname"].value;
			var lastname = document.forms["signup_form"]["lastname"].value;
			var email = document.ContactForm.email;
			var confirm_email=document.ContactForm.confirm_email;
			var password=document.forms["signup_form"]["password"].value;
			var confirm_password=document.forms["signup_form"]["confirm_password"].value;
			if(email != confirm_email){
				alert("Emails do not match");
				confirm_email.focus();
				return false;
			}
			if (password != confirm_password) {
				alert("Passwords do not match");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<h1>Log in</h1>
	<form name="signup_form" method="POST" action="http://localhost:9999/WebApplication3/login" onsubmit="return validateForm();">
            <h2>Email:<input type="email" name="email_id" value = "<% out.print(attemptedEmail); %>" placeholder ="Email Id" required></h2>
                <div id="incorrect_login_box">
                    <h4> <% out.print(loginMessage); %></h4>
                </div>
            <h2>Password:<input type="password" name="password" required> </h2>
                <div id="incorrect_password_box">
                    <h4><% out.print( passwordMessage); %></h4>                       
                </div>
                <br>
		<input type ="submit" value="submit">
	</form>
        <br>
        <form action="http://localhost:9999/WebApplication3/signup.html">
            <input type="submit" value="Sign up">
        </form>
</body>
</html>