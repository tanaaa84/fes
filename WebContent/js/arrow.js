function getId(elem){
         return document.getElementById(elem)
        }

function hasClass(name,parent) {
		var c; 
		var a = parent.getElementsByTagName('*');
		for(var i=0,j=a.length;i<j;i++)
		{
			var re = new RegExp("(|\\s)" + name + "(\\s|$)");
            if ( re.test(a[i].className) ) c = a[i];
		}
		return c
}

function cssjs(a,o,c1,c2){
	switch (a){
		case 'swap':
			o.className=!cssjs('check',o,c1)?o.className.replace(c2,c1):o.className.replace(c1,c2);
		break;
		case 'add':
			if(!cssjs('check',o,c1)){o.className+=o.className?' '+c1:c1;}
		break;
		case 'remove':
			var rep=o.className.match(' '+c1)?' '+c1:c1;
			o.className=o.className.replace(rep,'');
		break;
		case 'check':
			return new RegExp("(|\\s)" + c1 + "(\\s|$)").test(o.className)
		break;
	}
}

function getStyle( elem, name ) {
    if (elem.style[name])
        return elem.style[name];
    else if (elem.currentStyle)
        return elem.currentStyle[name];
    else if (document.defaultView && document.defaultView.getComputedStyle) {
        name = name.replace(/([A-Z])/g,"-$1");
        name = name.toLowerCase();
        var s = document.defaultView.getComputedStyle(elem,"");
        return s && s.getPropertyValue(name);
    } else
    return null;
}
 

function easeIn(t,b,c,d){
     return c*(t/=d)*t + b;
}

function proListScroll(o) {
    this.o = getId(o);
    this.arrowLeft = hasClass('arrow_left',this.o);
    this.arrowRight = hasClass('arrow_right',this.o);
    this.ScrollBox = hasClass('pro_list',this.o);
	this.liWidth = 0;
	this.ul = this.ScrollBox.getElementsByTagName("UL")[0];
	this.ulWidth = 0;
	this.scrollinit();
	this.proDetail();
}

proListScroll.prototype.proDetail = function (){
   var _this = this;
   var obj = this.ScrollBox.getElementsByTagName("ul")[0].getElementsByTagName("li");
   
}



proListScroll.prototype.scrollinit = function (){
	var _this = this;
    var lis = this.ScrollBox.getElementsByTagName("LI");
	for(var i=0,j=lis.length;i<j;i++)
	  {
		this.liWidth += parseInt( getStyle( lis[i], "width" ))
	  }
    this.ul.style.width = this.ulWidth = this.liWidth + 'px';

    this.arrowLeft.onclick = function (){
        var b=_this.ScrollBox.scrollLeft,c=-788,d=25,t=10;
		function Run(){
		 _this.ScrollBox.scrollLeft = Math.ceil(easeIn(t,b,c,d));
		  if(t<d){ t++; setTimeout(Run, 10); }
	     }
        Run();

		if( parseInt(_this.ulWidth) - _this.ScrollBox.scrollLeft == 788)
		 {
			this.src = 'images/arrow_left.gif'
			this.alt = ' ‘ ‘∫Û∑≠'
		 }
		if(_this.ScrollBox.scrollLeft >= 0)
		 {
          _this.arrowRight.src = 'images/arrow_right.gif'
		  _this.arrowRight.alt = ' ‘ ‘«∞∑≠'
		 }
    }

    this.arrowRight.onclick = function (){  
        var b=_this.ScrollBox.scrollLeft,c=788,d=25,t=10;
		function Run(){
		 _this.ScrollBox.scrollLeft = Math.ceil(easeIn(t,b,c,d));
		  if(t<d){ t++; setTimeout(Run, 10); }
	     }
        Run();

		if( parseInt(_this.ulWidth) - _this.ScrollBox.scrollLeft == 788)
		  {this.src = 'images/arrow_right.gif'
		  this.alt = ' ‘ ‘«∞∑≠'
		  }

 		if(_this.ScrollBox.scrollLeft < _this.liWidth)
		 {
          _this.arrowLeft.src = 'images/arrow_left.gif'
		  _this.arrowLeft.alt = '«∞∑≠'
		 }      

    }
}