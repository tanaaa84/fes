/****************************************/
/**
 * js公共库 V1.0
 * 作者:10yue
 * 创建时间：2012/10/25
 * 最后修改者:10yue
 */
/****************************************/

/**
 * 弹出窗口
 * 
 * @param url
 *            打开的路径
 * @param win
 *            标题
 */
function mywinopen(url, win) {
	var swidth = screen.width - 7;
	var sheight = screen.height - 80;
	window.open(url, win, "width=" + swidth + ",height=" + sheight
			+ ",top=0,left=0,status=yes,toolbar=no,menubar=no,resizable=yes");
	// location=no,,scrollbars=yes,status=no,
}

/**
 * 关闭IE窗口
 */
function winclose() {
	window.close();
}

/**
 * 关闭弹窗
 */
function closewin() {
	ownerDialog.close();
}

function refresh() {
	window.location.reload();
	parent.parent.topFrame.location.reload();
}

function winreload() {
	window.location.reload();
}

/**
 * 确认框
 * 
 * @param txt
 *            文字
 * @param url
 *            地址
 */
function btncof(txt, url) {
	if (confirm(txt)) {
		location.href = url;
	}
}

/**
 * 设置焦点
 * 
 * @param obj
 *            设置焦点的控件
 */
function setfocus(obj) {
	document.getElementById(obj).focus();
}

/**
 * 设置焦点并选中
 * 
 * @param targetid
 *            文本框的id
 */
function onselect(targetid) {
	document.getElementById(targetid).focus();
	document.getElementById(targetid).select();
}

/**
 * 全/反选
 * 
 * @param obj
 *            checkbox的对象
 * @param name
 *            checkbox的name值
 */
function selectAll(obj, name) {
	$('input[name=' + name + ']').attr('checked', obj.checked);
}

/**
 * 弹出窗口
 * 
 * @param w
 *            弹出窗口宽
 * @param h
 *            弹出窗口高
 * @param title
 *            标题
 * @param url
 *            打开路径
 * @param frmobj
 *            弹出窗口对像
 */
function popup(w, h, title, url, frmobj) {
	var diag = new Dialog(frmobj);
	diag.Width = w;
	diag.Height = h;
	diag.Title = title;
	diag.URL = url;
	diag.show();
}

/**
 * 提交时弹出窗口
 * 
 * @param message
 *            弹出窗口信息
 * @param formID
 *            表单form的Id
 * @param actionName
 */
function submitConfirm(message, formId, url) {
	Dialog.confirm(message, function() {
		document.getElementById(formId).action = url;
		document.getElementById(formId).submit();
	});
}

/**
 * showModalDialog弹窗
 * 
 * @param url
 * @param win
 * @param width
 * @param height
 */
function winsref(url, win, width, height) {
	var sRet;

	sRet = window.showModalDialog(url, win,
			'scroll:0;status:0;help:0;resizable:0;dialogWidth:' + width
					+ 'px;dialogHeight:' + height + 'px');

	if (sRet == "refresh") {
		window.location.reload();
	}
}

/**
 * 动态添加行的提交表单
 * 
 * @param alt
 *            提示信息
 * @param lenname
 *            动态添加行的名称
 */
function addSubmit(formId, alt, lenname) {
	var form1 = document.getElementById(formId);
	var flag = false;
	if (alt == undefined) {
		alt = "确定要提交吗?";
	}
	if (lenname == undefined) {
		if (id > 1) {
			if (confirm(alt)) {
				form1.submit();
				flag = true;
			}
		} else {
			alert("没有可提交的数据！");
		}
	} else {
		if (document.getElementsByName(lenname).length >= 1) {
			if (confirm(alt)) {
				form1.submit();
				flag = true;
			}
		} else {
			alert("没有可提交的数据！");
		}
	}
	return flag;
}

/**
 * 计算总金额
 * 
 * @param price
 *            价格
 * @param num
 *            换算关系
 * @param amount
 *            数量
 * @param total
 *            总价格显示的id
 */
function ct(price, num, amount, total) {
	var p = document.getElementById(price).value;
	var a = document.getElementById(amount).value;
	if (a == "0") {
		alert("数量不能为0！");
		onselect(amount);
	} else {

		if (num != null && num != "") {
			var n = document.getElementById(num).value;
			document.getElementById(total).value = (Number(p) * Number(n) * Number(a))
					.toFixed(2);
		} else {
			document.getElementById(total).value = (Number(p) * Number(a))
					.toFixed(2);
		}
	}
}

/**
 * 中药计算总金额(在开始的时候可以输入'0')
 * 
 * @param price
 *            价格
 * @param num
 *            换算关系
 * @param amount
 *            数量
 * @param total
 *            总价格显示的id
 */
function ctzy(price, num, amount, total) {
	var p = document.getElementById(price).value;
	var a = document.getElementById(amount).value;
	if (num != null && num != "") {
		var n = document.getElementById(num).value;
		document.getElementById(total).value = (Number(p) * Number(n) * Number(a))
				.toFixed(2);
	} else {
		document.getElementById(total).value = (Number(p) * Number(a))
				.toFixed(2);
	}
}

/**
 * 
 * @param tbid
 *            清除表格的id
 */
function clearValue(tbid) {
	var addinfo = document.getElementById(tbid).getElementsByTagName("input");
	var infolen = addinfo.length;
	for ( var i = 0; i < infolen; i++) {
		if (addinfo[i].type != "button") {
			addinfo[i].value = "";
		}
	}
}

function sipwin(w, h, title, url) {
	var diag = new Dialog();
	diag.Width = w;
	diag.Height = h;
	diag.Title = title;
	diag.URL = url;
	diag.show();
}

function sendvalue(tr) {
	if (tr.getElementsByTagName("input").length > 0) {
		var infovalue = tr.getElementsByTagName("input")[0].value;// 值
		var infoname = tr.getElementsByTagName("input")[1].value;// 目标id
		var infolist = infovalue.split(",");
		var objarr = infoname.split(",");
		for ( var i = 0; i < infolist.length; i++) {
			document.getElementById(objarr[i]).value = infolist[i];
		}
	}
}

/**
 * 点击变颜色
 * 
 * @param obj
 *            鼠标点击行(this)
 */
var oldTr = null;
function tagscheck(obj) {
	if (oldTr == null) {
		oldTr = obj;
		oldTr.style.background = "#FFFF99";
	} else {
		oldTr.style.background = "";
		obj.style.background = "#FFFF99";
		oldTr = obj;
	}
}

/*******************************************************************************
 * 计算两时间相差的天数
 * 
 * @param bigDate
 *            大时间的id
 * @param smallDate
 *            小时间的id
 * @param ts
 *            存放时间差的id
 */
function DateDiff(bigDate, smallDate, ts) {
	var sDate1 = document.getElementById(bigDate).value; // sDate1和sDate2是yyyy-mm-dd格式
	var sDate2 = document.getElementById(smallDate).value;
	var aDate, oDate1, oDate2, iDays;
	aDate = sDate1.split("-");
	oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]); // 转换为mm-dd-yyyy格式
	aDate = sDate2.split("-");
	oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
	iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); // 把相差的毫秒数转换为天数
	iDays++;
	document.getElementById(ts).value = iDays;
}

// 显示提示信息
function displaySuggest() {
	document.getElementById("suggest").style.display = "block";
}

// 隐藏提示信息
function hiddenSuggest() {
	document.getElementById("suggest").style.display = "none";
}

// 清空提示信息
function clearSuggest() {
	document.getElementById("suggest").innerHTML = "";
}

/**
 * select选择跳转
 * 
 * @param url
 * @param val
 */
function changeOpt(url, val) {
	if (val != null) {
		window.location.href = url + val;
	}
}

/**
 * 输入的数量是否能整除换算关系
 * 
 * @param inamount
 *            数量
 * @param num
 *            换算关系
 * @returns {Boolean}
 */
function hsgx(inamount, num) {
	var flag = true;
	var i = document.getElementById(inamount).value;
	var n = document.getElementById(num).value;
	var a = Number(i);
	var b = Number(n);
	if (a % b != 0) {
		flag = false;
	}
	return flag;
}

/**
 * 只能输入数字
 */
function noNumbers(e) {
	var keynum;
	var keychar;
	var numcheck;

	if (window.event) // IE
	{
		keynum = e.keyCode;
	} else if (e.which) // Netscape/Firefox/Opera
	{
		keynum = e.which;
	}
	keychar = String.fromCharCode(keynum);
	numcheck = /\d/;
	return numcheck.test(keychar);
}

/*******************************************************************************
 * 只能输入数字（含小数）
 * 
 * @param obj
 *            文本框的id
 */
function clearNoNum(obj) {
	obj.value = obj.value.replace(/[^\d.]/g, ""); // 清除“数字”和“.”以外的字符
	obj.value = obj.value.replace(/^\./g, ""); // 验证第一个字符是数字而不是.
	obj.value = obj.value.replace(/^\.{2,}/g, ""); // 只保留第一个"."清除多余的"."
	obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$",
			".");
}

/**
 * 判断对象是否为0或空
 * 
 * @param obj
 * @returns {Boolean}
 */
function NumIsZero(obj) {
	var num = document.getElementById(obj).value;
	var flag = true;
	if (Number(num) <= 0) {
		alert("数量不能为0！");
		onselect(obj);
		flag = false;
	}
	return flag;
}

/**
 * 比较数量与库存的大小关系
 * 
 * @param inamount
 *            数量
 * @param kc
 *            库存量
 * @returns {Boolean}
 */
function compare(inamount, kc) {
	var i = Number(document.getElementById(inamount).value);
	var k = Number(document.getElementById(kc).value);
	var flag = true;
	if (i > 0) {
		if (i > k) {
			alert("数量不能大于可用库存！");
			onselect(inamount);
			flag = false;
		}
	} else {
		alert("数量不能为0！");
		onselect(inamount);
		flag = false;
	}
	return flag;
}

/*******************************************************************************
 * 循环比较每条数据的本批库存量和领药数量
 * 
 * @param kcph
 *            本批库存数量
 * @param amount
 *            领药数量
 * @returns {Boolean}
 */
function forbj(bpkc, lysl) {
	var kcph = document.getElementsByName(bpkc);
	var amount = document.getElementsByName(lysl);
	var i = 0;
	var flag = true;
	for (i; i < kcph.length; i++) {
		if (Number(amount[i].value) > 0) {
			if (Number(kcph[i].value) < Number(amount[i].value)) {
				alert("数量不能大于可用库存！");
				flag = false;
				amount[i].focus();
				amount[i].select();
				break;
			}
		} else {
			alert("数量不能为0！");
			flag = false;
			amount[i].focus();
			amount[i].select();
			break;
		}
	}
	return flag;
}

/**
 * 通用分页执行函数
 * 
 * @param url
 *            执行的路径
 * @param page_num
 *            跳转的页码
 */
function gotoPage(url, page_num) {
	if (url != null && url != "") {
		if (url.indexOf("?") > -1) {
			url += "&"; // 如果url中已经包含了其他的参数,就把curPageNo参数接在后面
		} else {
			url += "?"; // 如果url中没有别的参数
		}
		location.href = url + "pageNo=" + page_num;
	}
}

/*******************************************************************************
 * 提交按钮延时
 * 
 * @param btnid
 *            提交按钮的id
 */
function stopsubmit(btnid) {
	var btnsubmit = document.getElementById(btnid);
	btnsubmit.disabled = "disabled";
	window.setTimeout("showbtnsubmit('" + btnid + "')", 2000);
}

function showbtnsubmit(btnid) {
	var btnsubmit = document.getElementById(btnid);
	btnsubmit.disabled = "";
}

/**
 * 验证输入是否是整数
 */
function onlyNum() {
	// 在这里添加想要保留键的键值
	var keys = [ 8, 9, 13, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 96, 97, 98,
			99, 100, 101, 102, 103, 104, 105 ];
	var keyCode = event.keyCode;
	for ( var i = 0; i < keys.length; i++) {
		if (keyCode == keys[i]) {
			event.returnValue = true;
			break;
		} else {
			event.returnValue = false;
		}
	}
}

/**
 * 输入实数
 */
function DoubleNum() {
	// 在这里添加想要保留键的键值
	var keys = [ 8, 9, 13, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 96, 97, 98,
			99, 100, 101, 102, 103, 104, 105, 110, 190 ];
	var keyCode = event.keyCode;
	for ( var i = 0; i < keys.length; i++) {
		if (keyCode == keys[i]) {
			event.returnValue = true;
			break;
		} else {
			event.returnValue = false;
		}
	}
}

function getDate(oldtime, time) {
	var arr = oldtime.split(",");
	var newtime = "";
	for ( var i = 0; i < arr.length; i++) {
		var date = document.getElementById(arr[i]).value;
		if (Number(date) > 0) {
			newtime += date + "-";
		} else {
			// alert("日期格式输入有误！");
			setfocus(arr[i]);
			break;
		}
	}
	document.getElementById(time).value = newtime.substring(0,
			newtime.length - 1);
}

/**
 * 计算特定时间后的3个月的时间
 */
function countDate(felid1, felid2) {
	var thisDayVal = $("#" + felid1).val();
	if (thisDayVal == undefined) {
		return;
	}
	thisDayVal = thisDayVal.split("-"); // 获取时间的值

	var time1 = new Date(thisDayVal[0], thisDayVal[1], thisDayVal[2]); // 将这个值转换为一个时间对象
	var time2 = new Date(time1.getTime() + 7776000000); // new 一个新的时间对象,并加上 90
	// 天(毫秒数)

	var month = time2.getMonth() < 10 ? "0" + time2.getMonth() : time2
			.getMonth();
	var day = time2.getDate() < 10 ? "0" + time2.getDate() : time2.getDate();
	if (month == '00') {
		month = '01';
	}
	var nextDay = time2.getFullYear() + "-" + month + "-" + day; // 将时间对象转换成我们需要的格式
	$("#" + felid2).val(nextDay); // 把时间赋值给新的input
}

/**
 * window.open方法传中文会乱码,以后统一调这个方法,随意指定get和post都行(可省) 调用方式: var options = {
 * url:"ghtypeList", //url地址 target:"mainFrame",
 * //如果想在指定iframe跳转页面,则传递,否则不写此项,将会弹出新窗口 data:{"ghs":"沈泉庄"}, //参数 type:"get",
 * //提交方式,可省,默认为get target:"mainFrame" //指定的iframe的name,不指定,则弹出新窗口 };
 * winOpen(options);
 */
function winOpen(options) {
	var name = 'temp_window' + new Date().getMilliseconds(); // 生成新窗口的name
	var tempForm = document.createElement("form");
	tempForm.id = "temp_form";
	tempForm.method = options.type ? options.type : "get"; // 用于指定提交方式(get,post),可省,默认为
	// get
	tempForm.action = options.url; // 用于指定 url
	tempForm.target = options.target ? options.target : name; // 用于指定新窗口的名称(若指定,则在指定的iframe里执行),否则弹出新窗口
	if (options.data) {
		for (o in options.data) {
			var hideInput = document.createElement("input");
			hideInput.type = "hidden";
			hideInput.name = o;
			hideInput.value = options.data[o];
			tempForm.appendChild(hideInput);
		}
	}
	tempForm.onsubmit = function() {
		if (!options.target) {
			window
					.open(
							'about:blank',
							target,
							'width=800, height=600, top=30, left=80, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes,location=yes, status=yes');
		}
	};
	document.body.appendChild(tempForm);
	tempForm.submit();
	document.body.removeChild(tempForm);
}

// <a onclick="SetHome(this,window.location)">设为首页</a>
function SetHome(obj, vrl) {
	try {
		obj.style.behavior = 'url(#default#homepage)';
		obj.setHomePage(vrl);
	} catch (e) {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager
						.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
			}

			var prefs = Components.classes['@mozilla.org/preferences-service;1']
					.getService(Components.interfaces.nsIPrefBranch);
			prefs.setCharPref('browser.startup.homepage', vrl);
		}
	}
}

// <a onclick="AddFavorite(window.location,document.title)">加入收藏</a>
function AddFavorite(sURL, sTitle) {
	try {
		window.external.addFavorite(sURL, sTitle);
	} catch (e) {
		try {
			window.sidebar.addPanel(sTitle, sURL, "");
		} catch (e) {
			alert("加入收藏失败，请使用Ctrl+D进行添加");
		}
	}
}

// js判断非空
var isEmptyValue = function(value) {
	var type;
	if (value == null) {
		// 等同于 value === undefined || value === null
		return true;
	}
	type = Object.prototype.toString.call(value).slice(8, -1);
	switch (type) {
	case 'String':
		return !$.trim(value);
	case 'Array':
		return !value.length;
	case 'Object':
		return $.isEmptyObject(value); // 普通对象使用 for...in 判断，有 key 即为 false
	default:
		return false; // 其他对象均视作非空
	}
}