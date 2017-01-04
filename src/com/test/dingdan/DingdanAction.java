package com.test.dingdan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;




public class DingdanAction {

	//�������
	private String dingdanno;
	//�û���
	private String username;
	//С˵������
	private String xiaoshuoname;
	//С˵�ı��
	private String xiaoshuono;
	//�۸�
	private String price;
	//�ջ���ַ
	private String addres;
	public String getXiaoshuono() {
		return xiaoshuono;
	}

	public void setXiaoshuono(String xiaoshuono) {
		this.xiaoshuono = xiaoshuono;
	}

	//����
	private String shuliang;
	//�ܼ�
	private String zongjia;
//	���
	private String shenhe;
//	����
	private String zuozhe;
	
	public String getZuozhe() {
		return zuozhe;
	}

	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}

	public String getShenhe() {
		return shenhe;
	}

	public void setShenhe(String shenhe) {
		this.shenhe = shenhe;
	}

	public String getDingdanno() {
		return dingdanno;
	}

	public void setDingdanno(String dingdanno) {
		this.dingdanno = dingdanno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getShuliang() {
		return shuliang;
	}

	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}

	public String getZongjia() {
		return zongjia;
	}

	public void setZongjia(String zongjia) {
		this.zongjia = zongjia;
	}
	public void setXiaoshuoname(String xiaoshuoname) {
		this.xiaoshuoname = xiaoshuoname;
	}

	public String getXiaoshuoname() {
		return xiaoshuoname;
	}

	//��ѯ���ж���
	public String ChaDingdan(){
		List<DingdanAction> list=new ArrayList<DingdanAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from dingdan";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				DingdanAction dto=new DingdanAction();
				dto.setDingdanno(rs.getString("dingdanno"));
				dto.setUsername(rs.getString("username"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setAddres(rs.getString("addres"));
				dto.setShuliang(rs.getString("shuliang"));
				dto.setZongjia(rs.getString("zongjia"));
				dto.setShenhe(rs.getString("shenhe"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "dingdan_ChaDingdan";
	}
	
	//���Ӷ���
	@SuppressWarnings("deprecation")
	public String AddDingdan(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		Date time=new Date();
		String user=request.getParameter("user");
		String xiaoshuoname=request.getParameter("xiaoshuoname");
		String price=request.getParameter("price");
		String addres=request.getParameter("addres");
		String shuliang=request.getParameter("shuliang");
		String zongjia=request.getParameter("zongjia");
		String dingdanno=""+time.getHours()+time.getDate()+time.getMonth()+time.getDay()+time.getYear()+time.getMinutes()+time.getSeconds();
		String sql="insert into dingdan(dingdanno,username,xiaoshuoname,price,addres,shuliang,zongjia)values('"+dingdanno+"','"+user+"','"+xiaoshuoname+"','"+price+"','"+addres+"','"+shuliang+"','"+zongjia+"')";
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
		return "dingdan_AddDingdan";
	}
	
	//��˶���
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
				sql="update dingdan set shenhe=1 where dingdanno in("+ids+");";
			}else{
				sql="update dingdan set shenhe=2 where dingdanno in("+ids+");";
			}
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<DingdanAction> list=new ArrayList<DingdanAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from dingdan";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				DingdanAction dto=new DingdanAction();
				dto.setDingdanno(rs.getString("dingdanno"));
				dto.setUsername(rs.getString("username"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setAddres(rs.getString("addres"));
				dto.setShuliang(rs.getString("shuliang"));
				dto.setZongjia(rs.getString("zongjia"));
				dto.setShenhe(rs.getString("shenhe"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "dingdan_ChaDingdan";
	}

	//��ͼ����ӵ����ﳵ
	public String Gouwuche(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String user=request.getParameter("user");
		String sql="insert into dingdan1(username,xiaoshuono,price,zuozhe,shuliang,zongjia)values('"+user+"','"+xiaoshuono+"','"+price+"','"+zuozhe+"','"+shuliang+"','"+zongjia+"')";
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
		return "dingdan_Gouwuche";
	}

	//����ҳ���ѯ
	public String Jiesuan(){

		List<DingdanAction> list=new ArrayList<DingdanAction>();
		
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String user=(String)request.getSession().getAttribute("user");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from dingdan1 where username='"+user+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				DingdanAction dto=new DingdanAction();
				dto.setUsername(rs.getString("username"));
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setPrice(rs.getString("price"));
				dto.setShuliang(rs.getString("shuliang"));
				dto.setZongjia(rs.getString("zongjia"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "dingdan_Jiesuan";
	}
	
//	�����ύ����
	@SuppressWarnings("deprecation")
	public String Goumai(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		Date time=new Date();
		String user=request.getParameter("user");
		String xiaoshuono=request.getParameter("xiaoshuono");
		String xiaoshuoname=request.getParameter("xiaoshuoname");
		String price=request.getParameter("price");
		String xiangqing=request.getParameter("xiangqing");
		String addres=request.getParameter("addres");
		String shuliang=request.getParameter("shuliang");
		String zongjia=request.getParameter("zongjia");
		String dingdanno=xiaoshuono+""+time.getHours()+time.getDate()+time.getMonth()+time.getDay()+time.getYear()+time.getMinutes()+time.getSeconds();
		String sql="insert into dingdan(dingdanno,username,xiaoshuono,xiaoshuoname,price,xiangqing,addres,shuliang,zongjia)values('"+dingdanno+"','"+user+"','"+xiaoshuono+"','"+xiaoshuoname+"','"+price+"','"+xiangqing+"','"+addres+"','"+shuliang+"','"+zongjia+"')";
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
		return "dingdan_AddDingdan";
	}
	
	//tijiao����
	@SuppressWarnings("deprecation")
	public String Add(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		Date time=new Date();
		String xiaoshuono=request.getParameter("xiaoshuono");
		System.out.println(xiaoshuono);
		String user=request.getParameter("user");
		System.out.println(user);
		String xiaoshuoname=request.getParameter("xiaoshuoname");
		System.out.println(xiaoshuoname);
		String price=request.getParameter("price");
		String addres=request.getParameter("addres");
		String shuliang=request.getParameter("shuliang");
		String zongjia=request.getParameter("zongjia");
		String dingdanno=""+time.getHours()+time.getDate()+time.getMonth()+time.getDay()+time.getYear()+time.getMinutes()+time.getSeconds();
		String sql="insert into dingdan(dingdanno,username,xiaoshuoname,price,addres,shuliang,zongjia)values('"+dingdanno+"','"+user+"','"+xiaoshuoname+"','"+price+"','"+addres+"','"+shuliang+"','"+zongjia+"')";
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

		List<DingdanAction> list=new ArrayList<DingdanAction>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql1 = "select * from dingdan1";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				DingdanAction dto=new DingdanAction();
				dto.setUsername(rs.getString("username"));
				dto.setXiaoshuono(rs.getString("xiaoshuono"));
				dto.setZuozhe(rs.getString("zuozhe"));
				dto.setPrice(rs.getString("price"));
				dto.setShuliang(rs.getString("shuliang"));
				dto.setZongjia(rs.getString("zongjia"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
				Statement st=con.createStatement();
				String sql2="delete from dingdan1 where xiaoshuono='"+xiaoshuono+"'";
				st.executeUpdate(sql2);
				st.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		return "dingdan_Add";
	}
//	��ѯ�Լ��������
	
	public String Dingdan(){
		
		List<DingdanAction> list=new ArrayList<DingdanAction>();
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		String user=(String)request.getSession().getAttribute("user");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test","sa","123456");
			Statement st=con.createStatement();
			String sql = "select * from dingdan where username='"+user+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				DingdanAction dto=new DingdanAction();
				dto.setDingdanno(rs.getString("dingdanno"));
				dto.setXiaoshuoname(rs.getString("xiaoshuoname"));
				dto.setPrice(rs.getString("price"));
				dto.setAddres(rs.getString("addres"));
				dto.setShuliang(rs.getString("shuliang"));
				dto.setZongjia(rs.getString("zongjia"));
				dto.setShenhe(rs.getString("shenhe"));
				list.add(dto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("List", list);
		return "dingdan_Dingdan";
	}


	
}
