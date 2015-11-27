// JavaScript Document
function checkData() {
	var treeid = document.getElementsByName('treeid');
	var flag = false;
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked == true) {
			flag = true;
			break;
		}
	}
	if (!flag) {
		alert("请至少选择一项");
	}
	return flag;
}

function checkDelData() {
	if (confirm("你确定删除吗？")) {
		var treeid = document.getElementsByName('treeid');
		var flag = false;
		for ( var i = 0; i < treeid.length; i++) {
			if (treeid[i].checked == true) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			alert("请至少选择一项");
		}
		return flag;
	}
}

// 链接设置页面删除
function checkDelData(txt, obj) {
	if (confirm(txt)) {
		var treeid = document.getElementsByName(obj);
		var flag = false;
		for ( var i = 0; i < treeid.length; i++) {
			if (treeid[i].checked == true) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			alert("请至少选择一项");
		}
		return flag;
	}
}

// checkBox选框
function getid(obj, obj2, url) {
	var treeid = document.getElementsByName(obj);
	document.getElementById(obj2).value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById(obj2).value == "")
				document.getElementById(obj2).value = treeid[i].value;
			else
				document.getElementById(obj2).value += "," + treeid[i].value;
		}
	}
	
	url += "&ids=" + document.getElementById(obj2).value;
	window.location = url;
}

function getdelid(obj, obj2, url) {
	var treeid = document.getElementsByName(obj);
	document.getElementById(obj2).value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById(obj2).value == "")
				document.getElementById(obj2).value = treeid[i].value;
			else
				document.getElementById(obj2).value += "," + treeid[i].value;
		}
	}
	if (url == 'artDel') {
		url += "?ids=" + document.getElementById(obj2).value;
		window.location = url;
	}
	else if (url == 'artMoveTree') {
		popup(230, 800, "移动文章", "artMoveTree?classids=" + document.getElementById(obj2).value, "artMoveTree");
	}
	else if (url == 'artToCheck') {
		url += "?ids=" + document.getElementById(obj2).value;
		window.location = url;
	}
	else if (url == 'linkDel') {
		url += "?ids=" + document.getElementById(obj2).value;
		window.location = url;
	}
}

function addRoot() {
	popup(550, 300, "添加一级分店", "columnRootAdd", "columnRootAdd");
}

function addNext() {
	var treeid = document.getElementsByName("treeid");
	document.getElementById("allids").value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById("allids").value == "")
				document.getElementById("allids").value = treeid[i].value;
			else
				document.getElementById("allids").value += "," + treeid[i].value;
		}
	}

	// 验证是否选取一个以上项目
	var allids = document.getElementById("allids").value;
	var str = allids.split(",");
	var cot = 0;
	for ( var j = 0; j < str.length; j++) {
		cot++;
	}

	if (cot > 1) {
		alert("只能选择一个一级分店！");
	}
	else {
		popup(550, 300, "添加子级分店", "columnNextAdd?treeids=" + allids + "", "columnNextAdd");
	}
}

function modclass() {
	var treeid = document.getElementsByName("treeid");
	document.getElementById("allids").value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById("allids").value == "")
				document.getElementById("allids").value = treeid[i].value;
			else
				document.getElementById("allids").value += "," + treeid[i].value;
		}
	}

	// 验证是否选取一个以上项目
	var allids = document.getElementById("allids").value;
	var str = allids.split(",");
	var cot = 0;
	for ( var j = 0; j < str.length; j++) {
		cot++;
	}

	if (cot > 1) {
		alert("只能选择一个一级分店！");
	}
	else {
		popup(550, 300, "修改分店", "columnEdit?treeids=" + allids + "", "columnEdit");
	}
}

function delclass() {
	var treeid = document.getElementsByName("treeid");
	document.getElementById("allids").value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById("allids").value == "")
				document.getElementById("allids").value = treeid[i].value;
			else
				document.getElementById("allids").value += "," + treeid[i].value;
		}
	}

	var allids = document.getElementById("allids").value;
	popup(550, 300, "删除分店", "columnDel?treeids=" + allids + "", "columnDel");
}

function sortclass() {
	var treeid = document.getElementsByName("treeid");
	document.getElementById("allids").value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById("allids").value == "")
				document.getElementById("allids").value = treeid[i].value;
			else
				document.getElementById("allids").value += "," + treeid[i].value;
		}
	}

	// 验证是否选取一个以上项目
	var allids = document.getElementById("allids").value;
	var str = allids.split(",");
	var cot = 0;
	for ( var j = 0; j < str.length; j++) {
		cot++;
	}

	if (cot > 1) {
		alert("只能选择一个分店！");
	}
	else {
		popup(550, 300, "分店排序", "sortclass?treeids=" + allids + "", "sortclass");
	}

	/**
	 * var sRet;
	 * 
	 * sRet = window.showModalDialog('sortclass?act=no&treeids=' +
	 * document.getElementById("allids").value +
	 * '','sortclass','scroll:0;status:0;help:0;resizable:0;dialogWidth:530px;dialogHeight:310px');
	 * 
	 * if (sRet == "refresh") { window.location.reload(); }
	 */
}

function setRdOnly(obj1, obj2, objtxt) {
	var lmsxid = document.getElementById(obj1).value;

	if (lmsxid == objtxt) {
		document.getElementById(obj2).readOnly = "";
		document.getElementById(obj2).value = "http://";
	}
	else {
		document.getElementById(obj2).readOnly = "readOnly";
		document.getElementById(obj2).value = "";
	}
}

function addClass() {
	var treeid = document.getElementsByName("treeid");
	document.getElementById("allids").value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById("allids").value == "")
				document.getElementById("allids").value = treeid[i].value;
			else
				document.getElementById("allids").value += "," + treeid[i].value;
		}
	}
	var allids = document.getElementById("allids").value;
	var id = document.getElementById("id").value;
	window.location = "accountEdit?id=" + id + "&classids=" + allids;
	// window.parent.location.reload();
	window.parent.document.getElementById("classids").value = allids;
	closewin();

}
function getToMove(id, sortid, oldid, oldsortid, classid, str) {
	if (str == "上移") {
		if (oldid == null || oldid == '') {
			alert("已经是最上一篇！");
		}
		else {
			location.href = "artMove?id=" + id + "&sortid=" + sortid + "&oldid=" + oldid + "&oldsortid=" + oldsortid
					+ "&classid=" + classid;
		}
	}
	else if (str = "下移") {
		if (oldsortid == null || oldsortid == '') {
			alert("已经是最下一篇！");
		}
		else {
			location.href = "artMove?id=" + id + "&sortid=" + sortid + "&oldid=" + oldid + "&oldsortid=" + oldsortid
					+ "&classid=" + classid;
		}
	}
}

function artToMove() {
	var treeid = document.getElementsByName("treeid");
	document.getElementById("allids").value = "";
	for ( var i = 0; i < treeid.length; i++) {
		if (treeid[i].checked) {
			if (document.getElementById("allids").value == "")
				document.getElementById("allids").value = treeid[i].value;
			else
				document.getElementById("allids").value += "," + treeid[i].value;
		}
	}
	var allids = document.getElementById("allids").value;
	var classids = document.getElementById("classids").value;
	location.href = "artToMove?classids=" + classids + "&ids=" + allids;
	window.parent.location.reload();
	ownerDialog.close();
}