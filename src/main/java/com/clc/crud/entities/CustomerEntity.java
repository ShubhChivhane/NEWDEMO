package com.clc.crud.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustomerEntityInfo")
public class CustomerEntity {
	
	@Id
	private int custId;
	private String custFullName;
	private int custAge;
	private double custBalance;
	private boolean isActive;
	private boolean isPrime;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustFullName() {
		return custFullName;
	}
	public void setCustFullName(String custFullName) {
		this.custFullName = custFullName;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isPrime() {
		return isPrime;
	}
	public void setPrime(boolean isPrime) {
		this.isPrime = isPrime;
	}
	@Override
	public String toString() {
		return "CustomerEntity [custId=" + custId + ", custFullName="
				+ custFullName + ", custAge=" + custAge + ", custBalance="
				+ custBalance + ", isActive=" + isActive + ", isPrime="
				+ isPrime + "]";
	}
	public CustomerEntity(int custId, String custFullName, int custAge,
			double custBalance, boolean isActive, boolean isPrime) {
		super();
		this.custId = custId;
		this.custFullName = custFullName;
		this.custAge = custAge;
		this.custBalance = custBalance;
		this.isActive = isActive;
		this.isPrime = isPrime;
	}
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
