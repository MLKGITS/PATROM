package dao;
import java.sql.*;

import com.mysql.jdbc.Connection;

import beans.LoginBean;

public class LoginDao {
	
	String dbUrl ="jdbc:mysql://localhost:3306/userdb";
	String dbUname = "root";
	String dbPass = "";
	String dbDriver = "com.mysql.jdbc.Driver";
	
	
	
	
	public void loadDriver(String bdDrver) {
		try {
			Class.forName(dbDriver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection(dbUrl, dbUname, dbPass);
			
			System.out.println("CONNECTED");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  con;
	}
	
	
	public boolean validate(LoginBean loginBean) {
		loadDriver(dbDriver);
		
		Connection con = getConnection();
		String sql = "select * from profil where name=? and password=?";
		boolean status = false;
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getUserpass());
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return status; 
		}
		
		
	}
	

	

