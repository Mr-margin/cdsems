$(function(){
	//展开收起
	$(".flip").click(function(){
	    $("#collapse").slideToggle("slow");
	    $(".xs1").toggle();
	    $(".xs2").toggle();
	 }); 
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
	var massifName=$("#massifName").val();
	var countyCode=$("#countyCode").val();
	var massifAddress=$("#massifAddress").val();
	var massifCovered=$("#massifCovered").val();
	var massifCovered1=$("#massifCovered1").val();
	var temp = {
			token : '',
			data :{
				pageSize : params.limit,
				pageNumber :  params.offset,
                sortOrder:this.sortOrder,
                massifName:massifName,
                countyCode:countyCode,
                massifAddress:massifAddress,
                massifCovered:massifCovered,
                massifCovered1:massifCovered1
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
            myPermission();
        },
		 columns: [
		     {
	        	checkbox: true,
	        	align:'center',
	        },
	        {
	            field: 'cid',
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
	            field: 'massifName',
	            title: '地块名称',
	            align:'center',
	        },
	        {
	            field: 'massifCode',
	            title: '地块编码',
	            align:'center',
	        },
	        {
	            field: 'massifStage',
	            title: '所处阶段',
	            align:'center',
	            // formatter: function (value, row, index) {
		        	// if(value != null){
		        	// 	switch (value) {
					// 		case "S0":
					// 			return "疑似地块";
					// 			break;
					// 		case "S1":
					// 			return "初步调查";
					// 			break;
					// 		case "S2":
					// 			return "详细调查";
					// 			break;
					// 		case "S3":
					// 			return "风险评估";
					// 			break;
					// 		case "S4":
					// 			return "风险管控";
					// 			break;
					// 		case "S5":
					// 			return "土壤修复与治理";
					// 			break;
					// 		case "S6":
					// 			return "土壤修复与治理评估";
					// 			break;
					//
					// 		default:
					// 			return "";
					// 			break;
					// 	}
		        	// }
	            // }
	        },
	        {
	            field: '',
	            title: '操作',
	            align:'center',
	            width:'80',
	            formatter:function(value,row,index){
	                var s = '<a class="btn btn-warning btn-xs" ><i class="fa fa-file-text-o"></i></a> ';
	                var m = '<a class="btn btn-info btn-xs"  style="font-size:14px"><i class="fa fa-map-marker"></i></a> ';
	                var e = '<a class="btn btn-origin btn-xs jbxx_update eleNone" title="编辑"  onclick="updateDk('+index+')"><i class="fa fa-pencil-square-o"></i></a> ';
	                var d = '<a class="btn btn-danger btn-xs jbxx_detele eleNone" title="删除"  onclick="delDk('+row.cid+')"><i class="fa fa-trash"></i></a> ';
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
function addDk(){
	window.location.href="#wrAdd";
}
/**
 * 编辑地块
 */
function updateDk(index){
	//获取表单数据
	var rows = $("#dataTable").bootstrapTable('getData');
	console.log(rows[index]);
	//将选中行数据存入session当中
	sessionStorage["row"]=JSON.stringify(rows[index]);
	window.location.href="#wrUpdate";
}

/**
 * 删除地块
 */
function delDk(cid){
    delData(cid);
}
//删除地块
function delData(cid){
	var json = {cid:cid};
    swal({
        title: "确认删除",
        text: "删除污染地块基础信息时会同时删除与其关联的初步调查、详细调查、风险评估、风险管控、治理修复、效果评估的数据，确定删除此条数据？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
        if(result == true) {
            $.ajax({
                url:'/' + projectName + '/ContaminatedLandController/deleteContaminatedLand',
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
function deleteDk() {
	//获取所有被选中的记录
    var rows = $("#dataTable").bootstrapTable('getSelections');
    if (rows.length== 0) {
    	toastr.warning("请先选择要删除的记录!");
        return;
    }
	swal({
        title: "确认删除",
        text: "删除污染地块基础信息时会同时删除与其关联的初步调查、详细调查、风险评估、风险管控、治理修复、效果评估的数据，确定删除选中的数据？",
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
		            arr.push(v.cid)
		        })
		        ajaxPost('/' + projectName + '/ContaminatedLandController/deleteContaminatedLandBatch', {data: arr.join(",")}).done(function (data) {
		            if (data.status == 0) {
		                swal("成功删除选中污染地块", "", "success");
		                initTable(); 
		            } else {
		                swal("删除污染地块", "", "error");
		            }
		            
		        });		       
		  }
    })
}


//去批量导入
function impExcel(){
	window.location.href="#wrImport";
}
//去导出
function expExcel(){
	swal({
        title: "确认导出",
        text: "确认导出这些污染地块？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }).then(function(result){
		  if(result == true) {
              var url = '/' + projectName + '/ContaminatedLandController/exportContanminatedBatch?massifName='+$("#massifName").val()+"&countyCode="+$("#countyCode").val()+"&massifAddress="+$("#massifAddress").val()+"&massifCovered="+$("#massifCovered").val()+"&massifCovered1="+$("#massifCovered").val();
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
                          $(a).remove();
                      }
                      swal("成功导出选中污染地块", "", "success");
                      initTable();
                  } else {
                      swal("导出污染地块", "", "error");
				  }
              };
              // 发送ajax请求
              xhr.send()
		  }
    })
	//window.location.href = '/' + projectName + '/company/exportExcel';
}
