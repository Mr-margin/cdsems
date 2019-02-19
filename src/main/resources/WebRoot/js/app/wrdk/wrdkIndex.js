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
			if(Id == "wrdk_jcxx"){
				firstPage="wrList"
			}else if(Id == "wrdk_cbdc"){
				firstPage="preInvestList"
			}else if(Id == "wrdk_xxdc"){
				firstPage="deInvestList"
			}else if(Id == "wrdk_fxpg"){
				firstPage="evalList"
			}else if(Id == "wrdk_fxgk"){
				firstPage="controlList"
			}else if(Id == "wrdk_zlxf"){
				firstPage="repairList"
			}else if(Id == "wrdk_xgpg"){
				firstPage="effectList"
			}
	    });
	}
	
	
	
    vipspa.start({
        view: '#ui-view',
        router: {
        	//污染地块
        	 'wrList': { // 污染地块列表
             	templateUrl: 'wr/wrList.html',
             	controller: '../../js/app/wrdk/wr/wrList.js'
             },
             'wrAdd': { // 污染地块添加
              	templateUrl: 'wr/wrAdd.html',
              	controller: '../../js/app/wrdk/wr/wrAdd.js'
              },
              'wrUpdate': { // 污染地块编辑
               	templateUrl: 'wr/wrUpdate.html',
               	controller: '../../js/app/wrdk/wr/wrUpdate.js'
               },
               'wrImport': { // 污染地块导入
                  	templateUrl: 'wr/wrImport.html',
                  	controller: '../../js/app/wrdk/wr/wrImport.js'
                  },
             //初步调查
	          'preInvestList': { // 初步调查列表
	           	templateUrl: 'preInvestigation/preInvestList.html',
	           	controller: '../../js/app/wrdk/preInvestigation/preInvestList.js'
	           },
	           'preInvestAdd': { //初步调查添加
	            	templateUrl: 'preInvestigation/preInvestAdd.html',
	            	controller: '../../js/app/wrdk/preInvestigation/preInvestAdd.js'
	           },
	           'preInvestUpdate': { // 初步调查编辑
	             	templateUrl: 'preInvestigation/preInvestUpdate.html',
	             	controller: '../../js/app/wrdk/preInvestigation/preInvestUpdate.js'
	           },
	          //详细调查
	           'deInvestList': { // 详细调查列表
		           	templateUrl: 'deInvestigation/deInvestList.html',
		           	controller: '../../js/app/wrdk/deInvestigation/deInvestList.js'
	           },
	           'deInvestAdd': { //详细调查添加
	            	templateUrl: 'deInvestigation/deInvestAdd.html',
	            	controller: '../../js/app/wrdk/deInvestigation/deInvestAdd.js'
	           },
	           'deInvestUpdate': { // 详细调查编辑
	             	templateUrl: 'deInvestigation/deInvestUpdate.html',
	             	controller: '../../js/app/wrdk/deInvestigation/deInvestUpdate.js'
	           },
	          
		          //风险评估
		           'evalList': { // 风险评估列表
			           	templateUrl: 'evaluation/evalList.html',
			           	controller: '../../js/app/wrdk/evaluation/evalList.js'
		           },
		           'evalAdd': { //风险评估添加
		            	templateUrl: 'evaluation/evalAdd.html',
		            	controller: '../../js/app/wrdk/evaluation/evalAdd.js'
		           },
		           'evalUpdate': { //风险评估编辑
		             	templateUrl: 'evaluation/evalUpdate.html',
		             	controller: '../../js/app/wrdk/evaluation/evalUpdate.js'
		           },
		          
		          //风险管控
		           'controlList': { // 风险管控列表
			           	templateUrl: 'riskControl/controlList.html',
			           	controller: '../../js/app/wrdk/riskControl/controlList.js'
		           },
		           'controlAdd': { //风险管控添加
		            	templateUrl: 'riskControl/controlAdd.html',
		            	controller: '../../js/app/wrdk/riskControl/controlAdd.js'
		           },
		           'controlUpdate': { //风险管控编辑
		             	templateUrl: 'riskControl/controlUpdate.html',
		             	controller: '../../js/app/wrdk/riskControl/controlUpdate.js'
		           },
		          
		          //治理修复
		           'repairList': { // 治理修复列表
			           	templateUrl: 'govRepair/repairList.html',
			           	controller: '../../js/app/wrdk/govRepair/repairList.js'
		           },
		           'repairAdd': { //治理修复添加
		            	templateUrl: 'govRepair/repairAdd.html',
		            	controller: '../../js/app/wrdk/govRepair/repairAdd.js'
		           },
		           'repairUpdate': { //治理修复编辑
		             	templateUrl: 'govRepair/repairUpdate.html',
		             	controller: '../../js/app/wrdk/govRepair/repairUpdate.js'
		           },
		          
		          //治理修复
		           'effectList': { // 治理修复列表
			           	templateUrl: 'effect/effectList.html',
			           	controller: '../../js/app/wrdk/effect/effectList.js'
		           },
		           'effectAdd': { //治理修复添加
		            	templateUrl: 'effect/effectAdd.html',
		            	controller: '../../js/app/wrdk/effect/effectAdd.js'
		           },
		           'effectUpdate': { //治理修复编辑
		             	templateUrl: 'effect/effectUpdate.html',
		             	controller: '../../js/app/wrdk/effect/effectUpdate.js'
		           },
		           
            'defaults': firstPage//默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


	