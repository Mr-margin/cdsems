$(function(){
	//展开收起
	$(".flip").click(function(){
	    $("#collapse").slideToggle("slow");
	    $(".xs1").toggle();
	    $(".xs2").toggle();
	 });
	
	//表格
	initTable();  
})


/**
 * 配置参数
 * @param params
 * @returns {}
 */
function queryParams(params){ 
	var temp = {
			token : '',
			data :{
				pageSize : params.limit,
				pageNumber :  params.offset,
                sortOrder:this.sortOrder,
			}
	};
	return temp;
};
function initTable() {  
    //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/cdsems/ContaminatedLandController/selectContaminatedLand',  //请求后台的URL（*）
        method: 'post',                     //请求方式（*）
        dataType: "json",					//返回数据类型
        toolbar: '#exampleToolbar',         //工具按钮用哪个容器
        striped: true,                    	//是否显示行间隔色
        cache: false,                      	//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        locale:'zh-CN',
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
		onLoadSuccess: function(data){
		},
		 columns: [
		     {
	        	checkbox: true,
	        	align:'center',
	        },
	        {
	            field: '',
	            title: '序号',
	            align:'center',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        },
	        {
	            field: 'cid',
	            title: 'cid',
	            align:'center',
	        },
	        {
	            field: '',
	            title: '操作',
	            align:'center',
	            width:'150',
	            formatter:function(value,row,index){
	                var s = '<a class="btn btn-warning btn-xs" ><i class="iconfont">&#xe619;</i></a> ';
	                var m = '<a class="btn btn-info btn-xs" ><i class="iconfont">&#xe617;</i></a> ';
	                var e = '<a class="btn btn-origin btn-xs"><i class="iconfont">&#xe649;</i></a> ';
	                var d = '<a class="btn btn-danger btn-xs" ><i class="iconfont">&#xe60d;</i></a> ';
	                return s+m+e+d;
	            },
	        }
	        ]
	});	
};	



//条件查询
function search(){
	initTable();
}



function add(){
	window.location.href="#enterpriseAdd";
}