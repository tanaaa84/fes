//添加投票项
function addNext(){
	var num = $('[name=vo]').length+1;
	$('#trVote').before("<tr id='trVo"+num+"'><td><input type='text' name='vo' id='vo"
			+num+"' size='47'/><input type='button' value='删除此项' class='button' onclick='remove(trVo"+num+")' /></td></tr>");
}
//根据this删除一项
function remove(e) {
	$(e).remove();
}

//提交
function check(){
	var v = $('[name=vo]');
	var v1 = v[0].value;
	var v2 = v[1].value;
	var name = $('[name=name]').val();
	if(name==""){
		alert("投票名称不能为空!");
	}else{
		if(v1==""||v2==""){
			alert("最低添加两条投票项!");
		}else{
			var vote = $('[name=vo]');
			var i = 0;
			var length = vote.length;
			var votename = "";
			for(;i<length;i++){
				if(vote[i].value!=""){
					votename += vote[i].value+",";
				}
			}
			$('#votename').attr("value",votename);
			$('#form1').submit();
		}
	}
}