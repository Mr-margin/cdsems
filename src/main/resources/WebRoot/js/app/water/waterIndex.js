$(function(){
    vipspa.start({
        view: '#ui-view',
        router: {
        	//基础信息
        	 'waterList': { // 基础信息列表
             	templateUrl: 'waterList.html',
             	controller: '../../js/app/water/waterList.js'
             },
             'waterAdd': { // 基础信息添加
              	templateUrl: 'waterAdd.html',
              	controller: '../../js/app/water/waterAdd.js'
              },
             'waterUpdate': { // 基础信息编辑
               	templateUrl: 'waterUpdate.html',
               	controller: '../../js/app/water/waterUpdate.js'
               },
             'waterImport': { // 基础信息导入
                  	templateUrl: 'waterImport.html',
                  	controller: '../../js/app/water/waterImport.js'
               },
               'waterInfor': { // 基础信息
                 	templateUrl: 'waterInfor.html',
                 	controller: '../../js/app/water/waterInfor.js'
              },
            
            'defaults': 'waterList' //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


	