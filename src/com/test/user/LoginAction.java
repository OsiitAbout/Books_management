package com.test.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class LoginAction {

	//用户名
	private String username;
	//用户密码
	private String password;
	//描述
	private String descs;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}
	//登陆验证
	public String login(){
		List<LoginAction> list=new ArrayList<LoginAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
		HttpSession se=request.getSession(); 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
		Statement st=con.createStatement();
		String sql="select *from [user2] where username='"+username+"' and password='"+password+"'";
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			request.setAttribute("List",list);
			se.setAttribute("user", username);
			se.setAttribute("password", rs.getString("password"));
			se.setAttribute("descs", rs.getString("descs"));
			return "user_Zhuye";
		}else{
			return "user_Cuowu";
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//注册用户信息
	public String Zhuce(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test", "sa","123456");
			Statement st=con.createStatement();
			String sql = "insert into [user2] values('"+username+"','"+password+"','"+descs+"');";
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "user_Zhuce";
	}
	//查询所有用户信息
	public String ChaUser(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		List<LoginAction> list=new ArrayList<LoginAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql="select *from [user2]";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				LoginAction dto=new LoginAction();
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setDescs(rs.getString("descs"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "user_ChaUser";
	}
	//增加用户
	public String AddUser(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String descs=request.getParameter("descs");
		String sql="insert into [user2](username,password,descs)values('"+username+"','"+password+"','"+descs+"')";
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
		List<LoginAction> list=new ArrayList<LoginAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1="select *from [user2]";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				LoginAction dto=new LoginAction();
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setDescs(rs.getString("descs"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "user_ChaUser";
	}
	//删除用户
	public String DeleteUser(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String ss[]=username.split(",");
		for(int i=0;i<ss.length;i++){
			String sql="delete from [user2] where username='"+ss[i]+"';";
			System.out.println(sql);
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
				Statement st=con.createStatement();
				st.executeUpdate(sql);
				st.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		List<LoginAction> list=new ArrayList<LoginAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1="select *from [user2]";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				LoginAction dto=new LoginAction();
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setDescs(rs.getString("descs"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "user_ChaUser";
	}
	//更改密码
	public String UpdateMima(){
		
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			String sql="update [user2] set password='"+password+"' where username='"+username+"';";
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			java.sql.Statement st=con.createStatement();
			st.executeUpdate(sql);
			System.out.println(sql);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "user_UpdateMima";
	}

}
