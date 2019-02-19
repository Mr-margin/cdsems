var zNodes = [];
var setting = {
	check: {//表示tree的节点在点击时的相关设置
		enable: false,//是否显示radio/checkbox
		//chkStyle: "radio",//值为checkbox或者radio表示
		//radioType: "all",
		//checkboxType: {"Y": "ps", "N": "ps"},//表示父子节点的联动效果
		//radioType: "level"//设置tree的分组
	},
	showLine: true,                  //是否显示节点间的连线
	checkable: true, 
	data: {
		key: {
			name: "NAME"
		},
		simpleData: {
			enable: true,
			idKey: "ID",
			pIdKey: "PID",
			rootPId: 0
		}
	},
	view: {
		showIcon: false,
		selectedMulti: false,
		showLine: true
	},
	callback: {
		onClick: treeClick
	}
};
//点击行业树div和行业输入框以外的地方时隐藏行业树div
document.addEventListener("click", function(e){
	if(!(event.target.id == "treeDiv" || event.target.id == "INDUSTRY_TYPE" || event.target.id == "hyTree" || $(event.target).parents("#hyTree").length>0)){
   	 	treeDiv.style.display = "none";
    }
});

//定义serializeObject方法，序列化表单
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

/**
 * 页面加载
 */
$(function(){
	//获取session中预存的用户数据
	console.log(sessionStorage);
	var suLevel = sessionStorage["suLevel"];
	if(suLevel=="4"){
		var suCompanyname = sessionStorage["suCompanyname"];
		$("#COMPANY_NAME").val(suCompanyname);
		$("#COMPANY_NAME").attr("readonly","readonly")//将input元素设置为readonly
	}
	//初始化行政区划
	initCity();
	//初始化行业列表
	initIndustry();
	//初始化工业园区
	//initZone();
	
	$("#INDUSTRY_TYPE").click(function(){
		$("#treeDiv").show();
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

function initCity(){
	var data={tcId:263};
	$("#CITY_CODE").html("<option value='510100'>成都市</option>")
	$.ajax({
		url: '/' + projectName + '/city/getCountyByCityID',
		type:"post",
		async: false,
		contentType: 'application/json;charset=utf-8',
		dataType:"json",
		data:JSON.stringify({
			"token":"",
			"data":data
		}),
		success:function(data){
			if(data.status == '0'){
				$("#COUNTY_CODE").html("");
				console.log(data);
				var list = data.data;
				for(var i=0;i<list.length;i++){
					$("#COUNTY_CODE").append("<option value='"+list[i].tcCode+"'>"+list[i].tcName+"</option>")
				}
			}else{
				errInfo(data.msg);
			}
		}
	});
}

function initIndustry(){
	$.ajax({
		url: '/' + projectName + '/company/listAllIndustry',
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
				//console.log(data.data);
				var input = document.getElementById("INDUSTRY_TYPE");
				var width = input.offsetWidth;
				var height = input.offsetHeight;
				var top = input.offsetTop;
				var left = input.offsetLeft;
				$("#treeDiv").css("width",width+"px");
				$("#treeDiv").css("left",$("#hylabel").outerWidth(true)+left+"px");
				$("#treeDiv").css("top",(height+top)+"px");
				
				zNodes = data.data;
				$.fn.zTree.init($("#hyTree"), setting, zNodes);
			}else{
				errInfo(data.msg);
			}
		}
	});
}

function initZone(){
	$("#INDUSTRY_ZONE").html("<option value=''>选择工业园区</option>");
	$.ajax({
		url: '/' + projectName + '/company/listAllPark',
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
				console.log(data);
				var list = data.data;
				for(var i=0;i<list.length;i++){
					$("#INDUSTRY_ZONE").append("<option value='"+list[i].ID+"'>"+list[i].PARK_NAME+"</option>")
				}
			}else{
				errInfo(data.msg);
			}
		}
	});
}

/**
 * 添加
 */
function add(){
	if($("#dataForm").valid()){
		var data = $("#dataForm").serializeObject();
		$.ajax({
			url: '/' + projectName + '/company/insert',
			type:"post",
			contentType: 'application/json;charset=utf-8',
			dataType:"json",
			data:JSON.stringify({
				"token":"",
				"data":data
			}),
			success:function(data){
				if(data.status == '0'){
					sucInfo("添加成功！");
					window.location.href = "#companyList";
				}else{
					errInfo(data.msg);
				}
			}
		});
	}
}

/**
 * 取消
 */
function back(){
	window.location.href = "#companyList";
}

function treeClick(event, treeId, treeNode){
	$("#INDUSTRY_CODE").val(treeNode.CODE);
	$("#INDUSTRY_TYPE").val(treeNode.NAME);
	treeDiv.style.display = "none";
}
