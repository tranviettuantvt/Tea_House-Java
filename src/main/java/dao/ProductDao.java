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


public class ProductDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List<Product> getListProduct(){
		try {
			String query="SELECT * FROM tea_house_prj301.product";
			conn=new DbCon().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<>();
			while(rs.next()) {
				Product prd= new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
				plist.add(prd);
			}
			return plist;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
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
	
	public List<Product> getListProductByCateId(String cid){
		try {
			conn=new DbCon().getConnection();
			String query="SELECT * FROM tea_house_prj301.product where categoryId=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, cid);
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<>();
			while(rs.next()) {
				Product pd =new Product(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getDouble(4), rs.getString(5));
				plist.add(pd);
			}
			return plist;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<Product> getListProductByName(String pname){
		try {
			conn=new DbCon().getConnection();
			String query="SELECT * FROM tea_house_prj301.product where productName like ?";
			ps=conn.prepareStatement(query);
			ps.setString(1, "%" +pname+"%");
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<>();
			while(rs.next()) {
				Product pd =new Product(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getDouble(4), rs.getString(5));
				plist.add(pd);
			}
			return plist;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void deleteProduct(String pid) {
		try {
			conn=new DbCon().getConnection();
			String sql="delete from tea_house_prj301.product where productId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, pid);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Product getProductById(String pid) throws ClassNotFoundException, SQLException {
		Product pd= new Product();
		try {
			conn=DbCon.getConnection();
			if(conn != null) {
				String sql="SELECT * from tea_house_prj301.product where productId=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, pid);
				rs=ps.executeQuery();
				if(rs.next()) {
					pd.setProductId(rs.getInt(1));
					pd.setProductName(rs.getString(2));
					pd.setCategoryId(rs.getInt(3));
					pd.setProductPrice(rs.getDouble(4));
					pd.setImage(rs.getString(5));
					
				}
			}
		}
		finally {
			
		}
		return pd;
	}
	
	public void editProduct(String pid, String pname,  int cid, double productPrice, String image) throws ClassNotFoundException, SQLException {
		conn=DbCon.getConnection();
		try {
			String sql = "Update tea_house_prj301.product set productName=?, categoryId=?, productPrice=?, productImage=? where productId=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, cid);
			ps.setDouble(3, productPrice);
			ps.setString(4, image);
			ps.setString(5, pid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertProduct(String pname,int cid, Double price,  String image) {
		try {
			conn=DbCon.getConnection();
			String sql="insert into tea_house_prj301.product (productName, categoryId,productPrice,productImage) values (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, cid);
			ps.setDouble(3, price);
			ps.setString(4, image);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	public int getTotalProduct() {
		try {
			conn=DbCon.getConnection();
			String sql="select count(*) from tea_house_prj301.product;";
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
	
	public List<Product> pagingProduct(int index){
		List<Product> plist= new ArrayList<>();
		try {
			conn=DbCon.getConnection();
			String sql="select * from tea_house_prj301.product order by productId limit 5 offset ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, (index-1)*5);
			rs=ps.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getDouble(4), rs.getString(5)));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return plist;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Product> plist= new ArrayList<>();
		ProductDao pdao= new ProductDao();
		plist=pdao.pagingProduct(2);
		for(Product p: plist) {
			System.out.println(p);
		}
	}
}
