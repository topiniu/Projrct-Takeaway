
	$("#creatStore").bind("click",function(){
		$("#right > div").remove();
		$("#left > a").css("background","gray");
		$("#creatStore").css("background","#cc0000");
		alert("ִ��ajax");
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
			$("#registerBox").append('<h1>���������뿪��ĵ������ƣ�</h1><br/>'+
					'<form action="Operator/storeAction!createStore">'+
					'<input type="text" name="storeName"/>'+
					'<input type="submit" id="creatStoreButt" value="�ύ">'+
					'</form>');
		}else{
			$("#right").append('<div id="registerBox"></div>');
			$("#registerBox").append('<h1>������д' + '<a href="' + basePath + '/register.jsp">����</a>' + '��Ϊ�̼Ұɣ�</h1>');
		}
	}






