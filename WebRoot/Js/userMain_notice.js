var pageNo = 1;
var flag = true;
var status = 0;

$(function(){
	var notice = $("#notice");
	var rightDiv = $("#main > #right");
	notice.bind("click",noticeBind);

	function noticeBind(){
		$("#left > a").css("background","gray");
		
		notice.css("background-color","#cc0000");
		$("#right > div").remove();
		var s = $("#buttBox");
		if(s.length==0)
		{
			rightDiv.append('<div id="buttBox">'+
					'<a id="newNotices" href="javascript:void(0)" onClick="trans(0)">Î´ÔÄ¶Á</a>'+
					'<a id="oldNotices" href="javascript:void(0)" onClick="trans(1)">ÒÑÔÄ¶Á</a>'+
					'</div>' +
					'<div id="contentBox"></div>');
			getNotices();
		}
	}
}); 	
function trans(i)
{
	pageNo = 1;
		status = i;
	$("#noticeBox").remove();
	getNotices();
}
function getNotices(){ 
	var url = "User/userMain!getNewNotices";
	if(status)
		url = "User/userMain!getOldNotices"
	$.ajax({
		type:"POST",
		url:url,
		data:{"pageNo":pageNo},
		success:function(data){
			var notice = data.noticesList;
			var contentBox = $("#contentBox");
			contentBox.append('<div id="noticeBox"></div>');
			var noticeBox = $("#noticeBox");
			for(var i=0;i<notice.length;i++)
			{
				noticeBox.append('<div class="noBox" id="no'+notice[i].id+'">' +
						'<h4>' + notice[i].content + '</h4>' +
						'<p>' + notice[i].creatDate + '</p>' +
						'<a class="read" href="javascript:void(0)" onClick="bindInfo('+notice[i].id+')">ÒÑÔÄ</a>'+
						'</div>');
			}
			if(status){
				var l = $(".read");
				l.remove();
			}
				lscroll();
				flag=true;
		},
		error:function(){
			alert("ajax failed");
		}
	});
} 
function bindInfo(noticeId){
	$.ajax({
		type:"POST",
		url:"User/userMain!upNotice",
		data:{"noticeId":noticeId},
		success:function(data){
			var no = "#no"+noticeId;
			$(no).slideUp("fast");
		},
		error:function(){
			alert("ajax failed");
		}
	});
}
function lscroll(){
	$("#noticeBox").scroll(function(){
		var scrollHeight = $("#noticeBox").get(0).scrollHeight;
		if($("#noticeBox").scrollTop() +  $("#noticeBox").height() >= scrollHeight)
		{
			if(!flag)
			{
				return false;
			}else
			{
				flag=false;
				pageNo++;
				getNotices();
			}
		}
});
}
