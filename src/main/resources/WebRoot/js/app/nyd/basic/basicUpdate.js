var aid = 0;
$(function(){

	//获取session中预存的用户表格行数据，并转化为json格式
	var row = JSON.parse(sessionStorage["row"]);
	console.log(row)
	aid = row.aid;
    //加载县
    getSuCountyRegion(row)
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
/**
 * 加载县
 * @param pid
 */
function getSuCountyRegion(row){
	ajaxPost('/' + projectName + '/ContaminatedLandController/selectCity').done(function(result){
		if(result.status == 0){
			var html = "";
			var data = result.data;
			console.log(data)
			html += "<option value=''>全部</option>";
			$.each(data,function(index, currItem){
				html += "<option value='"+currItem.TC_CODE+"'>"+currItem.TC_NAME+"</option>";
			})
			$("#countyCode").html(html);
            $("#countyCode").val(row.countyCode);
            var countyCode = quanxian();
            if ( countyCode != "" ){
                $("#countyCode").attr("disabled","disabled");
                $("#countyCode").val(countyCode);
            }
		}
	})
}
//获取要修改的原数据
function getData(row){
	for(var i in row) {
		$("#"+i).val(row[i]);
	}

}


/**
 * 添加
 */
function Update(){
	if($("#dataForm").valid()){
		var json =$("#dataForm").serializeObject();
		json["aid"] = aid;
        json["countyCode"] = $("#countyCode").val();
		ajaxPost('/' + projectName + '/AgricuturalSoilController/saveAgricuturalSoil',json).done(function(result){
			console.log(result)
			if(result.status == 0){
				sucInfo("修改成功！");
				window.location.href = "#basicList";
			}else{
				errInfo("修改失败！");
			}
		});
	}else{
		if($('#agricuturalName').val() == ''){
			errInfo("农用地名称不能为空！");
		}
  			
	}
}

/**
 * 取消
 */
function back(){
	window.location.href = "#basicList";
}
