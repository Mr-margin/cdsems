//单选按钮距离定位
var infoJsonStr = sessionStorage.getItem('dataIDJson');
infoEntity = JSON.parse(infoJsonStr);
console.log(infoEntity)
var cid = infoEntity.cid;
initPart4Content(cid);
//更新更多详情信息内容
/**
 * 
 * ----------------------排污许可证注销、撤销详情----------------------
 */

/*排污许可证撤销/撤销证据页面赋值*/

function initPart4Content(cid) {
    ajaxPost("/cdsems/OneMapPointQueryController/selectById",{
    	cid:cid
    }).done(function (result) {
        if (result.status == 0) {
        	console.log(result.data)
        	var item=result.data[0];
        
            $("#pot_1").html(handleNullStr(item.CID));
            $("#pot_2").html(handleNullStr(item.USER_ID)); // 无
            $("#pot_3").html(handleNullStr(item.MASSIF_CODE));
            $("#pot_4").html(handleNullStr(item.MASSIF_NAME));
            $("#pot_5").html(handleNullStr(item.provinceName)); // 无
            $("#pot_6").html(handleNullStr(item.cityName));
            $("#pot_7").html(handleNullStr(item.TNAME));
            $("#pot_8").html(handleNullStr(item.BZ)); // 无
            $("#pot_9").html(handleNullStr(item.MASSIF_POLLUTE));
            $("#pot_10").html(handleSCJDBM(item.MASSIF_STAGE));
            $("#pot_11").html(handleNullStr(item.RISK_LEVEL));
//            $("#pot_12").html(handleNullStr(item.OPEADDRESS));
//            $("#pot_13").html(handleNullStr(item.CBDCID));
            $("#pot_14").html(handleNullStr(item.SYQDWMC)); // 无
            $("#pot_15").html(handleNullStr(item.LEGAL_REPRESENTATIVE));
            $("#pot_16").html(handleNullStr(item.BUSINESS_LICENSE));
            $("#pot_17").html(handleNullStr(item.MASSIF_ADDRESS));
            $("#pot_18").html(handleNullStr(item.POSTAL_CODE));
            $("#pot_19").html(handleNullStr(item.MASSIF_AROUND_AREA));
            $("#pot_20").html(handleNullStr(item.MASSIF_COVERED));
            $("#pot_21").html(handleNullStr(item.COORDINATE_DESCRIPTION));
            $("#pot_22").html(handleNullStr(item.ACCESS_UNIT_CONTACTS));
            $("#pot_23").html(handleNullStr(item.ACCESS_UNIT_PHONE));
            $("#pot_24").html(handleNullStr(item.MASSIF_LONGITUDE));
            $("#pot_25").html(handleNullStr(item.MASSIF_LATITUDE));
            $("#pot_26").html(handleNullStr(item.FAX));
            $("#pot_27").html(handleNullStr(item.MAILBOX));
            
            $("#pot_28").html(handleNullStr(item.PID));
            $("#pot_29").html(handleNullStr(item.PRELIMINARY_TITLE));
            $("#pot_30").html(handleNullStr(item.PRELIMINARY_WEBSITE));
            $("#pot_31").html(handleNullStr(item.PRELIMINARY_COMPILING_UNIT));
            $("#pot_32").html(handleNullStr(item.PRELIMINARY_COMPILING_TIME));
            $("#pot_33").html(handleNullStr(item.DCBGLJ)); // 无
            $("#pot_34").html(handleNullStr(item.JCBGLJ)); //无
            $("#pot_35").html(handleNullStr(item.FILL_STATE));
            $("#pot_36").html(handleNullStr(item.MPOLLUTE));
            
            
            console.log($(".table-left").height())
        	$(".table-right").height($(".table-left").height()-52);
            $(".table-right .qiye_map").height($(".table-left").height()-120);
        }
    });
    
}




//处理字符串为null的情况和没有值显示undefined的情况；
function handleNullStr(value){
	var result = "";
	if(value && value!="null"){
		result = value;		
	}
	return result;
}
var scjdbmObj = {
		S0 : '疑似地块',
		S1 : '初步调查',
		S2 : '详细调查',
		S3 : '风险评估',
		S4 : '风险管控',
		S5 : '土壤修复与治理',
		S6 : '土壤修复与治理评估'
}
function handleSCJDBM(value){
	var result = "";
	if(value && value!="null"){
		result = scjdbmObj[value];
	}
	return result;
}

var TBJDBMObj = {
		T1 : '填报',
		S1 : '填报完成',
		S2 : '退改'
}
function handleTBJDBM(value){
	var result = "";
	if(value && value!="null"){
		result = TBJDBMObj[value];
	}
	return result;
}

