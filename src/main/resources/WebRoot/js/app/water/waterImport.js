$(function(){
	//加载县
	getSuCountyRegion()
	//初始化验证表单
	$("#yqimportForm").validate({
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
function yqsubmit(){
    var formData = new FormData();
    formData.append("file", $("#file")[0].files[0]);
    $.ajax({
        type:'POST',
        url: '/' + projectName + '/CompanyWaterMonitorController/importWaterSourceExcel',
        data:formData,
        contentType:false,
        processData:false,//这个很有必要，不然不行
        dataType:"json",
        mimeType:"multipart/form-data",
        success:function(data){
            if (data.status == 0) {
                sucInfo("导入成功！");
                back();
            } else {
                errInfo(data.msg);
            }
        },
        error : function(){
            errInfo("导入失败!");
        }
    });
}
/**
 * 取消
 */
function back(){
	window.location.href = "#waterList";
}
