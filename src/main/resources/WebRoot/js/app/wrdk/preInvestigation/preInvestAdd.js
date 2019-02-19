$(function(){
	//初始化地块列表
	listMassif()
	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		format : "yyyy-mm-dd",
		pickerPosition:'top-right'
	});
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

//初始化地块列表
function listMassif(){
	$.ajax({
		url: '/' + projectName + '/ContaminatedLandController/selectContanminatedAll',
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
				$("#massif_name").html("");
				if(list.length>0){
					for(var i=0,len=list.length;i<len;i++){
						$("#massif_name").append("<option value='"+list[i].CID+"'>"+list[i].MASSIF_NAME+"</option>");
					}
				}
			}else{
				errInfo("初始化名称列表失败！");
			}
		}
	})
}
/**
 * 添加
 */
function addInv(){
	if($("#dataForm").valid()){
		var formData = new FormData();
        formData.append("files0", $("#file0")[0].files[0]);
        formData.append("files1", $("#file1")[0].files[0]);
        var json= $("#dataForm").serializeObject();
        json["cid"] = $("#massif_name").val();
        formData.append("data", JSON.stringify(json));
        console.log(formData)
        $.ajax({
            type:'POST',
            url: '/' + projectName + '/ContaminatedLandController/insertTPreliminaryContaminated',
            data:formData,
            contentType:false,
            processData:false,//这个很有必要，不然不行
            dataType:"json",
            mimeType:"multipart/form-data",
            success:function(data){
                if (data.status == 0) {
                    sucInfo("添加成功！");
                    window.location.href = "#preInvestList";
                } else {
                    errInfo("添加失败！");
                }
            },
            error : function(){
                errInfo("添加失败!");
            }
        });
	}else{
		 if($('#preliminaryTitle').val() == ''){
		        errInfo("标题不能为空！");
		    }
	}
   

}

/**
 * 取消
 */
function back(){
	window.location.href = "#preInvestList";
}
