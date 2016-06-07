<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet'
	type='text/css'>
<!--//webfonts-->
<script
	src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="resources/js/login.js" type="text/javascript"></script>
</head>
<body>

	<!--SIGN UP-->
	<h1>购物商城</h1>
	<div class="login-form">

		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<div><img src="resources/images/login_avtar.png" /></div>
			<div><img src="resources/images/login_avtar.png" /></div>
		</div>
		<form action="Login" onsubmit="return validate_form(this)"
			method="post">
			<input name="id" type="text" class="text" onfocus="this.value = '';"
				>
			<div class="key">
				<input name="pwd" type="password" onfocus="this.value = '';">
			</div>
			<div class="signin">
				<input type="submit">
			</div>
		</form>

	</div>
	<div class="copy-rights">
		<p>Copyright &copy; 2015.csxy@i1i2 All rights reserved.</p>
	</div>

</body>
</html>