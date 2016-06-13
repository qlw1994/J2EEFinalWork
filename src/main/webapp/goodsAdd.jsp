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
<link href="http://127.0.0.1:8080/ShopSite/resources/css/goodsform.css"
	rel="stylesheet" type="text/css" media="all" />
<title>GoodsAdd</title>
</head>
<body>
	<center>
		<form action="goodsAddSave" method="post" class="basic-grey"
			ENCTYPE="multipart/form-data">
			<h1>
				GoodsAdd <span>Please fill all the texts in the fields.</span>
			</h1>
			<input id="pageNo" type="hidden" name="pageNo" value="${pageNo}" />
			<label> <span>图片: </span> <input type="file" id="photo"
				name="photo">
			</label> <label> <span>大类:</span> <input id="gtype1" type="text"
				name="gtype1" placeholder="大类" />
			</label> <label> <span>中类 :</span> <input id="t2id" type="text"
				name="t2id" placeholder="中类 " />
			</label> <label> <span>名字 :</span> <input id="gname" type="text"
				name="gname" placeholder="名字" />
			</label> <label> <span>价格:</span> <input id="gprice" type="text"
				name="gprice" placeholder="价格" />
			</label> <label> <span>数量 :</span> <input id="gnumber" type="text"
				name="gnumber" placeholder="数量" />
			</label> <label><span>&nbsp;</span> <input type="submit"
				class="button" value="保存" /> </label>
		</form>
	</center>
</body>
</html>