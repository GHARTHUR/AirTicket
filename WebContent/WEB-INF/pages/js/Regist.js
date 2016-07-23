$(document).ready(function() { 
$("#check").click(function(){
	if($("#username").val()==''){
		$("#username").popover({
			content: "请输入邮箱"
		});
		setTimeout(function () {
        	$("#username").popover("hide");
        	$('#username').popover('destroy');
    	}, 3000);
		$("#username").popover("show");
		return;
	}
	$.ajax({
             type: "GET",
             url: "./Check",
             data: {username:$("#username").val()},
             dataType: "json",
             success: function(data){
             	console.log("ok");
                }
         });
})
});