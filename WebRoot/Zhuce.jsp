<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    
    <title>注册</title>
    <script type="text/javascript">
    function yonghu() {
		id = document.getElementById("username").value;
		if (id == null || id == "") {
			alert("用户不能为空！请重新输入！");
		} else if (id.length > 6) {
			alert("用户名过长,请重新输入！");
			document.getElementById("username").select();
		}
	}
	function mima1() {
		password = document.getElementById("password").value;
		if (password == null || password == "") {
			alert("密码不能为空！");
		} else {
			if (password.length > 6) {
				alert("密码太长！");
				document.getElementById("password").select();
			}
		}
	}
	function mima2() {
		password2 = document.getElementById("password2").value;
		if (password2 == null || password2 == "") {
			alert("密码不能为空！");
		} else if (password.length > 6) {
			alert("密码太长！");
		} else if (password != password2) {
			alert("新密码与原密码不一致，请重新输入！！！");
			document.getElementById("password2").select();
		}
	}
    
    
    function fanhui(){
  	location.href="/Tushu/index.jsp";
  }
    
    
    
    </script>

  </head>
  
  <body bgcolor="yellow">
		<h1 align="center">
			注册信息
		</h1>
		<form method="post" action="user_Zhuce.action" id="login">
			<p align="left">
				用户名：
				<input type="text" name="username" id="username" onBlur="yonghu()">
			</p>
			<p align="left">
				密&nbsp;&nbsp;码：
				<input type="password" id="password" name="password" onblur="mima1()">
			</p>
			<p align="left">
				密&nbsp;&nbsp;码：
				<input type="password" id="password2" name="password2" onblur="mima2()">
			</p>
				  <p>
   			  <input name="zhu" type="submit" id="zhu" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   			  <a href="shouye.jsp">
    			<input name="fanhui" type="button" id="fanhui" value="返回" onclick="fanhui()"></a>
    			</p>
			</form>
  </body>
</html>
