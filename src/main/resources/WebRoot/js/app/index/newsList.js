var pageSize = 10;

$(function(){
	
	//类型；1：法律法规；2：标准规范；3：系统通知
	var indexType = sessionStorage["indexType"];
	
	//标题修改
	if(indexType=="1"){
		$("#panelTitle").html("法律法规");
	}else if(indexType=="2"){
		$("#panelTitle").html("标准规范");
	}else if(indexType=="3"){
		$("#panelTitle").html("系统通知");
	}
	
	if(indexType=="1"||indexType=="2"){
		//获取法律法规与标准规范
		getTbNews(indexType);
	}else if(indexType=="3"){
		//获取系统通知
		getTbMessage();
	}
})



//获取法律法规与标准规范数据
function getTbNews(indexType){
	var json = {
			"tnType" : indexType,
			pageSize:pageSize,//每页条数
			pageNumber:0//开始索引
	};
	ajaxPost('/' + projectName + '/index/getNewsListByType',json).done(function(result){
		if(result.rows && result.rows.length>0){
			var data = result.rows;
			addNewsToHtml(data, indexType);
			
			//计算总页数
			var totalPages = Math.ceil(result.total/(pageSize*1.0));
			
			//加载分页插件
			var options = {
	                bootstrapMajorVersion: 3,
	                currentPage: 1,//当前页
	                totalPages: totalPages,//总页数
	                numberofPages: 5,//显示的页数
	                itemTexts: function (type, page, current) { //修改显示文字
	                    switch (type) {
	                        case "first":
	                            return "第一页";
	                        case "prev":
	                            return "上一页";
	                        case "next":
	                            return "下一页";
	                        case "last":
	                            return "最后一页";
	                        case "page":
	                            return page;
	                    }
	                }, onPageClicked: function (event, originalEvent, type, page) { //异步换页
	                	//计算开始索引
	                	var pageNumber = (page-1)*pageSize;
	                	
	                	var json = {
	                			"tnType" : indexType,
	                			pageNumber:pageNumber,
	                			pageSize:pageSize
	                	};
	                	ajaxPost('/' + projectName + '/index/getNewsListByType',json).done(function(result){
	                		if(result.rows){
	                			var data = result.rows;
	                			addNewsToHtml(data, indexType);
	                		}
	                	})
	                    
	                }
	            };//--options end
	            $('#paginator').bootstrapPaginator(options);
		}//--if end
	})//--ajax end
}

function addNewsToHtml(data, indexType){
	var html = "";
	for (var i = 0; i < data.length; i++) {
		var currItem = data[i];
		var currHtml = '<li><a href="javascript:gotoNewsInfoPage('+indexType+','+currItem.tnId+')">'
//		var currHtml = '<li><a href="#newsInfo"   onclick="gotoNewsInfoPage('+indexType+','+currItem.tnId+')">'
			+ '<p>'+currItem.tnTitle+'</p>';
		if(currItem.tnIstop && currItem.tnIstop==1){
			currHtml += '<img src="../../img/news/new_top.png" class="img-responsive new_top pull-left" height="30px">';
		}
		currHtml += '<span>'+currItem.tnPosttime+'</span>'
			+ '</a></li>';
		html += currHtml;
	}
	$("#msgList").html(html);
}

//获取系统通知数据
function getTbMessage(){
	var json = {
			pageSize:pageSize,//每页条数
			pageNumber:0//开始索引
	};
	ajaxPost('/' + projectName + '/index/getMessageListByUserId',json).done(function(result){
		if(result.rows && result.rows.length>0){
			var data = result.rows;
			addMessageToHtml(data);
			
			//计算总页数
			var totalPages = Math.ceil(result.total/(pageSize*1.0));
			
			//加载分页插件
			var options = {
	                bootstrapMajorVersion: 3,
	                currentPage: 1,//当前页
	                totalPages: totalPages,//总页数
	                numberofPages: 5,//显示的页数
	                itemTexts: function (type, page, current) { //修改显示文字
	                    switch (type) {
	                        case "first":
	                            return "第一页";
	                        case "prev":
	                            return "上一页";
	                        case "next":
	                            return "下一页";
	                        case "last":
	                            return "最后一页";
	                        case "page":
	                            return page;
	                    }
	                }, onPageClicked: function (event, originalEvent, type, page) { //异步换页
	                	//计算开始索引
	                	var pageNumber = (page-1)*pageSize;
	                	
	                	var json = {
	                			pageNumber:pageNumber,
	                			pageSize:pageSize
	                	};
	                	ajaxPost('/' + projectName + '/index/getMessageListByUserId',json).done(function(result){
	                		if(result.rows){
	                			var data = result.rows;
	                			addMessageToHtml(data);
	                		}
	                	})
	                    
	                }
	            };//--options end
	            $('#paginator').bootstrapPaginator(options);
		}//--if end
	})//--ajax end
}

function addMessageToHtml(data){
	var html = "";
	for (var i = 0; i < data.length; i++) {
		var currItem = data[i];
		var currHtml = '<li><a href="javascript:gotoNewsInfoPage(3,'+currItem.tmId+')">'
//		var currHtml = '<li><a href="#newsInfo" onclick="gotoNewsInfoPage(3,'+currItem.tmId+')">'
			+ '<p>'+currItem.tmTitle+'</p>'
			+ '<span>'+currItem.tmDeadtime+'</span>'
			+ '</a></li>';
		html += currHtml;
	}
	$("#msgList").html(html);
}

//跳转 到详情页面页面
function gotoNewsInfoPage(indexType, dataID){
	sessionStorage["indexType"] = indexType;
	sessionStorage["dataID"] = dataID;
	window.location.href = "#newsInfo";
}