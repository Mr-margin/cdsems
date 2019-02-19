$(function(){
    //获取所有的农用地
    getAgricuturalName();
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
//农用地名称
function getAgricuturalName(){
    ajaxPost('/' + projectName + '/AgricuturalSoilController/selectAll').done(function(result){
        if(result.status == 0){
            var html = "";
            var data = result.data;
            $.each(data,function(index, currItem){
                html += "<option value='"+currItem.aid+"'>"+currItem.agricuturalName+"</option>";
            })
            $("#aid").html(html);

        }
    })
}

/**
 * 添加
 */
function add(){
	if($("#dataForm").valid()){
	    var json= $("#dataForm").serializeObject();
	    json["aid"] = $("#aid").val();
        ajaxPost('/' + projectName + '/AgricuturalSoilController/saveMonitorSoil',json).done(function(result){
            if (result.status == 0) {
                sucInfo("添加成功！");
                window.location.href = "#monitorList";
            } else {
                errInfo("添加失败！");
            }
        })
	}else{
		if($('#sampleType').val() == ''){
			errInfo("样品类型不能为空！");
		}
	}
}

/**
 * 取消
 */
function back(){
	window.location.href = "#monitorList";
}
