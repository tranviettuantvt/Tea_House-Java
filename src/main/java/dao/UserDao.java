package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbCon;
import model.Category;
import model.Product;
import model.User;

public class UserDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List<Category> getListCategory(){
		try {
			String query="SELECT * FROM tea_house_prj301.category";
			conn=new DbCon().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<Category> clist=new ArrayList<>();
			while(rs.next()) {
				Category ct= new Category(rs.getInt(1), rs.getString(2));
				clist.add(ct);
			}
			return clist;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public List<User> getListUser(){
		try {
			String query="SELECT * FROM tea_house_prj301.user";
			conn=new DbCon().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<User> ulist=new ArrayList<>();
			while(rs.next()) {
				User user= new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				ulist.add(user);
			}
			return ulist;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public User loginUser(String user, String pass) {
		try {
			conn=new DbCon().getConnection();
			String sql="SELECT * FROM tea_house_prj301.user where userName=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public User checkUsernameExist(String user) {
		try {
			conn=new DbCon().getConnection();
			String sql="SELECT * FROM tea_house_prj301.user where userName=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void insertUser(String uname, String pass, String fullName) throws ClassNotFoundException, SQLException {
		conn=DbCon.getConnection();
		try {
			String sql="insert into  tea_house_prj301.user (userName, password, role, fullName) values(?,?,0,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ps.setString(3, fullName);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteUser(String uid) {
		try {
			conn=new DbCon().getConnection();
			String sql="delete from tea_house_prj301.user where userId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public User getUserById(String uid) throws ClassNotFoundException, SQLException {
		User user=new User();
		try {
			conn=DbCon.getConnection();
			if(conn != null) {
				String sql="SELECT * FROM tea_house_prj301.user where userId=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, uid);
				rs=ps.executeQuery();
				if(rs.next()) {
					user.setUserId(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setRole(rs.getInt(4));
					user.setFullName(rs.getString(5));
				}
			}
		}
		finally {
			
		}
		return user;
	}
	
	
	public void editUser(String uid, String uname, String pass, int role, String fname) throws ClassNotFoundException, SQLException {
		conn=DbCon.getConnection();
		try {
			String sql = "Update tea_house_prj301.user set  userName=?, password=?, role=?, fullName=? where userId=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ps.setInt(3, role);
			ps.setString(4, fname);
			ps.setString(5, uid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int getTotalUser() {
		try {
			conn=DbCon.getConnection();
			String sql="select count(*) from tea_house_prj301.user;";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public List<User> pagingUser(int index){
		List<User> ulist= new ArrayList<>();
		try {
			conn=DbCon.getConnection();
			String sql="select * from tea_house_prj301.user order by userId limit 5 offset ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, (index-1)*5);
			rs=ps.executeQuery();
			while(rs.next()) {
				ulist.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return ulist;
	}
}
