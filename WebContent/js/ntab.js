﻿function scrollDoor() {
}
scrollDoor.prototype = {
	sd : function(menus, divs, openClass, closeClass) {
		var _this = this;
		if (menus.length != divs.length) {
			alert("菜单层数量和内容层数量不一样!");
			return false;
		}
		for ( var i = 0; i < menus.length; i++) {
			_this.$(menus[i]).value = i;
			_this.$(menus[i]).onmouseover = function() {

				for ( var j = 0; j < menus.length; j++) {
					_this.$(menus[j]).className = closeClass;
					_this.$(divs[j]).style.display = "none";
				}
				_this.$(menus[this.value]).className = openClass;
				_this.$(divs[this.value]).style.display = "block";
			};
		}
	},
	$ : function(oid) {
		if (typeof (oid) == "string")
			return document.getElementById(oid);
		return oid;
	}
};

function getChange(hideid, showid) {
	$("#n" + hideid).removeClass();
	$("#n" + hideid).addClass("normal");
	$("#" + hideid).css("display", "none");
	$("#n" + showid).removeClass();
	$("#n" + showid).addClass("active");
	$("#" + showid).css("display", "block");

}

window.onload = function() {
	var SDmodel = new scrollDoor();
	SDmodel.sd([ "Gold01", "Gold02", "Gold03" ], [ "g01", "g02", "g03" ], "active", "normal");
	//SDmodel.sd([ "Calendar01", "Calendar02" ], [ "c01", "c02" ], "active", "normal");
}
