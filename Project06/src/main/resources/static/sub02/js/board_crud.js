$(function(){
	/*var menu = $('#board_tabmenu .menu');
	var board_cont = [$('#board_contents1'),$('#board_contents2')];
	console.log(board_cont);
	menu.each(function(i){
		$(this).click(function(){
			for(var j in board_cont){
				board_cont[j].hide();
			}
			board_cont[i].show();
			menu.removeClass('active');
			$(this).addClass('active');
			return false;
		});
	})
	menu.eq(0).trigger('click');*/
	$('#board_contents2 dl dd.subject').each(function(i){
	    $(this).click(function(){
        	    $('#board_contents2 dl dd.update form input').eq(i).trigger('click');
        });
	});
	var $modal = $('.modal_wrap')
	
	$('#board_contents2 .delete #delete').click(function(){
		$modal.show();
	});
	$modal.find('ul li.no input').each(function(){
		$(this).click(function(){
			$modal.hide();
		});
	});
	
});