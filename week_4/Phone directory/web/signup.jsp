<!DOCTYPE html>
<html>
<head>
	<title>Sign up</title>
	<link rel="stylesheet" type="text/css" href="signup-styles.css">
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
	<div id="main-container">
		<div id="app-name-container">
			<div id="function">
					Register to
				</div>
			<div id="app-name">
				Space Portal
			</div>
		</div>
		<div id="registration-box">

				<form name="signup_form" method="POST" action="create_user" onSubmit="return validateForm();">
					<input type="text" class="input-box" name="firstname" placeholder="  First Name">
					<input type="text" class="input-box" name="lastname" placeholder="  Last Name" required>
					<input type="email" class="input-box" name="email_id" placeholder="  Email" required>
					
					<input type="email" class="input-box" name="confirm_email" placeholder="  Confirm Email" required>
                                        <% 
                                            if("email_exists".equals(session.getAttribute("status"))){
                                                out.print("&nbsp;&nbsp;&nbsp;Email id " +(String)session.getAttribute("attempted_email") + " already exists,try again<br>");
                                            }
                                            session.invalidate();
                                        %>
					<input type="password" class="input-box"name="password" placeholder="  Password" required>
						<input type="password" class="input-box"name="confirm_password" placeholder="  Confirm Password" required>
					<div id="submit-box">
						<input type="submit" class="submit-btn" value="Create account">
					</div>
				</form>
		</div>		
	</div>

</body>
</html>