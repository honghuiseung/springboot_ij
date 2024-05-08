$(function(){

    //게시판 동작
    var board = $('#board_body dl').not('.first');
    var board_content = board.find('.board_cont');
    board_content.hide();

    board.each(function(){
        $(this).click(function(){
            board_content.hide();
            board.removeClass('on');
            $(this).addClass('on').find('.board_cont').show();
        });
    });

    //게시판 숫자 동작
    $('#board_num ul li a.num').on('click',function(){
        $('#board_num ul li a.num').removeClass('active');
        $(this).addClass('active');
    })
});