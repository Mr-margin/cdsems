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
        url: '/cdsems/AgricuturalSoilController/AgricuturalSoilTable',  //请求后台的URL（*）
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
	            field: 'aid',
	            title: '主键',
	            visible: false
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
	            field: 'agricuturalName',
	            title: '农用地名称',
	            align:'center',
	        },
	        {
	            field: 'agricuturalCode',
	            title: '农用地编码',
	            align:'center',
	        },
	        {
	            field: 'agricuturalType',
	            title: '土地利用类型',
	            align:'center',
	        },
	        // {
	        //     field: 'countyCode',
	        //     title: '县区',
	        //     align:'center',
	        // },
	        {
	            field: 'longitude',
	            title: '经度',
	            align:'center',
	        },
	        {
	            field: 'latitude',
	            title: '纬度',
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
	                var e = '<a class="btn btn-origin btn-xs eleNone nyd_update" title="编辑"  onclick="updateData('+index+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="btn btn-danger btn-xs eleNone nyd_detele" title="删除"  onclick="del('+row.aid+')"><i class="fa fa-trash"></i></a> ';
	                //return s+m+e+d;
	                return e+d;
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
 * 添加地块
 */
function Add(){
	window.location.href="#basicAdd";
}
/**
 * 编辑地块
 */
function updateData(index){
	//获取表单数据
	var rows = $("#dataTable").bootstrapTable('getData');
	console.log(rows[index]);
	//将选中行数据存入session当中
	sessionStorage["row"]=JSON.stringify(rows[index]);
	$("#countyCode").val(rows[index].countyCode)
	window.location.href="#basicUpdate";
}

/**
 * 删除地块
 */
//function del(cid){
//	delInfo(cid);
//}
//删除地块
function del(cid){
	var json = {aid:cid};
	swal({
        title: "确认删除",
        text: "删除农用地基础信息时会同时删除与其关联的农用地监测信息数据，确定删除此条数据？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
		  if(result == true) {
			  $.ajax({
					url:'/' + projectName + '/AgricuturalSoilController/deleteAgricuturalSoil',
					type:"post",
					contentType: 'application/json;charset=utf-8',
					dataType:"json",
					data:JSON.stringify({
						"token":"",
						"data":json
					}),
					success:function(data){
						if(data.status == 0){
							sucInfo("删除成功！");
							initTable();
						}else{
							errInfo(data.msg);
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


/**
 * 批量删除地块
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
        text: "删除农用地基础信息时会同时删除与其关联的农用地监测信息数据，确定删除选中的数据？",
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
		            arr.push(v.aid)
		        })
		        ajaxPost('/' + projectName + '/AgricuturalSoilController/deleteAgricuturalSoilBatch', {data: arr.join(",")}).done(function (data) {
		            if (data.status == 0) {
		                swal("成功删除选中记录", "", "success");
		                initTable(); 
		            } else {
		                swal("删除记录", "", "error");
		            }
		            
		        });		       
		  }
    })
}


//去批量导入
function impExcel(){
	window.location.href="#basicImport";
}
//去导出
function expExcel(){

	swal({
        title: "确认导出",
        text: "确认导出这些记录？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
		  if(result == true) {
              var url = '/' + projectName + '/AgricuturalSoilController/exportAgricuturalBatch?agricuturalName='+$("#agricuturalName").val()+"&agricuturalType="+$("#agricuturalType").val()+"&countyCode="+$("#countyCode").val();
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
                      swal("成功导出选中记录", "", "success");
                      initTable();
                  } else {
                      swal("导出记录", "", "error");
				  }
              };
              // 发送ajax请求
              xhr.send()
		  }
    })
	//window.location.href = '/' + projectName + '/company/exportExcel';
}
