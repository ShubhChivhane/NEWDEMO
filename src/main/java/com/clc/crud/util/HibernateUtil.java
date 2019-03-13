package com.clc.crud.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory(){
		if(factory == null){
			factory= new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}

	public static void resourceCleanUp(Session session, Transaction tr) {
		if(session!=null){
			session.flush();
			if(tr!=null){
				tr.commit();
			}
			session.close();
		}
			
	}

}
