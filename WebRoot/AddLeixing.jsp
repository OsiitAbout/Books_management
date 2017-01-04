<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书类型</title>
    <script type="text/javascript">
    
    function sub(){
    	if(document.getElementById("leixingno").value==null||document.getElementById("leixingno").value==''){
    		alert("请输入类型编号！");
    		return;
    	}
    	var reg=/^[\u4E00-\u9FA5]{2,4}$/;//正则表达式必须为汉字
    	if(document.getElementById("fenlei").value==null||document.getElementById("fenlei").value==''){
    		alert("请输入类型名字！");
    		return;
    	}else if(document.getElementById("fenlei").value.length>10){
    		alert("小说类型名字不能超过10个字符");
    		document.getElementById("fenlei").focus();
    		return;
    	}else if(!reg.test(document.getElementById("fenlei").value)){
    		alert("小说名字必须为汉子!");
    		document.getElementById("fenlei").focus();
    		return;
    	}
    	document.getElementById("addform").submit();
    }
    
    </script>
  </head>

	<body bgcolor="pink">
		<div align="center">
			<form action="lei_Addleixing.action" id="addform" method="post">
				编号：
				<input type="text" name="leixingno" id="leixingno" />
				<br>
				<br>
				类型：
				<input type="text" name="fenlei" id="fenlei" />
				<br>
				<br>
				<input type="button" value="确定" onclick="sub()">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置">
				<br>
			</form>
		</div>
	</body>
</html>
