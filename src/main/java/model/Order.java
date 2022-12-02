package model;

import java.util.Date;

public class Order extends Product{
	private int orderId;
	private int userId;
	private int quantity;
	private String orderDate;
	
	public Order() {
		
	}

	public Order(int orderId, int userId, int quantity, String orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}




	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public String getOrderDate() {
		return orderDate;
	}




	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}




	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", quantity=" + quantity + ", orderDate="
				+ orderDate + "]";
	}
	
	
}
