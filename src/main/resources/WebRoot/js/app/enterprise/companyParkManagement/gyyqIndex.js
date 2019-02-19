$(function(){
    vipspa.start({
        view: '#ui-view',
        router: {
        	 'yqList': { // 工业园区列表
             	templateUrl: 'yq/yqList.html',
             	controller: '../../../js/app/enterprise/companyParkManagement/yq/yqList.js'
             },
             'yqAdd': { // 工业园区添加
              	templateUrl: 'yq/yqAdd.html',
              	controller: '../../../js/app/enterprise/companyParkManagement/yq/yqAdd.js'
              },
              'yqUpdate': { // 工业园区编辑
               	templateUrl: 'yq/yqUpdate.html',
               	controller: '../../../js/app/enterprise/companyParkManagement/yq/yqUpdate.js'
               },
               'yqImport': { // 工业园区导入
	              	templateUrl: 'yq/yqImport.html',
	              	controller: '../../../js/app/enterprise/companyParkManagement/yq/yqImport.js'
               },
               'yqInfor': { // 工业园区导入
            	   templateUrl: 'yq/yqInfor.html',
            	   controller: '../../../js/app/enterprise/companyParkManagement/yq/yqInfor.js'
               },
           

            'defaults': 'yqList' //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处-理加载html模块异常时展示错误内容
        	
    });
    
    
})

