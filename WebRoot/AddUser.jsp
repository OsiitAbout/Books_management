<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加</title>
    <script type="text/javascript">
    
    function sub(){
    	if(document.getElementById("username").value==null||document.getElementById("username").value==''){
    		alert("请输入姓名！");
    		return;
    	}
    	if(document.getElementById("password").value==null||document.getElementById("password").value==''){
    		alert("请输入密码！");
    		return;
    	}
    	if(document.getElementById("descs").value==null||document.getElementById("descs").value==''){
    		alert("请输入描述！");
    		return;
    	}
    	document.getElementById("addform").submit();
    }
    
    </script>
  </head>

	<body bgcolor="pink">
		<div align="left">
			<form action="user_AddUser.action" id="addform" method="post">
				姓名：
				<input type="text" name="username" id="username" />
				<br>
				<br>
				密码：
				<input type="password" name="password" id="password" />
				<br>
				<br>
				描述：
				<input type="text" name="descs" id="descs" />
				<br>
				<br>
				<input type="button" value="确定" onclick="sub()">
				<input type="reset" value="重置">
				<br>
			</form>
		</div>
	</body>
</html>
