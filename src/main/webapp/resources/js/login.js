function validate_form(thisform) {
	with (thisform) {
		if (validate_required(id, "用户名不能为空") == false) {
			id.focus();
			return false
		}
		if (validate_required(pwd, "密码不能为空") == false) {
			pwd.focus();
			return false
		}
	}
}
function validate_required(field, text) {
	with (field) {
		if (value == null || value == "") {
			alert(text);
			return false
		} else {
			return true
		}
	}
}
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
