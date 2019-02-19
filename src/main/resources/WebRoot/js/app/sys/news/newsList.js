/**
 * 变量
 */

/**
 * 页面加载
 */
$(function(){
	//
	myPermission();
	
	initNewsTable();
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


/**
 * 显示用户列表
 */
function initNewsTable(){
	 //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/'+projectName+'/sys/news/list',  //请求后台的URL（*）
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
	            checkbox: 'true',
	        },{
	            field: 'xh',
	            title: '序号',
	            align:'center',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        },{
	            field: 'tnId',
	            title: '主键',
	            align:'center',
	            visible: false
	        },{
	            field: 'tnTitle',
	            align:'center',
	            title: '标题'
	        },{
	            field: 'tnType',
	            title: '类型',
	            align:'center',
	            formatter: function (value, row, index) {
	            	var result = "";
	        		if(value == "1"){
	        			result = "法律法规";
	        		}else if(value == "2"){
	        			result = "标准规范";
	        		}
	        		return result;
	            }  
	        },{
	            field: 'tnPosttime',
	            align:'center',
	            title: '发布时间'
	        },{
	            field: 'tnCheckstatue',
	            align:'center',
	            title: '审核状态',
	            formatter: function (value, row, index) {
	            	var result = "";
	        		if(value == "1"){
	        			result = "未审核";
	        		}else if(value == "2"){
	        			result = "审核通过";
	        		}else if(value == "3"){
	        			result = "审核不通过";
	        		}
	        		return result;
	            }
	        },{
	            field: 'tnIstop',
	            align:'center',
	            title: '置顶状态',
	            formatter: function (value, row, index) {
	            	var result = "";
	        		if(value == "0"){
	        			result = "未置顶";
	        		}else if(value == "1"){
	        			result = "置顶";
	        		}
	        		return result;
	            }
	        },
	        {
	            field: 'todo',
	            align:'center',
	            title: '操作',
	            width:'100',
	            formatter:function(value,row,index){
	            	var a = '<a class="btn btn-success btn-xs sys_news_check eleNone" title="审核" onclick="checkNews('+row.tnId+')"><i class="fa fa-check-square-o"></i></a> ';
	                var e = '<a class="btn btn-origin btn-xs sys_news_update eleNone" title="编辑" onclick="updateNews('+row.tnId+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="btn btn-danger btn-xs sys_news_delete eleNone" title="删除" onclick="delNews('+row.tnId+')"><i class="fa fa-trash"></i></a> ';
	                return a+e+d;
	            },
	        }]
	});	
}

/**
 * 查询参数
 */
function queryParams(params){ 
	var tnTitle = $("#tnTitle").val();
	var tnType = $("#tnType").val();
	var tnCheckstatue = $("#tnCheckstatue").val();
	var tnIstop = $("#tnIstop").val();
	var temp = {
			token : '',
			data :{
				pageSize : params.limit,
				pageNumber :  params.offset,
				tnTitle : tnTitle ,
				tnType : tnType ,
				tnCheckstatue : tnCheckstatue ,
				tnIstop : tnIstop ,
				sortName:this.sortName,
                sortOrder:this.sortOrder,
			}
	};
	return temp;
};

/**
 * 添加用户
 */
function addNews(){
	window.location.href="#newsAdd";
}

/**
 * 编辑用户
 */
function updateNews(tnId){
	//获取表单数据
	//将选中行数据存入session当中
	sessionStorage["tnId"]=tnId;
	window.location.href="#newsUpdate";
}
/**
 * 编辑用户
 */
function checkNews(tnId){
	//获取表单数据
	//将选中行数据存入session当中
	sessionStorage["tnId"]=tnId;
	window.location.href="#newsCheck";
}


/**
 * 删除用户
 */
function delNews(tnId){
	delInfo(tnId);
}

//删除用户
function delData(id){
	var json = {tnId:id};
	ajaxPost('/' + projectName + '/sys/news/deleteNews', json).done(function(result){
		if(result.status == 0){
			sucInfo("删除成功！");
			initNewsTable();
		}else{
			errInfo("删除失败！");
		}
	})
}

/**
 * 批量删除新闻
 */
function deleteNewsArr(){
	var tnIds = "";
	var selections = $('#dataTable').bootstrapTable('getSelections')
	if(selections.length<=0){
		errInfo("请选择一条数据！");
	}else{
		//获取id
		for (var i = 0; i < selections.length; i++) {
			var currSelection = selections[i];
			tnIds += currSelection.tnId + ",";
		}
		tnIds = tnIds.substring(0, tnIds.length-1);
		
		swal({
			  title: '确定删除吗？',
			  type: 'warning',
			  showCancelButton: true,
		        closeOnConfirm: false,
		        cancelButtonText: "取消",
		        confirmButtonText: "确定",
		        confirmButtonColor: "#ec6c62"
		}).then(function(result){
			  if(result == true) {
				  var json = {tnIds:tnIds};
					ajaxPost('/' + projectName + '/sys/news/deleteNewsByTnIds', json).done(function(result){
						if(result.status == 0){
							sucInfo("删除成功！");
							initNewsTable();
						}else{
							errInfo("删除失败！");
						}
					})
			  }
		})
	}
}

//批量审核新闻
function checkNewsArr(tnCheckstatue){
	var tnIds = "";
	var selections = $('#dataTable').bootstrapTable('getSelections')
	if(selections.length<=0){
		errInfo("请选择一条数据！");
	}else{
		//获取id
		for (var i = 0; i < selections.length; i++) {
			var currSelection = selections[i];
			tnIds += currSelection.tnId + ",";
		}
		tnIds = tnIds.substring(0, tnIds.length-1);
		var title = tnCheckstatue=="2"?"确定审核通过吗？":"确定审核不通过吗？";
		var sucInfoStr = tnCheckstatue=="2"?"审核通过成功？":"审核不通过成功？";
		var errInfoStr = tnCheckstatue=="2"?"审核通过失败？":"审核不通过失败？";
		
		swal({
			  title: title,
			  type: 'warning',
			  showCancelButton: true,
		        closeOnConfirm: false,
		        cancelButtonText: "取消",
		        confirmButtonText: "确定",
		        confirmButtonColor: "#ec6c62"
		}).then(function(result){
			  if(result == true) {
				  var json = {
						  tnIds:tnIds,
						  tnCheckstatue:tnCheckstatue
				  };
					ajaxPost('/' + projectName + '/sys/news/checkNewsByTnIds', json).done(function(result){
						if(result.status == 0){
							sucInfo(sucInfoStr);
							initNewsTable();
						}else{
							errInfo(errInfoStr);
						}
					})
			  }
		})
	}
}

