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
	//初始化企业列表
	listCompany();
	//初始化污染物列表
	listPollutant();
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

//初始化企业列表
function listCompany(){
	$.ajax({
		url: '/' + projectName + '/company/listAllCompany',
		type:"post",
		async: false,
		contentType: 'application/json;charset=utf-8',
		dataType:"json",
		data:JSON.stringify({
			"token":"",
			"data":{}
		}),
		success:function(data){
			if(data.status == '0'){
				var list = data.data;
				$("#COMPANY_ID").html("");
				if(list.length>0){
					for(var i=0,len=list.length;i<len;i++){
						$("#COMPANY_ID").append("<option value='"+list[i].ID+"'>"+list[i].COMPANY_NAME+"</option>");
					}
				}
				$("#COMPANY_ID" ).selectpicker('refresh');
			}else{
				errInfo("初始化企业列表失败！");
			}
		}
	})
}

function listPollutant(){
	$.ajax({
		url: '/' + projectName + '/companyPollutantMonitor/listAllPollutant',
		type:"post",
		async: false,
		contentType: 'application/json;charset=utf-8',
		dataType:"json",
		data:JSON.stringify({
			"token":"",
			"data":{}
		}),
		success:function(data){
			if(data.status == '0'){
				var list = data.data;
				$("#POLLUTANT_ID").html("");
				if(list.length>0){
					for(var i=0,len=list.length;i<len;i++){
						$("#POLLUTANT_ID").append("<option value='"+list[i].ID+"'>"+list[i].POLLUTANT_NAME+"</option>");
					}
				}
				$("#POLLUTANT_ID" ).selectpicker('refresh');
			}else{
				errInfo("初始化企业列表失败！");
			}
		}
	})
}

//获取要修改的原数据
function getData(row){
	for(var i in row) {
		$("#"+i).val(row[i]);
	}
	$("#COMPANY_ID" ).selectpicker('refresh');
	$("#POLLUTANT_ID" ).selectpicker('refresh');
}

/**
 * 提交
 */
function update(){
	if($("#dataForm").valid()){
		var data = $("#dataForm").serializeObject();
		$.ajax({
			url: '/' + projectName + '/companyPollutantMonitor/update',
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
					window.location.href = "#companyPollutantMonitorList";
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
	window.location.href = "#companyPollutantMonitorList";
}
