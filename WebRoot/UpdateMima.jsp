<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码</title>
    <script type="text/javascript">
    function fanhui(){
    	location.href="shu_Zhanshi.action";
    }
    
    </script>

  </head>
  
  <body bgcolor="yellow">
  <h1 align="center">修改密码</h1>
  <div align="center">
  <form action="user_UpdateMima.action" id="addform" method="post">
  用户：<input type="text" id="username" name="username" value="${user }" readonly="readonly"><br>
  密码：<input type="text" id="password" name="password"><br>
  <input type="submit" value="确定" onclick="sub()">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="返回" onclick="fanhui()">
  
  
  </form>
  </div>
  </body>
</html>
