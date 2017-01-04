<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>商品详情</title>
		<script type="text/javascript">
	function fanhui() {
		window.parent.location.href = "/Tushu/G.jsp";
	}
	function liji() {
		var price = '${price }';
		var num = document.getElementById("shuliang").value;
		var zongjia =Number(num)*Number(price);
		document.getElementById("num").value = zongjia;
		if(document.getElementById("shuliang").value==null||document.getElementById("shuliang").value==''){
    		alert("请您 添加要购买的数量！");
    		return;
    	}
    	if(document.getElementById("addres").value==null||document.getElementById("addres").value==''){
    		alert("请输入收货地址！");
    		return;
    	}else if(document.getElementById("addres").value.length>20){
    		alert("地址不能超过20个字符");
    		document.getElementById("addres").focus();
    		return;
    	}
		document.getElementById("addform").action ="dingdan_AddDingdan.action";
		document.getElementById("addform").submit();
	}
</script>
		<style type="text/css">
<!--
.STYLE1 {
	font-size: xx-large
}

body {
	background-color: pink;
}
-->
</style>
	</head>

	<body>
		<form id="addform" method="post">
			<br>
			<br>
			<font size="6">购买页面</font>
			<br>
			<img src="${pageContext.request.contextPath}/tupian/${tupianFileName }" width="300" height="250">
			<br>
			<input type="hidden" name="user" value="${user }">
			 用户：${user }
			<br/>
			<input type="hidden" name="xiaoshuono" value="${xiaoshuono }">
			 编号：${xiaoshuono }
			<br/>
			<input type="hidden" name="xiaoshuoname" value="${xiaoshuoname }">
			 名字：${xiaoshuoname }
			<br>
			<input type="hidden" name="price" value="${price }">
			价格：${price }
			<br>
			<input type="hidden" name="zuozhe" value="${zuozhe }">
			作者：${zuozhe }
			<br>
			<input type="hidden" name="xiangqing" value="${xiangqing }">
			详情：${xiangqing }
			<br>
			<input type="hidden" name="chubanriqi" value="${chubanriqi }">
			日期：${chubanriqi }
			<br>
			<br>

			购买数量：
			<input type="hidden" id="num" name="zongjia">
			<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="shuliang" name="shuliang">
			<br>
			收货地址：
			<input type="text" name="addres" id="addres"/>
			<br>
			<input type="button" value="立即购买" onclick="liji()">
			<input type="button" value="返回" onclick="fanhui()" />
		</form>
	</body>
</html>
