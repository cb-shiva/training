




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <script type="text/javascript">
		function validateForm() {
			var email = document.signup_form.email_id.value;
			var confirm_email=document.signup_form.confirm_email.value;
			var password=document.signup_form.password.value;
			var confirm_password=document.signup_form.confirm_password.value;
			if(email !== confirm_email){
				alert("Emails do not match");
				return false;
			}
			if (password !== confirm_password) {
				alert("Passwords do not match");
				return false;
			}
			return true;
		}
	</script>
    </head>
    <body>
	<h1>Sign up</h1>
	<form name="signup_form" method="POST" action="create_user" onSubmit="return validateForm();">
		First name:<input type="text" name="firstname" required><br>
		Last Name:<input type="text" name="lastname" required><br>
		Email:<input type="email" name="email_id" required><br>
                <% 
                    if("email_exists".equals(session.getAttribute("status"))){
                        out.print("<h3>Email id " +(String)session.getAttribute("attempted_email") + " already exists,try again</h3><br>");
                    }
                    session.invalidate();
                %>
		Confirm Email:<input type="email" name="confirm_email" required><br>
		Password:<input type="password" name="password" required> <br>
		Confirm Password:<input type="password" name="confirm_password" required>
		<input type ="submit" value="submit">
	</form>
</body>
</html>
