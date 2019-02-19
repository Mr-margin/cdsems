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
	
	loadZtree();
	
	//加载功能权限
	/*$.ajax({
		url: '/' + projectName + '/system/right/listAll',
		type:"post",
		contentType: 'application/json;charset=utf-8',
		dataType:"json",
		data:JSON.stringify({
			"token":"",
			"data":{}
		}),
		success:function(result){
			if(result.status == 0){
				var html = "";
				var data = result.data;
				$.each(data,function(index, currItem){
					html += "<option value='"+currItem.srId+"'>"+currItem.srName+"</option>";
				})
				$("#suSrId").html(html);
				
			}
		}
	});*/
	
	
}




function loadZtree(){
	var settings = {
			check: {//表示tree的节点在点击时的相关设置
				enable: true,//是否显示radio/checkbox
				chkStyle: "checkbox",//值为checkbox或者radio表示
				checkboxType: {"Y": "ps", "N": "s"},//表示父子节点的联动效果
				chkboxType: {"Y": "ps", "N": "s"},//表示父子节点的联动效果
				radioType: "level"//设置tree的分组
			},
			showLine: true,                  //是否显示节点间的连线
			checkable: true,                 //每个节点上是否显示 CheckBox
			callback: {
				onCheck: onCheck,
			}
	};
	var json = {};
	ajaxPost('/' + projectName + '/sys/module/listAll',json).done(function(result){
		if(result.status == 0){
			var notes = result.data;
			$.fn.zTree.init($("#moduleTree"), settings, notes);
		}
	})
	
	var settings2 = {
			check: {//表示tree的节点在点击时的相关设置
				enable: true,//是否显示radio/checkbox
				chkStyle: "checkbox",//值为checkbox或者radio表示
				checkboxType: {"Y": "ps", "N": "s"},//表示父子节点的联动效果
				chkboxType: {"Y": "ps", "N": "s"},//表示父子节点的联动效果
				radioType: "level"//设置tree的分组
			},
			showLine: true,                  //是否显示节点间的连线
			checkable: true,                 //每个节点上是否显示 CheckBox
			callback: {
				onCheck: onCheck2,
			}
	};
	ajaxPost('/' + projectName + '/sys/yzt/listAll',json).done(function(result){
		if(result.status == 0){
			var notes = result.data;
			$.fn.zTree.init($("#yztTree"), settings2, notes);
		}
	})
}

function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("moduleTree");
	var nodes = zTree.getCheckedNodes(true);
	smIds = ""; smNames = "";
	for (var i=0; i<nodes.length; i++) {
		smIds += nodes[i].id + ",";
		smNames += nodes[i].name + ",";
	}
	if (smNames.length > 0 ){
		smNames = smNames.substring(0, smNames.length-1);
	}
	if (smIds.length > 0 ){
		smIds = smIds.substring(0, smIds.length-1);
	}
	$("#srSmNames").val(smNames);
	$("#srSmIds").val(smIds);
}

function onCheck2(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("yztTree");
	var nodes = zTree.getCheckedNodes(true);
	srSyIds = ""; srSyNames = "";
	for (var i=0; i<nodes.length; i++) {
		srSyIds += nodes[i].id + ",";
		srSyNames += nodes[i].name + ",";
	}
	if (srSyNames.length > 0 ){
		srSyNames = srSyNames.substring(0, srSyNames.length-1);
	}
	if (srSyIds.length > 0 ){
		srSyIds = srSyIds.substring(0, srSyIds.length-1);
	}
	$("#srSyNames").val(srSyNames);
	$("#srSyIds").val(srSyIds);
}

function showMenu() {
	var cityObj = $("#srSmNames");
	var cityOffset = $("#srSmNames").offset();
	$("#menuContent").slideDown("fast");

	$("body").bind("mousedown", onBodyDown);
}

function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}

function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "srSmNames" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
		hideMenu();
	}
}

function showMenu2() {
	var cityObj = $("#srSyNames");
	var cityOffset = $("#srSyNames").offset();
	$("#menuContent2").slideDown("fast");

	$("body").bind("mousedown", onBodyDown2);
}

function hideMenu2() {
	$("#menuContent2").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown2);
}

function onBodyDown2(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "srSyNames" || event.target.id == "menuContent2" || $(event.target).parents("#menuContent2").length>0)) {
		hideMenu2();
	}
}




/**
 * 添加
 */
function addRole(){
	if($("#dataForm").valid()){
		var json = $("#dataForm").serializeObject();
		
		ajaxPost('/' + projectName + '/sys/role/saveRole',json).done(function(result){
			if(result.status == 0){
				sucInfo("添加成功！");
				window.location.href = "#roleList";
			}else if(result.status == 10){
				errInfo("角色名称已存在！");
			}else{
				errInfo("添加失败！");
			}
		})
	}
}

/**
 * 取消
 */
function backRole(){
	window.location.href = "#roleList";
}
