$(function(){
	//权限控制
	myPermission();
	$.each($(".page-header ul li:visible"), function(i, item) {
		$(this).addClass("visibles");
	})
	$.each($(".visibles"), function(i, item) {
		$(".visibles").eq(0).addClass("active")
		var Id=$(".visibles").eq(0).attr("id");
		if(Id == "index"){
			$('#informationIframe').attr('src',"views/index/indIndex.html")
		}else if(Id == "yzt"){
			$('#informationIframe').attr('src',"views/information/infoIndex.html")
		}else if(Id == "wrdk"){
			$('#informationIframe').attr('src',"views/wrdk/wrdkIndex.html")
		}else if(Id == "nyd"){
			$('#informationIframe').attr('src',"views/nyd/nydIndex.html")
		}else if(Id == "company"){
			$('#informationIframe').attr('src',"views/enterprise/index.html")
		}else if(Id == "jsydzr"){
			$('#informationIframe').attr('src',"views/construLand/construIndex.html")
		}else if(Id == "gyyq"){
			$('#informationIframe').attr('src',"views/enterprise/companyParkManagement/yqIndex.html")
		}else if(Id == "yysyd"){
			$('#informationIframe').attr('src',"views/water/waterIndex.html")
		}else if(Id == "soilRemediation_list"){
			$('#informationIframe').attr('src',"views/soilRemediation/index.html")
		}else if(Id == "xxgk"){
			$('#informationIframe').attr('src',"views/xxgk/xxIndex.html")
		}else if(Id == "sys"){
			$('#informationIframe').attr('src',"views/sys/sysIndex.html")
		}
    });
})
//获取屏幕的高度防止底部版权栏到上面去的现象
var allHeight=document.documentElement.clientHeight;
$(".page-container").css("height",(allHeight-202)+'px');
$("#informationIframe").css("height",(allHeight-202)+'px');

var session = window.sessionStorage;
$('.page-header ul li').click(function(){   
	//存储index防止刷新跳回首页
	var xIndex = $(this).index();
    session.setItem('zoo',(xIndex+1));
    
    $(this).addClass('active').siblings('.page-header ul li').removeClass('active')    
     var src = $(this).attr('data_src')
    $('#informationIframe').attr('src',src)
})

//function active(){
//	$('.page-header ul li').removeClass("active");
//	$('.page-header ul li').eq(zoo-1).addClass("active")
//}
//console.log(session.getItem('zoo'))
//// 判断模块出现页面不同
//	var zoo=1;
//     zoo = session.getItem('zoo');
//	if(zoo==1){ 
//		active()
//		$('#informationIframe').attr('src',"views/index/indIndex.html")
//	}else if(zoo == 2){
//		active()
//		$('#informationIframe').attr('src',"views/information/infoIndex.html")
//	}else if(zoo == 3){
//		
//	}else if(zoo == 4){
//		
//	}else if(zoo == 5){
//		
//	}else if(zoo == 6){
//		
//	}else if(zoo == 7){
//		
//	}else if(zoo == 8){
//		
//	}else if(zoo == 9){
//		
//	}else if(zoo == 10){
//		active()
//		$('#informationIframe').attr('src',"views/sys/sysIndex.html")
//	}
//
//


	
	
//显示用户名
function showUserInfo(){
	
}

	
//退出登录
function logout(){
	var json = {};
	ajaxPost('/' + projectName + '/sys/user/loginOut',json).done(function(result){
		if(result.status==0){
//			sucInfo("退出成功");
			//销毁session
			sessionStorage["user"] = "";
			sessionStorage["suId"] = "";
			//将模块权限存入session当中
			sessionStorage["srSmIds"]="";
			sessionStorage["srSmEles"]="";
			window.location.href = "login.html";
		}else{
			errInfo("退出失败");
		}
	})
}

//修改密码
function updateSuPassword(){
	if($("#dataForm").valid()){
		var suId = sessionStorage["suId"];
		var suPassword = $("#suPassword").val();
		var newSuPassword = $("#newSuPassword").val();
		var newSuPassword2 = $("#newSuPassword2").val();
		if(newSuPassword!=newSuPassword2){
			errInfo("两次输入的新密码不一致！");
		}else if(suPassword==newSuPassword){
			errInfo("新密码与旧密码不能相同！");
		}else{
			var json = {
					suId:suId,
					suPassword:suPassword,
					newSuPassword:newSuPassword
			}
			ajaxPost('/' + projectName + '/sys/user/updateSuPassword',json).done(function(result){
				if(result.status == 0){
					sucInfo("修改密码成功！");
					window.location.href = "login.html";
				}else if(result.status == 11){
					errInfo("新密码与旧密码不能相同！");
				}else if(result.status == 1){
					errInfo(result.msg);
				}else{
					errInfo("添加失败！");
				}
			});
		}
	}
}

//获取名称
var roleName=session.getItem('user');
var json = eval('(' + roleName + ')');
$("#roleName").html(json.suRealname)

