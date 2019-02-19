var projectName = "cdsems";

//富文本编辑器对象
var ue = null;

	
	
	
//window.history.go(1);
var ip = "192.168.1.24";
function ajaxPost(url, parameter) {
    var parameterPar = {
        "token": "",
        "data": parameter
    };
    return $.ajax(url, {
        type: "POST",
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(parameterPar),
        xhrFields: {
            withCredentials: true
        },
        dataFilter: function (data, type) {
            if (checkState(data)) {
                return data;
            }
        },
        crossDomain: true,
    })
}

function ajaxPost2(url, parameter) {
    var parameterPar = {
        "token": "",
        "data": parameter
    };
    return $.ajax(url, {
        type: "POST",
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(parameterPar),
        async : false,
        xhrFields: {
            withCredentials: true
        },
        dataFilter: function (data, type) {
            if (checkState(data)) {
                return data;
            }
        },
        crossDomain: true,
    })
}

function checkState(data) {
    var data = JSON.parse(data);
    if (data.status == 1002) {
        swal({
            title: "用户信息失效,请重新登录",
            type: "warning",
            showCancelButton: false,
            closeOnConfirm: false,
            confirmButtonText: "确定",
            confirmButtonColor: "#ec6c62"
        }, function () {
            window.parent.location.href = "/cdsems/login.html";
            return false;
        });
    } else if (data.status == 1007) {
        swal({
            title: "没有访问权限",
            type: "warning",
            showCancelButton: false,
            closeOnConfirm: false,
            confirmButtonText: "确定",
            confirmButtonColor: "#ec6c62"
        }, function () {
            window.history.back(-1);
            swal.close();
            // swal("请联系管理员获取权限", "", "success");
            //  window.location.href = "/seimp/index.html";
            return false;
        });
    } else if(data.status == 4){
    	toastr.error("输入参数包含敏感字符");
    	return false;
	}else{
        return true;
    }
}

/**
 * 权限控制
 */
function myPermission(){
	//用户
	var userStr = sessionStorage["user"];
	if(userStr){
		var userObj = JSON.parse(userStr);
		var roleObj = userObj.suSysRole;
		//角色
		if(roleObj){
			var srSmEles = roleObj.srSmEles;
			if(srSmEles){
				$.each(srSmEles,function(index, ele){
					$(ele).show();
				})
			}
		}
	}
}

/**
 * 成功提示框
 */
function sucInfo(msg){
	swal(msg,"","success");
}

/**
 * 失败提示框
 */
function errInfo(msg){
	swal(msg,"","error");
}

/**
 * 删除提示框
 */
function delInfo(id){
	swal({
		  title: '确定删除吗？',
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#ec6c62',
		  confirmButtonText: '确定',
		  cancelButtonText: '取消'
		}).then(function(result){
		  if(result == true) {
			  //删除数据
			delData(id);
		  }
		})
}

//权限控制
function quanxian(){

    if ( window.sessionStorage.getItem('suLevel') == "3") {
        return window.sessionStorage.getItem('suRegioncode');
    } else return "";
}