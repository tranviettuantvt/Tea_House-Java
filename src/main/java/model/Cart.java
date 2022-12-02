package model;

public class Cart extends Product{
	private int quantity;
	
	public Cart() {
		
	}

	public Cart(int quantity) {
		super();
		this.quantity = quantity;
	}
	
	

	public Cart(int productId, String productName, int categoryId, Double productPrice, String image) {
		super(productId, productName, categoryId, productPrice, image);
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
