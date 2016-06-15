<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HeadCheck</title>
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
		<table class="altrowstable" id="alternatecolor">
			<tr>
				<th>hcid</th>
				<th>hcurl</th>
				<th>hcfromtype</th>
				<th>hcfromid</th>
			</tr>
			<c:forEach var="headcheck" items="${headchecks}">
				<tr>

					<td><c:out value="${headcheck.hcid}" /></td>
					<td><img id="headPhoto"
						src="http://127.0.0.1:8080/ShopSite/${headcheck.hcurl}" width=32px
						height=30px /></td>
					<td><c:out value="${headcheck.hcfromtype}" /></td>
					<td><c:out value="${headcheck.hcfromid}" /></td>
					<td><a
						href="http://127.0.0.1:8080/ShopSite/List/HeadPass?hcid=${headcheck.hcid}&cid=${headcheck.hcfromid}&pageNo=${page.topPageNo}">通过</a></td>

					<td><a
						href="http://127.0.0.1:8080/ShopSite/List/HeadNotPass?hcid=${headcheck.hcid}&cid=${headcheck.hcfromid}&pageNo=${page.topPageNo}">不通过</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录
					共${page.totalPages}页 当前第${page.pageNo}页<br> <a
					href="http://127.0.0.1:8080/ShopSite/HeadCheck?pageNo=${page.topPageNo}"><input
						type="button" name="fristPage" value="首页" /></a> <c:choose>
						<c:when test="${page.pageNo!=1}">

							<a
								href="http://127.0.0.1:8080/ShopSite/HeadCheck?pageNo=${page.previousPageNo}"><input
								type="button" name="previousPage" value="上一页" /></a>

						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" name="previousPage"
								value="上一页" />

						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${page.pageNo != page.totalPages}">
							<a
								href="http://127.0.0.1:8080/ShopSite/HeadCheck?pageNo=${page.nextPageNo }"><input
								type="button" name="nextPage" value="下一页" /></a>
						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" name="nextPage"
								value="下一页" />

						</c:otherwise>
					</c:choose> <a
					href="http://127.0.0.1:8080/ShopSite/HeadCheck?pageNo=${page.bottomPageNo }"><input
						type="button" name="lastPage" value="尾页" /></a>
				</td>
				<td><a href="http://127.0.0.1:8080/ShopSite/syshome.jsp">返回</a></td>
			</tr>
		</table>
	</center>
</body>
</html>