<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>查询订单</title>
<script type="text/javascript">

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
			<h3>全部订单</h3>
			
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>
						订单编号
					</th>
					<th>
						名字
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
					<th>
						收货地址
					</th>
					<th>
						状态
					</th>

				</tr>
				<c:forEach items="${List}" var="item">
					<tr>
						<td>
							${item.dingdanno }
						</td>
						<td>
							${item.xiaoshuoname }
						</td>
						<td>
							${item.price}			
						</td>
						<td>
							${item.shuliang }			
						</td>
						<td>
							${item.zongjia }			
						</td>
						<td>
							${item.addres }			
						</td>
						<td>
						<c:if test="${item.shenhe eq '1' }">已发货</c:if>
						<c:if test="${item.shenhe!='1'}">暂时没有发货信息</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
