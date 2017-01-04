<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    <script type="text/javascript">
    function sub(){
        document.getElementById('sub').submit();
    }
    </script>
  </head>
  
  <body bgcolor="wine red">
  <div align="center">							
  <form action="${pageContext.request.contextPath}/user_login.action" id="sub" method="post">
  			 <p align="center">
    用户：
    <input type="text" name="username" value="admin">
    </p>
    <p align="center">
    密码：
    <input type="password" name="password" value="1231">
    </p>
  		<p align="center">
  				<input type="button" value="登录" onclick="sub()" />&nbsp;&nbsp;&nbsp;&nbsp;
  				<a href="Zhuce.jsp">
  				<input type="button" id="zhuce" value="注册"></a>&nbsp;&nbsp;&nbsp;
  				
  </form>
  </div>
  
  </body>
</html>
