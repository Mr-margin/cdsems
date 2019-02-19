var mid = 0;
$(function(){
	//获取session中预存的用户表格行数据，并转化为json格式
	var row = JSON.parse(sessionStorage["row"]);
	mid = row.mid;
    //获取所有的农用地
    getAgricuturalName(row.aid);
    getInvest(row);
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
function getAgricuturalName(val){
    ajaxPost('/' + projectName + '/AgricuturalSoilController/selectAll').done(function(result){
        if(result.status == 0){
            var html = "";
            var data = result.data;
            $.each(data,function(index, currItem){
                html += "<option value='"+currItem.aid+"'>"+currItem.agricuturalName+"</option>";
            })
            $("#aid").html(html);
            $("#aid").val(val);

        }
    })
}
//获取要修改的原数据
function getInvest(row){
	for(var i in row) {
		$("#"+i).val(row[i]);
	}
}

/**
 * 添加
 */
function Update(){
	if($("#dataForm").valid()){
        // var formData = new FormData();
	    // formData.append("files4", $("#file4")[0].files[0]);
	    var json= $("#dataForm").serializeObject();
		json["mid"]=mid;
        json["aid"] = $("#aid").val();
        ajaxPost('/' + projectName + '/AgricuturalSoilController/saveMonitorSoil',json).done(function(result){
            if (result.status == 0) {
                sucInfo("修改成功！");
                window.location.href = "#monitorList";
            } else {
                errInfo("修改失败！");
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
