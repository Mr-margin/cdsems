//增加透明样式以及事件
function huaDiv() {
   /* $(".vectorLayer").slider({//矢量图滑动条滑动事件
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("vectorLayer");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
	if ($(".vectorLayer").slider({
		 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
	})) {
		$(".vectorLayer").slider({}).on('slide', function (slideEvt) {
	        //当滚动时触发
	    	var value=slideEvt.value;
	        var percent=(value/10).toFixed(1);
	        var targetLayer=app.map.getLayer("vectorLayer");
	        if(targetLayer==null){return;}
	        targetLayer.setOpacity(percent);
	        return;
	    });
	}
    
    
 /*   $(".baseLayer").slider({//影像
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("baseLayer");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
   
    if ($(".baseLayer").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	 $(".baseLayer").slider({}).on('slide', function (slideEvt) {
    	        //当滚动时触发
    	    	var value=slideEvt.value;
    	        var percent=(value/10).toFixed(1);
    	        var targetLayer=app.map.getLayer("baseLayer");
    	        if(targetLayer==null){return;}
    	        targetLayer.setOpacity(percent);
    	        return;
    	    });
    }
  /*  $(".layer0").slider({//谷歌影像
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("layer0");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".layer0").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".layer0").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("layer0");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
/*    $(".annoLayerImg").slider({//影像中文
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("annoLayerImg");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".annoLayerImg").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".annoLayerImg").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("annoLayerImg");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
    /*$(".vectorNoteLayer").slider({//矢量中文
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("vectorNoteLayer");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".vectorNoteLayer").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".vectorNoteLayer").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("vectorNoteLayer");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
  /*  $(".daolu").slider({//道路
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("gaosuLayer");
            var targetLayer1=app.map.getLayer("shengdaoLayer");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            targetLayer1.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".daolu").slider({
    	max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal"//朝向
    })) {
    	$(".daolu").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("daolu");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
    /*$(".gongliwangge").slider({//公里网格
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.grideGraphicLayer;
            var targetLayer1=app.wanggeLayer;
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            targetLayer1.setOpacity(percent);
            return;
        }
    });*/
    
    if ( $(".gongliwangge").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".gongliwangge").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("gongliwangge");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
  /*  $(".jingjinji").slider({//京津冀
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("jingjinji");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    if ($(".jingjinji").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".jingjinji").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("jingjinji");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });	
    }
  /*  $(".changsanjiao").slider({//长三角
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("changsanjiao");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".changsanjiao").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".changsanjiao").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("changsanjiao");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });	
    }
   /* $(".zhusanjiao").slider({//珠三角
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("zhusanjiao");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".zhusanjiao").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".zhusanjiao").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("zhusanjiao");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
  /*  $(".guanqu").slider({//大型灌区分布
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var type=event.target.getAttribute("data");
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("guanqu");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".guanqu").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".guanqu").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("guanqu");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });	
    }
/*    $(".shengJie").slider({//省
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("shengJie");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
   
    if ($(".shengJie").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	 $(".shengJie").slider({}).on('slide', function (slideEvt) {
    	        //当滚动时触发
    	    	var value=slideEvt.value;
    	        var percent=(value/10).toFixed(1);
    	        var targetLayer=app.map.getLayer("shengJie");
    	        if(targetLayer==null){return;}
    	        targetLayer.setOpacity(percent);
    	        return;
    	    });
    }
 /*   $(".shiJie").slider({//省
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("shiJie");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".shiJie").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".shiJie").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("shiJie");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
   /* $(".xianJie").slider({//县
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("xianJie");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".xianJie").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".xianJie").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("xianJie");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
 /*   $(".heliu").slider({//河流
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("heliu");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".heliu").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".heliu").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("heliu");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
    // 土地利用
    
    if ($(".tudiliyong").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".tudiliyong").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("tudiliyong");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
        });
    }
/*    $(".turangleixing").slider({//土壤类型
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("turangleixing");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".turangleixing").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".turangleixing").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("turangleixing");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
/*    $(".renkou").slider({//人口分布
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("renkou");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ( $(".renkou").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".renkou").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("renkou");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
   /* $(".fenbu_1").slider({//污染地块
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_1");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".fenbu_1").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_1").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_1");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
    /*$(".fenbu_2").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_2");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".fenbu_2").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_2").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_2");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
  /*  $(".fenbu_4").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_4");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ( $(".fenbu_4").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_4").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_4");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
 /*   $(".fenbu_5").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_5");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".fenbu_5").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_5").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_5");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
/*    $(".fenbu_6").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_6");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".fenbu_6").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_6").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_6");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
/*    $(".fenbu_3").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_3");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".fenbu_3").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_3").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_3");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
   /* $(".fenbu_7").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_7");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".fenbu_7").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_7").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_7");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
  /*  $(".fenbu_8").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_8");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    if ($(".fenbu_8").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_8").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_8");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });	
    }
    
  /*  $(".fenbu_11").slider({
        max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal",//朝向
        slide: function(event, ui) {//滑动回调函数
            var value=ui.value;
            var percent=(value/$(event.target).slider("option","max")).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_11");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        }
    });*/
    
    if ($(".fenbu_11").slider({
    	 max:10,//最右侧值
         value:10,//初始值
         orientation:"horizonal"//朝向
    })) {
    	$(".fenbu_11").slider({}).on('slide', function (slideEvt) {
            //当滚动时触发
        	var value=slideEvt.value;
            var percent=(value/10).toFixed(1);
            var targetLayer=app.map.getLayer("fenbu_11");
            if(targetLayer==null){return;}
            targetLayer.setOpacity(percent);
            return;
        });
    }
    // 农用地
    if ($(".fenbu_12").slider({
      	 max:10,//最右侧值
           value:10,//初始值
           orientation:"horizonal"//朝向
      })) {
      	$(".fenbu_12").slider({}).on('slide', function (slideEvt) {
              //当滚动时触发
          	var value=slideEvt.value;
              var percent=(value/10).toFixed(1);
              var targetLayer=app.map.getLayer("fenbu_12");
              if(targetLayer==null){return;}
              targetLayer.setOpacity(percent);
              return;
          });
      }
    // 建设用地准入
    if ($(".fenbu_14").slider({
   	 max:10,//最右侧值
        value:10,//初始值
        orientation:"horizonal"//朝向
   })) {
   	$(".fenbu_14").slider({}).on('slide', function (slideEvt) {
           //当滚动时触发
       	var value=slideEvt.value;
           var percent=(value/10).toFixed(1);
           var targetLayer=app.map.getLayer("fenbu_14");
           if(targetLayer==null){return;}
           targetLayer.setOpacity(percent);
           return;
       });
   }
}