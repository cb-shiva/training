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
	<title>Log in</title>
	
</head>
<body>
	<h1>Log in</h1>
	<form name="login_form" method="POST" action="login" >
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
        
        <form action="signup.jsp">
            <input type="submit" value="Sign up">
        </form>
</body>
</html>