<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SysHome</title>
</head>
<body>
	<center>
		<h1>Hello ${sysuser_id}</h1>
		<h1>
			<a href="http://127.0.0.1:8080/ShopSite/List/Customers">用户管理</a>
		</h1>
		<h1>
			<a href="http://127.0.0.1:8080/ShopSite/List/HeadCheck">头像审核【${sutoheadcheck}】</a>
		</h1>
		<h1>
			<a href="#">商品审核【${sutogoodscheck}】</a>
		</h1>
	</center>
</body>
</html>