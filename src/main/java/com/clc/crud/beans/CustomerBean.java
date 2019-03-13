package com.clc.crud.beans;

public class CustomerBean {
	
	private int custId;
	private String custFName;
	private String custLName;
	private int custAge;
	private double custBalance;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustFName() {
		return custFName;
	}
	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}
	public String getCustLName() {
		return custLName;
	}
	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}
	@Override
	public String toString() {
		return "\n CustomerBean [custId=" + custId + ", custFName=" + custFName
				+ ", custLName=" + custLName + ", custAge=" + custAge
				+ ", custBalance=" + custBalance + "]";
	}
	public CustomerBean(int custId, String custFName, String custLName,
			int custAge, double custBalance) {
		super();
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custAge = custAge;
		this.custBalance = custBalance;
	}
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
