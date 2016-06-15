<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CustomerList</title>
<style type="text/css">
table.altrowstable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}

table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

.oddrowcolor {
	background-color: #d4e3e5;
}

.evenrowcolor {
	background-color: #c3dde0;
}
</style>
<script type="text/javascript">
	/* 	function show(obj, id, valu) {

	 if (id == "0") {
	 obj.innerHTML = "<input type='text' name='id' value='"+ valu +"'>";
	 } else if (id == "1") {
	 obj.innerHTML = "<input type='text' name='pwd' value='"+ valu +"'>";
	 }
	 } */

	function mod(id, pwd) {
		alert(id);
		alert(pwd);
		var pageNo = "${page.topPageNo}";
		return;
		document
				.write("<form action=List/CustomerModify method=post style='display:none'>");
		document.write("<input type=hidden name=id value='" + id + "'");
		document.write("<input type=hidden name=pwd value='" + pwd + "'");
		document.write("<input type=hidden name=pageNo value='" + pageNo + "'");
		document.write("</form>");
		document.form1.submit();
	}

	function initpwd() {
		<c:set var="pwdnow" value="${customer_pwd}"></c:set>
	}
	function altRows(id) {
		if (document.getElementsByTagName) {

			var table = document.getElementById(id);
			var rows = table.getElementsByTagName("tr");

			for (i = 0; i < rows.length; i++) {
				if (i % 2 == 0) {
					rows[i].className = "evenrowcolor";
				} else {
					rows[i].className = "oddrowcolor";
				}
			}
		}
	}

	window.onload = function() {
		altRows('alternatecolor');
	}
</script>
</head>
<body>

	<center>
		<h1>Hello ${sysuser_id}</h1>
		<table class="altrowstable" id="alternatecolor" height=50px
			width=400px>
			<tr>
				<th>userid</th>
				<th>password</th>
			</tr>
			<c:forEach var="customer" items="${customers}">
				<form action="CustomerModify" method="POST">
					<table class="altrowstable" id="alternatecolor" height=50px
						width=400px>
						<tr>

							<td width=400px><input type="hidden" name="id"
								value="${customer.cid}"> <c:out value="${customer.cid}" /></td>
							<td width=400px><input type="text" name="pwd"
								value="${customer.cpwd}" onfocus="initpwd()"></td>
							<td><input type="submit" value="修改" onclick="alert('修改成功')"></td>

							<td><a
								href="http://127.0.0.1:8080/ShopSite/List/CustomerDelete?id=${customer.cid}&pageNo=${page.topPageNo}">删除</a></td>
						</tr>
					</table>
				</form>
			</c:forEach>
			<tr>
				<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录
					共${page.totalPages}页 当前第${page.pageNo}页<br> <a
					href="http://127.0.0.1:8080/ShopSite/List/CustomerDelete?pageNo=${page.topPageNo}"><input
						type="button" name="fristPage" value="首页" /></a> <c:choose>
						<c:when test="${page.pageNo!=1}">

							<a
								href="http://127.0.0.1:8080/ShopSite/List/Customers?pageNo=${page.previousPageNo}"><input
								type="button" name="previousPage" value="上一页" /></a>

						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" name="previousPage"
								value="上一页" />

						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${page.pageNo != page.totalPages}">
							<a
								href="http://127.0.0.1:8080/ShopSite/List/Customers?pageNo=${page.nextPageNo }"><input
								type="button" name="nextPage" value="下一页" /></a>
						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" name="nextPage"
								value="下一页" />

						</c:otherwise>
					</c:choose> <a
					href="http://127.0.0.1:8080/ShopSite/List/CustomerDelete?pageNo=${page.bottomPageNo }"><input
						type="button" name="lastPage" value="尾页" /></a>
				</td>
				<td><a href="http://127.0.0.1:8080/ShopSite/syshome.jsp">返回</a></td>
			</tr>
		</table>
	</center>
</body>
</html>