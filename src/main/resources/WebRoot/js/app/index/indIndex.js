$(function(){
    vipspa.start({
        view: '#ui-view',
        router: {
            'all': { // 首页总览
            	templateUrl: 'all.html',
            	controller: '../../js/app/index/all.js'
            },
            'newsList': { // 资讯列表
            	templateUrl: 'newsList.html',
            	controller: '../../js/app/index/newsList.js'
            },
            'newsInfo': { // 资讯详情
            	templateUrl: 'newsInfo.html',
            	controller: '../../js/app/index/newsInfo.js'
            },
            'defaults': 'all' //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


