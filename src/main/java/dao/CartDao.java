package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.Argument;

import connection.DbCon;
import model.Cart;
import model.Category;
import model.Order;

public class CartDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public CartDao(Connection con) {
		super();
		this.conn = con;
	}
	
	
	public List<Cart> getCartProduct(ArrayList<Cart> cartList){
		List<Cart> cart = new ArrayList<>();
		try {
			if(cartList.size() > 0) {
				for(Cart item: cartList) {
					String sql="SELECT * FROM tea_house_prj301.product where productId=?";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, item.getProductId());
					rs=ps.executeQuery();
					while(rs.next()) {
						Cart line= new Cart();
						line.setProductId(rs.getInt("productId"));
						line.setProductName(rs.getString("productName"));
						line.setCategoryId(rs.getInt("categoryId"));
						line.setProductPrice(rs.getDouble("productPrice")*item.getQuantity());
						line.setQuantity(item.getQuantity());
						cart.add(line);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cart;
	}
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum=0;
		try {
			if(cartList.size()>0) {
				for(Cart item: cartList) {
					String sql="SELECT * from tea_house_prj301.product where productId=?";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, item.getProductId());
					rs=ps.executeQuery();
					while(rs.next()) {
						sum+=rs.getDouble(4)*item.getQuantity();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sum;
		
	}
	
	public List<Cart> pagingCart(int index, List<Cart> cartProduct){
		List<Cart> clist= new ArrayList<>();
		for(int i=(index-1)*5; i<(index-1)*5+5; i++) {
			clist.add(cartProduct.get(i));
		}
		return clist;
	}
	
//	
//	public List<Order> getListOrder(){
//		try {
//			String query="SELECT * FROM tea_house_prj301.order;";
//			conn=new DbCon().getConnection();
//			ps=conn.prepareStatement(query);
//			rs=ps.executeQuery();
//			List<Order> olist=new ArrayList<>();
//			while(rs.next()) {
//				Order order= new Order();
//				order.setOrderId(rs.getInt(1));
//				order.setUserId(rs.getInt(2));
//				order.setProductId(rs.getInt(3));
//				order.setQuantity(rs.getInt(4));
//				order.setOrderDate(rs.getDate(5));
//				olist.add(order);
//			}
//			return olist;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
//	
	
	
	public static void main(String[] args) {
//		ArrayList<Cart> cartListSS = (ArrayList<Cart>) session.getAttribute("cartListSS");
	}
}
