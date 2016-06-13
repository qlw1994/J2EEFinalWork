<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="resources/js/table.js" type="text/javascript"></script>
<link href="resources/css/table.css" rel="stylesheet" type="text/css"
	media="all" />
<title>AddressList</title>
</head>
<body>
	<center>
		<h1>
			Hello <img id="headPhoto" src="" width=32px height=30px />
			${customer_id}
		</h1>
		<table class="altrowstable" id="alternatecolor">
			<tr>
				<th>alid</th>
				<th>cid</th>
				<th>address</th>
				<th>aname</th>
				<th>aphone</th>
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
				<td><a href="http://127.0.0.1:8080/ShopSite/home.jsp">返回</a></td>
			</tr>
		</table>
	</center>
</body>
</html>