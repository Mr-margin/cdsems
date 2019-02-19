//定义serializeObject方法，序列化表单
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
/**
 * 页面加载
 */
$(function(){
	init_date();
	//初始化区县列表
	initCounty();
	
	//获取session中预存的用户表格行数据，并转化为json格式
	var row = JSON.parse(sessionStorage["row"]);
	console.log(row);
	getData(row);
	
	//初始化验证表单
	$("#dataForm").validate({
		focusInvalid : true,
	    errorPlacement:function(error,element){
            element.tooltip({
                title:error.text()
            }).parent().addClass("has-errors");
        },
        onfocusout: function (element) {
        	$(element).tooltip('destroy');
            $(element).parent().removeClass('has-errors');  
            this.element(element);  
        }  
	});
})

function initCounty(){
	var data={tcId:263};
	$.ajax({
		url: '/' + projectName + '/city/getCountyByCityID',
		type:"post",
		async: false,
		contentType: 'application/json;charset=utf-8',
		dataType:"json",
		data:JSON.stringify({
			"token":"",
			"data":data
		}),
		success:function(data){
			if(data.status == '0'){
				$("#COUNTY").html("");
				console.log(data);
				var list = data.data;
				for(var i=0;i<list.length;i++){
					$("#COUNTY").append("<option value='"+list[i].tcCode+"'>"+list[i].tcName+"</option>")
				}
			}else{
				errInfo(data.msg);
			}
		}
	});
}

//获取要修改的原数据
function getData(row){
	for(var i in row) {
		$("#"+i).val(row[i]);
	}
}

/**
 * 提交
 */
function update(){
	var startDate = $("#START_DATE").val();
	var endDate = $("#END_DATE").val();
	if(startDate!="" && endDate!="" && startDate>endDate){
		errInfo("启动时间不能大于截止时间！");
		return;
	}
	if($("#dataForm").valid()){
		var data = $("#dataForm").serializeObject();
		$.ajax({
			url: '/' + projectName + '/soilRemediation/update',
			type:"post",
			contentType: 'application/json;charset=utf-8',
			dataType:"json",
			data:JSON.stringify({
				"token":"",
				"data":data
			}),
			success:function(data){
				if(data.status == 0){
					sucInfo("修改成功！");
					window.location.href = "#soilRemediationList";
				}else{
					errInfo(data.msg);
				}
			}
		});
	}
}

/**
 * 取消
 */
function back(){
	window.location.href = "#soilRemediationList";
}
