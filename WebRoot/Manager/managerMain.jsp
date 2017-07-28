<%@ page language="java" contentType="text/html; charset=GBK" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%
  	if(session.getAttribute("Logined_mgr") == null)
  	{
  		%>
  			<jsp:forward page="managerLogin.jsp"/>
  		<%
  	}
   %>
  
    <base href="<%=basePath%>">
    
    <title>Welcome <s:property value="#session.Logined_mgr.nicName"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="Css/managerMain.css">
	
	<script type="text/javascript" src="Js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="Js/managerMain.js"></script>

  </head>
  
  <body>
  <div id="top">
 	 Welcome,manager&nbsp;<a><s:property value="#session.Logined_mgr.nicName"/></a>
  </div>
  <div id="left">
  	<h1>管理员面板</h1>
  </div>
  <div id="center"></div>
  <div id="right">
  	<h1>待处理的申诉面板</h1>
  </div>
  <div id="bottom">
  	<a>版权所有 &copy;&nbsp;&nbsp;topiniu</a>
  </div>
  </body>
</html>
