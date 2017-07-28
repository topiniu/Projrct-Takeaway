	var pageNo = 1;
	var flag = true;
	function a(){
		$.ajax({
			type:"POST",
			url:"Manager/findAppList_main",
			data:{"pageNo":pageNo},
			success:function(data){
				var apps = data.applicationList;
				if(apps.length == 0){
					$("#center").append('<h1 style="color:red;">暂时没有要处理的申请</h1>');
				}else{
					for (var i=0;i<apps.length;i++) {
						$("#center").append(
								'<div id="application">' +
								'<p>单号:' + apps[i].id + '</p>' +
								'<p id="peo">申请人:' + apps[i].identityInfo.name + '</p>' +
								'<p>申请日期:' + apps[i].createDate + '</p>' +
								'<a href="Manager/findAppDetail_applicationDetail?id='+apps[i].id+'">查\t看\t详\t情</a>'+
								'</div><br/>'
						);
					}
				}
					flag=true;
			},
			
			error:function(){
				alert("ajax failed");
			}
		});
	}
	
	$(function(){
		a();
		$("#center").scroll(function(){
				var scrollHeight = $("#center").get(0).scrollHeight;
				if($("#center").scrollTop() +  $("#center").height() >= scrollHeight)
				{
					if(!flag)
					{
						return false;
					}else
					{
						flag=false;
						pageNo++;
						a();
					}
				}
		});
	});