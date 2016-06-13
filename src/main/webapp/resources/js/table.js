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
$(document).ready(function() {
	var photo = "${photoURL}";
	if (photo != null && photo != "") {
		$("#headPhoto").attr('src', photo);
	} else {
		$("#headPhoto").attr('src', "http://127.0.0.1:8080/ShopSite/resources/images/avatar.png");
	}

})