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

	//С˵���
	private String xiaoshuono;
	//С˵����
	private String xiaoshuoname;
	//С˵�۸�
	private String price;
	//�ϴ����ļ���
	private File tupian;
	// ��װ�ϴ��ļ����͵�����
	private String tupianContentType;
	//��װ�ϴ��ļ���������
	private String tupianFileName;
	//����
	private String zuozhe;
	//С˵������
	private String xiangqing;
	//С˵�ĳ�������
	private String chubanriqi;
	//��˵����¼�
	private String shangxiajia;
	//С˵�ķ���
	private String fenlei;
	//���
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

	//��ҳչʾȫ���ϼ�С˵
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

	//����С˵ҳ��
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

	//��ѯ����������С˵
	public String ChaShijie(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='����������' and shangxiajia='1'";
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

	//��ѯ���������С˵
	public String ChaXuanhuan(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='���������' and shangxiajia='1'";
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

	//��ѯ����������С˵
	public String ChaYule(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='����������' and shangxiajia='1'";
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

	//��ѯ����������С˵
	public String ChaWuxia(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='����������' and shangxiajia='1'";
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

	//��ѯ����������С˵
	public String ChaDoushi(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='����������' and shangxiajia='1'";
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

	//��ѯ��ʷ������С˵
	public String ChaLishi(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='��ʷ������' and shangxiajia='1'";
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

	//��ѯ�Ŵ�������С˵
	public String ChaGudai(){
		List<ShuAction> list=new ArrayList<ShuAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from xiaoshuo where fenlei='�Ŵ�������' and shangxiajia='1'";
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

	//����Ա��ѯ�����鼮
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

	//����������Ϣ
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

	//�޸Ĳ�ѯͼ����Ϣ
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
	//�޸�ͼ����Ϣ
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
	//���ͼ�����¼ܡ�ɾ��ͼ�飡��������������������������
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

	//���̹���ͼ��ҳ���ѯ
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

	//����
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