
/**
 * 页面加载
 */
$(function(){
	myPermission();
	//展开收起
	$(".flip").click(function(){
	    $("#collapse").slideToggle("slow");
	    $(".xs1").toggle();
	    $(".xs2").toggle();
	 });
	areaTypeChange();
	initTable();
})

function areaTypeChange(){
	var type = $("#areaType").val();
	if(type==""){
		$("#valType").hide();
	}else{
		$("#valType").show();
	}
}

/**
 * 显示列表
 */
function initTable(){
	 //先销毁表格  
    $('#dataTable').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTable').bootstrapTable({
        url: '/'+projectName+'/companyPolluter/listPage',  //请求后台的URL（*）
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
        onLoadError: function (data) {
        	$("dataTable").bootstrapTable('removeAll');
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
	        	checkbox: true,
	        	align:'center',
	        },{
	            field: 'xh',
	            title: '序号',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        }, {
	            field: 'ID',
	            title: '主键',
	            visible: false
	        },{
	            field: 'COMPANY_NAME',
	            title: '企业名称'
	        },{
	            field: 'LEGAL_PERSON',
	            title: '法定代表人'
	        },{
	            field: 'ORGANIZING_CODE',
	            title: '组织机构代码'
	        },{
	            field: 'ADDRESS',
	            title: '地址'
	        },{
	            field: 'PRODUCTION_AREA',
	            title: '生产区面积'
	        },{
	            field: 'STORAGE_AREA',
	            title: '储存区面积'
	        },{
	            field: 'WATER_TREATMENT_AREA',
	            title: '废水治理区面积'
	        },{
	            field: 'SOLID_DISPOSAL_AREA',
	            title: '固体废物贮存或处置区面积'
	        },{
	            field: 'POLLUTER_AREA',
	            title: '污染区域总面积'
	        },/*{
	            field: 'PRODUCT',
	            title: '主要产品和原料'
	        },{
	            field: 'GAS_TREATMENT',
	            title: '废气排放和处理'
	        },{
	            field: 'WATER_TREATMENT',
	            title: '废水排放和处理'
	        },{
	            field: 'SOLID_TREATMENT',
	            title: '固体废物排放和处理'
	        },{
	            field: 'LEAK',
	            title: '管道或地下设施泄露'
	        },{
	            field: 'ACCIDENT',
	            title: '污染事故'
	        },{
	            field: 'TRACE',
	            title: '污染痕迹'
	        },*/{
	            field: 'todo',
	            title: '操作',
	            width:'80',
	            formatter:function(value,row,index){
	                var e = '<a class="btn btn-origin btn-xs companyPolluter_update eleNone" title="编辑" onclick="update('+index+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="btn btn-danger btn-xs companyPolluter_delete eleNone" title="删除" onclick="del('+row.ID+')"><i class="fa fa-trash"></i></a> ';
	                return e+d;
	            },
	        }]
	});	
}

/**
 * 查询参数
 */
function queryParams(params){ 
	var company_name = $("#company_name").val();
	var organizing_code = $("#organizing_code").val()
	var legal_person = $("#legal_person").val()
	var address = $("#address").val()
	var areaType = $("#areaType").val()
	var minVal = $("#minVal").val()
	var maxVal = $("#maxVal").val()
	var temp = {
		token : '',
		data :{
			pageSize : params.limit,
			pageNumber :  params.offset,
			company_name : company_name,
			organizing_code : organizing_code,
			legal_person:legal_person,
			address:address,
			areaType:areaType,
			minVal:minVal,
			maxVal:maxVal
		}
	};
	return temp;
};

/**
 * 添加
 */
function add(){
	window.location.href="#companyPolluterAdd";
}

/**
 * 编辑
 */
function update(index){
	//获取表单数据
	var rows = $("#dataTable").bootstrapTable('getData');
	console.log(rows[index]);
	//将选中行数据存入session当中
	sessionStorage["row"]=JSON.stringify(rows[index]);
	window.location.href="#companyPolluterUpdate";
}

/**
 * 删除
 */
function del(id){
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
					url:'/' + projectName + '/companyPolluter/delete',
					type:"post",
					contentType: 'application/json;charset=utf-8',
					dataType:"json",
					data:JSON.stringify({
						"token":"",
						"data":{id:id}
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

//批量删除
function delBatch(){
	var ids="";
	//获取选中行表格数据
	var rows = $("#dataTable").bootstrapTable('getSelections');
	if(rows.length>0){
		for(var i=0;i<rows.length;i++){
			if(ids==""){
				ids=rows[i].ID;
			}else{
				ids+=","+rows[i].ID;
			}
		}
	}else{
		errInfo("没有选中的数据");
		return;
	}
	swal({
        title: "确认删除",
        text: "确定删除选中的数据？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
		  if(result == true) {
			  $.ajax({
					url:'/' + projectName + '/companyPolluter/deleteBatch',
					type:"post",
					contentType: 'application/json;charset=utf-8',
					dataType:"json",
					data:JSON.stringify({
						"token":"",
						"data":{ids:ids}
					}),
					success:function(data){
						if(data.status == 0){
							sucInfo("批量删除成功！");
							initTable();
						}else{
							errInfo(data.msg);
						}
					}
				});
		  }
    })
	
}
//去批量导入
function impExcel(){
	window.location.href="#companyPolluterImport";
}
//去导出
function expExcel(){
	var company_name = $("#company_name").val();
	var organizing_code = $("#organizing_code").val()
	var legal_person = $("#legal_person").val()
	var address = $("#address").val()
	var areaType = $("#areaType").val()
	var minVal = $("#minVal").val()
	var maxVal = $("#maxVal").val()
	var url = '/' + projectName + '/companyPolluter/exportExcel'
		+'?company_name='+company_name+'&organizing_code='+organizing_code+'&legal_person='+legal_person+'&address='+address+'&areaType='+areaType+'&minVal='+minVal+'&maxVal='+maxVal;
	swal({
        title: "确认导出",
        text: "确定导出选中的数据？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
		  if(result == true) {
              var xhr = new XMLHttpRequest();
              xhr.open('GET', url, true);
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
                          $(a).remove();
                      }
                      swal("成功导出选中数据", "", "success");
                      initTable();
                  } else {
                      swal("导出失败", "", "error");
				  }
              };
              // 发送ajax请求
              xhr.send();
		  }
    })
}
