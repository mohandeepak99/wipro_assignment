package com.surya.hibernate.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")  // <-- changed from "User"
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	    private int id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "email")
	    private String email;

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public User() {
			super();
		}

		public User( String name, String email) {
			super();
			
			this.name = name;
			this.email = email;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
		}
	    
	    
	    
}
