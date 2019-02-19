
$(function(){
	document.onkeydown=function(e){	//进入登录页面初始化键盘函数
		var keycode=document.all?event.keyCode:e.which; //判断键盘按下后该按键的ANSI字符
		if(keycode==13)login(); //如果为13会触发login()函数
	}
	
	$("#checkCodeImg").click(function(){
		refreshImg();
	})
	
});

function login(){
	var suUsername = $("#suUsername").val();
	var suPassword = $("#suPassword").val();
	var checkCode = $("#checkCode").val();
	if(suUsername == "" || suPassword == ""){
		errInfo("用户名和密码不能为空")
		return;
	}
	if(checkCode == ""){
		errInfo("验证码不能为空")
		return;
	}
	$.ajax({
		url:"sys/user/loginUser",
		type:"post",
		contentType: 'application/json;charset=utf-8',
		dataType:"json",
		data:JSON.stringify({
			"token":"",
			"data":{
				suUsername : suUsername,
				suPassword : suPassword,
				checkCode:checkCode
			}
		}),
		success:function(result){
			if(result.status == 0){
				var data = result.data;
				sessionStorage["user"] = JSON.stringify(result.data);
				sessionStorage["suId"] = data.suId;
				sessionStorage["suLevel"] = data.suLevel;//用户级别
				sessionStorage["suRegioncode"] = data.suRegioncode;//用户行政区划
				sessionStorage["suCompanyname"] = data.suCompanyname;//企业名称
				//将模块权限存入session当中
				if(data.suSysRole){
					sessionStorage["srSmIds"]=data.suSysRole.srSmIds;
				}
				if(data.suSysRole){
					sessionStorage["srSmEles"]=data.suSysRole.srSmEles;
				}
				//将空间数据权限存入session当中
				window.location.href="index.html";
			}else if(result.status == 1005){
				errInfo("验证码错误")
				refreshImg();
			}else{
				errInfo("用户名或密码错误")
				refreshImg();
			}
		}
	})
}

//刷新图片
function refreshImg(){
	$("#checkCodeImg").attr("src","/cdsems/checkCode/getCheckCode.do?rnd="+Math.random());
}
