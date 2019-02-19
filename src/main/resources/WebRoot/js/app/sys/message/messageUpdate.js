 /**
 * 变量
 */
var allUserLength = 0;

/**
 * 页面加载
 */
$(function(){
	//
	initBaseData();
	
	//加载用户信息
	getMessageData();
	
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
		format : "yyyy-mm-dd"
	});
	
	ajaxPost2('/' + projectName + '/sys/user/listAll',{}).done(function(result){
		if(result.status == 0){
			var html = "";
			var data = result.data;
			
			//记录所有用户数量
			if(data){
				allUserLength = data.length;
			}
			
			html += "<option value='-1'>全部</option>";
			$.each(data,function(index, currItem){
				html += "<option value='"+currItem.suId+"'>"+currItem.suUsername+"</option>";
			})
			$("#tmSuIds").html(html);
			$("#tmSuIds").selectpicker("refresh");
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
 * 加载用户信息
 */
function getMessageData(){
	var tmId = sessionStorage["tmId"];
	var json = {"tmId" : tmId};
	ajaxPost('/' + projectName + '/sys/message/getMessageByID',json).done(function(result){
		if(result.status == 0){
			var data = result.data;
			for(var currName in data){
				if(currName != "tmSuIds" && currName != "tmContent");
				$("#"+currName).val(data[currName]);
			}
			
			if(data["tmContent"]){
				var reg = new RegExp("<br>","g"); 
				var newStr = data["tmContent"].replace(reg,"\n");
				$("#tmContent").val(newStr);
			}
			
			//用户ids
			var tmSuIds = data.tmSuIds;
			if(tmSuIds){
				var tmSuIdsArr = tmSuIds.split(",");
//				if(allUserLength==tmSuIdsArr.length){
//					$("#tmSuIds").selectpicker("val", "");
//				}else{
					$("#tmSuIds").selectpicker("val", tmSuIdsArr);
//				}
			}
		}
	})
}

/**
 * 提交
 */
function updateMessage(){
	if($("#dataForm").valid()){
		var tmSuIds = $("#tmSuIds").selectpicker("val");
//		if(tmSuIds && tmSuIds.length==1 && tmSuIds[0]==""){
//			$("#tmSuIds").selectpicker("selectAll");
////			tmSuIds = $("#tmSuIds").selectpicker("val");
//			tmSuIds.splice(0, 1);
//		}
		tmSuIds = tmSuIds.join(",");
		//用户集合
		var json = {
				tmTitle : $("#tmTitle").val(),
				tmId : sessionStorage["tmId"],
				tmSuIds : tmSuIds,
				tmDeadtime : $("#tmDeadtime").val(),
				tmContent : $("#tmContent").val().replace(/\n|\r\n/g,"<br>")
		}
		
		ajaxPost('/' + projectName + '/sys/message/updateMessage',json).done(function(result){
			if(result.status == 0){
				sucInfo("修改成功！");
				window.location.href = "#messageList";
			}else{
				errInfo("修改失败！");
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
