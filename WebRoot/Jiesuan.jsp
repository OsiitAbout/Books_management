<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>结算页面</title>
		<script type="text/javascript">
		function checks(){
	var checkall=document.getElementById("checkall");
	var checks=document.getElementsByName("checks");
	if(checkall.checked==true){
		for(var i=0;i<checks.length;i++){
			checks[i].checked=true;
		}
	}else{
		for(var i=0;i<checks.length;i++){
			checks[i].checked=false;
		}
	}
}
	function fanhui(){
		document.location.href="shu_Zhanshi.action";
	}
	
	function tijiao(){
		var xiaoshuono="";
        var checks=document.getElementsByName("checks");
        for(var i=0;i<checks.length;i++){
        	if(checks[i].checked==true){
            	xiaoshuono=xiaoshuono+checks[i].value+",";
        	}
        }
        if(xiaoshuono!=""){
        	if(confirm('你确认提交？')){
        		document.location.href="dingdan_Add.action?xiaoshuono="+xiaoshuono;
        	}        }else{
        	alert("请选择购买图书！");
        }
    }	
</script>


	</head>

	<body bgcolor="pink">
	
			<div align="center">
				<span class="STYLE1"><strong>结算页面</strong>
				</span>
			</div>
			<h4>
				登陆用户：${user }
			</h4>
			<div align="right">
				<input type="button" value="返回首页" onclick="fanhui()">
			</div>
			<hr>
			<div align="center">
				<br />
				<br />
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<th>
							<input type="checkbox" name="checkall" id="checkall"
							onClick="checks()" />全选
						</th>
						<th>
							编号
						</th>
						<th>
							用户
						</th>
						<th>
							作者
						</th>
						<th>
							价格
						</th>
						<th>
							数量
						</th>
						<th>
							总价
						</th>
					</tr>
					<c:forEach items="${List}" var="item">
						<tr>
							<td>
								<input type="checkbox" name="checks" value="${item.xiaoshuono }" />
							</td>
							<td>
								${item.xiaoshuono }
								<input type="hidden" id="xiaoshuono"
									value="${item.xiaoshuono }" />
							</td>
							<td>
								${item.username }
								<input type="hidden" id="user" value="${item.username }" />
							</td>
							<td>
								${item.zuozhe }
								<input type="hidden" id="zuozhe" value="${item.zuozhe }" />
							</td>
							<td>
								${item.price }
								<input type="hidden" id="price" value="${item.price }" />
							</td>
							<td>
								${item.shuliang }
								<input type="hidden" id="shuliang" value="${item.shuliang }" />
							</td>
							<td>
								${item.zongjia }
								<input type="hidden" id="zongjia" value="${item.zongjia }" />
							</td>
							
						</tr>
					</c:forEach>
				</table>
				<br/>
							收货地址：&nbsp;&nbsp;&nbsp;
								<input type="text" name="addres" /><br/><BR/>
								<input type="submit" value="提交订单" id="tj" onclick="tijiao()">
			</div>
	</body>
</html>
