package com.sathya.entity;
import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;
@Component
@Embeddable
public class Discount {
	private String productCategory1;
	private double discount;
	private double gst;
	private int deliveryCharges;
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Discount(String productCategory1, double discount, double gst, int deliveryCharges) {
		super();
		this.productCategory1 = productCategory1;
		this.discount = discount;
		this.gst = gst;
		this.deliveryCharges = deliveryCharges;
	}
	public String getProductCategory1() {
		return productCategory1;
	}
	public void setProductCategory1(String productCategory1) {
		this.productCategory1 = productCategory1;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public int getDeliveryCharges() {
		return deliveryCharges;
	}
	public void setDeliveryCharges(int deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}
	@Override
	public String toString() {
		return "Discount [productCategory1=" + productCategory1 + ", discount=" + discount + ", gst=" + gst
				+ ", deliveryCharges=" + deliveryCharges + "]";
	}
	
	
	
}
