<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script src="js/jquery.js" ></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </head>
  
  <body>
    <div id="container">
    <ul class="nav nav-tabs">
	  <li class="active"><a href="#">城市列表</a></li>
	  <li><a href="#">国家</a></li>
	  <li><a href="#">语言与语种</a></li>
	  <li><a href="#">联系我们</a></li>
	</ul>
    
    
    
    	<h1>欢迎来到城市列表</h1>
    	
    	<div id="editBox">
    	<form id="editForm" action="#" method="post">
    		<fieldset>
    		<legend>城市信息：</legend>
    		编号：<input id="cid" name="city.id" readonly="readonly" type="text">
    		名称：<input id="cname" name="city.name" type="text">
    		行政区：<input id="cdist" name="city.district" type="text"><br/>
    		人口：<input id="cpopu" name="city.population" type="number">
    		国家代码：<input id="ccoun" name="city.countryCode" type="text">
    		<input type="button" onclick="updateForm()" value="更新">
    		<input type="button" onclick="insertForm()" value="新增">
    		</fieldset>
    	</form>	
    	</div>
    	
    	<table id="datagrid" width="958px" cellpadding="0" cellspacing="0">
			<tr>
				<th width="10%">编号</th>
				<th width="20%">城市</th>
				<th width="20%">人口</th>
				<th width="20%">行政区</th>
				<th width="20%">国家代码</th>
				<th width="10%">&nbsp;</th>
			</tr>	    	
			<c:forEach items="${citys}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td>${c.population}</td>
				<td>${c.district}</td>
				<td>${c.countryCode}</td>
				<td>
					<a href="javascript:return false" onclick="editFun(this)">编辑</a>&nbsp;
					<a href="deleteCityAct?city.id=${c.id}&currentPage=${currentPage}">删除</a>
				</td>
			</tr>
			</c:forEach>
    	</table>
    	<div id="pageBox">
    		<p>
    			共有记录${maxItems}条，分${maxPage}页，当前第${currentPage+1}页&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="queryCityAct?currentPage=0">首页</a>
    			<a href="queryCityAct?currentPage=${currentPage-1}">前一页</a>
    			<a href="queryCityAct?currentPage=${currentPage+1}">后一页</a>
    			<a href="queryCityAct?currentPage=${maxPage-1}">末页</a>
    		</p>
    	</div>
    </div>
    
    
    
    
<script >

function editFun(eve){
	//document.getElementById("a").v
	var row = eve.parentNode.parentNode;
	var cid=row.childNodes[1].innerHTML;
	var cname=row.childNodes[3].innerHTML;
	var cpopu=row.childNodes[5].innerHTML;
	var cdist=row.childNodes[7].innerHTML;
	var ccoun=row.childNodes[9].innerHTML;
	document.getElementById("cid").value=cid;
	document.getElementById("cname").value=cname;
	document.getElementById("cpopu").value=cpopu;
	document.getElementById("cdist").value=cdist;
	document.getElementById("ccoun").value=ccoun;
	
}
function updateForm(){
	var fm = document.getElementById("editForm");
	fm.action="updateCityAct";
	fm.submit();
}
function insertForm(){
	var fm = document.getElementById("editForm");
	fm.action="insertCityAct";
	fm.submit();
}


</script>    
    
  </body>
</html>
