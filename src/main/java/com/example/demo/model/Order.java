package com.example.demo.model;

import java.util.Date;



public class Order {
	
	private long orderId;
	private String totalPrice;
	private double totalPrice1;
	
	private String customerId;
	private String productName;
	private String price;
	private String quantity;
	private String order1;
	public String getOrder1() {
		return order1;
	}
	public double getTotalPrice1() {
		return totalPrice1;
	}
	public void setTotalPrice1(double totalPrice1) {
		this.totalPrice1 = totalPrice1;
	}
	public void setOrder1(String order1) {
		this.order1 = order1;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	private Date createAt;
	private Date updateAt;

}
