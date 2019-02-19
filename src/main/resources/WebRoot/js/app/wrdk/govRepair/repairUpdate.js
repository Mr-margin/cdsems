var tid = "";
$(function(){

	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		format : "yyyy-mm-dd",
		pickerPosition:'top-right'
	});
	//获取session中预存的用户表格行数据，并转化为json格式
	var row = JSON.parse(sessionStorage["row"]);
    listMassif(row.cid);
	tid = row.tid+"";
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

//初始化地块列表
function listMassif(val){
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
                $("#massif_name").val(val);
			}else{
				errInfo("初始化名称列表失败！");
			}
		}
	})
}
//获取要修改的原数据
function getInvest(row){
	for(var i in row) {
		$("#"+i).val(row[i]);
	}
    var date =  new Date(row.treamentRepairTime);
    if ( row.treamentRepairTime == null || row.treamentRepairTime == "" || row.treamentRepairTime ==undefined) {
        $("#treamentRepairTime").val("")
    } else {
        var y = 1900+date.getYear();
        var m = "0"+(date.getMonth()+1);
        var d = "0"+date.getDate();
        $("#treamentRepairTime").val(y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length))
    }
  }

/**
 * 添加
 */
function updateRepair(){
	if($("#dataForm").valid()){
		var formData = new FormData();
        formData.append("files", $("#file5")[0].files[0]);
        var json= $("#dataForm").serializeObject();
        json["cid"] = $("#massif_name").val();
        json["tid"] = tid;
        formData.append("data", JSON.stringify(json));
        console.log(formData)
        $.ajax({
            type:'POST',
            url: '/' + projectName + '/ContaminatedLandController/insertTRepairContaminated',
            data:formData,
            contentType:false,
            processData:false,//这个很有必要，不然不行
            dataType:"json",
            mimeType:"multipart/form-data",
            success:function(data){
                if (data.status == 0) {
                    sucInfo("修改成功！");
                    window.location.href = "#repairList";
                } else {
                    errInfo("修改失败！");
                }
            },
            error : function(){
                errInfo("修改失败!");
            }
        });
	}else{
		 if($('#treamentRepairTitle').val() == ''){
		        errInfo("标题不能为空！");
		    } 
	}
    
}

/**
 * 取消
 */
function back(){
	window.location.href = "#repairList";
}
