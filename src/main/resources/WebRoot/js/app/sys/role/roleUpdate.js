/**
 * 变量
 */

/**
 * 页面加载
 */
$(function(){
	//
	initBaseData();
	
	//加载角色信息
	getRoleData();
	
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
	ajaxPost2('/' + projectName + '/sys/module/listAll',json).done(function(result){
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
	ajaxPost2('/' + projectName + '/sys/yzt/listAll',json).done(function(result){
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
	var cityObj = $("#srRightName");
	var cityOffset = $("#srRightName").offset();
	$("#menuContent").slideDown("fast");

	$("body").bind("mousedown", onBodyDown);
}

function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}

function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "srRightName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
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
 * 加载角色信息
 */
function getRoleData(){
	var srId = sessionStorage["srId"];
	
		var json = {"srId" : srId};
		ajaxPost('/' + projectName + '/sys/role/getRole',json).done(function(result){
			if(result.status == 0){
				var data = result.data;
				for(var currName in data){
					$("#"+currName).val(data[currName]);
				}
				
				//加载功能权限
				var smIds = ""; 
				var smNames = "";
				var rightTree = $.fn.zTree.getZTreeObj("moduleTree");
				rightTree.checkAllNodes(false);
				var sysRoleModule = data.srSysRoleModule;
				for (var i = 0; i < sysRoleModule.length; i++) {
					var currItem = sysRoleModule[i];
					var node = rightTree.getNodeByParam("id", currItem.srmSmId);
                    if(node){
                    	rightTree.checkNode(node, true, false);
                    	smIds += node.id + ",";
                    	smNames += node.name + ",";
                    }
				}
				if (smNames.length > 0 ){
					smNames = smNames.substring(0, smNames.length-1);
				}
				if (smIds.length > 0 ){
					smIds = smIds.substring(0, smIds.length-1);
				}
				$("#srSmNames").val(smNames);
				$("#srSmIds").val(smIds);
				
				//加载数据权限
				var syIds = ""; 
				var syNames = "";
				var rightTree = $.fn.zTree.getZTreeObj("yztTree");
				rightTree.checkAllNodes(false);
				var srSysRoleYzt = data.srSysRoleYzt;
				for (var i = 0; i < srSysRoleYzt.length; i++) {
					var currItem = srSysRoleYzt[i];
					var node = rightTree.getNodeByParam("id", currItem.srySyId);
                    if(node){
                    	rightTree.checkNode(node, true, false);
                    	syIds += node.id + ",";
                    	syNames += node.name + ",";
                    }
				}
				if (syNames.length > 0 ){
					syNames = syNames.substring(0, syNames.length-1);
				}
				if (syIds.length > 0 ){
					syIds = syIds.substring(0, syIds.length-1);
				}
				$("#srSyNames").val(syNames);
				$("#srSyIds").val(syIds);
			}
		})
		
}



/**
 * 编辑提交
 */
function udpateRole(){
	if($("#dataForm").valid()){
		var json = $("#dataForm").serializeObject();
		
		ajaxPost('/' + projectName + '/sys/role/updateRole',json).done(function(result){
			if(result.status == 0){
				sucInfo("修改成功！");
				window.location.href = "#roleList";
			}else if(result.status == 10){
				errInfo("角色名称已存在！");
			}else{
				errInfo("修改失败！");
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
