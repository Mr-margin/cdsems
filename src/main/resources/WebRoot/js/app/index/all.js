$(function(){
	//用户信息
	
	$("#myCarousel").carousel('cycle');
	
	//标准规范栏目
	var json1 = {
			"tnType" : "2",
			pageSize:12,
			pageNumber:0
	};
	ajaxPost('/' + projectName + '/index/getNewsListByType',json1).done(function(result){
		if(result.rows){
			var data = result.rows;
			addNews1(data);
		}
	})
	
	//法律法规栏目
	var json2 = {
			"tnType" : "1",
			pageSize:12,
			pageNumber:0
	};
	ajaxPost('/' + projectName + '/index/getNewsListByType',json2).done(function(result){
		if(result.rows){
			var data = result.rows;
			addNews2(data);
		}
	})
	
	//系统通知
	var json3 = {
			pageSize:6,
			pageNumber:0
	};
	ajaxPost('/' + projectName + '/index/getMessageListByUserId',json3).done(function(result){
		if(result.rows){
			var data = result.rows;
			addMessage(data);
		}
	})
	
	
	
})

//添加标准规范数据到html
function addNews1(data){
	var html = "";
	for (var i = 0; i < data.length; i++) {
		var currItem = data[i];
		var currHtml = '<li class="col-lg-6 col-md-6 col-sm-6 col-xs-6"><a href="javascript:gotoNewsInfoPage(2,'+currItem.tnId+')">'
			+ '<p>> '+currItem.tnTitle+'</p>';
		if(currItem.tnIstop && currItem.tnIstop==1){
			currHtml += '<img src="../../img/news/new_top.png" class="img-responsive new_top pull-left" height="30px">';
		}
		currHtml += '<span>'+currItem.tnPosttime+'</span>'
			+ '</a></li>';
		html += currHtml;
	}
	$("#newsList1").html(html);
}

//添加法律法规数据到html
function addNews2(data){
	var html = "";
	for (var i = 0; i < data.length; i++) {
		var currItem = data[i];
		var currHtml = '<li class="col-lg-6 col-md-6 col-sm-6 col-xs-6"><a href="javascript:gotoNewsInfoPage(1,'+currItem.tnId+')">'
			+ '<p>>'+currItem.tnTitle+'</p>';
		if(currItem.tnIstop && currItem.tnIstop==1){
			currHtml += '<img src="../../img/news/new_top.png" class="img-responsive new_top pull-left" height="30px">';
		}
		currHtml += '<span>'+currItem.tnPosttime+'</span>'
			+ '</a></li>';
		html += currHtml;
	}
	$("#newsList2").html(html);
}

//处理新闻标题
function handleNewsTitle(tnTitle){
	var result = "";
	if(result){
		
	}
	return result;
		
}

//添加系统通知到HTML
function addMessage(data){
	var html = "";
	for (var i = 0; i < data.length; i++) {
		var currItem = data[i];
		var currHtml = '<li><a href="javascript:gotoNewsInfoPage(3,'+currItem.tmId+')">'
			+ '<p>>'+currItem.tmTitle+'</p>'
			+ '<span>'+currItem.tmDeadtime+'</span>'
			+ '</a></li>';
		html += currHtml;
	}
	$("#messageList").html(html);
}



//数字滚动效果
function asd() {
    $.fn.countTo = function (options) {
        options = options || {};
        return $(this).each(function () {
            // set options for current element
            var settings = $.extend({}, $.fn.countTo.defaults, {
                from: $(this).data('from'),
                to: $(this).data('to'),
                speed: $(this).data('speed'),
                refreshInterval: $(this).data('refresh-interval'),
                decimals: $(this).data('decimals')
            }, options);
            // how many times to update the value, and how much to increment the value on each update
            var loops = Math.ceil(settings.speed / settings.refreshInterval),
                increment = (settings.to - settings.from) / loops;
            // references & variables that will change with each update
            var self = this,
                $self = $(this),
                loopCount = 0,
                value = settings.from,
                data = $self.data('countTo') || {};
            $self.data('countTo', data);
            // if an existing interval can be found, clear it first
            if (data.interval) {
                clearInterval(data.interval);
            }
            data.interval = setInterval(updateTimer, settings.refreshInterval);
            // initialize the element with the starting value
            render(value);
            function updateTimer() {
                value += increment;
                loopCount++;
                render(value);
                if (typeof(settings.onUpdate) == 'function') {
                    settings.onUpdate.call(self, value);
                }
                if (loopCount >= loops) {
                    // remove the interval
                    $self.removeData('countTo');
                    clearInterval(data.interval);
                    value = settings.to;
                    if (typeof(settings.onComplete) == 'function') {
                        settings.onComplete.call(self, value);
                    }
                }
            }

            function render(value) {
                var formattedValue = settings.formatter.call(self, value, settings);
                $self.html(formattedValue);
            }
        });
    };
    $.fn.countTo.defaults = {
        from: 0,               // the number the element should start at
        to: 0,                 // the number the element should end at
        speed: 1000,           // how long it should take to count between the target numbers
        refreshInterval: 100,  // how often the element should be updated
        decimals: 0,           // the number of decimal places to show
        formatter: formatter,  // handler for formatting the value before rendering
        onUpdate: null,        // callback method for every time the element is updated
        onComplete: null       // callback method for when the element finishes updating
    };

    function formatter(value, settings) {
        return value.toFixed(settings.decimals);
    }

// custom formatting example
    $('#count-number').data('countToOptions', {
        formatter: function (value, options) {
            return value.toFixed(options.decimals).replace(/\B(?=(?:\d{3})+(?!\d))/g, ',');
        }
    });
  //数据概况
	var json4 = {};
	ajaxPost('/' + projectName + '/index/getIndexCount',json4).done(function(result){
		if(result.status==0){
			var data = result.data;
			addIndexCount(data);
		}
	})
// start all the timers
}
asd();


//添加数据概况到html
function addIndexCount(data){
	console.log(data)
	$.each(data, function( i, item ) {
	  $('.sta' + i).attr('data-to', item.COUNT)
	});
	
    $('.timer').each(count);
    function count(options) {
        var $this = $(this);
        options = $.extend({}, options || {}, $this.data('countToOptions') || {});
        $this.countTo(options);
    }
}


//跳转 到列表页面
function gotoNewsList(indexType){
	sessionStorage["indexType"] = indexType;
	window.location.href = "#newsList";
}

//跳转 到详情页面页面
function gotoNewsInfoPage(indexType, dataID){
	sessionStorage["indexType"] = indexType;
	sessionStorage["dataID"] = dataID;
	window.location.href = "#newsInfo";
}