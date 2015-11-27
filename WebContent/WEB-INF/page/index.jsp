<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fes test</title>

<script type="text/javascript" src="js/plugin/jquery.min.js"></script>
<script type="text/javascript" src="js/common/jquery.js"></script>
<script type="text/javascript" src="js/plugin/jquery.form.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
<script type="text/javascript" src="js/common/checkform.js"></script>

<script type="text/javascript">
	$(function($) {
		$("#btn1").bind("click", function() {
			var options = {
				url : 'testAddAction',
				type : 'post',
				dataType : 'text',
				success : function(text) {
					var obj = jQuery.parseJSON(text);
					
					if(obj.status == 'ok') {
						alert("成功！");
					}
					else {
						alert("失败,请重试");
					}
				}
			};
			$("#frm").ajaxSubmit(options);
		});
		
		$("#btn2").bind("click", function() {
			var options = {
				url : 'testAddAction2',
				type : 'post',
				dataType : 'text',
				success : function(text) {
					var obj = jQuery.parseJSON(text);
					
					if(obj.status == 'ok') {
						alert("成功！");
					}
					else {
						alert("失败,请重试");
					}
				}
			};
			$("#frm").ajaxSubmit(options);
		});
	});
</script>
</head>
<body>

<form name="frm" id="frm">
	姓名：<input type="text" name="name" id="name" />
	密码：<input type="text" name="pass" id="pass" />
	
	<input type="button" name="btn1" id="btn1" value="form1提交" />
	<input type="button" name="btn2" id="btn2" value="form2提交" />
</form>

<input type="button" name="add" id="add" value="弹窗添加" onclick="" />

<table border="1" width="99%">
	<tr>
		<td>姓名</td>
		<td>密码</td>
		<td>操作</td>
	</tr>
	
	<tr>
		<td>111</td>
		<td>222</td>
		<td>
		修改
		删除
		</td>
	</tr>
</table>

</body>
</html>