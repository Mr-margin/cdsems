/**
 * 变量
 */

/**
 * 页面加载
 */
$(function(){
	//
	initBaseData();
	
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
 * 权限控制
 */


/**
 * 加载角色、行政区划
 */
function initBaseData(){
	
	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		initialDate: new Date(),
		format : "yyyy-mm-dd"
	});
	
	//默认显示当前时间
	$('.mydatetime').datetimepicker('setDate', new Date());
	
	ajaxPost('/' + projectName + '/sys/user/listAll',{}).done(function(result){
		if(result.status == 0){
			var html = "";
			var data = result.data;
			html += "<option value='-1'>全部</option>";
			$.each(data,function(index, currItem){
				html += "<option value='"+currItem.suId+"'>"+currItem.suUsername+"</option>";
			})
			$("#tmSuIds").html(html);
			$("#tmSuIds").selectpicker("refresh");
			//默认选择全部
			$("#tmSuIds").selectpicker("val",["-1"]);
			$("#tmSuIds").on("changed.bs.select",function (e, clickedIndex, isSelected, previousValue) {
				//如果是全选，去掉其他
				if(clickedIndex==0 && isSelected==true){
					$("#tmSuIds").selectpicker("val",["-1"]);
				}
				//如果是其他，去掉全选
				if(clickedIndex!=0){
					var currVal = $("#tmSuIds").selectpicker("val");
					if(currVal[0]=="-1"){
						currVal.splice(0, 1);
						$("#tmSuIds").selectpicker("val", currVal);
					}
				}
			});
		}
	})
	
	
}



/**
 * 添加
 */
function addMessage(){
	if($("#dataForm").valid()){
		var tmSuIds = $("#tmSuIds").selectpicker("val");
//		if(tmSuIds && tmSuIds.length==1 && tmSuIds[0]==""){
//			$("#tmSuIds").selectpicker("selectAll");
//			tmSuIds = $("#tmSuIds").selectpicker("val");
//			tmSuIds.splice(0, 1);
//		}
			tmSuIds = tmSuIds.join(",");
		//用户集合
		var json = {
				tmTitle : $("#tmTitle").val(),
				tmSuIds : tmSuIds,
				tmDeadtime : $("#tmDeadtime").val(),
				tmContent : $("#tmContent").val().replace(/\n|\r\n/g,"<br>")
		}
		
		ajaxPost('/' + projectName + '/sys/message/saveMessage',json).done(function(result){
			if(result.status == 0){
				sucInfo("添加成功！");
				window.location.href = "#messageList";
			}else{
				errInfo("添加失败！");
			}
		});
	}
}

/**
 * 取消
 */
function backMessage(){
	window.location.href = "#messageList";
}
