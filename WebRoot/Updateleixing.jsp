<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>产品修改</title>
		<script type="text/javascript">
    function sub(){
    
    	 //验证小说名字必须为汉字
    	var reg=/^[\u4E00-\u9FA5]{2,4}$/;//正则表达式必须为汉字
    	if(document.getElementById("fenlei").value==null||document.getElementById("fenlei").value==''){
    		alert("请输入类型名字！");
    		return;
    	}else if(document.getElementById("fenlei").value.length>10){
    		alert("小说类型名字不能超过10个字符");
    		document.getElementById("fenlei").focus();
    		return;
    	}else if(!reg.test(document.getElementById("fenlei").value)){
    		alert("小说类型名字必须为汉子!");
    		document.getElementById("fenlei").focus();
    		return;
    	}
        document.getElementById("updateform").submit();
    }
    </script>
     <style type="text/css">
<!--
.STYLE1 {font-size: xx-large}
body {
	background-color:pink;
}
-->
</style>	
	</head>
	<body>
	
		<div align="center">
		
			<form action="lei_Updateleixing1.action" id="updateform"
				method="post">
				编号：
				<input type="text" name="leixingno" id="leixingno" value="${leixingno }" readonly="readonly"/>
				<br>
				<br>
				名字：
				<input type="text" name="fenlei" id="fenlei" value="${fenlei }" />
				<br>
				<br>
				<input type="button" value="提交" onclick=sub();>
				<input type="reset" value="重置">
			</form>
		</div>
	</body>
</html>
