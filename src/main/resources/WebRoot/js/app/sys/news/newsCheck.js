/**
 * 变量
 */

/**
 * 页面加载
 */
$(function(){
	//
	initBaseData();
	
	//加载用户信息
	
	
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
	//加载角色
	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		format : "yyyy-mm-dd"
	});
	
	//实例化ueditor
	if(ue){
		ue = ue.destroy();
	}
	ue = UE.getEditor('tnContent');
	
	ue.addListener('ready',function(){
		getNewsData();
	})
}





/**
 * 加载用户信息
 */
function getNewsData(){
	var tnId = sessionStorage["tnId"];
	var json = {"tnId" : tnId};
	ajaxPost2('/' + projectName + '/sys/news/getNewsByID',json).done(function(result){
		if(result.status == 0){
			var data = result.data;
			for(var currName in data){
				if(currName!="tnTbNewsFiles" && currName!="tnContent" && currName!="tnIstop"){
					$("#"+currName).val(data[currName]);
				}
			}
			
			//富文本编辑器
			ue.setContent(data.tnContent);
			
			ue.setDisabled();
			
			//文件
			//文件
			if(data.tnTbNewsFiles && data.tnTbNewsFiles[0].tnfOldname){
//				$("#tnfOldname").html("<a href='"+data.tnTbNewsFiles[0].tnfUrl+"'>"+data.tnTbNewsFiles[0].tnfOldname+"</a>");
				$("#tnfOldname").html(data.tnTbNewsFiles[0].tnfOldname);
			}
			
			//是否置顶
			$("input:radio[name=tnIstop][value='"+data.tnIstop+"']").prop("checked",true);
			
			
		}
	})
}

/**
 * 提交
 */
function checkNews(tnCheckstatue){
	var json = {
			tnId:sessionStorage["tnId"],
			tnCheckstatue:tnCheckstatue
	};
	
	//判断是审核通过还是不通过
	var resultInfo = tnCheckstatue=="2" ? "审核通过" : "审核不通过";
	
	ajaxPost('/' + projectName + '/sys/news/checkNews', json).done(function(result){
		if(result.status == 0){
			sucInfo(resultInfo+"成功！");
			window.location.href = "#newsList";
		}else{
			errInfo(resultInfo+"审核失败！");
		}
	})
		
}

/**
 * 取消
 */
function backNews(){
	window.location.href = "#newsList";
}
