package com.example.SpringSetterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SuppressWarnings("resource")
public class App
{
    public static void main( String[] args )
    {
    	
		ApplicationContext applicationContext=new  ClassPathXmlApplicationContext("configuration.xml");
    	
    	Order order=applicationContext.getBean("orderBean",Order.class);
    	order.showOrderDetails();
    }
}
 