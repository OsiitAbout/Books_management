<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>商品详情</title>
		<script type="text/javascript">
    function fanhui(){
   		 location.href="shu_Zhanshi.action";
    }
     function liji(flag){
    	location.href="shu_Liji.action?xiaoshuono="+flag;
    }
     function jia(){
   		
		if(document.getElementById("shulang").value==null||document.getElementById("shulang").value==''){
			alert("请输入您要添加的数量！");
		}else{
			var price = '${price }';
			var num = document.getElementById("shulang").value;
			var zongjia =Number(num)*Number(price);
		
			document.getElementById("num").value = zongjia;
			document.getElementById("addform").action ="dingdan_Gouwuche.action";
			document.getElementById("addform").submit();
		}
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
		<form action="shu_Miaoshu.action" id="addform" method="post" enctype="multipart/form-data">
			<br>
			<br>
			<font size="6">本书详情</font>
			<br>
			<img src="${pageContext.request.contextPath}/tupian/${tupianFileName }" width="300" height="300">
			<br>
			<input type="hidden" name="user" value="${user }">
			用户：${user }
			<br>
			<input type="hidden" name="xiaoshuono" value="${xiaoshuono }">
			编号：${xiaoshuono }
			<br>
			<input type="hidden" name="xiaoshuoname" value="${xiaoshuoname }">
			名字：${xiaoshuoname }
			<br>
			<input type="hidden" name="price" value="${price }">
			价格：${price }
			<br>
			<input type="hidden" name="zuozhe" value="${zuozhe }">
			作者：${zuozhe }
			<br/>
			<input type="hidden" name="xiangqing" value="${xiangqing }">
			详情：${xiangqing }
			<br>
			<input type="hidden" name="kucun" value="${kucun }">
			库存：${kucun }
			<br>
			<br/>
			购买数量：
			<input type="text" name="shuliang" id="shulang" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
			<input type="hidden" id="num" name="zongjia">
			<input type="button" value="立即购买" onclick="liji(${xiaoshuono})">
			<input type="button" value="加入购物车" onclick="jia()" />
			<input type="button" value="返回" onclick="fanhui()" />
		</form>
	</body>
</html>
