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
	
	ajaxPost('/' + projectName + '/sys/role/listAll',{}).done(function(result){
		if(result.status == 0){
			var html = "";
			var data = result.data;
			$.each(data,function(index, currItem){
				html += "<option value='"+currItem.srId+"'>"+currItem.srName+"</option>";
			})
			$("#suSrId").html(html);
			
		}
	})
	
	
	//加载县
	getSuCountyRegion("263");
}


/**
 * 加载县
 * @param pid
 */
function getSuCountyRegion(pid){
	var json = {tcId:pid}
	ajaxPost('/' + projectName + '/city/getCountyByCityID',json).done(function(result){
		if(result.status == 0){
			var html = "";
			var data = result.data;
			$.each(data,function(index, currItem){
				html += "<option value='"+currItem.tcCode+"'>"+currItem.tcName+"</option>";
			})
			$("#suCountyRegion").html(html);
			
		}
	})
}

//用户级别改变事情
function handleCityCounty(){
	var suLevel = $("#suLevel").val();
	if("2"==suLevel){
		//label
		$("#regionLabel").html('行政区划<span style="color: red;">*</span>');
		
		//css
		$("#suCityRegion").parent().removeClass("col-sm-4");
		$("#suCityRegion").parent().addClass("col-sm-8");
		
		$("#suCityRegion").parent().show();
		$("#suCountyRegion").parent().hide();
		$("#suCompanyname").parent().hide();
		
	}else if("3"==suLevel){
		//label
		$("#regionLabel").html('行政区划<span style="color: red;">*</span>');
		
		//css
		$("#suCityRegion").parent().removeClass("col-sm-8");
		$("#suCityRegion").parent().addClass("col-sm-4");
		
		$("#suCountyRegion").parent().show();
		$("#suCityRegion").parent().show();
		$("#suCompanyname").parent().hide();
	}if("4"==suLevel){
		//label
		$("#regionLabel").html('企业名称<span style="color: red;">*</span>');
		
		$("#suCountyRegion").parent().hide();
		$("#suCityRegion").parent().hide();
		$("#suCompanyname").parent().show();
	}
}

/**
 * 添加
 */
function addUser(){
	if($("#dataForm").valid()){
		var json = $("#dataForm").serializeObject();
		ajaxPost('/' + projectName + '/sys/user/saveUser',json).done(function(result){
			if(result.status == 0){
				sucInfo("添加成功！");
				window.location.href = "#userList";
			}else if(result.status == 10){
				errInfo("用户名重复！");
			}else{
				errInfo("添加失败！");
			}
		});
	}
}

/**
 * 取消
 */
function backUser(){
	window.location.href = "#userList";
}
