/**
 * 页面初始化
 */
$(function(){

	
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

function back(){
	window.location.href="#companyMigrationList";
}

function add(){
	if ($("#file").val() == "" ) return errInfo("请选择上传文件!");
	var data = new FormData(document.getElementById("importForm"));
	$.ajax({
		url:"/" + projectName + "/companyMigration/importExcel",
		type:"post",
        data:data,
        processData:false,
        contentType:false,
        dataType:"json",
		success:function(data){
			console.log(data)
			//判断接口返回状态
			if(data.status=="0"){	//成功
				sucInfo("导入成功！");
				//数据列表列表
				back();
			}else{	//失败
				errInfo(data.msg);
			}
		}
	});
}