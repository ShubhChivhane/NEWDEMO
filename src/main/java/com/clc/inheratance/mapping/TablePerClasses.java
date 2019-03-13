package com.clc.inheratance.mapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clc.crud.util.HibernateUtil;


public class TablePerClasses {

	public static void main(String[] args) {
		
      Emp e1= new Emp(1, "A", "pune", 21);
      Pemp p1= new Pemp(10, "B", "PUNE", 23, "ABC");
      Cemp c1= new Cemp(11, "D", "PUNE", 25, "BBC");
      
      
      SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
      Session session = sessionfactory.openSession();
      Transaction tr = session.beginTransaction();
      session.save(e1);
      session.save(p1);
      session.save(c1);
      
      HibernateUtil.resourceCleanUp(session, tr);
	}

}


@Entity
@Table(name="Employee")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorValue("Employee") for table per class
class Emp
{
	@Id
	private int id;
	private String name;
	private String address;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Emp(int id, String name, String address, int age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}
	
	
	
}

@Entity

//@DiscriminatorValue("PEmployee")
class Pemp extends Emp
{
  private String companyName;

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public Pemp(int id, String name, String address, int age, String companyName) {
	super(id, name, address, age);
	this.companyName = companyName;
}

public Pemp() {
	super();
	// TODO Auto-generated constructor stub
}

public Pemp(int id, String name, String address, int age) {
	super(id, name, address, age);
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "PEmp [id=" + getId() + ", name=" + getName()+ ", address=" + getAddress() + ", age=" + getAge()+ ",companyName=" + companyName + "]";
	
}
  
	
	
}

@Entity
//@DiscriminatorValue("CEmployee")
class Cemp extends Emp 
{
	private String consultancyName;

	public String getConsultancyName() {
		return consultancyName;
	}

	public void setConsultancyName(String consultancyName) {
		this.consultancyName = consultancyName;
	}

	public Cemp(int id, String name, String address, int age, String consultancyName) {
		super(id, name, address, age);
		this.consultancyName = consultancyName;
	}

	public Cemp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cemp(int id, String name, String address, int age) {
		super(id, name, address, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		return "CEmp [id=" + getId() + ", name=" + getName()+ ", address=" + getAddress() + ", age=" + getAge()+ ",consultancyName=" + consultancyName + "]";
		
	}
	
	
	
	
}