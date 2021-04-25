package com.aish.Springbootwithkafkaconsumer.model;

public class User {

	private String name;
    private String department;
    private String salary;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String department, String salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
 
    
}
