package com.clc.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.clc.crud.beans.CustomerBean;
import com.clc.crud.dao.CustomerDao;
import com.clc.crud.dao.impl.CustomerDaoImpl;
import com.clc.crud.entities.CustomerEntity;
import com.clc.crud.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	
	static CustomerDao customerDao = null;
	public CustomerServiceImpl() {
			super();
			customerDao = new CustomerDaoImpl();
	}
	
	
	private CustomerBean convertEntityToBean(CustomerEntity entity){
		CustomerBean bean = new CustomerBean();
		bean.setCustAge(entity.getCustAge());
		bean.setCustBalance(entity.getCustBalance());
		String fullname[] = entity.getCustFullName().split("_");
		bean.setCustFName(fullname[0]);
		bean.setCustLName(fullname[1]);
		bean.setCustId(entity.getCustId());
		return bean;
	}
	private CustomerEntity convertBeanToEntity(CustomerBean bean){
		CustomerEntity entity = new CustomerEntity();
		entity.setCustAge(bean.getCustAge());
		entity.setCustFullName(bean.getCustFName()+"_"+bean.getCustLName());
		entity.setCustBalance(bean.getCustBalance());
		entity.setCustId(bean.getCustId());
		return entity;
	}

	private List<CustomerBean> convertEntitiesToBeans(List<CustomerEntity> entities){
		List<CustomerBean> beans = new ArrayList<CustomerBean>();
		for(CustomerEntity entity :entities){
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}

	public boolean addCustomer(CustomerBean bean) {
		CustomerEntity entity = convertBeanToEntity(bean);
		if(entity.getCustBalance() >= 50000)
			entity.setPrime(true);
		entity.setActive(true);
		return customerDao.insertCustomer(entity);
	}

	public CustomerBean getCustomer(int custId) {
		return convertEntityToBean(customerDao.fetchCustomer(custId));
	}

	public List<CustomerBean> getAllCustomer() {
		return convertEntitiesToBeans(customerDao.fetchAllCustomer());
	}

	public List<CustomerBean> deleteCustomer(int custId) {
		return convertEntitiesToBeans(customerDao.removeCustomer(custId));
	}

	public CustomerBean updateCustomer(CustomerBean bean) {
		CustomerEntity entity = convertBeanToEntity(bean);
		if(entity.getCustBalance() >= 50000)
			entity.setPrime(true);
		
		return convertEntityToBean(customerDao.modifyCustomer(entity));
	}

	public int getTotalCustomers() {
		return customerDao.fetchAllCustomer().size();
	}

	public double getCustomerBalanceTotal() {
		System.out.println("customer list");
		List<CustomerEntity> entities = customerDao.fetchAllCustomer();
		double totalBalance = 0;
		for (CustomerEntity customerEntity : entities) {
			totalBalance+=customerEntity.getCustBalance();
		}
		return totalBalance;
	}

}
