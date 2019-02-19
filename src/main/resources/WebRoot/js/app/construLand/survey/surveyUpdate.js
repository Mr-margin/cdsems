var iid = 0;
$(function(){
	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		format : "yyyy-mm-dd",
	});
	//获取session中预存的用户表格行数据，并转化为json格式
	var row = JSON.parse(sessionStorage["row"]);
	iid = row.iid;
    //获取建设用地
    getBuLidingAll(row.lid)
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
//获取建设用地
function getBuLidingAll(val){
    ajaxPost('/' + projectName + '/BuLidingLandController/selectBuLidingAll').done(function(result){
        if(result.status == 0){
            var html = "";
            var data = result.data;
            $.each(data,function(index, currItem){
                html += "<option value='"+currItem.LID+"'>"+currItem.MASSIF_NAME+"</option>";
            })
            $("#lid").html(html);
            $("#lid").val(val);

        }
    })
}
//获取要修改的原数据
function getInvest(row){
	for(var i in row) {
		$("#"+i).val(row[i]);
	}
    var date =  new Date(row.preliminaryCompilingTime);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
	$("#preliminaryCompilingTime").val(y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length))
}

/**
 * 添加
 */
function Update(){
	if($("#dataForm").valid()){
		var formData = new FormData();
	    formData.append("files", $("#file")[0].files[0]);
	    formData.append("files1", $("#file1")[0].files[0]);
	    var json= $("#dataForm").serializeObject();
		json["iid"]=iid+'';
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
		            	sucInfo("修改成功！");
						window.location.href = "#surveyList";
		            } else {
		            	errInfo("修改失败！");
		            }
		        },
		        error : function(){
		            errInfo("修改失败!");
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
