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

function addDepot(){
	popup(550,300,"添加部门","depotAdd","depotAdd");
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
	
	//验证是否选取一个以上项目
	var allids = document.getElementById("allids").value;
	var str = allids.split(",");
	var cot = 0;
	for(var j = 0;j < str.length;j++){
		cot++;
	}
	
	if(cot > 1){
		alert("只能选择一个部门！");
	}
	else{
		popup(550,300,"添加子级部门","depotNextAdd?treeids=" + allids + "","depotNextAdd");
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

	//验证是否选取一个以上项目
	var allids = document.getElementById("allids").value;
	var str = allids.split(",");
	var cot = 0;
	for(var j = 0;j < str.length;j++){
		cot++;
	}
	
	if(cot > 1){
		alert("只能选择一个部门！");
	}
	else{
		popup(550,300,"修改分店","depotEdit?treeids=" + allids + "","depotEdit");
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
	popup(550,300,"删除部门","depotDel?treeids=" + allids + "","depotDel");
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
	
	//验证是否选取一个以上项目
	var allids = document.getElementById("allids").value;
	var str = allids.split(",");
	var cot = 0;
	for(var j = 0;j < str.length;j++){
		cot++;
	}
	
	if(cot > 1){
		alert("只能选择一个分店！");
	}
	else{
		popup(550,300,"部门排序","depotSoet?treeids=" + allids + "","depotSoet");
	}
}

function setRdOnly(obj1,obj2,objtxt){
	var lmsxid = document.getElementById(obj1).value;
	
	if(lmsxid == objtxt){
		document.getElementById(obj2).readOnly = "";
		document.getElementById(obj2).value = "http://";
	}
	else{
		document.getElementById(obj2).readOnly = "readOnly";
		document.getElementById(obj2).value = "";
	}
}