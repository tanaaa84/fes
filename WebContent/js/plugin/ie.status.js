function getCurrentTime(){
	 var noon; 
	 var time=new Date(); 
	 var hour=time.getHours(); 
	 var minute=time.getMinutes(); 
	 var second=time.getSeconds();
	 var today=new Date;
	 var week=new Array(7); 
	 week[0]="日"; 
	 week[1]="一"; 
	 week[2]="二"; 
	 week[3]="三"; 
	 week[4]="四"; 
	 week[5]="五"; 
	 week[6]="六"; 
	 if (hour<5) noon="凌晨";
	 if (hour>4 & hour<8) noon="早晨";
	 if (hour>7 & hour<12) noon="上午";
	 if (hour==12) noon="中午";
	 if (hour>12 & hour<19) noon="下午";
	 if (hour>18 & hour<23) noon="晚上";
	 if (hour>22) noon="深夜";
	 if (hour>12) hour=hour-12;
	 if (hour<10) hour="0"+hour;
	 if (minute<10) minute="0"+minute;
	 if (second < 10) second="0"+second;
	 self.status="湖北网格软件有限公司 "+ today.getYear()+"年"+(today.getMonth()+1)+"月"+today.getDate()+"日 星期"+week[today.getDay()]+" "+noon+" "+hour+":"+minute + ":" + second;
	 window.setTimeout("getCurrentTime();",100);	
}

$(document).ready(function(){
	getCurrentTime();
});
	