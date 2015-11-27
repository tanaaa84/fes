/**
 * @author matrix
 * @version 1.1
 */
(function ($) { 
	
	$.g = {
		loaddata:function(p,configs){
			switch(configs.dataType)
			{
				case 'json':
					$.ajax({
						url:configs.url,
						type:configs.type,
						data:configs.data,
						dataType:configs.dataType,
						success:function(json){
							$.g.createTData(p,json,configs);
						}
					});
					break;

				case 'html':
					//加载html
					p.load(configs.url,configs.data,function(){
						configs.data.totalpage = $('#totalpage').val();
						configs.data.total = $('#total').val();
						$.g.pager(p,configs);
					});						 			
					break;					
				default:
					break;
			}
		},
		pager:function(p,configs){
			//生成分页
			//包含分页按扭的div
 			var cdiv = document.createElement('div');
 			cdiv.id = 'cdiv';
 			//json = jQuery.parseJSON(json);
 			cdiv.innerHTML = '共' + configs.data.total + '条记录,每页' + configs.data.pagesize + '条，当前第<span style="color:red">' + configs.data.currentpage + '</span>/' + configs.data.totalpage + '页'
 			+ ' |  <a href="#" id=tpage>首页</a> | <a href="#" id="spage">上一页</a> | <a href="#" id=nextpage>下一页</a> | <a href="#" id="lastpage">未页</a> | 转到第&nbsp;'
 			+ '<input type="text" name="pageval" style="width:40px" id="pageval"/><input type="button" name="pageto" value="跳转" id="pageto" /> 页';
 			$('#cdiv').is('div')?$('#cdiv').replaceWith(cdiv):p.append(cdiv);
 			$.g.bindevent(p,configs);
 			
		},
		bindevent:function(p,configs){
			//绑定事件
 			//首页
 			$('#tpage').bind('click',function(){
 				configs.data.currentpage = 1;
 				p.pageReload();
 			});
 			//未页
 			$('#lastpage').bind('click',function(){
 				configs.data.currentpage = configs.data.totalpage;
 				p.pageReload();
 			});
 			//下一页
 			$('#nextpage').bind('click',function(){
 				if(configs.data.currentpage == configs.data.totalpage){
 					alert('已经是最后一页了！');
 				}else{
 					try{
 						configs.data.currentpage = parseInt(configs.data.currentpage) + 1;
 					}catch (e) {
 						alert('页数错误！');
					}
 					
 	 				p.pageReload();
 				}	
 			});
 			//下一页
 			$('#spage').bind('click',function(){
 				if(configs.data.currentpage == 1){
 					alert('已经是第1页了！');
 				}else{
 					try{
 						configs.data.currentpage = parseInt(configs.data.currentpage) - 1;
 					}catch (e) {
 						alert('页数错误！');
					}
 	 				p.pageReload();
 				}	
 			});
 			//跳转
 			$('#pageto').bind('click',function(){
 				var page = $("#pageval").val();
 				if(page < 1 || page > configs.data.totalpage){
 					alert('输入页数错误！');
 				}else{
 					try{
 						configs.data.currentpage = parseInt(page);
 					}catch (e) {
 						alert('输入页数错误！');
					}					
 	 				p.pageReload();
 				}	
 			});
		},
		createTData:function(p,json,configs){
			configs.data.totalpage = json.totalpage;
			configs.data.total = json.totalcount;
 			//创建存放数据的table
 			var tdata = document.createElement('table');
 			tdata.id = 'tdata';
 			//创建thead
 			var thead = document.createElement('thead');
 			//创建tr
 			var ttr = document.createElement('tr');
 			var cum = configs.cum;
 			for(var i in cum){			
 				var ttd = document.createElement('td');
 				ttd.innerHTML =  cum[i].field;
 				ttr.appendChild(ttd);
 			}
 			thead.appendChild(ttr);
 			tdata.appendChild(thead);	
 			//创建tbody
 			var tbody = document.createElement('tbody');
 			var data = json.data;
 			$.each(data,function(j,o){
 				//创建tr
	 			var tbtr = document.createElement('tr');
	 			for(var i in cum){	
	 				var tbtd = document.createElement('td');
	 				tbtd.innerHTML = o[cum[i].index];
	 				tbtr.appendChild(tbtd);
	 			}
	 			tbody.appendChild(tbtr);
 			});
 			
 			tdata.appendChild(tbody);
 			$('#tdata').is('table')?$('#tdata').replaceWith(tdata):p.append(tdata);	
 			$.g.pager(p,configs);
 		}
	};
	
	$.fn.pager = function(options){
		 var defaults = {   //默认值
			data:{
				currentpage:1,
				pagesize:10
				},
			type:'post',
			dataType:'json'
		 };  
		 var configs = $.extend(defaults, options); 
		 this.each(function(){ 
			 var p = $(this);
			 p.data("configs",configs); //缓存配置
			 $.g.loaddata(p,configs);
		 });
	};
	 
	$.fn.pageReload = function(options){
		 var p = $(this);
		 var configs = p.data("configs");
		 configs = $.extend(true,configs, options);
		 switch(configs.dataType)
			{
				case 'json':			
					$.ajax({
						url:configs.url,
						type:configs.type,
						dataType:configs.dataType,
						data:configs.data,
						success:function(json){
							$.g.createTData(p,json,configs);
						}
					});	
					break;

				case 'html':
					p.load(configs.url,configs.data,function(){
						$.g.htmlpager(p,configs);
					});		
					break;
					
				default:
					break;
			}
	};
	
})(jQuery);