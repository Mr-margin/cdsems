$(function(){
	initBaseData();
	//加载县
	getSuCountyRegion();
	//获取session中预存的用户表格行数据，并转化为json格式
	getyqinfor();
	selectWaterMonitorInfor();
	//初始化验证表单
	$("#dataForm").validate({
		focusInvalid : true,
	    errorPlacement:function(error,element){
            element.tooltip({
                title:error.text()
            }).parent().addClass("has-errors");
        },
        onfocusout: function (element) {
        	$(element).tooltip('destroy');
            $(element).parent().removeClass('has-errors');  
            this.element(element);  
        }  
	});
    
})

function initBaseData(){
	$('.mydatetime').datetimepicker({
		language:  'zh-CN',  //日期
		minView : "2",//最精确的视图，day
		autoclose : true,
		format : "yyyy-mm-dd",
		pickerPosition:'top-right'
	});
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

//获取要修改的监测表原数据
function selectWaterMonitorInfor() { 
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
    $('#dataTableOfwater').bootstrapTable('destroy');  
    //初始化表格,动态从服务器加载数据  
    $('#dataTableOfwater').bootstrapTable({
        url: '/' + projectName + '/CompanyWaterMonitorController/SelectWaterMonitorsList',  //请求后台的URL（*）
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
	        	formatter: function (value, row, index) { 
	        		if(value=='' || value==null || value== undefined){
	        			var date = new Date()
	        			value = date.format("yyyy-MM-dd");
	        		}
	        		return value;
	        	},
        	    editable: {
                	type: 'date',
               		title: '监测时间',
                },
	        },
	        {
	            field: 'THE_TOTAL_CHROMIUM',
	            title: '总铬',
	            align:'center',
	            editable: {
                    type: 'text',
                    title: '总铬',
                    validate: function (v) {
                        if (isNaN(v)) return '总铬必须是数字';
                        if (v < 0) return '总铬必须大于等于0';
                    }
                }
	        },
	        {
	            field: 'CADMIUM',
	            title: '镉',
	            align:'center',
	            editable: {
                    type: 'text',
                    title: '镉',
                    validate: function (v) {
                        if (isNaN(v)) return '镉必须是数字';
                        if (v < 0) return '镉必须大于等于0';
                    }
                }
	        },
	        {
	        	field: 'MERCURY',
	        	title: '汞',
	        	align:'center',
	        	editable: {
                    type: 'text',
                    title: '汞',
                    validate: function (v) {
                        if (isNaN(v)) return '汞必须是数字';
                        if (v < 0) return '汞必须大于等于0';
                    }
                }
	        },
	        {
	        	field: 'ARSENIC',
	        	title: '砷',
	        	align:'center',
	        	editable: {
                    type: 'text',
                    title: '砷',
                    validate: function (v) {
                        if (isNaN(v)) return '砷必须是数字';
                        if (v < 0) return '砷必须大于等于0';
                    }
                }
	        },
	        {
	        	field: 'LEAD',
	        	title: '铅',
	        	align:'center',
	        	editable: {
                    type: 'text',
                    title: '铅',
                    validate: function (v) {
                        if (isNaN(v)) return '铅必须是数字';
                        if (v < 0) return '铅必须大于等于0';
                    }
                }
	        },
	        {
	        	field: 'NICKEL',
	        	title: '镍',
	        	align:'center',
	        	editable: {
                    type: 'text',
                    title: '镍',
                    validate: function (v) {
                        if (isNaN(v)) return '镍必须是数字';
                        if (v < 0) return '镍必须大于等于0';
                    }
                }
	        },
	        {
	        	field: 'COPPER',
	        	title: '铜',
	        	align:'center',
	        	editable: {
                    type: 'text',
                    title: '铜',
                    validate: function (v) {
                        if (isNaN(v)) return '铜必须是数字';
                        if (v < 0) return '铜必须大于等于0';
                    }
                }
	        },
	        {
	            field: '',
	            title: '操作',
	            align:'center',
	            width:'80',
	            formatter:function(value,row,index){
	                var d = '<a class="btn btn-danger btn-xs" title="删除"  onclick="delyqInfor('+row.ID+')"><i class="fa fa-trash"></i></a> ';
	                return d;
	            },
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
					url:'/' + projectName + '/CompanyWaterMonitorController/DelWaterMonitorList',
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
							getyqinfor();
							selectWaterMonitorInfor();
						}else{
							errInfo("删除失败！");
						}
					}
				});
		  }
    })
}
/**
 * 添加
 */
function updatewater(){
	if($("#dataForm").valid()){
		var json =$("#dataForm").serializeObject();

		json["id"]=sessionStorage["id"];
		json["waterSource"]=$('#dataTableOfwater').bootstrapTable('getData');
		
		
		if($("#WATER_SOURCE_NAME").val() == "" || $("#WATER_SOURCE_NAME").val() == null || $("#WATER_SOURCE_NAME").val() == undefined){ // "",null,undefined
			$('#watertabelId .WATER_SOURCE_NAME').text('饮用水源地名称不能为空').show().fadeOut(5000);
	        return;
	    }
		if($("#WATER_SOURCE_TYPE").val() == "" || $("#WATER_SOURCE_TYPE").val() == null || $("#WATER_SOURCE_TYPE").val() == undefined){ // "",null,undefined
			$('#watertabelId .WATER_SOURCE_TYPE').text('饮用水源地类型不能为空').show().fadeOut(5000);
			return;
		}
		
		
		json["countyCode"]=$("#countyCode").val();
		json["waterSourceName"]=$("#WATER_SOURCE_NAME").val();
		json["waterSourceCode"]=$("#WATER_SOURCE_CODE").val();
		json["waterSourceType"]=$("#WATER_SOURCE_TYPE").val();
		
		
		ajaxPost('/' + projectName + '/CompanyWaterMonitorController/updaPolluterInfor',json).done(function(result){
			if(result.status == 0){
				sucInfo("编辑成功！");
				window.location.href = "#waterList";
			}else{
				errInfo("编辑失败！");
			}
		});
	}else{
		if($('#massifCode').val() == ''){
			errInfo("地块编码不能为空！");
		}
  			
	}
}



/**
 * 添加
 */
function updateyq(){
	if($("#dataForm").valid()){
		var id = sessionStorage["id"];
		var parkName = $("#PARK_NAME").val();
		var parkArea = $("#AREA").val();
		var parkAddress = $("#ADDRESS").val();
		var traffic = $("#TRAFFIC").val();
		var infrastructure = $("#INFRASTRUCTURE").val();
		var advantage = $("#ADVANTAGE").val();
		var countactName = $("#CONTACT_NAME").val();
		var countactPhone = $("#CONTACT_PHONE").val();

		$.ajax({
			url: '/' + projectName + '/CompanyWaterMonitorController/updateparkManagInfor',
			type:"post",
			contentType: 'application/json;charset=utf-8',
			dataType:"json",
			data:JSON.stringify({
				"token":"",
				"data":{
					"id":id,
					"parkName":parkName,
					"area":parkArea,
					"address":parkAddress,
					"traffic":traffic,
					"infrastructure":infrastructure,
					"advantage":advantage,
					"contactName":countactName,
					"contactPhone":countactPhone
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
 * 取消
 */
function back(){
	window.location.href = "#waterList";
}
