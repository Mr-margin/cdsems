$(function(){
	//展开收起
	$(".flip").click(function(){
	    $("#collapse").slideToggle("slow");
	    $(".xs1").toggle();
	    $(".xs2").toggle();
	 });
	//表格
	getyqinfor();  
	dataTablesinfor();
})

/**
 * 配置参数
 * @param params
 * @returns {}
 */
function queryParams(params){ 
	var id = sessionStorage["id"];
	var temp = {
			token : '',
			data :{
				id:id
			}
	};
	return temp;
};
//获取要修改的监测表原数据
function dataTablesinfor() { 
	var id = sessionStorage["id"];
	var temp = {
		token : '',
		data :{
			id:id
		}
	};
	let $table = $('#dataTableOfwater');
    let $button = $('#inforbuttonOfwater');
    let $getTableData = $('#getTableDataOfwater');
	
    //先销毁表格  
    $('#dataTablesinfor').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTablesinfor').bootstrapTable({
        url: '/cdsems/CompanyWaterMonitorController/SelectWaterMonitorsList',  //请求后台的URL（*）
        method: 'post',                     //请求方式（*）
        dataType: "json",					//返回数据类型
        toolbar: '#toolbar',         //工具按钮用哪个容器
        striped: true,                    	//是否显示行间隔色
        cache: false,                      	//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        locale:'zh-CN',
        pagination: false,                  	//是否显示分页（*）        
        ajaxOptions: {async: false, timeout: 10000},
        sortOrder: "desc",                  //排序方式
        clickToSelect : false,				// 点击行即可选中单选/复选框
        queryParams: temp,			//传递参数（*）
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
		},
		 columns: [
		    
	        {
	            title: '序号',
	            align:'center',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        },
	        {
	        	field: 'UPLOAD_TIME',
	        	title: '监测时间',
	        	align:'center',
	        },
	        {
	            field: 'THE_TOTAL_CHROMIUM',
	            title: '总铬',
	            align:'center',
	        },
	        {
	            field: 'CADMIUM',
	            title: '镉',
	            align:'center',
	        },
	        {
	        	field: 'MERCURY',
	        	title: '汞',
	        	align:'center',
	        },
	        {
	        	field: 'ARSENIC',
	        	title: '砷',
	        	align:'center',
	        },
	        {
	        	field: 'LEAD',
	        	title: '铅',
	        	align:'center',
	        },
	        {
	        	field: 'NICKEL',
	        	title: '镍',
	        	align:'center',
	        },
	        {
	        	field: 'COPPER',
	        	title: '铜',
	        	align:'center',
	        },
	        {
	            field: 'ID',
	            title: '主键',
	            visible: false
	        }	
	        ],
	});	
    let rowIdx = 0;
    $button.click(function() {
    	$table.bootstrapTable('insertRow', {
            index: rowIdx ++,
            row: {
            	ID: '',
            	WATER_ID: '',
            	UPLOAD_TIME: '',
            	THE_TOTAL_CHROMIUM: '',
            	CADMIUM: '',
            	MERCURY: '',
            	ARSENIC: '',
            	LEAD: '',
            	NICKEL: '',
            	COPPER: ''
            }
        });
    });
    $getTableData.click(function() {
        /*alert(JSON.stringify($table.bootstrapTable('getData')));*/
    });
    function saveData(index, field, value) {
    	$table.bootstrapTable('updateCell', {
            index: index,       //行索引
            field: field,       //列名
            value: value        //cell值
        })
    }
};

//删除工业园区
function delyqInfor(id){
	var json = {id:id};
	ajaxPost('/' + projectName + '/CompanyParkManagementController/DelParkPollutantList', json).done(function(result){
		if(result.status == 0){
			sucInfo("删除成功！");
			initTable();
		}else{
			errInfo("删除失败！");
		}
		initTable();
	})
}

/**
 * 添加
 */

function updateInfor(){
	var parkManag = $('#dataTables').bootstrapTable('getData');
	var id = sessionStorage["id"];
	
	if($("#dataForm").valid()){

		$.ajax({
			url: '/' + projectName + '/CompanyParkManagementController/updaPolluterInfor',
			type:"post",
			contentType: 'application/json;charset=utf-8',
			dataType:"json",
			data:JSON.stringify({
				"token":"",
				"data":{
					"id":id,
					"parkManag":parkManag
				}
			}),
			success:function(data){
				if(data.status == '0'){
					sucInfo("添加成功！");
					window.location.href = "#waterList";
				}else{
					errInfo(data.msg);
				}
			}
		});
	}
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
//获取要修改的原数据
function getyqinfor(){
	var id = sessionStorage["id"];
	var json = {"id" : id};
	ajaxPost('/' + projectName + '/CompanyWaterMonitorController/SelectWaterMonitorList',json).done(function(result){
		if(result.status == 0){
			
			var data = result.data;
			$("#COUNTY_NAME").val(data.rows[0].COUNTY_NAME);
			$("#WATER_SOURCE_NAME").val(data.rows[0].WATER_SOURCE_NAME);
			$("#WATER_SOURCE_CODE").val(data.rows[0].WATER_SOURCE_CODE);
			$("#WATER_SOURCE_TYPE").val(data.rows[0].WATER_SOURCE_TYPE);
		}
	})
}

/**
 * 取消
 */
function back(){
	window.location.href = "#waterList";
}