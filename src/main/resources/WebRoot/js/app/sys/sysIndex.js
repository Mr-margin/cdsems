$(function(){
	var firstPage;
	//权限控制
	myPermission();
	listControl()
	function listControl(){
		$.each($(".sysList li:visible"), function(i, item) {
			$(this).addClass("visibles");
		})
		$(".visibles").eq(0).css("paddingTop","0")
		$.each($(".visibles"), function(i, item) {
			var Id=$(".visibles").eq(0).attr("id");
			if(Id == "sys_message"){
				firstPage="messageList"
			}else if(Id == "sys_news"){
				firstPage="newsList"
			}else if(Id == "sys_user"){
				firstPage="userList"
			}else if(Id == "sys_role"){
				firstPage="roleList"
			}else if(Id == "sys_log"){
				firstPage="logList"
			}
	    });
	}
	
    vipspa.start({
        view: '#ui-view',
        router: {
        	 'userList': { // 用户列表
             	templateUrl: 'user/userList.html',
             	controller: '../../js/app/sys/user/userList.js'
             },
             'userAdd': { // 用户添加
             	templateUrl: 'user/userAdd.html',
             	controller: '../../js/app/sys/user/userAdd.js'
             },
             'userUpdate': { // 用户更新
             	templateUrl: 'user/userUpdate.html',
             	controller: '../../js/app/sys/user/userUpdate.js'
             },
             'roleList': { // 角色列表
             	templateUrl: 'role/roleList.html',
             	controller: '../../js/app/sys/role/roleList.js'
             },
             'roleAdd': { // 角色添加
             	templateUrl: 'role/roleAdd.html',
             	controller: '../../js/app/sys/role/roleAdd.js'
             },
             'roleUpdate': { // 角色更新
             	templateUrl: 'role/roleUpdate.html',
             	controller: '../../js/app/sys/role/roleUpdate.js'
             },
             'logList': { // 日志列表
             	templateUrl: 'log/logList.html',
             	controller: '../../js/app/sys/log/logList.js'
             },
             'newsList': { // 新闻列表
             	templateUrl: 'news/newsList.html',
             	controller: '../../js/app/sys/news/newsList.js'
             },
             'newsAdd': { // 新闻添加
             	templateUrl: 'news/newsAdd.html',
             	controller: '../../js/app/sys/news/newsAdd.js'
             },
             'newsUpdate': { // 新闻更新
             	templateUrl: 'news/newsUpdate.html',
             	controller: '../../js/app/sys/news/newsUpdate.js'
             },
             'newsCheck': { // 新闻审核
              	templateUrl: 'news/newsCheck.html',
              	controller: '../../js/app/sys/news/newsCheck.js'
              },
              'messageList': { // 系统通知列表
               	templateUrl: 'message/messageList.html',
               	controller: '../../js/app/sys/message/messageList.js'
               },
               'messageAdd': { // 系统通知添加
               	templateUrl: 'message/messageAdd.html',
               	controller: '../../js/app/sys/message/messageAdd.js'
               },
               'messageUpdate': { // 系统通知更新
               	templateUrl: 'message/messageUpdate.html',
               	controller: '../../js/app/sys/message/messageUpdate.js'
               },
           

            'defaults': firstPage //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})

////存储路由
//var storage = window.sessionStorage;
//
//$("#Menus li").click(function(){
//	$(this).addClass("active").siblings("#Menus li").removeClass("active")	
//	
//	//存储路由
//	storage.setItem('route',$(this).children().attr('href'));
//	//存储index
//	storage.setItem('mIndex',$(this).index());
//})
//console.log(storage.getItem('route'))
////刷新页面后显示路由
//window.location.href = storage.getItem('route');

//判断模块出现页面不同
//var mIndex;
//mIndex = storage.getItem('mIndex');
//function active(){
//	$('#Menus li').removeClass("active");
//	$('#Menus li').eq(mIndex).addClass("active")
//}
//active()

