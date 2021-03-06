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
/**
 * 加载县
 * @param pid
 */
function getSuCountyRegion(){
	ajaxPost('/' + projectName + '/ContaminatedLandController/selectCity').done(function(result){
		if(result.status == 0){
			var html = "";
			var data = result.data;
			html += "<option value=''>全部</option>";
			$.each(data,function(index, currItem){
				html += "<option value='"+currItem.TC_CODE+"'>"+currItem.TC_NAME+"</option>";
			})
			$("#countyCode").html(html);
			var countyCode = quanxian();
			if ( countyCode != "" ){
                $("#countyCode").attr("disabled","disabled");
                $("#countyCode").val(countyCode);
			}
		}
	})
}
getSuCountyRegion()
/**
 * 添加
 */
function add(){
	if($("#dataForm").valid()){
		var json= $("#dataForm").serializeObject();
		json["countyCode"]=$("#countyCode").val();
        var patrn = /^\d+(\.\d+)?$/;
        if(json["massifCovered"] != ""){
            if( !patrn.exec(json["massifCovered"]))  return errInfo("占地面积请您输入有效数字！");
		}
		ajaxPost('/' + projectName + '/BuLidingLandController/saveBuLidingLand',json).done(function(result){
			console.log(result)
			if(result.status == 0){
				sucInfo("添加成功！");
				window.location.href = "#basicList";
			}else{
				errInfo("添加失败！");
			}
		});
	}else{
		if($('#massifCode').val() == ''){
			errInfo("地块编码不能为空！");
		}
  			
	}
}

/**
 * 取消
 */
function back(){
	window.location.href = "#basicList";
}
