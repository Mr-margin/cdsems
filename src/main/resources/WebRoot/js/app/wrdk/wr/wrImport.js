$(function(){
	//初始化验证表单
	$("#importForm").validate({
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
function submit(){
    if ($("#file").val() == "" ) return errInfo("请上传文件!");
    var formData = new FormData();
    formData.append("files", $("#file")[0].files[0]);
    $.ajax({
        type:'POST',
        url: '/' + projectName + '/ContaminatedLandController/importContanminatedBatch',
        data:formData,
        contentType:false,
        processData:false,//这个很有必要，不然不行
        dataType:"json",
        mimeType:"multipart/form-data",
        success:function(data){
            if (data.status == 0) {
                sucInfo("导入成功！");
                window.location.href = "#wrList";
            } else {
                errInfo("导入失败!"+data.msg);
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
	window.location.href = "#wrList";
}
