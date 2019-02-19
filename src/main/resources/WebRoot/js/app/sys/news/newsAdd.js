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
		format : "yyyy-mm-dd"
	});
	
	//默认显示当前时间
	$('.mydatetime').datetimepicker('setDate', new Date());
	
	//实例化ueditor
	if(ue){
		ue = ue.destroy();
	}
	ue = UE.getEditor('tnContent');
	
}




/**
 * 添加
 */
function addNews(){
	if($("#dataForm").valid()){
		//ue
		var tnContent = ue.getContent();
		
		//正文内容不为空
		if(!tnContent || tnContent=="" || tnContent.trim()==""){
			errInfo("请填写正文内容！");
			return;
		}
		
		var myForm = new FormData();
		myForm.append("tnTitle",$("#tnTitle").val());
		myForm.append("tnSource",$("#tnSource").val());
		myForm.append("tnType",$("#tnType").val());
		myForm.append("tnAuthor",$("#tnAuthor").val());
		myForm.append("tnPosttime",$("#tnPosttime").val());
		myForm.append("tnCheckperson",$("#tnCheckperson").val());
		myForm.append("tnIstop", $("input[name='tnIstop']:checked").val());
		myForm.append("tnContent",tnContent);
		myForm.append("tnTbNewsFiles",$("#tnTbNewsFiles")[0].files[0]);
		
		$.ajax({
		    url: '/'+projectName+'/sys/news/saveNews',
		    type: 'POST',
		    cache: false,
		    data: myForm,
		    processData: false,
		    contentType: false,
		    async: false,
		    success:function(result){
		    	//上传成功
		    	if(result.status == 0){
					sucInfo("添加成功！");
					window.location.href = "#newsList";
				}else if(result.status == 10){
					errInfo("标题名称已存在！");
				}else{
					errInfo("添加失败！");
				}
		    }
		});
	}
}

/**
 * 取消
 */
function backNews(){
	window.location.href = "#newsList";
}
