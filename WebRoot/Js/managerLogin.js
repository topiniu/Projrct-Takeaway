$(document).ready(function(){
	$("#submit").bind("click",function(){
		var idText = $("#id").val();
		var passText = $("#pass").val();
		$.ajax({
			type:"POST",
			url:"Manager/login",
			data:{"id":idText,"pass":passText},
			success:function(data){
				if(data.msg=="LOGINPASS")
				{
					//$("#msg").html(data.msg);
					location.href("managerMain.jsp");
				}else{
					$("#msg").html(data.msg);
				}
			},
			error:function(){
				alert("ajax failed");
			}
		});
	});
});