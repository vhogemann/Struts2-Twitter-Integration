$(document).ready(function(){

    /* menu animations */

    $("ul.menu").children().mouseenter(function(){
        $(this).addClass("highlight");
    });

    $("ul.menu").children().mouseleave(function(){
        $(this).removeClass("highlight");
    });

});
