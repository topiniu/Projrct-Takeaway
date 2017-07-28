
	$("#creatStore").bind("click",function(){
		$("#right > div").remove();
		$("#left > a").css("background","gray");
		$("#creatStore").css("background","#cc0000");
		alert("执行ajax");
		$.ajax({
			type:"POST",
			url:"Operator/storeAction!isCCStore",
			data:null,
			success:function(data){
				if(data.CCStore==1)
					addDiv(1);
				else
					addDiv(0);
			},
			error:function(){
				alert("ajax failed");
			}
		});
		});
function addDiv(status){
	var location = (window.location+'').split('/'); 
	var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
	
	alert("stratus= " + status);
	if(status == 1){
			$("#right").append('<div id="registerBox"></div>');
			$("#registerBox").append('<h1>请输入你想开设的店铺名称：</h1><br/>'+
					'<form action="Operator/storeAction!createStore">'+
					'<input type="text" name="storeName"/>'+
					'<input type="submit" id="creatStoreButt" value="提交">'+
					'</form>');
		}else{
			$("#right").append('<div id="registerBox"></div>');
			$("#registerBox").append('<h1>现在填写' + '<a href="' + basePath + '/register.jsp">申请</a>' + '成为商家吧！</h1>');
		}
	}






