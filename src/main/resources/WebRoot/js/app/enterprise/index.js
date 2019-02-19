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
			if(Id == "company_list"){
				firstPage="companyList"
			}else if(Id == "companyMigration_list"){
				firstPage="companyMigrationList"
			}else if(Id == "companyPolluter_list"){
				firstPage="companyPolluterList"
			}else if(Id == "companyReceptor_list"){
				firstPage="companyReceptorList"
			}else if(Id == "companyMonitor_list"){
				firstPage="companyMonitorList"
			}else if(Id == "companyPollutantMonitor_list"){
				firstPage="companyPollutantMonitorList"
			}
	    });
	}
	
	
    vipspa.start({
        view: '#ui-view',
        router: {
        	 'companyList': { // 企业信息列表
             	templateUrl: 'company/companyList.html',
             	controller: '../../js/app/enterprise/company/companyList.js'
             },
             'companyAdd': { // 企业信息添加
             	templateUrl: 'company/companyAdd.html',
             	controller: '../../js/app/enterprise/company/companyAdd.js'
             },
             'companyUpdate': { // 企业信息更新
             	templateUrl: 'company/companyUpdate.html',
             	controller: '../../js/app/enterprise/company/companyUpdate.js'
             },
             'companyImport': { 
              	templateUrl: 'company/companyImport.html',
              	controller: '../../js/app/enterprise/company/companyImport.js'
              },
             
             'companyMigrationList': { // 企业迁移信息列表
              	templateUrl: 'companyMigration/companyMigrationList.html',
              	controller: '../../js/app/enterprise/companyMigration/companyMigrationList.js'
              },
              'companyMigrationAdd': { // 企业迁移信息添加
              	templateUrl: 'companyMigration/companyMigrationAdd.html',
              	controller: '../../js/app/enterprise/companyMigration/companyMigrationAdd.js'
              },
              'companyMigrationUpdate': { // 企业迁移信息更新
              	templateUrl: 'companyMigration/companyMigrationUpdate.html',
              	controller: '../../js/app/enterprise/companyMigration/companyMigrationUpdate.js'
              },
              'companyMigrationImport': { 
                	templateUrl: 'companyMigration/companyMigrationImport.html',
                	controller: '../../js/app/enterprise/companyMigration/companyMigrationImport.js'
                },
              
              'companyPolluterList': { // 企业污染源信息列表
               	templateUrl: 'companyPolluter/companyPolluterList.html',
               	controller: '../../js/app/enterprise/companyPolluter/companyPolluterList.js'
               },
               'companyPolluterAdd': { // 企业污染源信息添加
               	templateUrl: 'companyPolluter/companyPolluterAdd.html',
               	controller: '../../js/app/enterprise/companyPolluter/companyPolluterAdd.js'
               },
               'companyPolluterUpdate': { // 企业污染源信息更新
               	templateUrl: 'companyPolluter/companyPolluterUpdate.html',
               	controller: '../../js/app/enterprise/companyPolluter/companyPolluterUpdate.js'
               },
               'companyPolluterImport': { 
                 	templateUrl: 'companyPolluter/companyPolluterImport.html',
                 	controller: '../../js/app/enterprise/companyPolluter/companyPolluterImport.js'
                 },
               
               'companyReceptorList': { // 企业敏感受体信息列表
                	templateUrl: 'companyReceptor/companyReceptorList.html',
                	controller: '../../js/app/enterprise/companyReceptor/companyReceptorList.js'
                },
                'companyReceptorAdd': { // 企业敏感受体信息添加
                	templateUrl: 'companyReceptor/companyReceptorAdd.html',
                	controller: '../../js/app/enterprise/companyReceptor/companyReceptorAdd.js'
                },
                'companyReceptorUpdate': { // 企业敏感受体信息更新
                	templateUrl: 'companyReceptor/companyReceptorUpdate.html',
                	controller: '../../js/app/enterprise/companyReceptor/companyReceptorUpdate.js'
                },
                'companyReceptorImport': { 
                  	templateUrl: 'companyReceptor/companyReceptorImport.html',
                  	controller: '../../js/app/enterprise/companyReceptor/companyReceptorImport.js'
                  },
                
                'companyMonitorList': { // 企业自监测数据列表
                 	templateUrl: 'companyMonitor/companyMonitorList.html',
                 	controller: '../../js/app/enterprise/companyMonitor/companyMonitorList.js'
                 },
                 'companyMonitorAdd': { // 企业自监测数据添加
                 	templateUrl: 'companyMonitor/companyMonitorAdd.html',
                 	controller: '../../js/app/enterprise/companyMonitor/companyMonitorAdd.js'
                 },
                 'companyMonitorUpdate': { // 企业自监测数据更新
                 	templateUrl: 'companyMonitor/companyMonitorUpdate.html',
                 	controller: '../../js/app/enterprise/companyMonitor/companyMonitorUpdate.js'
                 },
                 'companyMonitorImport': { 
                   	templateUrl: 'companyMonitor/companyMonitorImport.html',
                   	controller: '../../js/app/enterprise/companyMonitor/companyMonitorImport.js'
                   },
                   
				   'companyPollutantMonitorList': { // 企业特征污染物监测数据列表
					   templateUrl: 'companyPollutantMonitor/companyPollutantMonitorList.html',
					   controller: '../../js/app/enterprise/companyPollutantMonitor/companyPollutantMonitorList.js'
					},
					'companyPollutantMonitorAdd': { // 企业特征污染物监测数据添加
						templateUrl: 'companyPollutantMonitor/companyPollutantMonitorAdd.html',
						controller: '../../js/app/enterprise/companyPollutantMonitor/companyPollutantMonitorAdd.js'
					},
					'companyPollutantMonitorUpdate': { // 企业特征污染物监测数据更新
						templateUrl: 'companyPollutantMonitor/companyPollutantMonitorUpdate.html',
						controller: '../../js/app/enterprise/companyPollutantMonitor/companyPollutantMonitorUpdate.js'
					},
					'companyPollutantMonitorImport': { 
						templateUrl: 'companyPollutantMonitor/companyPollutantMonitorImport.html',
						controller: '../../js/app/enterprise/companyPollutantMonitor/companyPollutantMonitorImport.js'
					},

            'defaults': firstPage //默认路由
        },
        errorTemplateId: '#error',  //可选的错误模板，用来处理加载html模块异常时展示错误内容
        	
    });
    
    
})


