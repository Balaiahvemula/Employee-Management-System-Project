package com.EmpServices;

public class Employee 
{
     int id;
     String name;
     int age;
     int sal;
	public Employee(int id, String name, int age, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}
	
}
