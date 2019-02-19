$(function(){
	var Height=$(".news").height()-94
	$(".boxings").css("minHeight",Height+'px')
	
	//类型；1：法律法规；2：标准规范；3：系统通知
	var indexType = sessionStorage["indexType"];
	var dataID = sessionStorage["dataID"];
	
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
		getTbNews(dataID);
	}else if(indexType=="3"){
		//获取系统通知
		getTbMessage(dataID);
	}
})



//获取法律法规与标准规范数据
function getTbNews(dataID){
	var json = {
			"tnId" : dataID
	};
	ajaxPost('/' + projectName + '/sys/news/getNewsByID',json).done(function(result){
		if(result.status==0){
			var data = result.data;
			//添加到HTML\
			$(".title").html(data.tnTitle);
			$(".tip1").html(data.tnPosttime);
			if(data.tnSource && data.tnSource!=""){
				$(".tip2").html(data.tnSource);
			}else{
				$(".tip2").hide();
			}
//			$(".tip3").html(data.tnAuthor);
			$(".article").html(data.tnContent);
			//附件
			if(data.tnTbNewsFiles && data.tnTbNewsFiles.length>0&& data.tnTbNewsFiles[0].tnfOldname){
				$("#nwesFile").html("附件：<a href='/"+projectName+""+data.tnTbNewsFiles[0].tnfUrl+"' download>"+data.tnTbNewsFiles[0].tnfOldname+"</a>");
			}
		}
	})
}

//获取系统通知数据
function getTbMessage(dataID){
	var json = {
			tmId:dataID
	};
	ajaxPost('/' + projectName + '/sys/message/getMessageByID',json).done(function(result){
		if(result.status==0){
			var data = result.data;
			//添加到html
			$(".title").html(data.tmTitle);
//			$(".tip1").html(data.tnPosttime);
//			$(".tip2").html(data.tnSource);
//			$(".tip3").html(data.tnAuthor);
			$(".tip").hide();
			$(".article").html(data.tmContent);
		}
	})
}

