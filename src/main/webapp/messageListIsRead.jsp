<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.min.js"></script>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.easydropdown.js"></script>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/table.js" type="text/javascript"></script>
<link href="http://127.0.0.1:8080/ShopSite/resources/css/table.css" rel="stylesheet" type="text/css"
	media="all" />
<title>MessageListIsRead</title>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var photo = "${photoURL}";
						if (photo != null && photo != "") {
							$("#headPhoto").attr('src', photo);
						} else {
							$("#headPhoto")
									.attr('src',
											"http://127.0.0.1:8080/ShopSite/resources/images/avatar.png");
						}

					})
</script>
</head>
<body>
	<center>
		<h1>
			Hello <img id="headPhoto" src="" width=32px height=30px />
			${customer_id}
		</h1>
		<table class="altrowstable" id="alternatecolor">
			<tr>
				<th>mid</th>
				<th>mcontent</th>
				<th>mstate</th>
				<th>mfrom</th>
				<th>mto</th>
				<th>mcreate</th>
			</tr>
			<c:forEach var="messages" items="${messagesList}">
				<tr>

					<td><c:out value="${messages.mid}" /></td>
					<td><c:out value="${messages.mcontent}" /></td>
					<td><c:out value="${messages.mstate}" /></td>
					<td><c:out value="${messages.mfrom}" /></td>
					<td><c:out value="${messages.mto}" /></td>
					<td><c:out value="${messages.mcreate}" /></td>
					<td><a
						href="http://127.0.0.1:8080/ShopSite/MessageList/MessageDelete?alid=${messages.mid}&cid=${customer_id}&pageNo=${page.topPageNo}">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录
					共${page.totalPages}页 当前第${page.pageNo}页<br> <a
					href="http://127.0.0.1:8080/ShopSite/MessageList?pageNo=${page.topPageNo}&cid=${customer_id}"><input
						type="button" name="fristPage" value="首页" /></a> <c:choose>
						<c:when test="${page.pageNo!=1}">

							<a
								href="http://127.0.0.1:8080/ShopSite/MessageList?pageNo=${page.previousPageNo}&cid=${customer_id}"><input
								type="button" name="previousPage" value="上一页" /></a>

						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" name="previousPage"
								value="上一页" />

						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${page.pageNo != page.totalPages}">
							<a
								href="http://127.0.0.1:8080/ShopSite/MessageList?pageNo=${page.nextPageNo}&cid=${customer_id}"><input
								type="button" name="nextPage" value="下一页" /></a>
						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" name="nextPage"
								value="下一页" />

						</c:otherwise>
					</c:choose> <a
					href="http://127.0.0.1:8080/ShopSite/MessageList?pageNo=${page.bottomPageNo}&cid=${customer_id}"><input
						type="button" name="lastPage" value="尾页" /></a>
				</td>
				<td><a href="http://127.0.0.1:8080/ShopSite/home.jsp">返回</a></td>
			</tr>
		</table>
	</center>
</body>
</html>