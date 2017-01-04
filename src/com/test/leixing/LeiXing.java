package com.test.leixing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


public class LeiXing {

	//小说的类型no
	private String leixingno;
	//小说的类型名字
	private String fenlei;


	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}

	public String getFenlei() {
		return fenlei;
	}
	public void setLeixingno(String leixingno) {
		this.leixingno = leixingno;
	}

	public String getLeixingno() {
		return leixingno;
	}
	
	//管理员查询所有图书类型
	public String Chaleixing(){
		List<LeiXing> list=new ArrayList<LeiXing>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from leixing";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				LeiXing dto=new LeiXing();
				dto.setLeixingno(rs.getString("leixingno"));
				dto.setFenlei(rs.getString("fenlei"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "lei_Chaleixing";
	}

//	增加图书类型
	public String Addleixing(){
		String sql="insert into leixing(leixingno,fenlei)values('"+leixingno+"','"+fenlei+"')";
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
		List<LeiXing> list=new ArrayList<LeiXing>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1 = "select * from leixing";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				LeiXing dto=new LeiXing();
				dto.setLeixingno(rs.getString("leixingno"));
				dto.setFenlei(rs.getString("fenlei"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "lei_Chaleixing";
	}
	
//	修改查询图书类型
	public String Updateleixing(){
		
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String leixingno=request.getParameter("leixingno");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql="select *from leixing where leixingno="+leixingno;
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				request.setAttribute("leixingno", leixingno);
				request.setAttribute("fenlei", rs.getString("fenlei"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "lei_Updateleixing";
	}
//	修改图书类型
	public String Updateleixing1(){
		
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String sql="update leixing set fenlei='"+fenlei+"' where leixingno='"+ leixingno+"'";
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
		List<LeiXing> list=new ArrayList<LeiXing>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1 = "select * from leixing";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				LeiXing dto=new LeiXing();
				dto.setLeixingno(rs.getString("leixingno"));
				dto.setFenlei(rs.getString("fenlei"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "lei_Chaleixing";
	}
//	删除图书类型
	public String Deleteleixing(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String leixingno = request.getParameter("leixingno");
		String ss[] = leixingno.split(",");
		for (int i = 0; i < ss.length; i++) {
			String sql = "delete from leixing where leixingno=" + ss[i];
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "lei_Deleteleixing";
	}
}
