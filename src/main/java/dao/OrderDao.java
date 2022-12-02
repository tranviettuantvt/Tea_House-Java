package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbCon;
import model.Cart;
import model.Order;
import model.Product;
import model.User;

public class OrderDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public OrderDao(Connection con) {
		super();
		this.conn = con;
	}
	
	public boolean insertOrder(int uid, int pid, int quantity, String daTe) {
        boolean result = false;
        try {
            String sql = "insert into tea_house_prj301.order (userId, productId, orderQuantity, orderDate) values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.setInt(2, pid);
            ps.setInt(3, quantity);
            ps.setString(4, daTe);
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
			// TODO: handle exception
		}
        return result;
    }
	
	public List<Order> getListOrderByUser(int uid){
		List<Order> olist = new ArrayList<>();
		try {
			String sql="select * from tea_house_prj301.order where userId=? order by tea_house_prj301.order.orderId desc";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			while(rs.next()) {
				Order order= new Order();
				int pid=rs.getInt(3);
				ProductDao pdao= new ProductDao();
				Product product= pdao.getProductById(Integer.toString(pid));
				order.setOrderId(rs.getInt(1));
				order.setUserId(uid);
				order.setProductId(pid);
				order.setProductName(product.getProductName());
				order.setCategoryId(product.getCategoryId());
				order.setProductPrice(product.getProductPrice()*rs.getInt(4));
				order.setQuantity(rs.getInt(4));
				order.setOrderDate(rs.getString(5));
				olist.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return olist;
	}
	
	public void deleteFromOrder(String oid) {
		try {
			conn=new DbCon().getConnection();
			String sql="delete from tea_house_prj301.order where orderId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, oid);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public double getTotalOrderPrice(ArrayList<Order> orderList) {
		double sum=0;
		for(Order o: orderList) {
			sum+=o.getProductPrice();
		}
		return sum;
	}
	
	public int getTotalOrder(int uid) {
		try {
			conn=DbCon.getConnection();
			String sql="select count(*) from tea_house_prj301.order where userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
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
	
	public List<Order> pagingOrder(int index, ArrayList<Order> orderL){
		List<Order> olist= new ArrayList<>();
		for(int i=(index-1)*5; i<(index-1)*5+5; i++) {
			if(i>=orderL.size()) 
				break;
			System.out.println(orderL.get(i));
			olist.add(orderL.get(i));
			
		}
		return olist;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Order> olist= new ArrayList<>();
		OrderDao orderDao= new OrderDao(DbCon.getConnection());
		
		ArrayList<Order> orders= new ArrayList<>();
		ArrayList<Order> orderPaging= new ArrayList<>();
		orders = (ArrayList<Order>) orderDao.getListOrderByUser(2);
		orderPaging=(ArrayList<Order>) orderDao.pagingOrder(5, orders);
		for(Order o: orderPaging) {
			System.out.println(o);
		}
//		System.out.println(orders.get(23));
	}
}
