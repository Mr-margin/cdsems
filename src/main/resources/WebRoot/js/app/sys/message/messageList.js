/**
 * 变量
 */

/**
 * 页面加载
 */
$(function(){
	//
	myPermission();
	
	////加载基础数据
	initBaseData();
	
	initMessageTable();
})

/**
 * 权限控制
 */
/*
function userPermission(){
	//用户
	var userStr = sessionStorage["user"];
	if(userStr){
		var userObj = JSON.parse(userStr);
		var roleObj = userObj.suSysRole;
		//角色
		if(roleObj){
			var srRightElement = roleObj.srRightElement;
			if(srRightElement){
				$.each(srRightElement,function(index, ele){
					$(ele).show();
				})
			}
		}
	}
}*/


function initBaseData(){
	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		format : "yyyy-mm-dd"
	});
}


/**
 * 显示用户列表
 */
function initMessageTable(){
	
	var tmStartTime = $("#tmStartTime").val();
	var tmEndTime = $("#tmEndTime").val();
	console.log("ddd");
	if(tmStartTime && tmEndTime && tmStartTime>tmEndTime){
		 toastr.error("开始时间不能大于结束时间!");
		 return;
	}
	
	 //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/'+projectName+'/sys/message/list',  //请求后台的URL（*）
        method: 'post',                     //请求方式（*）
        dataType: "json",					//返回数据类型
        toolbar: '#exampleToolbar',         //工具按钮用哪个容器
        striped: true,                    	//是否显示行间隔色
        cache: false,                      	//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                  	//是否显示分页（*）
        ajaxOptions: {async: false, timeout: 10000},
        sortOrder: "desc",                  //排序方式
        clickToSelect : false,				// 点击行即可选中单选/复选框
        queryParams: queryParams,			//传递参数（*）
        pageSize: 10,						//页面大小 每页显示条数
        pageNumber: 1,  					//初始化加载第一页，默认第一页
        pageList: [10],		//设置表格每页显示的记录      
        showToggle: false,  				//名片格式
		showColumns: false, 				//显示隐藏列  
		toolbar: "#fpsc_update_tools",
		iconSize: "outline",
		icons: {
	        refresh: "glyphicon-repeat",
	        toggle: "glyphicon-list-alt",
	        columns: "glyphicon-list"
	    },
	    showRefresh: false,  	//显示刷新按钮
		singleSelect: false,	//复选框只能选择一条记录
		search: false,			//是否显示右上角的搜索框
		clickToSelect: true,	//点击行即可选中单选/复选框
        queryParamsType : "limit", 	//查询参数组织方式 ，参数格式,发送标准的RESTFul类型的参数请求
        sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）    
        silent: true,  			//刷新事件必须设置
        contentType : "application/json", 	//请求数据内容格式 默认是 application/json 自己根据格式自行服务端处理
        onLoadError: function (data) {
        	dataTable.bootstrapTable('removeAll');
			toastr["info"]("info", "没有找到匹配的记录");
		},
		onLoadSuccess: function(data){
			myPermission();
		},
		onClickRow : function(row, $element) {		
			rowData = row;
			$('.success').removeClass('success');
			$($element).addClass('success');
		},
		 columns: [{
	            field: 'xh',
	            title: '序号',
	            align:'center',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        }, {
	            field: 'tmId',
	            title: '主键',
	            align:'center',
	            visible: false
	        },{
	            field: 'tmTitle',
	            align:'center',
	            title: '消息标题'
	        },{
	            field: 'tmDeadtime',
	            align:'center',
	            title: '过期时间'
	        },{
	            field: 'tmIsdead',
	            align:'center',
	            title: '过期状态',
	        	formatter: function (value, row, index) {
	        		var result = "";
	        		if(value == "0"){
	        			result = "<span style='color:green'>未过期</span>";
	        		}
	        		if(value == "1"){
	        			result = "<span style='color:red'>已过期</span>";
	        		}
	        		return result;
	            }  
	        },
	        {
	            field: 'todo',
	            title: '操作',
	            align:'center',
	            width:'110',
	            formatter:function(value,row,index){
	            	var a = "";
	            	if(row.tmIsdead && row.tmIsdead=="0"){
	            		var a = '<a class="btn btn-success btn-xs sys_message_dead eleNone" title="设置为过期" onclick="deadMessage('+row.tmId+')"><i class="fa fa-bell-slash-o"></i></a> ';
	            	}
	                var e = '<a class="btn btn-origin btn-xs sys_message_udpate eleNone" title="编辑" onclick="updateMessage('+row.tmId+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="btn btn-danger btn-xs sys_message_delete eleNone" title="删除" onclick="delMessage('+row.tmId+')"><i class="fa fa-trash"></i></a> ';
	                return a+e+d;
	            },
	        }]
	});	
}

/**
 * 查询参数
 */
function queryParams(params){ 
	var tmIsdead = $("#tmIsdead").val();
	var tmStartTime = $("#tmStartTime").val();
	var tmEndTime = $("#tmEndTime").val();
	var temp = {
			token : '',
			data :{
				pageSize : params.limit,
				pageNumber :  params.offset,
				tmIsdead : tmIsdead,
				tmStartTime : tmStartTime,
				tmEndTime : tmEndTime,
				sortName:this.sortName,
                sortOrder:this.sortOrder,
			}
	};
	return temp;
};

/**
 * 添加用户
 */
function addMessage(){
	window.location.href="#messageAdd";
}

/**
 * 编辑用户
 */
function updateMessage(tmId){
	//获取表单数据
	//将选中行数据存入session当中
	sessionStorage["tmId"]=tmId;
	window.location.href="#messageUpdate";
}


/**
 * 删除用户
 */
function delMessage(tmId){
	delInfo(tmId);
}
//删除用户
function delData(id){
	var json = {tmId:id};
	ajaxPost('/' + projectName + '/sys/message/deleteMessage', json).done(function(result){
		if(result.status == 0){
			sucInfo("删除成功！");
			initMessageTable();
		}else{
			errInfo("删除失败！");
		}
	})
}

/**
 * 设置消息过期
 */
function deadMessage(tmId){
	swal({
		  title: '确定设置消息过期吗？',
		  type: 'warning',
		  showCancelButton: true,
		  cancelButtonText: "取消",
	        confirmButtonText: "确定",
	        confirmButtonColor: "#ec6c62"
	}).then(function(result){
		if(result == true) {
			var json = {tmId:tmId};
			ajaxPost('/' + projectName + '/sys/message/deadMessage', json).done(function(result){
				if(result.status == 0){
					sucInfo("设置成功！");
					initMessageTable();
				}else{
					errInfo("设置失败！");
				}
			})
		}
	})
}


