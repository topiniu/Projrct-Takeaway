$(function(){
	$("#loginButt").bind("click",function(){
		$("#body").css("background-color","black");
		$("#body").append(
				'<div id="loginBox">'+
				'<input id="nameBox" name="userName" type="text" /><br/>'+
				'<label id="name" for="nameBox">ÄãµÄµÇÂ¼Ãû</label>'+
				'<input id="passBox" name="password" type="password"/><br/>'+
				'<label id="pass" for="passBox">ÃÜÂëÄØ?</label>'+
				'<input id="login" type="submit" value="Login in"/><br/>'+
				'<h5 id="msg"></h5>'+
				'</div>');
		$("#loginBox").slideDown();
		$("#nameBox").bind("input propertychange",function(){
			$("#name").css("visibility","hidden");
		});
		$("#passBox").bind("input propertychange",function(){
			$("#pass").css("visibility","hidden");
		});
		
		$("#nameBox").bind("blur",function(){
			if(!$("#nameBox").val())
				$("#name").css("visibility","visible");
		});
		$("#passBox").bind("blur",function(){
			if(!$("#passBox").val())
				$("#pass").css("visibility","visible");
		});
		
		$("#login").bind("click",function(){
			var userName = $("#nameBox").val();
			var password = $("#passBox").val();
			$.ajax({
				type:"POST",
				url:"User/userLogin",
				data:{"userName":userName,"password":password},
				success:function(data){
					//alert(data.msg);
					if(data.msg=="LOGINPASS"){
						$("#loginBox").slideUp("fast");
						location.href("index.jsp");
					}
					else
						$("#msg").html(data.msg);
				},
				error:function(){
					alert("ajax failed");
				}
			});
		});
	});
});