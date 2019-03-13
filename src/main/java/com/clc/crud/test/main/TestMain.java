package com.clc.crud.test.main;

import com.clc.crud.beans.CustomerBean;
import com.clc.crud.service.CustomerService;
import com.clc.crud.service.impl.CustomerServiceImpl;

public class TestMain {
	
	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();
		
//		for(int i=11;i<=20;i++){
//			service.addCustomer(new CustomerBean(i,"Yogesh"+i,"Chame",30, 12302));
//		}
		
	System.out.println(service.getCustomerBalanceTotal());
	System.out.println(service.deleteCustomer(15));
	System.out.println(service.getCustomerBalanceTotal());
	System.out.println(service.getTotalCustomers());
		
		
		
		
	}

}
