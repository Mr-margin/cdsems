$(function(){
    vipspa.start({
        view: '#ui-view',
        router: {
        	//基础信息
        	 'xxTip': { // 基础信息列表
             	templateUrl: 'xxTip.html',
             	controller: '../../js/app/xxgk/xxTip.js'
             },
            
            'defaults': 'xxTip' //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


	