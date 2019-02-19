$(function(){
    vipspa.start({
        view: '#ui-view',
        router: {
        	 'soilRemediationList': { // 信息列表
             	templateUrl: 'soilRemediationList.html',
             	controller: '../../js/app/soilRemediation/soilRemediationList.js'
             },
             'soilRemediationAdd': { // 信息添加
             	templateUrl: 'soilRemediationAdd.html',
             	controller: '../../js/app/soilRemediation/soilRemediationAdd.js'
             },
             'soilRemediationUpdate': { // 信息更新
             	templateUrl: 'soilRemediationUpdate.html',
             	controller: '../../js/app/soilRemediation/soilRemediationUpdate.js'
             },
             'soilRemediationImport': { 
              	templateUrl: 'soilRemediationImport.html',
              	controller: '../../js/app/soilRemediation/soilRemediationImport.js'
             },

            'defaults': 'soilRemediationList' //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


