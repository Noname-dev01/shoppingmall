function obj_resize() {
	//슬라이드 이미지 세로값
	$(".slide_img > p").width($(window).width());
	var slide_height = $(".slide_img img").height()
	$(".slide_img").height(slide_height);
	
	//베스트메뉴  세로값
	var best_img_height = $(".img_wrap img").height();
	$(".img_wrap").height(best_img_height);
}

$(function() {
	obj_resize()
	$(window).resize(function() {
		obj_resize();
		
		width = $(window).width();
	});
	
	//슬라이드
	var slide_index = 0;
	var slide_max = $(".slide_img > p").length - 1;
	var width = $(window).width();
		
	$(".slide_img > p").width(width);
	$(".slide_img > p").not(":eq(0)").css("left", width + "px");
		
	var clear_slide = setInterval(main_slide, 3000);
	
	function main_slide() {
		(slide_index == slide_max) ? slide_index = 0 : slide_index += 1;
		
		slide_move()
	}
	
	function slide_move() {
		$(".slide_img > p").eq(slide_index - 1).animate({"left": -width + "px"}, 1000);
		$(".slide_img > p").eq(slide_index).animate({"left" : 0}, 1000, function() {
			$(".slide_img > p").not(":eq("+ slide_index +")").css("left", width + "px");
		});
	}
	
	//버튼 클릭 시 
	$("#main_slide > p").click(function() {
		clearInterval(clear_slide);
	});
	
	//오른쪽 버튼 클릭
	$(".right_button").click(function() {
		slide_right()
	});
	function slide_right() {
		(slide_index == slide_max) ? slide_index = 0: slide_index += 1;
		
		if(slide_index == 0) {
			$(".slide_img > p").not(":eq(" + slide_max + ")").css("left", width + "px");
			$(".slide_img > p").eq(slide_max).animate({"left": -width + "px"}, 1000);
		}else {
			$(".slide_img > p").not(":eq(" + (slide_index - 1) + ")").css("left", width + "px");
			$(".slide_img > p").eq(slide_index - 1).animate({"left": -width + "px"}, 1000);
		}
		
		slide_move()
	}
	
	//왼쪽 버튼 클릭
	$(".left_button").click(function() {
		slide_left()
	});
	function slide_left() {
		var buttonNumber = slide_index;
		(slide_index == 0) ? slide_index = slide_max : slide_index -= 1;
				
		$(".slide_img > p").eq(slide_index).css("left", -width + "px");
		$(".slide_img > p").eq(slide_index).animate({"left" : 0}, 1000);
		$(".slide_img > p").eq(buttonNumber).animate({"left" : width + "px"}, 1000);
	}
});

$(function(){
	$('.banner_img:not(:first)').hide(); 
	$('li.banner_name:eq(0)').addClass('hover');
	
	$('.banner_name').mouseover(function(){	
		$('li.banner_name:eq(0)').removeClass('hover');				     $(this).addClass('hover');
		$('.banner_img',this).show();}).mouseout(function(){
		 $(this).removeClass('hover');
		$('.banner_img:not(:first)').hide(); 
		
			return false;
		});				
});