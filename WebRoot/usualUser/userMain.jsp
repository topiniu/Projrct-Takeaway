<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%
		if(session.getAttribute("Logined_user")==null)
		{
		%>
			<script>
				location.href("<%=basePath%>/index.jsp");
			</script>
		<%
		}
	 %>
	  </head>
  
  <body>
  <h1>Welcome</h1><h3><s:property value="#session.Logined_user.name"/></h3>
  
    <div id="head">
    	
    </div>

	<div id="main">
		<div id="left">
			<a>个人资料/修改</a>
			<a>安全信息/修改</a>
			<a>我关注的商品</a>
			<a>我的订单</a>
			<a id="creatStore" href="javascript:void(0)">我要开店</a>
			<a id="notice" href="javascript:void(0)">系统通知</a>
		</div>
		
		<div id="right">
		</div>
	</div>
	
	<script type="text/javascript" src="Js/jquery-2.1.4.min.js"></script>
 	<script type="text/javascript" src="Js/userMain_notice.js"></script>
 	<script type="text/javascript" src="Js/userMain_creatStore.js"></script>
  <link rel="stylesheet" type="text/css" href="Css/userMain.css">
  </body>
</html>













