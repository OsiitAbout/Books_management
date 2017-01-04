<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>Suoyin.html</title>
	<script type="text/javascript">
	function user(){
		var user=parent.frames["you"];
		user.document.location.href="user_ChaUser.action";
	}
	
	function leixing(){
		var classes=parent.frames["you"];
		classes.document.location.href="lei_Chaleixing.action";
	}
	
	function tushu(){
		var classes=parent.frames["you"];
		classes.document.location.href="shu_ChaTushu.action";
	}
	function dingdan(){
		var sco=parent.frames["you"];
		sco.document.location.href="dingdan_ChaDingdan.action";
	}
	function fanhui(){
   		 window.parent.location.href="/Tushu/G.jsp";
    }
	</script>
	<style type="text/css">
.STYLE1 {font-size: xx-large}
body {
	background-color:green;
}
</style>

  </head>
  
  <body>
 <p> <input type="button" value="用户管理" onclick="user()"></p>
 <p> <input type="button" value="图书管理" onclick="tushu()"></p>
 <p> <input type="button" value="类型管理" onclick="leixing()"></p>
 <p> <input type="button" value="订单管理" onclick="dingdan()"></p>
 <p> <input type="button" value="返回首页" onclick="fanhui()"></p>
  </body>
  
</html>
