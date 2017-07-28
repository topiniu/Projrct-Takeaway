$(function(){
	$("#datePicker").datepicker({
		dateFormat:"yy-mm-dd",
		showAnim:"slideDown",
		changeMouth:true,
		changeYear:true
	});
	trans();
	function trans(){
		$("#usualForm").slideDown("fast",function(){
			onInput();
			$("#usual").css({"background-color":" #cc0000 ","color":"white"});
		});
	};

	$("#operator").bind("click",function(){
		$("#usualForm").hide("slow");
		$("#usual").css({"background-color":"white","color":"black"});
		$("#formContainer").css("background-color","white");
		$("#operatorForm").slideDown("fast",function(){
				onInput();
				$("#operator").css({"background-color":" #cc0000 ","color":"white"});
		});
	});
	
	$("#usual").bind("click",function(){
		$("#operatorForm").hide("slow");
		$("#operator").css({"background-color":"white","color":"black"});
		trans();
	});
	
	function onInput(){
		$(".input,.textarea").hover(function(){
			$(this).css("border-color"," #cc0000 ");
		},function(){
			$(this).css("border-color","#BEBEBE");
		});
	}
	
	$("#photoBar").bind("click",function(){
		$("#choosePhoto").click();
	});
	
	$("#choosePhoto").change(function(){
		var url = getObjectURL(this.files[0]);
		//$("#photoBar").hide("fast");
		$("#img").attr("src",url);
		$("#img").slideDown("fast");
	});
	
	function getObjectURL(file) {
		var url = null ; 
		if (window.createObjectURL!=undefined) { // basic
			url = window.createObjectURL(file) ;
		} else if (window.URL!=undefined) { // mozilla(firefox)
			url = window.URL.createObjectURL(file) ;
		} else if (window.webkitURL!=undefined) { // webkit or chrome
			url = window.webkitURL.createObjectURL(file) ;
		}
		return url;
	}
});