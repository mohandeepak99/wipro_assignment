package com.example.SpringSetterInjection;
 
public class Order {
 
	
	private Customer customer;
 
	public Customer getCustomer() {
		return customer;
	}
 
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void showOrderDetails()
	{
		System.out.println("order placed by :-"+getCustomer().getName());
		customer.display();
	}
	
}
 