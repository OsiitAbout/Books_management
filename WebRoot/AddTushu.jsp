<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
    <script type="text/javascript">
    
    function sub(){
    
    	//验证是否已经选择图片
   	 	if(document.getElementById("tupian").value==null||document.getElementById("tupian").value==''){
    		alert("请选择你要上传的图片！！");
    		return;
    	}
    	//验证是否输入小说编号
   	 	if(document.getElementById("xiaoshuono").value==null||document.getElementById("xiaoshuono").value==''){
    		alert("请输入编号！！");
    		return;
    	}
    	//验证小说名字必须为汉字
    	var reg=/^[\u4E00-\u9FA5]{2,4}$/;//正则表达式必须为汉字
    	if(document.getElementById("xiaoshuoname").value==null||document.getElementById("xiaoshuoname").value==''){
    		alert("请输入名字！");
    		return;
    	}else if(document.getElementById("xiaoshuoname").value.length>10){
    		alert("小说名字不能超过10个字符");
    		document.getElementById("xiaoshuoname").focus();
    		return;
    	}else if(!reg.test(document.getElementById("xiaoshuoname").value)){
    		alert("小说名字必须为汉子!");
    		document.getElementById("xiaoshuoname").focus();
    		return;
    	}
    	//验证价格是否输入正确
    	if(document.getElementById("price").value==null||document.getElementById("price").value==''){
    		alert("请输入价格！");
    		return;
    	}else if(isNaN(document.getElementById("price").value)){
    		alert("价格输入错误！");
    		document.getElementById("price").focus();
    		return;
    	}
    	//验证作者必须为汉字
    	var reg=/^[\u4E00-\u9FA5]{2,4}$/;//正则表达式必须为汉字
    	if(document.getElementById("zuozhe").value==null||document.getElementById("zuozhe").value==''){
    		alert("请输入作者！");
    		return;
    	}else if(!reg.test(document.getElementById("zuozhe").value)){
    		alert("作者必须为汉子!");
    		return;
    	}
    	//小说详情不能超过二十个字符
    	if(document.getElementById("xiangqing").value==null||document.getElementById("xiangqing").value==''){
    		alert("请输入详情！");
    		return;
    	}else if(document.getElementById("xiangqing").value.length>10){
    		alert("小说详情不能超过20个字符");
    		document.getElementById("xiangqing").focus();
    		return;
    	}
    	//验证输入的日期是否正确
    	var chubanriqi=document.getElementById("chubanriqi").value;//获取文本框内容
    	var s=chubanriqi.split("-");//用“-”分内容
    	if(document.getElementById("chubanriqi").value==null||document.getElementById("chubanriqi").value==''){
    		alert("请输入出版日期！");
    		return;
    	}else if(s.length!=3){
    		alert("日期格式不正确，请重新输入,格式为XX-XX-XX！");	
    		document.getElementById("chubanriqi").focus();
    		return;
    	}else if(isNaN(s[0])){
    		alert("年只能输入数字！");
    		document.getElementById("chubanriqi").focus();
    		return;
    	}else if(isNaN(s[1])){
    		alert("月只能输入数字！");
    		document.getElementById("chubanriqi").focus();
    		return;
		}else if(isNaN(s[2])){
    		alert("日只能输入数字！");
    		document.getElementById("chubanriqi").focus();
    		return;
    	}else if(s[0]<1900||s[0]>2016){
    		alert("年只能输入1900-2016！");
    		document.getElementById("chubanriqi").focus();
    		return;
    	}else if(s[1]<1||s[1]>12){
    		alert("月只能输入1-12！");
    		document.getElementById("chubanriqi").focus();
    		return;
    	}else if(s[2]<1||s[2]>31){
    		alert("日只能输入1-31！");
    		document.getElementById("chubanriqi").focus();
    		return;
    	} 
    	 //验证是否输入输入库存
   	 	if(document.getElementById("kucun").value==null||document.getElementById("kucun").value==''){
    		alert("请输入库存！！");
    		return;
    	}
    	document.getElementById("addform").submit();
    }
    
    </script>
  </head>

	<body bgcolor="pink">
	<h1 align="center">增加图书</h1>
		<div align="center">
			<form action="shu_AddTushu.action" id="addform" method="post" enctype="multipart/form-data">
				小说展示：
				<input type="file" name="tupian" id="tupian" />
				<br>
				<br>
				编号：
				<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="xiaoshuono" name="xiaoshuono">
				<br>
				<br>
				名字：
				<input type="text" name="xiaoshuoname" id="xiaoshuoname" />
				<br>
				<br>
				价格：
				<input type="text" name="price" id="price" />
				<br>
				<br>
				作者：
				<input type="text" name="zuozhe" id="zuozhe" />
				<br>
				<br>
				详情：
				<input type="text" name="xiangqing" id="xiangqing" />
				<br>
				<br>
				分类：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<select id="fenlei" name="fenlei">
					<option>世界名著类</option>
				    <option>奇幻玄幻类</option>
				    <option>都市娱乐类</option>
				    <option>武侠仙侠类</option>
				    <option>都市言情类</option>
				    <option>历史军事类</option>
				    <option>古代言情类</option>
				</select>
				<br>
				<br>
				出日：
				<input type="text" name="chubanriqi" id="chubanriqi" />
				<br>
				<br>
				库存：
				<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="kucun" name="kucun">
				<br>
				<br>
				<input type="button" value="确定" onclick="sub()">
				<input type="reset" value="重置">
				<br>
			</form>
		</div>
	</body>
</html>
