$(function(){
	/*var menu = $('#board_tabmenu .menu');
	var board_cont = [$('#board_contents1'),$('#board_contents2')];
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
        	    $('#board_contents2 dl').eq(i+1).find('dd.update form input').eq(1).trigger('click');
        });
	});
	var $modal = $('.modal_wrap')

    $('#board_contents2 .delete #delete').each(function(){
        	    var board_id = "id"+$(this).parent('form').find('.board_id').attr('value');
                $(this).click(function(){
                        $modal.show();
                        $('#modal label').attr('for',board_id);
                    });
        	});

	$modal.find('ul li.no .input').each(function(){
		$(this).click(function(){
			$modal.hide();
		});
	});
	
});