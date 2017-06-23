<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <c:set var="arr1" value="'aaa','bbb','ccc'" ></c:set>
    <c:set var="arr2" value="'aaa','bbb'" ></c:set>
    
    <ul>
    <c:forEach items="${arr1}" var="it" >
    <li <c:if test="${arr2.contains(it) }"> style="color: #D22;"</c:if> >
    	${it}   
    </li>	
    </c:forEach>
    </ul>
    <hr/>
    <form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="Go">
    </form>
    <hr/>
    <a href="dowloadFile">下载</a>
    
  </body>
</html>
