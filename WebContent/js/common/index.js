
//用以计算百分比
var n = 1;

//投票
function toVote(type,t){
	var ids = "";
	var flag = false;
	if(type=='单'){
		$('[name=radio]').each(function(){
		   if(this.checked){
			   ids = this.value+',';
			   flag = true;
		   }
		 });
	}else if(type=='多'){
		$('[name=checkbox]').each(function(){
			if(this.checked){
				ids += this.value+',';
				flag = true;
			}
		});
	}
	if(flag==false){
		alert("请选择再投票!");
	}else{
		var voteid = $('#voteid').val();
		$.ajax({
			url : 'toVote',
			type : 'post',
			data : 'ids='+ids+'&voteid='+voteid,
			dateType : 'text',
			success : function(text) {
				if(text == 'false'){
					alert("不能重复投票!");
				}else if(text == 'true'){
					alert("投票成功!");
					if(t!='index'){
						window.location = 'showVote?pid='+t;
					}
				}
			},
			error : function() {
				alert("系统错误");
			}
		});
	}
}