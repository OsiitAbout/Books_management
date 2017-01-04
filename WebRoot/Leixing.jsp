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
        
  function checks(){
		var checkall=document.getElementById("checkall");
		var ids=document.getElementsByName("ids");
		if(checkall.checked==true){
			for(var i=0;i<ids.length;i++){
				ids[i].checked=true;
			}
		}else{
			for(var i=0;i<ids.length;i++){
				ids[i].checked=false;
			}
		}
	}
		function add(){
		var add=parent.frames["xia"];
		var zengjia=document.location.href="AddLeixing.jsp";
	}
		function xiugai(){
    	var leixingno="";
    	var count=0;
    	var ids=document.getElementsByName("ids");
    	for(var i=0;i<ids.length;i++){
    		if(ids[i].checked==true){
    			leixingno=ids[i].value;
    			count++;
    			if(count>1){
    				alert('请选择一个要修改的数据！');
    				return;
    			}
    		}
    	}
    	if(leixingno!=""){
        	location.href="lei_Updateleixing.action?leixingno="+leixingno;
        }else{
        	alert("请选择修改的数据！");
        }
    }
		function shanchu(){
        var leixingno="";
        var ids=document.getElementsByName("ids");
        for(var i=0;i<ids.length;i++){
        	if(ids[i].checked==true){
            	leixingno=leixingno+ids[i].value+",";
        	}
        }
        if(leixingno!=""){
        	if(confirm('你确认删除？')){
        		location.href="lei_Deleteleixing.action?leixingno="+leixingno;
        	}
        }else{
        	alert("请选择删除的数据！");
        	
        }
    }	
		</script>
	</head>

	<body bgcolor="yellow">
		<div align="center">
			<input type="button" value="增加图书类型" onclick="add()">
			<input type="button" value="修改图书类型" onclick="xiugai()">
			<input type="button" value="删除图书类型" onclick="shanchu()">
			<br>
			<br>
			<table id="table1" border="1" cellpadding="10" cellspacing="0" align="center">
			<thead>
				<tr>
					<th>
						<input type="checkbox" id="checkall" name="checkall" onclick="checks()";> 
						全选
					</th>
					<th>
						编号
					</th>
					<th>
						名字
					</th>

				</tr>
				</thead>
  		<tbody id="group_one">
				<c:forEach items="${List}" var="item">
					<tr>
						<td>
							<input type="checkbox" name="ids" value="${item.leixingno }">
						</td>
						<td>
							${item.leixingno }
						</td>
						<td>
							${item.fenlei }
						</td>
					</tr>
				</c:forEach>
			</table>
			<br/>
			<table>
				<tr>
					<td class="di_1"><span id="divFood"></span><br></td>
					<td class="di_1">第 <input id="pageno" value="1" style="width:20px"/>页/<a href="#" onclick="page.aimPage()" class="fenye">跳转</a></td>
					<td class="di_1"><a href="#" onclick="page.firstPage()" class="fenye">首 页</a></td>
					<td class="di_1"><a href="#" onclick="page.prePage()" class="fenye">上一页</a></td>
					<td class="di_1"><a href="#" onclick="page.nextPage()" class="fenye">下一页</a></td>
					<td class="di_1"><a href="#" onclick="page.lastPage()" class="fenye">末 页</a></td>
				</tr>
			</table>
		</div>
	</body>

</html>
