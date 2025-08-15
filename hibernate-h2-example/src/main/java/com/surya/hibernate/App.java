package com.surya.hibernate;
 
 
 
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.surya.hibernate.entity.User;
import com.surya.hibernate.util.HibernateUtil;
 
 
public class App {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	
    	
    	//curd------------->create,update,read,deleted
    	
    	
    	
    	
    	//Inserting data in databases
    	
    	Session session=HibernateUtil.getSessionFactory().openSession();
    	Transaction tx=session.beginTransaction();
    	
    	User user=new User("MK","test@com.in");
    	session.persist(user);
    	tx.commit();
    	session.close();
    	System.out.println("this user data inserted into Database"+ user);
    	
    	
    	
    	
    	//reading
    	session=HibernateUtil.getSessionFactory().openSession();
    	
    	User userData=session.get(User.class, user.getId());
    	System.out.println("this user data fetched from Database"+ userData);
    	session.close();
    	
    	
    	
    	//update
    	session=HibernateUtil.getSessionFactory().openSession();
    	tx=session.beginTransaction();
    	userData.setName("User name Updated");
    	session.merge(userData);
    	tx.commit();
    	session.close();
    	System.out.println("User got Updated"+ userData);
    	
    	
    	
    	
    	//Delete
    	
    	session=HibernateUtil.getSessionFactory().openSession();
    	tx=session.beginTransaction();
    	session.remove(userData);
    	tx.commit();
    	session.close();
    	
    	System.out.println("User got Deleted"+ userData);
    	
    	}
}
 