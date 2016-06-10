
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

addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
