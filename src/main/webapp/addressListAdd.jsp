<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="http://127.0.0.1:8080/ShopSite/resources/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/table.js"
	type="text/javascript"></script>
<link
	href="http://127.0.0.1:8080/ShopSite/resources/css/addressform.css"
	rel="stylesheet" type="text/css" media="all" />
<title>AddressAdd</title>
</head>
<body>
	<center>
		<form action="AddressAddSave" method="post" class="basic-grey">
			<h1>
				AddressAdd <span>Please fill all the texts in the fields.</span>
			</h1>
			<input id="pageNo" type="hidden" name="pageNo" value="${pageNo}" />
			<input id="cid" type="hidden" name="cid" value="${cid}" /> <label>
				<span>地址 : </span> <input id="address" type="text" name="address"
				placeholder="收货人地址" />
			</label> <label> <span>收货人姓名 :</span> <input id="aname" type="text"
				name="aname" placeholder="收货人" />
			</label> <label> <span>收货人手机 :</span> <input id="aphone" type="text"
				name="aphone" placeholder="收货人联系方式" />
			</label> <label><span>&nbsp;</span> <input type="submit"
				class="button" value="提交" /> </label>
		</form>
	</center>
</body>
</html>