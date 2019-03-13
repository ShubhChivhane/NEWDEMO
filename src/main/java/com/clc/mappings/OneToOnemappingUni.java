package com.clc.mappings;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clc.crud.util.HibernateUtil;


public class OneToOnemappingUni {

	public static void main(String[] args) {
		Laptop l1 = new Laptop(11111,48520,"Lenovo");
		Laptop l2 = new Laptop(2222,54230,"Lenovo");
		
		Student s = new Student(101,"Amit",l1);
		Student s1 = new Student(102,"Amit",l2);
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	      Session session = sessionfactory.openSession();
	      Transaction tr = session.beginTransaction();
	      session.save(s);
	      session.save(s1);
	      
	      HibernateUtil.resourceCleanUp(session, tr);
		
		

	}

}
@Entity
@Table(name="STUDENT_INFORMATION")
class Student{
	@Id
	private int studId;
	private String studName;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(
	        name = "Stud_Lappy_Info",
	        joinColumns = @JoinColumn(
	                name = "STUDID",
	                referencedColumnName = "studId"
	        ),
	        inverseJoinColumns = @JoinColumn(
	                name = "LapID",
	                referencedColumnName = "laptopId"
	        )
	)
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
@Table(name="LAPTOP_INFORMATION")
class Laptop{
	@Id
	private int laptopId;
	private double laptopPrice;
	private String laptopModel;
	
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
	
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopPrice=" + laptopPrice + ", laptopModel=" + laptopModel
				+ "]";
	}
	
	public Laptop(int laptopId, double laptopPrice, String laptopModel) {
		super();
		this.laptopId = laptopId;
		this.laptopPrice = laptopPrice;
		this.laptopModel = laptopModel;
	
	}
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}