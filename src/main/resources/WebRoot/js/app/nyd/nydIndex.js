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
			if(Id == "nyd_jcxx"){
				firstPage="basicList"
			}else if(Id == "nyd_nydjc"){
				firstPage="monitorList"
			}
	    });
	}
    vipspa.start({
        view: '#ui-view',
        router: {
        	//基础信息
        	 'basicList': { // 基础信息列表
             	templateUrl: 'basic/basicList.html',
             	controller: '../../js/app/nyd/basic/basicList.js'
             },
             'basicAdd': { // 基础信息添加
              	templateUrl: 'basic/basicAdd.html',
              	controller: '../../js/app/nyd/basic/basicAdd.js'
              },
             'basicUpdate': { // 基础信息编辑
               	templateUrl: 'basic/basicUpdate.html',
               	controller: '../../js/app/nyd/basic/basicUpdate.js'
               },
             'basicImport': { // 基础信息导入
                  	templateUrl: 'basic/basicImport.html',
                  	controller: '../../js/app/nyd/basic/basicImport.js'
               },
             //监测
          	 'monitorList': { // 监测列表
               	templateUrl: 'monitor/monitorList.html',
               	controller: '../../js/app/nyd/monitor/monitorList.js'
               },
           'monitorAdd': { // 监测添加
            	templateUrl: 'monitor/monitorAdd.html',
            	controller: '../../js/app/nyd/monitor/monitorAdd.js'
            },
           'monitorUpdate': { // 监测编辑
             	templateUrl: 'monitor/monitorUpdate.html',
             	controller: '../../js/app/nyd/monitor/monitorUpdate.js'
             },
		           
            'defaults': firstPage //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


	