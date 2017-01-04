<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Suoyin.html</title>
	<script type="text/javascript">
	
	window.onload = function(){
        	page = new Page(3,'table1','group_one'); };

        	/**
        	* js分页类
        	* @param iAbsolute 每页显示记录数
        	* @param sTableId 分页表格属性ID值，为String
        	* @param sTBodyId 分页表格TBODY的属性ID值,为String,此项为要分页的主体内容
        	* var __variable__; private
        	* function __method__(){};private
        	*/
        	function Page(iAbsolute,sTableId,sTBodyId)
        	{
        	this.absolute = iAbsolute; //每页最大记录数
        	this.tableId = sTableId;
        	this.tBodyId = sTBodyId;
        	this.rowCount = 0;//记录数
        	this.pageCount = 0;//页数
        	this.pageIndex = 0;//页索引
        	this.__oTable__ = null;//表格引用
        	this.__oTBody__ = null;//要分页内容
        	this.__dataRows__ = 0;//记录行引用
        	this.__oldTBody__ = null;
        	this.__init__(); //初始化;
        	};
        	/*
        	初始化
        	*/
        	Page.prototype.__init__ = function(){
        	this.__oTable__ = document.getElementById(this.tableId);//获取table引用
        	this.__oTBody__ = this.__oTable__.tBodies[this.tBodyId];//获取tBody引用
        	this.__dataRows__ = this.__oTBody__.rows;
        	this.rowCount = this.__dataRows__.length;
        	try{
        	this.absolute = (this.absolute <= 0) || (this.absolute>this.rowCount) ? this.rowCount : this.absolute; 
        	this.pageCount = parseInt(this.rowCount%this.absolute == 0 
        	? this.rowCount/this.absolute : this.rowCount/this.absolute+1);
        	}catch(exception){}

        	this.__updateTableRows__();
        	};
        	/*
        	下一页
        	*/
        	Page.prototype.nextPage = function(){
        	if(this.pageIndex + 1 < this.pageCount){
        	this.pageIndex += 1;
        	this.__updateTableRows__();
        	}
        	};
        	/*
        	上一页
        	*/
        	Page.prototype.prePage = function(){
        	if(this.pageIndex >= 1){
        	this.pageIndex -= 1;
        	this.__updateTableRows__();
        	}
        	};
        	/*
        	首页
        	*/
        	Page.prototype.firstPage = function(){
        	if(this.pageIndex != 0){
        	this.pageIndex = 0;
        	this.__updateTableRows__();
        	} 
        	};
        	/*
        	尾页
        	*/
        	Page.prototype.lastPage = function(){
        	if(this.pageIndex+1 != this.pageCount){
        	this.pageIndex = this.pageCount - 1;
        	this.__updateTableRows__();
        	}
        	};
        	/*
        	页定位方法
        	*/


        	Page.prototype.aimPage = function(){ 
        	var abc = document.getElementById("pageno"); 
        	var iPageIndex = abc.value; 
        	var iPageIndex = iPageIndex*1; 
        	if(iPageIndex > this.pageCount-1){ 
        	this.pageIndex = this.pageCount -1; 
        	}else if(iPageIndex < 0){ 
        	this.pageIndex = 0; 
        	}else{ 
        	this.pageIndex = iPageIndex-1; 
        	} 
        	this.__updateTableRows__(); 
        	}; 

        	/*
        	执行分页时，更新显示表格内容
        	*/
        	Page.prototype.__updateTableRows__ = function(){
        	var iCurrentRowCount = this.absolute * this.pageIndex;
        	var iMoreRow = this.absolute+iCurrentRowCount > this.rowCount ? this.absolute+iCurrentRowCount - this.rowCount : 0;
        	var tempRows = this.__cloneRows__();
        	//alert(tempRows === this.dataRows);
        	//alert(this.dataRows.length);
        	var removedTBody = this.__oTable__.removeChild(this.__oTBody__);
        	var newTBody = document.createElement("TBODY");
        	newTBody.setAttribute("id", this.tBodyId);

        	for(var i=iCurrentRowCount; i < this.absolute+iCurrentRowCount-iMoreRow;i++){
        	newTBody.appendChild(tempRows[i]);
        	}
        	this.__oTable__.appendChild(newTBody);
        	/*
        	this.dataRows为this.oTBody的一个引用，
        	移除this.oTBody那么this.dataRows引用将销失,
        	code:this.dataRows = tempRows;恢复原始操作行集合.
        	*/
        	this.__dataRows__ = tempRows;
        	this.__oTBody__ = newTBody;
        	//alert(this.dataRows.length);
        	//alert(this.absolute+iCurrentRowCount);
        	//alert("tempRows:"+tempRows.length);
        	//页脚显示分 
        	var divFood = document.getElementById("divFood");//分页工具栏 
        	divFood.innerHTML=""; 
        	var rightBar = document.createElement("divFood"); 
        	rightBar.setAttribute("display",""); 
        	rightBar.setAttribute("float","left"); 
        	rightBar.innerHTML="第【<font color=#FF0000>"+(this.pageIndex+1)+"</font>】页/共【<font color=#FF0000>"+this.pageCount+"</font>】页"; 
        	var isOK="Y";
        	var cssColor=""; 
        	divFood.appendChild(rightBar); 

        	};
        	/*
        	克隆原始操作行集合
        	*/
        	Page.prototype.__cloneRows__ = function(){
        	var tempRows = [];
        	for(var i=0; i<this.__dataRows__.length; i++){
        	/*
        	code:this.dataRows[i].cloneNode(param), 
        	param = 1 or true:复制以指定节点发展出去的所有节点,
        	param = 0 or false:只有指定的节点和它的属性被复制.
        	*/
        	tempRows[i] = this.__dataRows__[i].cloneNode(1);
        	}
        	return tempRows;
        	};
        
	function miaoshu(flag){
		document.location.href="shu_Miaoshu.action?xiaoshuono="+flag;
	}
	
	function shijie(){
		var shijie=parent.frames["xia"];
		shijie.document.location.href="shu_ChaShijie.action";
	}
	function xuanhuan(){
		var xuanhuan=parent.frames["xia"];
		xuanhuan.document.location.href="shu_ChaXuanhuan.action";
	}
	function yule(){
		var yule=parent.frames["xia"];
		yule.document.location.href="shu_ChaYule.action";
	}
	function wuxia(){
		var wuxia=parent.frames["xia"];
		wuxia.document.location.href="shu_ChaWuxia.action";
	}
	function doushi(){
		var doushi=parent.frames["xia"];
		doushi.document.location.href="shu_ChaDoushi.action";
	}
	function lishi(){
		var lishi=parent.frames["xia"];
		lishi.document.location.href="shu_ChaLishi.action";
	}
	function gudai(){
		var gudai=parent.frames["xia"];
		gudai.document.location.href="shu_ChaGudai.action";
	}
	
	
	</script>
	<style type="text/css">
.STYLE1 {font-size: xx-large}
body {
	background-color:Pink;
}
</style>

  </head>
  
  <body>
  <div align="right">
  <c:choose>
  <c:when test="${user!=null}">
  登陆用户：${user }&nbsp;&nbsp;&nbsp;<a href="dingdan_Jiesuan.action">去结算</a>&nbsp;&nbsp;&nbsp;
  <a href="UpdateMima.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;
  <a href="/Tushu/Zhuye1.jsp">查看订单</a>
  <c:if test="${descs eq '1'}">
  <a href="/Tushu/Zhuye.jsp">后台管理</a>
  </c:if>
  <a href="/Tushu/index.jsp">退出</a>
  </c:when>
  <c:otherwise>
   		<a href="/Tushu/index.jsp">登陆</a>
   		</c:otherwise>
  </c:choose>
  <br/>
  <br/>
  <br/>
  <hr/>
  </div>
  <div align="center">
  <input type="button" id="shijie" name="shijie" onclick="shijie()" value="世界名著类">
 			<input type="button" id="xuanhuan" name="xuanhuan" onclick="xuanhuan()" value="奇幻玄幻类">
			<input type="button" id="yule" name="yule" onclick="yule()" value="都市娱乐类">
			<input type="button" id="wuxia" name="wuxia" onclick="wuxia()" value="武侠仙侠类">
			<input type="button" id="doushi" name="doushi" onclick="doushi()" value="都市言情类">
			<input type="button" id="lishi" name="lishi" onclick="lishi()" value="历史军事类">	
			<input type="button" id="gudai" name="gudai" onclick="gudai()" value="古代言情类">
			</div><br/><br/>
			<div align="center">
			<form action="shu_Chazhao.action" id="form" method="post">
				<input type="text" name="shuru" id="shuru">&nbsp;&nbsp;&nbsp;
				<input type="submit" value="查找" onclick="chazhao()">
			</form>
 </div><br><br><br>
 <table id="table1" border="1" cellpadding="20" cellspacing="0" align="center">
 <thead>
				<tr>
					<th>
						小说展示
					</th>
					<th>
						编号
					</th>
					<th>
						名字
					</th>
					<th>
						价格
					</th>
					<th>
						作者
					</th>
					<th>
						详情
					</th>
					<th>
						出版时间
					</th>
					<th>
						库存
					</th>

				</tr>
				</thead>
  		<tbody id="group_one">
				<c:forEach items="${List}" var="item">
					<tr>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							<img src="${pageContext.request.contextPath}/tupian/${item.tupianFileName }" width="80" height="60">
							</a>
						</td>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							${item.xiaoshuono }
							</a>
						</td>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							${item.xiaoshuoname }
							</a>
						</td>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							${item.price }
							</a>
						</td>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							${item.zuozhe }
							</a>
						</td>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							${item.xiangqing }
							</a>
						</td>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							${item.chubanriqi }
							</a>
						</td>
						<td><a href="shu_Miaoshu.action?xiaoshuono=${item.xiaoshuono }">
							${item.kucun }
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br/>
			<table align="center">
				<tr>
					<td class="di_1"><span id="divFood"></span><br></td>
					<td class="di_1">第 <input id="pageno" value="1" style="width:20px"/>页/<a href="#" onclick="page.aimPage()" class="fenye">跳转</a></td>
					<td class="di_1"><a href="#" onclick="page.firstPage()" class="fenye">首 页</a></td>
					<td class="di_1"><a href="#" onclick="page.prePage()" class="fenye">上一页</a></td>
					<td class="di_1"><a href="#" onclick="page.nextPage()" class="fenye">下一页</a></td>
					<td class="di_1"><a href="#" onclick="page.lastPage()" class="fenye">末 页</a></td>
				</tr>
			</table>
	</body>
</html>
