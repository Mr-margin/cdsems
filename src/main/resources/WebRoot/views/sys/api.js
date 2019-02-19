var url;
var json;

function getData(){
	ajaxPost(url, json).done(function(result){
		console.log(result);
	})
}

url = '/' + projectName + '/sys/yzt/listByPermission';
json = {
		
};
