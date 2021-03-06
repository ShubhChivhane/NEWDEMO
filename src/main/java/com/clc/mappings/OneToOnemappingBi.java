package com.clc.mappings;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clc.crud.util.HibernateUtil;


public class OneToOnemappingUni {

	public static void main(String[] args) {
		Laptop p1= new Laptop(11, 111, "DELL",null);
		Laptop p2= new Laptop(12, 1121, "HP",null);
		Student s1= new Student(1, "Shubham", p1);
		Student s2= new Student(2, "Rahul", p2);
		p1.setSt(s1);
		p1.setSt(s2);
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	      Session session = sessionfactory.openSession();
	      Transaction tr = session.beginTransaction();
	      session.save(s1);
	      session.save(s2);
	      
	      HibernateUtil.resourceCleanUp(session, tr);
		
		

	}

}
@Entity
@Table(name="STUDENT_INFO")
class Student{
	@Id
	private int studId;
	private String studName;
	@OneToOne(cascade=CascadeType.ALL)
	private Laptop laptop;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public Student(int studId, String studName, Laptop laptop) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", laptop=" + laptop + "]";
	}
	
	
	
	
	
}

@Entity
@Table(name="LAPTOP_INFO")
class Laptop{
	@Id
	private int laptopId;
	private double laptopPrice;
	private String laptopModel;
	@OneToOne
	private Student st;
	//getters setters tostring constructors
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public double getLaptopPrice() {
		return laptopPrice;
	}
	public void setLaptopPrice(double laptopPrice) {
		this.laptopPrice = laptopPrice;
	}
	public String getLaptopModel() {
		return laptopModel;
	}
	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopPrice=" + laptopPrice + ", laptopModel=" + laptopModel
				+ ", st=" + st + "]";
	}
	
	public Laptop(int laptopId, double laptopPrice, String laptopModel, Student st) {
		super();
		this.laptopId = laptopId;
		this.laptopPrice = laptopPrice;
		this.laptopModel = laptopModel;
		this.st = st;
	}
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}