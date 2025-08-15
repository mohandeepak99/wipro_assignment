package com.example.SpringSetterInjection;
 
public class Customer {
	
	private String name;
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	public void display()
	{
		System.out.println("Customer name is :-"+name);
	}
	
}
 