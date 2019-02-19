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
	var waterSourceName=$("#WATER_SOURCE_NAME").val();
	var countyCode=$("#countyCode").val();
	var temp = {
			token : '',
			data :{
				pageSize : params.limit,
				pageNumber :  params.offset,
                sortOrder:this.sortOrder,
                waterSourceName:waterSourceName,
                countyCode:countyCode
			}
	};
	return temp;
};
function initTable() {  
    //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/' + projectName + '/CompanyWaterMonitorController/SelectWaterMonitorList',  //请求后台的URL（*）
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
	    responseHandler: function (res) {
	        return res.data
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
	            field: 'ID',
	            title: '主键',
	            visible: false
	        },
	        {
	            title: '序号',
	            align:'center',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        },
	        {
	        	field: 'COUNTY_NAME',
	        	title: '区县',
	        	align:'center',
	        },
	        {
	            field: 'WATER_SOURCE_NAME',
	            title: '水源地名称',
	            align:'center',
	        },
	        {
	            field: 'WATER_SOURCE_CODE',
	            title: '水源地编码',
	            align:'center',
	        },
	        {
	        	field: 'WATER_SOURCE_TYPE',
	        	title: '水源地类型',
	        	align:'center',
	        	formatter:function(value){
	        		if(value == 0){
	        			value = "河流型";
	        		}else if(value == 1){
	        			value = "湖库型";
	        		}else if(value == 2){
	        			value = "地下水型";
	        		}
	                return value;
	            }
	        },
	        {
	            field: '',
	            title: '操作',
	            align:'center',
	            width:'100',
	            formatter:function(value,row,index){ 
	                var s = '<a class="seachwaterinfor btn btn-warning btn-xs eleNone" title="详情"   onclick="selectInfor('+row.ID+')" ><i class="fa fa-file-text-o"></i></a> ';
	                var e = '<a class="updatewaterinfor btn btn-origin btn-xs eleNone" title="编辑"  onclick="updateInfor('+row.ID+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="delwaterinfor btn btn-danger btn-xs eleNone" title="删除"   onclick="delInfor('+row.ID+')"><i class="fa fa-trash"></i></a> ';
	                return s+e+d;
	            },
	        }
	        ]
	});	
};	



//条件查询
function search(){
	initTable();
}


/**
 * 添加饮用水源地
 */
function addyq(){
	window.location.href="#waterAdd";
}
/**
 * 查看饮用水源地
 */
function selectInfor(id){
	//获取表单数据
	//将选中行数据存入session当中
	sessionStorage["id"]=id;
	window.location.href="#waterInfor";
}
/**
 * 编辑饮用水源地
 */
function updateInfor(id){
	//获取表单数据
	//将选中行数据存入session当中
	sessionStorage["id"]=id;
	window.location.href="#waterUpdate";
}
//删除饮用水源地
function delInfor(id){
//	var json = {id:id};
//	ajaxPost('/' + projectName + '/CompanyWaterMonitorController/DelWaterMonitor', json).done(function(result){
//		if(result.status == 0){
//			sucInfo("删除成功！");
//			initTable();
//		}else{
//			errInfo("删除失败！");
//		}
//		initTable();
//	})
	
	swal({
        title: "确认删除",
        text: "确定删除此条数据？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
		  if(result == true) {
			  $.ajax({
					url:'/' + projectName + '/CompanyWaterMonitorController/DelWaterMonitor',
					type:"post",
					contentType: 'application/json;charset=utf-8',
					dataType:"json",
					data:JSON.stringify({
						"token":"",
						"data":{id:id}
					}),
					success:function(data){
						if(data.data.status == 0){
							sucInfo("删除成功！");
							initTable();
						}else{
							errInfo(data.data.msg);
						}
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


//去批量导入
function yqsubmit(){
	window.location.href="#waterImport";
}


//去导出
function yqexpExcel(){
	//获取所有被选中的记录
	var rows = $("#dataTable").bootstrapTable('getSelections');
	/*if (rows.length== 0) {
		toastr.warning("请先选择要导出的记录!");
	    return;
	}*/
	var waterSourceName=$("#WATER_SOURCE_NAME").val();
	var countyCode=$("#countyCode").val();
		swal({
	    title: "确认导出",
	    text: "确认导出选中水源地信息？",
	    type: "warning",
	    showCancelButton: true,
	    closeOnConfirm: false,
	    cancelButtonText: "取消",
	    confirmButtonText: "确定",
	    confirmButtonColor: "#ec6c62"
	}).then(function(result){
			  if(result == true) {
	          var url = '/' + projectName + '/CompanyWaterMonitorController/exportWaterSourceInfor?waterSourceName='+waterSourceName+'&countyCode='+countyCode;
	          var xhr = new XMLHttpRequest();
	          xhr.open('POST', url, true);
	          xhr.responseType = "blob";
	          xhr.onload = function () {
	              // 请求完成
	              if (this.status === 200) {
	                  // 返回200
	                  var blob = this.response;
	                  var reader = new FileReader();
	                  reader.readAsDataURL(blob);    // 转换为base64，可以直接放入a表情href
	                  reader.onload = function (e) {
	                      // 转换完成，创建一个a标签用于下载
	                      var a = document.createElement('a');
	                      var timestamp = Date.parse(new Date());
	                      a.download = timestamp+'.xlsx';
	                      a.href = e.target.result;
	                      $("body").append(a);    // 修复firefox中无法触发click
	                      a.click();
	                      $(a).remove();0
	                  }
	                  swal("成功导出选中水源地信息", "", "success");
	                  initTable();
	              } else {
	                  swal("导出水源地信息", "", "error");
				  }
	          };
	          // 发送ajax请求
	          xhr.send()
			  }
	})
	//window.location.href = '/' + projectName + '/company/exportExcel';
}


/**
 * 批量删除饮用水源地
 */
function deleteALL() {
	//获取所有被选中的记录
    var rows = $("#dataTable").bootstrapTable('getSelections');
    if (rows.length== 0) {
    	toastr.warning("请先选择要删除的记录!");
        return;
    }
	swal({
        title: "确认删除",
        text: "确认删除这些水源地信息？",
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
		            arr.push(v.ID)
		        })
		        ajaxPost('/' + projectName + '/CompanyWaterMonitorController/DelWaterMonitor', {id: arr.join(",")}).done(function (data) {
		        	if (data.status == 0) {
		                swal("成功删除选中水源地信息", "", "success");
		                initTable();
		            } else {
		                swal("删除水源地信息", "", "error");
		            }
		        });		       
		  }
    })
}

function delList(){
      var cks=document.getElementsByName("btSelectItem");
	  var ids=[];
	  for(var i=0;i<cks.length;i++){
		 if(cks[i].checked){
			 ids.push(cks[i].value)
		 }
	  }
	  deleteDk(ids); 
}
function deleteDk(ids){
	var rows = $('#dataTable').bootstrapTable('getSelections');
    if (rows.length < 1) {
        return toastr.warning("请选择水源地");
    }
	swal({
        title: "确认删除",
        text: "确认删除这些水源地信息？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    },function(index){
	$.ajax({
		type: 'POST',
		url: '/' + projectName + '/ContaminatedLandController/deleteContaminatedLandBatch',
		data: {ids : ids},
		success: function(data){
			swal("成功删除选中水源地信息", "", "success");
		},
		error:function(data) {
			swal("删除水源地信息失败", "", "error");
		},
	});		
	initTable();
    });
}

