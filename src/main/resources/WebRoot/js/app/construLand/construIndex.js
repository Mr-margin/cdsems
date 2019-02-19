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
			if(Id == "jsyd_jc"){
				firstPage="basicList"
			}else if(Id == "jsyd_dc"){
				firstPage="surveyList"
			}
	    });
	}
	
	
    vipspa.start({
        view: '#ui-view',
        router: {
        	//基础信息
        	 'basicList': { // 基础信息列表
             	templateUrl: 'basic/basicList.html',
             	controller: '../../js/app/construLand/basic/basicList.js'
             },
             'basicAdd': { // 基础信息添加
              	templateUrl: 'basic/basicAdd.html',
              	controller: '../../js/app/construLand/basic/basicAdd.js'
              },
             'basicUpdate': { // 基础信息编辑
               	templateUrl: 'basic/basicUpdate.html',
               	controller: '../../js/app/construLand/basic/basicUpdate.js'
               },
             'basicImport': { // 基础信息导入
                  	templateUrl: 'basic/basicImport.html',
                  	controller: '../../js/app/construLand/basic/basicImport.js'
               },
             //调查信息
          	 'surveyList': { // 调查信息列表
               	templateUrl: 'survey/surveyList.html',
               	controller: '../../js/app/construLand/survey/surveyList.js'
               },
           'surveyAdd': { // 调查信息添加
            	templateUrl: 'survey/surveyAdd.html',
            	controller: '../../js/app/construLand/survey/surveyAdd.js'
            },
           'surveyUpdate': { // 调查信息编辑
             	templateUrl: 'survey/surveyUpdate.html',
             	controller: '../../js/app/construLand/survey/surveyUpdate.js'
             },
		           
            'defaults': firstPage //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


	