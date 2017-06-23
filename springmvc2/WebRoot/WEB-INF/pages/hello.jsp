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
    
    <title>My JSP 'hello.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script src="js/jquery.js" ></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/highchart.js"></script>
<style type="text/css">
#container,#bpbox{
	width: 550px;
	height: 400px; 
	margin: 0 auto;
	border: 1px solid  #955;
}


</style>
  </head>
  
  <body>
    ${message }<br>
    <ul>
    <c:forEach items="${citys }" var="ct" >
    <li>${ct.id } : ${ct.name }</li>
    </c:forEach>
    </ul>
    <hr>
    <button id="bt">Click Me</button>
    <div id="box"></div>
    <hr/>
    <div id="container" >
    
    
    </div>
     <hr/>
     <button id="bpbt">Bubble图形</button>
     <button id="chbt">plat图形</button>
    <div id="bpbox" >
    
    
    </div>
    
    
    <script type="text/javascript">
    //曲线图
    /*$(document).ready(function(){
    	var chart = {
    		      type: 'column'
    		   };
    	   var title = {
    		       text: '月平均气温'   
    		   };
    		   var subtitle = {
    		        text: 'Source: runoob.com'
    		   };
    		   var xAxis = {
    		       categories: ['一月', '二月', '三月', '四月', '五月', '六月'
    		              ,'七月', '八月', '九月', '十月', '十一月', '十二月']
    		   };
    		   var yAxis = {
    		      title: {
    		         text: 'Temperature (\xB0C)'
    		      },
    		      plotLines: [{
    		         value: 0,
    		         width: 1,
    		         color: '#808080'
    		      }]
    		   };   

    		   var tooltip = {
    		      valueSuffix: '\xB0C'
    		   }

    		   var legend = {
    		      layout: 'vertical',
    		      align: 'right',
    		      verticalAlign: 'middle',
    		      borderWidth: 0
    		   };

    		   var series =  [
    		      {
    		         name: 'Tokyo',
    		         data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
    		            26.5, 23.3, 18.3, 13.9, 9.6]
    		      }, 
    		      {
    		         name: 'New York',
    		         data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8,
    		            24.1, 20.1, 14.1, 8.6, 2.5]
    		      }, 
    		      {
    		         name: 'Berlin',
    		         data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6,
    		            17.9, 14.3, 9.0, 3.9, 1.0]
    		      }, 
    		      {
    		         name: 'London',
    		         data: [-13.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 
    		            46.6, 14.2, 10.3, 6.6, 4.8]
    		      }
    		   ];
    		   var plotOptions = {
    				      line: {
    				         dataLabels: {
    				            enabled: true
    				         },   
    				         enableMouseTracking: false
    				      }
    				   };
    		   var json = {};
				json.chart=chart;
    		   json.title = title;
    		   json.subtitle = subtitle;
    		   json.xAxis = xAxis;
    		   json.yAxis = yAxis;
    		   json.tooltip = tooltip;
    		   json.legend = legend;
    		   json.series = series;
    		   //json.plotOptions = plotOptions;
    		   $('#container').highcharts(json);
    	
    });
    */
    //饼图
    $("#chbt").click(function(){
    	 var chart = {
    		       plotBackgroundColor: null,
    		       plotBorderWidth: null,
    		       plotShadow: false
    		   };
    		   var title = {
    		      text: '2014 年各浏览器市场占有比例'   
    		   };      
    		   var tooltip = {
    		      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    		   };
    		   var plotOptions = {
    		      pie: {
    		         allowPointSelect: true,
    		         cursor: 'pointer',
    		         dataLabels: {
    		            enabled: true,
    		            format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
    		            style: {
    		               color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
    		            }
    		         }
    		      }
    		   };
    		   var series= [{
    		      type: 'pie',
    		      name: 'Browser share',
    		      data: [
    		         ['Firefox',   45.0],
    		         ['IE',       26.8],
    		         /*{
    		            name: 'Chrome',
    		            y: 12.8,
    		            sliced: true,
    		            selected: true
    		         },*/
    		         ['Chrome',    12.8],
    		         ['Safari',    8.5],
    		         ['Opera',     6.2],
    		         ['Others',   0.7]
    		      ]
    		   }];     
    		      
    		   var json = {};   
    		   json.chart = chart; 
    		   json.title = title;     
    		   json.tooltip = tooltip;  
    		   json.series = series;
    		   json.plotOptions = plotOptions;
    		   $('#container').highcharts(json);  
    });
    
    //区域图
    $("#bpbt").click(function(){
    	var chart = {
    		      type: 'area'
    		   };
    		   var title = {
    		      text: 'US and USSR nuclear stockpiles'   
    		   };
    		   var subtitle = {
    		      text: 'Source: <a href="http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf">' +
    		         'thebulletin.metapress.com</a>'  
    		   };
    		   var xAxis = {
    		      allowDecimals: false,
    		      labels: {
    		         formatter: function () {
    		            return this.value; // clean, unformatted number for year
    		         }
    		      }
    		   };
    		   var yAxis = {
    		      title: {
    		         text: 'Nuclear weapon states'
    		      },
    		      labels: {
    		         formatter: function () {
    		            return this.value / 1000 + 'k';
    		         }
    		      }
    		   };
    		   var tooltip = {
    		      pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
    		   };
    		   var plotOptions = {
    		      area: {
    		         pointStart: 1940,
    		         marker: {
    		            enabled: false,
    		            symbol: 'circle',
    		            radius: 2,
    		            states: {
    		               hover: {
    		                 enabled: true
    		               }
    		            }
    		         }
    		      }
    		   };
    		   var series= [{
    		         name: 'USA',
    		            data: [null, null, null, null, null, 6, 11, 32, 110, 235, 369, 640,
    		                1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126,
    		                27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342, 26662,
    		                26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,
    		                24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586,
    		                22380, 21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950,
    		                10871, 10824, 10577, 10527, 10475, 10421, 10358, 10295, 10104]
    		        }, {
    		            name: 'USSR/Russia',
    		            data: [null, null, null, null, null, null, null, null, null, null,
    		                5, 25, 50, 120, 150, 200, 426, 660, 869, 1060, 1605, 2471, 3322,
    		                4238, 5221, 6129, 7089, 8339, 9399, 10538, 11643, 13092, 14478,
    		                15915, 17385, 19055, 21205, 23044, 25393, 27935, 30062, 32049,
    		                33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000, 37000,
    		                35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,
    		                21000, 20000, 19000, 18000, 18000, 17000, 16000]
    		      }
    		   ];     
    		      
    		   var json = {};   
    		   json.chart = chart; 
    		   json.title = title;   
    		   json.subtitle = subtitle; 
    		   json.tooltip = tooltip;
    		   json.xAxis = xAxis;
    		   json.yAxis = yAxis;  
    		   json.series = series;
    		   json.plotOptions = plotOptions;
    		   $('#bpbox').highcharts(json);
    });
    
    
    $("#bt").click(function(){
    	$.getJSON("./helloJson?currentPage=1",function(data){
    		//alert(data);
    		var txt="<ul>";
    		$.each(data,function(n,ct){
    			//alert(n+"  "+ ct);
    			txt=txt+"<li>"+ct.id+"&nbsp;"+ct.name+"</li>"
    		});
    		txt=txt+"</ul>"
   			$("#box").html(txt);
    	});
    });
    
    </script>
  </body>
</html>
