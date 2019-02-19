$(function(){
    myPermission();
	//表格
	initTable();  
})

/**
 * 配置参数
 * @param params
 * @returns {}
 */
function queryParams(params){
    var agricuturalName=$("#agricuturalName").val();
    var agricuturalType=$("#agricuturalType").val();
    var countyCode=$("#countyCode").val();
    var temp = {
        token : '',
        data :{
            pageSize : params.limit,
            pageNumber :  params.offset,
            sortOrder:this.sortOrder,
            agricuturalName:agricuturalName,
            agricuturalType:agricuturalType,
            countyCode:countyCode,
        }
    };
    return temp;
};
function initTable() {  
    //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/cdsems/AgricuturalSoilController/MonitorSoilTable',  //请求后台的URL（*）
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
            myPermission();
		},
		 columns: [
		     {
	        	checkbox: true,
	        	align:'center',
	        },
	        {
	            field: 'mid',
	            title: '主键',
	            visible: false
	        },
	        {
	            field: 'aid',
	            title: '农用地ID',
	            visible: false
	        },
	        {
	            field: '',
	            title: '序号',
	            align:'center',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        },{
                 field: 'agricuturalName',
                 title: '农用地名称',
                 align:'center',
             },
	        {
	            field: 'sampleType',
	            title: '样品类型',
	            align:'center',
	        },
	        {
	            field: 'samplePointCode',
	            title: '样点编码',
	            align:'center',
	        },
	        {
	            field: 'sampleCode',
	            title: '样品编码',
	            align:'center',
	        },
	        {
	            field: 'ph',
	            title: 'PH',
	            align:'center',
	        },
	        {
	            field: '',
	            title: '操作',
	            align:'center',
	            width:'80',
	            formatter:function(value,row,index){
	                var s = '<a class="btn btn-warning btn-xs" ><i class="fa fa-file-text-o"></i></a> ';
	                var m = '<a class="btn btn-info btn-xs"  style="font-size:14px"><i class="fa fa-map-marker"></i></a> ';
	                var e = '<a class="btn btn-origin btn-xs eleNone nydjc_update" title="编辑"  onclick="Update('+index+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="btn btn-danger btn-xs eleNone nydjc_detele" title="删除"  onclick="del('+row.mid+')"><i class="fa fa-trash"></i></a> ';
	               // return s+m+e+d;
	                return e+d;
	            },
	        }
	        ]
	});	
};	


/**
 * 添加农用地监测数据
 */
function add(){
	window.location.href="#monitorAdd";
}
/**
 * 编辑农用地监测数据
 */
function Update(index){
	//获取表单数据
	var rows = $("#dataTable").bootstrapTable('getData');
	console.log(rows[index]);
	//将选中行数据存入session当中
	sessionStorage["row"]=JSON.stringify(rows[index]);
	window.location.href="#monitorUpdate";
}
/**
 * 删除农用地监测数据
 */
function del(cid){
    delInfo(cid);
}
//删除农用地监测数据
function delData(cid){
	var json = {aid:cid};
	ajaxPost('/' + projectName + '/AgricuturalSoilController/deleteMonitor', json).done(function(result){
		if(result.status == 0){
			sucInfo("删除成功！");
			initTable();
		}else{
			errInfo("删除失败！");
		}
	})
}





/**
 * 批量删除农用地监测数据
 */
function Dele() {
	//获取所有被选中的记录
    var rows = $("#dataTable").bootstrapTable('getSelections');
    if (rows.length== 0) {
    	toastr.warning("请先选择要删除的记录!");
        return;
    }
	swal({
        title: "确认删除",
        text: "确认删除选中的数据？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
		  if(result == true) {
			  //删除数据
			  var arr=[];
		    	$.each(rows, function (i,v) {
		            arr.push(v.mid)
		        })
		        ajaxPost('/' + projectName + '/AgricuturalSoilController/deleteMonitorBatch', {data: arr.join(",")}).done(function (data) {
		            if (data.status == 0) {
		                swal("成功删除选中农用地监测数据", "", "success");
		                initTable(); 
		            } else {
		                swal("删除农用地监测数据", "", "error");
		            }
		            
		        });		       
		  }
    })
}

/**
 * 加载县
 * @param pid
 */
function getSuCountyRegion(){
    ajaxPost('/' + projectName + '/ContaminatedLandController/selectCity').done(function(result){
        if(result.status == 0){
            var html = "";
            var data = result.data;
            console.log(data)
            html += "<option value=''>全部</option>";
            $.each(data,function(index, currItem){
                html += "<option value='"+currItem.TC_CODE+"'>"+currItem.TC_NAME+"</option>";
            })
            $("#countyCode").html(html);
            var countyCode = quanxian();
            if ( countyCode != "" ){
                $("#countyCode").attr("disabled","disabled");
                $("#countyCode").val(countyCode);
            }

        }
    })
}
getSuCountyRegion()
