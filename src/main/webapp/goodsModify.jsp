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
<link href="http://127.0.0.1:8080/ShopSite/resources/css/addressform.css"
	rel="stylesheet" type="text/css" media="all" />
<title>GoodsModify</title>
</head>
<body>
	<center>
		<form action="GoodsModifySave" method="post" class="basic-grey">
			<h1>
				GoodsModify 当前编号 ID: ${goods.gid}<span>Please fill all
					the texts in the fields.</span>
			</h1>
			<input id="pageNo" type="hidden" name="pageNo" value="${pageNo}" />
			<input id="gid" type="hidden" name="gid" value="${goods.gid}" />
			<label> <span>图片: </span> <img
				src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" width=60px
				height=62px>
			</label> <label> <span>大类:</span> <input id="gtype1" type="text"
				name="gtype1" value="${goods.gtype1}" disabled="disabled" />
			</label> <label> <span>中类 :</span> <input id="t2id" type="text"
				name="t2id" value="${goods.t2id}" disabled="disabled" />
			</label> <label> <span>名字 :</span> <input id="gname" type="text"
				name="gname" value="${goods.gname}" disabled="disabled" />
			</label> <label> <span>价格:</span> <input id="gprice" type="text"
				name="gprice" value="${goods.gprice}" />
			</label> <label> <span>数量 :</span> <input id="gnumber" type="text"
				name="gnumber" value="${goods.gnumber}" />
			</label><label> <span>上架时间 :</span> <input id="gcreate" type="text"
				name="gcreate" value="${goods.gcreate}" disabled="disabled" />
			</label> <label><span>&nbsp;</span> <input type="submit"
				class="button" value="保存" /> </label>
		</form>
	</center>
</body>
</html>