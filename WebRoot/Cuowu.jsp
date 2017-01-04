<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>错误页面</title>
    <script type="text/javascript">
    
    function fanhui(){
    	document.getElementById("sava").value;
    	document.location.href="/Tushu/index.jsp"
    }
    
    </script>

  </head>
  
  <body bgcolor="pink">
    <form action="" id="sava">
    <div align="center"> <strong><font color="#ff0000">用户不存在！请重新输入！！！！</font></strong></div>
    <p align="right">
     <input type="button" name="button" value="返回" onclick="fanhui()">
     </p>
     </form>
  </body>
</html>
