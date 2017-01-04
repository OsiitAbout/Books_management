<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>Suoyin.html</title>
	<script type="text/javascript">
	function dingdan(){
		var dingdan=parent.frames["you"];
		dingdan.document.location.href="dingdan_Dingdan.action";
	}
	
	function fanhui(){
   		 window.parent.location.href="/Tushu/G.jsp";
    }
	</script>
	<style type="text/css">
.STYLE1 {font-size: xx-large}
body {
	background-color:F66;
}
</style>

  </head>
  
  <body>
 <p> <input type="button" value="订单查询" onclick="dingdan()"></p>
 <p> <input type="button" value="返回首页" onclick="fanhui()"></p>
  </body>
  
</html>
