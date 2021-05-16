
$(function(){
    $.getJSON("/api", function(data){
        for(var i = 0; i<data.length; i++){
            var article = $($("#article").html());
            article.find(".title").html(data[i].title)
                .siblings(".content").html(data[i].content);
            article.appendTo($("#articles"));
        }
    })

})