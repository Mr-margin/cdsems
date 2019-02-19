$(function(){
	tab()
})
function tab(){
	$('.formTab>li').click(function(){
		$(this).addClass('liActive').siblings('li').removeClass('liActive');
		$('.tabItem').eq($(this).index()).show().siblings('.tabItem').hide();
	})
}

function back(){
	window.location.href="#tableList";
}