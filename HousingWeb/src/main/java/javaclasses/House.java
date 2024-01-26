package javaclasses;

import java.io.InputStream;

public class House {
	private int id;
	private String location;
	private String homeDetail;
	private String salePrice;
	private String rentPrice;
	private String brokerDetail;
	private InputStream file;
	
	
	
	
	
	public House(int id, String location, String homeDetail, String salePrice, String rentPrice, String brokerDetail, InputStream file) {
		super();
		this.id = id;
		this.location = location;
		this.homeDetail = homeDetail;
		this.salePrice = salePrice;
		this.rentPrice = rentPrice;
		this.brokerDetail = brokerDetail;
		this.file = file;
	}
	
	
	public House(String location, String homeDetail, String salePrice, String rentPrice, String brokerDetail, InputStream file) {
		super();
		this.id = id;
		this.location = location;
		this.homeDetail = homeDetail;
		this.salePrice = salePrice;
		this.rentPrice = rentPrice;
		this.brokerDetail = brokerDetail;
		this.file = file;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHomeDetail() {
		return homeDetail;
	}
	public void setHomeDetail(String homeDetail) {
		this.homeDetail = homeDetail;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getBrokerDetail() {
		return brokerDetail;
	}
	public void setBrokerDetail(String brokerDetail) {
		this.brokerDetail = brokerDetail;
	}
	public InputStream getFile() {
		return file;
	}
	public void setFile(InputStream file) {
		this.file = file;
	}
	
	

}
