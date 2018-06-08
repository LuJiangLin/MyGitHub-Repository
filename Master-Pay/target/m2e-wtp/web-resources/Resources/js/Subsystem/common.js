/* js通用函数方法*/

/*格式化日期 begin*/
function formatDate(anytime) { 
	if(null != anytime){
		var date = new Date(anytime.time);
	}
	var year = date.getFullYear(); 
	var month = date.getMonth() + 1; 
	var day = date.getDate(); 
	var hour = date.getHours(); 
	var minute = date.getMinutes(); 
	var second = date.getSeconds(); 
	return year + "-" + formatTen(month) + "-" + formatTen(day) + " " + formatTen(hour)+ ":" + formatTen(minute)+ ":" + formatTen(second); 
	} 
function formatTen(num) { 
	return num > 9 ? (num + "") : ("0" + num); 
} 
/*格式化日期 end*/

/*系统-栏目-添加*/
function system_category_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*系统-栏目-编辑*/
function system_category_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*系统-栏目-删除*/
function system_category_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}