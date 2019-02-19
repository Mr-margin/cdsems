/**
 * 变量
 */

/**
 * 页面加载
 */
$(function(){
	
	myPermission();
	
	initRoleTable();
})

/**
 * 权限控制
 */



/**
 * 显示角色列表
 */
function initRoleTable(){
	 //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/'+projectName+'/sys/role/list',  //请求后台的URL（*）
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
	            field: 'srId',
	            title: '主键',
	            align:'center',
	            visible: false
	        },{
	            field: 'srName',
	            align:'center',
	            title: '角色名'
	        },{
	            field: 'srDesc',
	            align:'center',
	            title: '角色描述'
	        },{
	            field: 'todo',
	            align:'center',
	            title: '操作',
	            width:'80',
	            formatter:function(value,row,index){
	                var e = '<a class="btn btn-origin btn-xs sys_role_update eleNone" title="编辑" onclick="updateRole('+row.srId+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="btn btn-danger btn-xs sys_role_delete eleNone" title="删除" onclick="delRole('+row.srId+')"><i class="fa fa-trash"></i></a> ';
	                return e+d;
	            },
	        }]
	});	
}

/**
 * 查询参数
 */
function queryParams(params){ 
	var srName = $("#srName").val();
	var temp = {
			token : '',
			data :{
				pageSize : params.limit,
				pageNumber :  params.offset,
				srName : srName ,
				sortName:this.sortName,
                sortOrder:this.sortOrder,
			}
	};
	return temp;
};

/**
 * 添加用户
 */
function addRole(){
	window.location.href="#roleAdd";
}

/**
 * 编辑用户
 */
function updateRole(srId){
	//获取表单数据
	//将选中行数据存入session当中
	sessionStorage["srId"]=srId;
	window.location.href="#roleUpdate";
}


/**
 * 删除角色
 */
function delRole(srId){
	delInfo(srId);
}

//删除角色
function delData(id){
	var json = {srId:id};
	ajaxPost('/' + projectName + '/sys/role/deleteRole', json).done(function(result){
		if(result.status == 0){
			sucInfo("删除成功！");
			initRoleTable();
		}else{
			errInfo("删除失败！");
		}
	})
}


