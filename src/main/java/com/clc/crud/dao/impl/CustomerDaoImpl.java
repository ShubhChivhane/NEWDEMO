package com.clc.crud.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clc.crud.dao.CustomerDao;
import com.clc.crud.entities.CustomerEntity;
import com.clc.crud.util.HibernateUtil;

public class CustomerDaoImpl  implements CustomerDao{

	static SessionFactory sFactory = null;
	
	public CustomerDaoImpl(){
		sFactory = HibernateUtil.getSessionFactory();
	}
	
	
	public boolean insertCustomer(CustomerEntity entity) {
		Session session = null;
		Transaction tr = null;
		try{
			session = sFactory.openSession();
			tr = session.beginTransaction();
			Integer persistedId = (Integer) session.save(entity);
			System.out.println(persistedId);
			System.out.println(entity.getCustId());
			if(persistedId==entity.getCustId())
				System.out.println("Customer inserted Successfully....!");
			return true;
		}catch(Exception e){
			System.out.println(e);
			tr.rollback();
		}finally{
			HibernateUtil.resourceCleanUp(session,tr);	
		}
		return false;
	}

	public CustomerEntity fetchCustomer(int custId) {
		Session session = null;
		try{
			session = sFactory.openSession();
			return (CustomerEntity) session.get(CustomerEntity.class, custId);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			HibernateUtil.resourceCleanUp(session,null);	
		}
		return null;
	}

	public List<CustomerEntity> fetchAllCustomer() {
		Session session = null;
		try{
			session = sFactory.openSession();
			return session.createCriteria(CustomerEntity.class).list();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			HibernateUtil.resourceCleanUp(session,null);	
		}
		return null;
	}

	public List<CustomerEntity> removeCustomer(int custId) {
		Session session = null;
		Transaction tr = null;
		CustomerEntity dbEntity = fetchCustomer(custId);
		if(dbEntity!=null){
			try{
				session = sFactory.openSession();
				tr = session.beginTransaction();
				session.delete(dbEntity);
				System.out.println("Customer Deleted Successfully...!");
			}catch(Exception e){
				System.out.println(e);
				tr.rollback();
			}finally{
				HibernateUtil.resourceCleanUp(session,tr);
			}
		}
		return fetchAllCustomer();
	}

	public CustomerEntity modifyCustomer(CustomerEntity entity) {
		Session session = null;
		Transaction tr = null;
		CustomerEntity dbEntity = fetchCustomer(entity.getCustId());
		if(dbEntity!=null){
			try{
				session = sFactory.openSession();
				tr = session.beginTransaction();
				CustomerEntity updatedEntity = (CustomerEntity) session.merge(entity);
				System.out.println("Customer Updated Successfully.");
				return updatedEntity;
			}catch(Exception e){
				System.out.println(e);
				tr.rollback();
			}finally{
				HibernateUtil.resourceCleanUp(session,tr);	
			}
		}
		return entity;
	}

}
