$(function(){
    vipspa.start({
        view: '#ui-view',
        router: {
            'information': { // 一张图
            	templateUrl: 'information.html',
            	controller: '../../js/app/information/information.js'
            },
            'defaults': 'information' //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


