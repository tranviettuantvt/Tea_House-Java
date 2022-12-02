package model;

public class Product {
	private int productId;
	private String productName;
	private int categoryId;
	private Double productPrice;
	private String image;
	
	public Product() {}

	public Product(int productId, String productName, int categoryId, Double productPrice, String image) {
	
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.productPrice = productPrice;
		this.image = image;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", categoryId=" + categoryId
				+ ", productPrice=" + productPrice + ", image=" + image + "]";
	}

	
	
	
}
