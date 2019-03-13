package com.clc.crud.dao;

import java.util.List;

import com.clc.crud.entities.CustomerEntity;

public interface CustomerDao {

	public boolean insertCustomer(CustomerEntity bean);
	public CustomerEntity fetchCustomer(int custId);
	public List<CustomerEntity> fetchAllCustomer();
	public List<CustomerEntity> removeCustomer(int custId);
	public CustomerEntity modifyCustomer(CustomerEntity bean);
}
