/**
 * 变量
 */

/**
 * 页面加载
 */
$(function(){
	
//	myPermission();
	
	//加载基础数据
	initBaseData();
	//表格
	initLogTable();
})

/**
 * 权限控制
 */

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
function initLogTable(){
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	console.log("ddd");
	if(startTime && endTime && startTime>endTime){
		 toastr.error("开始时间不能大于结束时间!");
		 return;
	}
	
	 //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/'+projectName+'/sys/log/list',  //请求后台的URL（*）
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
	            width:'5%',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        }, {
	            field: 'slSysUser',
	            align:'center',
	            title: '操作用户',
	            width:'13%',
	            formatter:function(value,row,index){
	                var result = "";
	                if(value){
	                	result = value["suUsername"];
	                }else{
	                	result = row.slSuId;
	                }
	                return result;
	            },
	        },{
	            field: 'slContent',
	            align:'center',
	            title: '操作内容'
	        },{
	            field: 'slSysLogType.sltName',
	            align:'center',
	            title: '操作类型',
	            width:'13%'
	        },{
	            field: 'slTime',
	            align:'center',
	            title: '操作时间',
	            width:'18%'
	        }]
	});	
}

/**
 * 查询参数
 */
function queryParams(params){ 
	var suUsername = $("#suUsername").val();
	var slSltId = $("#slSltId").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	console.log("ddd");
	var temp = {
			token : '',
			data :{
				pageSize : params.limit,
				pageNumber :  params.offset,
				sortName:this.sortName,
                sortOrder:this.sortOrder,
                suUsername : suUsername,
                slSltId : slSltId,
                startTime : startTime ,
                endTime : endTime ,
			}
	};
	return temp;
};


//跳转到统计页面
function log_statistics(){
	window.location.href = "#log_statistics";
}
