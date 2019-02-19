$(function(){
	//获取建设用地
	getBuLidingAll()
	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		format : "yyyy-mm-dd",
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
//获取建设用地
function getBuLidingAll(){
    ajaxPost('/' + projectName + '/BuLidingLandController/selectBuLidingAll').done(function(result){
        if(result.status == 0){
            var html = "";
            var data = result.data;
            $.each(data,function(index, currItem){
                html += "<option value='"+currItem.LID+"'>"+currItem.MASSIF_NAME+"</option>";
            })
            $("#lid").html(html);

        }
    })
}

/**
 * 添加
 */
function add(){
	if($("#dataForm").valid()){
		var formData = new FormData();
	    formData.append("files", $("#file")[0].files[0]);
	    formData.append("files1", $("#file1")[0].files[0]);
	    var json= $("#dataForm").serializeObject();
	    json["lid"] = $("#lid").val();
		formData.append("data", JSON.stringify(json));
		console.log(formData)
		 $.ajax({
		        type:'POST',
		        url: '/' + projectName + '/BuLidingLandController/saveInvestigationLand',
		        data:formData,
		        contentType:false,
		        processData:false,//这个很有必要，不然不行
		        dataType:"json",
		        mimeType:"multipart/form-data",
		        success:function(data){
		            if (data.status == 0) {
		            	sucInfo("添加成功！");
						window.location.href = "#surveyList";
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
			errInfo("调查标题不能为空！");
		}
  			
	}
}

/**
 * 取消
 */
function back(){
	window.location.href = "#surveyList";
}
