//定义serializeObject方法，序列化表单
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
/**
 * 页面加载
 */
$(function(){
	initBaseData()
	//
	addtPoullinfor222();
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
 * 配置参数
 * @param params
 * @returns {}
 */
function queryParams(params){ 
	var temp = {
			token : '',
			data :{
				id:''
			}
	};
	return temp;
};

function addtPoullinfor222() {  
    
	let $table = $('#dataTablessOfwater');
    let $button = $('#button');
    let $getTableData = $('#getTableData');
	
    
    //先销毁表格  
    $table.bootstrapTable('destroy');  
    
    //初始化表格,动态从服务器加载数据  
    $table.bootstrapTable({
        url: '/cdsems/CompanyParkManagementController/SelectParkPollutantsList',  //请求后台的URL（*）
        method: 'post',                     //请求方式（*）
        dataType: "json",					//返回数据类型
        toolbar: '#toolbar',
//        toolbar: '#exampleToolbar',         //工具按钮用哪个容器
        striped: true,                    	//是否显示行间隔色
        cache: false,                      	//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        locale:'zh-CN',
        pagination: false,                  	//是否显示分页（*）        
        ajaxOptions: {async: false, timeout: 10000},
        sortOrder: "desc",                  //排序方式
        clickToSelect : false,				// 点击行即可选中单选/复选框
        queryParams: queryParams,			//传递参数（*）
       /* pageSize: 10,						//页面大小 每页显示条数
        pageNumber: 1,  					//初始化加载第一页，默认第一页
        pageList: [10],		//设置表格每页显示的记录      
*/        showToggle: false,  				//名片格式
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
	        	field: '',
	            title: '序号',
	            align:'center',
	            formatter:function(value,row,index){
	                return index+1;
	            }
	        },
	        {
	        	field: 'UPLOAD_TIME',
	        	title: '监测时间',
	        	formatter: function (value, row, index) { 
	        		debugger;
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
	        	align:'center',
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
	            title: '操作',
	            align:'center',
	            width:'150',
	            formatter:function(value,row,index){
	                var d = '<a class="btn btn-danger btn-xs" title="删除"  onclick="delInfor('+row.ID+')"><i class="fa fa-trash"></i></a> ';
	                return d;
	            },
	        },
	        {
	            field: 'ID',
	            title: '主键',
	            visible: false
	        },
	        {
	            field: 'PARK_ID',
	            title: '基础信息表主键',
	            visible: false
	        }
	        ],
	});	

    let rowIdx = 0;
    $button.click(function() {
    	$table.bootstrapTable('insertRow', {
            index: rowIdx ++,
            row: {
            	'': '',
            	ID: '',
            	PARK_ID: '',
            	'序号': '',
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
    	/*console.log(JSON.stringify($table.bootstrapTable('getData')));
        alert(JSON.stringify($table.bootstrapTable('getData')));*/
    });
    function saveData(index, field, value) {
    	$table.bootstrapTable('updateCell', {
            index: index,       //行索引
            field: field,       //列名
            value: value        //cell值
        })
    }
};	


/**
 * 添加
 */
function addyq(){
	var parkManag = $('#dataTablessOfwater').bootstrapTable('getData');
	
	if($("#dataForm").valid()){
		var regu = "^[0-9]+\.?[0-9]*$";
		var countyCode = $("#countyCode").val();
		var sourceName = $("#WATER_SOURCE_NAME").val();
		var sourceCode = $("#WATER_SOURCE_CODE").val();
		var sourceType = $("#WATER_SOURCE_TYPE").val();
		
		var re = new RegExp(regu);
		if(sourceName == "" || sourceName == null || sourceName == undefined){ // "",null,undefined
			$('#waterTabelId .WATER_SOURCE_NAME').text('饮用水源地名称不能为空').show().fadeOut(5000);
			return;
		}
		/*if(sourceCode != "" && sourceCode != null && sourceCode != undefined){
		    if (!re.test(sourceCode)) {
		    	$('#waterTabelId .WATER_SOURCE_CODE').text('请填写正确的数字格式！').show().fadeOut(5000);
		        return;
		    }
		}*/
		if(sourceType == "" || sourceType == null || sourceType == undefined){
			$('#waterTabelId .WATER_SOURCE_TYPE').text('请选择饮用水源地类型！').show().fadeOut(5000);
			return;
		}
		$.ajax({
			url: '/' + projectName + '/CompanyWaterMonitorController/saveWaterSourceInfor',
			type:"post",
			contentType: 'application/json;charset=utf-8',
			dataType:"json",
			data:JSON.stringify({
				"token":"",
				"data":{
					"countyCode":countyCode,
					"waterSourceName":sourceName,
					"waterSourceCode":sourceCode,
					"waterSourceType":sourceType,
					"waterSource":parkManag
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
/**
 * 取消
 */
function back(){
	window.location.href = "#waterList";
}
