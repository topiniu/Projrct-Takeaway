<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Application detail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Css/applicationDetail.css">
	
  </head>
  
  <body>
    <h5><s:property value="app.id"/></h5><br>
    <h5><s:property value="app.identityInfo.name"/></h5>
    <br>
    <h5><s:property value="app.identityInfo.address"/></h5>
    <br>
    <h5><s:property value="app.identityInfo.tel"/></h5>
    <br>
    <img id="idPhoto" src="<%=basePath%>/IdentityPhoto/<s:property value='imgName'/>" alt="证件照" />
 	<br>
 	<a class="passButt" href="Manager/pass_applicationDetail?passId=<s:property value='app.id'/>">pass it</a>
  </body>
  
</html>
