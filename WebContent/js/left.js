/* 左侧菜单active */

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.getElementById(name1);
	var imgobj=document.getElementById(name2);
	//alert(imgobj);
	if(objectobj.style.display=="none"){
		for(i=1;i<18;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.getElementById(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.getElementById(name3);
				//alert(image);
				image.className = "";
			}
		}
		objectobj.style.display="";
		imgobj.className = "img";
	}
	else{
		objectobj.style.display="none";
		imgobj.className = "";
	}
}


function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.className = "active";	//当前值
	
	for(var i=1;i<126;i++)
	{
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.className = "";}	//正常值
	  }
	}
}

function expand(idstr){
	var name1="child"+idstr;
	var name2="xia"+idstr;
	var objectobj=document.getElementById(name1);
	var imgobj=document.getElementById(name2);
	//alert(imgobj);
	if(objectobj.style.display=="none"){
		for(i=1;i<35;i++){
			var name3="xia"+i;
			var name="child"+i;
			var o=document.getElementById(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.getElementById(name3);
				//alert(image);
				image.className = "ximg";
			}
		}
		objectobj.style.display="";
		imgobj.className = "yimg";
	}
	else{
		objectobj.style.display="none";
		imgobj.className = "ximg";
	}
}