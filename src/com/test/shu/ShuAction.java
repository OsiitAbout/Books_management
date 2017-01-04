package com.test.shu;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


public class ShuAction {

	//小说编号
	private String xiaoshuono;
	//小说名字
	private String xiaoshuoname;
	//小说价格
	private String price;
	//上传的文件名
	private File tupian;
	// 封装上传文件类型的属性
	private String tupianContentType;
	//封装上传文件名的属性
	private String tupianFileName;
	//作者
	private String zuozhe;
	//小说的详情
	private String xiangqing;
	//小说的出版日期
	private String chubanriqi;
	//审核的上下架
	private String shangxiajia;
	//小说的分类
	private String fenlei;
	//库存
	private String kucun;

	private int instance;

	private int models;
	public int getInstance() {
		return instance;
	}
	public void setInstance(int instance) {
		this.instance = instance;
	}
	public int getModels() {
		return models;
	}
	public void setModels(int models) {
		this.models = models;
	}
	public String getXiaoshuono() {
		return xiaoshuono;
	}
	public void setXiaoshuono(String xiaoshuono) {
		this.xiaoshuono = xiaoshuono;
	}
	public String getXiaoshuoname() {
		return xiaoshuoname;
	}
	public void setXiaoshuoname(String xiaoshuoname) {
		this.xiaoshuoname = xiaoshuoname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getZuozhe() {
		return zuozhe;
	}
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	public String getXiangqing() {
		return xiangqing;
	}
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	public String getChubanriqi() {
		return chubanriqi;							
	}
	public void setChubanriqi(String chubanriqi) {
		this.chubanriqi = chubanriqi;
	}
	public String getShangxiajia() {
		return shangxiajia;
	}
	public void setShangxiajia(String shangxiajia) {
		this.shangxiajia = shangxiajia;
	}
	public String getFenlei() {
		return fenlei;
	}
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	public String getKucun() {
		return kucun;
	}
	public void setKucun(String kucun) {
		this.kucun = kucun;
	}
	public File getTupian() {
		return tupian;
	}
	public void setTupian(File tupian) {
		this.tupian = tupian;
	}
	public String getTupianFileName() {
		return tupianFileName;
	}
	public void setTupianFileName(String tupianFileName) {
		this.tupianFileName = tupianFileName;
	}
	public void setTupianContentType(String tupianContentType) {
		this.tupianContentType = tupianContentType;
	}
	public String getTupianContentType() {
		return tupianContentType;
	}

	//主页展示全部上架小说
	public String Zhanshi(){

		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_Zhanshi";
	}

	//描述小说页面
	public String Miaoshu(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String xiaoshuono=request.getParameter("xiaoshuono");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql="select *from xiaoshuo where xiaoshuono="+xiaoshuono;
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				request.setAttribute("xiaoshuono", xiaoshuono);
				request.setAttribute("tupianFileName", rs.getString("tupian"));
				request.setAttribute("xiaoshuoname", rs.getString("xiaoshuoname"));
				request.setAttribute("price", rs.getString("price"));
				request.setAttribute("zuozhe", rs.getString("zuozhe"));
				request.setAttribute("xiangqing", rs.getString("xiangqing"));
				request.setAttribute("kucun", rs.getString("kucun"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "shu_Miaoshu";
	}

	//查询世界名著类小说
	public String ChaShijie(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='世界名著类' and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaShijie";
	}

	//查询玄幻奇幻类小说
	public String ChaXuanhuan(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='奇幻玄幻类' and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaXuanhuan";
	}

	//查询都市娱乐类小说
	public String ChaYule(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='都市娱乐类' and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaYule";
	}

	//查询武侠仙侠类小说
	public String ChaWuxia(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='武侠仙侠类' and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaWuxia";
	}

	//查询都市言情类小说
	public String ChaDoushi(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='都市言情类' and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaDoushi";
	}

	//查询历史军事类小说
	public String ChaLishi(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='历史军事类' and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaLishi";
	}

	//查询古代言情类小说
	public String ChaGudai(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='古代言情类' and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaGudai";
	}

	//管理员查询所有书籍
	public String ChaTushu(){

		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo,leixing where xiaoshuo.fenlei=leixing.fenlei";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setShangxiajia(rs.getString("shangxiajia"));
				dto.setFenlei(rs.getString("fenlei"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaTushu";
	}

	//增加新书信息
	public String AddTushu(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String realpath = ServletActionContext.getServletContext().getRealPath("/tupian");
		System.out.println("realpath: "+realpath);
		if (tupian != null) {
			File savefile = new File(new File(realpath), tupianFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			try {
				FileUtils.copyFile(tupian, savefile);
				ServletActionContext.getRequest().setAttribute("name", tupianFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String sql="insert into xiaoshuo(tupian,xiaoshuono,xiaoshuoname,price,zuozhe,xiangqing,chubanriqi,fenlei,kucun)values('"+tupianFileName+"','"+xiaoshuono+"','"+xiaoshuoname+"','"+price+"','"+zuozhe+"','"+xiangqing+"','"+chubanriqi+"','"+fenlei+"','"+kucun+"')";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ShuAction> list=new ArrayList<ShuAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1= "select * from xiaoshuo";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setShangxiajia(rs.getString("shangxiajia"));
				dto.setFenlei(rs.getString("fenlei"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaTushu";
	}

	//修改查询图书信息
	public String UpdateTushu(){

		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String xiaoshuono=request.getParameter("xiaoshuono");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql="select *from xiaoshuo where xiaoshuono="+xiaoshuono;
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				request.setAttribute("xiaoshuono", xiaoshuono);
				request.setAttribute("xiaoshuoname", rs.getString("xiaoshuoname"));
				request.setAttribute("price", rs.getString("price"));
				request.setAttribute("zuozhe", rs.getString("zuozhe"));
				request.setAttribute("xiangqing", rs.getString("xiangqing"));
				request.setAttribute("chubanriqi", rs.getString("chubanriqi"));
				request.setAttribute("kucun", rs.getString("kucun"));
				request.setAttribute("tupian", rs.getString("tupian"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "shu_UpdateTushu";
	}
	//修改图书信息
	public String UpdateTushu1(){

		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String sql="update xiaoshuo set xiaoshuoname='"+xiaoshuoname+"'," +
		"price='" + price + "',zuozhe='" + zuozhe + "'," +
		"xiangqing='"+xiangqing+"',chubanriqi='"+chubanriqi+"',kucun='"+kucun+"' where xiaoshuono="
		+ xiaoshuono;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ShuAction> list=new ArrayList<ShuAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1= "select * from xiaoshuo";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setShangxiajia(rs.getString("shangxiajia"));
				dto.setFenlei(rs.getString("fenlei"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaTushu";
	}
	//审核图书上下架、删除图书！！！！！！！！！！！！！！
	public String Shenhe(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String ids=request.getParameter("ids");
		String flag=request.getParameter("flag");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			ids=ids.substring(0,ids.length()-1);
			ids="'"+ids.replace(",","','")+"'";
			String sql="";
			if(flag.equals("1")){
				sql="delete from xiaoshuo where xiaoshuono in("+ids+");";
			}else if(flag.equals("2")){
				sql="update xiaoshuo set shangxiajia=1 where xiaoshuono in("+ids+");";
			}else{
				sql="update xiaoshuo set shangxiajia=2 where xiaoshuono in("+ids+");";

			}
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<ShuAction> list=new ArrayList<ShuAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1= "select * from xiaoshuo";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setShangxiajia(rs.getString("shangxiajia"));
				dto.setFenlei(rs.getString("fenlei"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_ChaTushu";
	}

	//立刻购买图书页面查询
	public String Liji(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String xiaoshuono=request.getParameter("xiaoshuono");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql="select *from xiaoshuo where xiaoshuono="+xiaoshuono;
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				request.setAttribute("xiaoshuono", xiaoshuono);
				request.setAttribute("tupianFileName", rs.getString("tupian"));
				request.setAttribute("xiaoshuoname", rs.getString("xiaoshuoname"));
				request.setAttribute("price", rs.getString("price"));
				request.setAttribute("zuozhe", rs.getString("zuozhe"));
				request.setAttribute("xiangqing", rs.getString("xiangqing"));
				request.setAttribute("chubanriqi", rs.getString("chubanriqi"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "shu_Liji";
	}

	//查找
	public String Chazhao(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String shuru=request.getParameter("shuru");
		System.out.println(shuru);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql="";
			sql = "select * from xiaoshuo where len(xiaoshuoname)<=3 and shangxiajia='1'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ShuAction dto=new ShuAction();
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setXiangqing(rs.getString("xiangqing"));
				dto.setChubanriqi(rs.getString("chubanriqi"));
				dto.setKucun(rs.getString("kucun"));
				dto.setTupianFileName(rs.getString("tupian"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "shu_Chazhao";
	}
}