package com.surya.hibernate.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "College")  // <-- changed from "User"
public class College {
	
		public enum Gender{
			MALE,
			FEMALE,
			OTHER
		}

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	    private int rollno;

	    @Column(name = "firstname")
	    private String firstname;
	    
	    @Column(name = "lastname")
	    private String lastname;

	    @Column(name = "Username",unique = true)
	    private String Username;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name ="gender")
	    private Gender gender;
	    
	    @Column(name = "address")
	    private String address;
	    
	    @Column(name = "dob")
	    private LocalDate dob;

	    // Getters and Setters
	    public int getRollno() {
	        return rollno;
	    }

	    public void setRollno(int rollno) {
	        this.rollno = rollno;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public String getUsername() {
	        return Username;
	    }

	    public void setUsername(String username) {
	        this.Username = username;
	    }

	    public Gender getGender() {
	        return gender;
	    }

	    public void setGender(Gender gender) {
	        this.gender = gender;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public LocalDate getDob() {
	        return dob;
	    }

	    public void setDob(LocalDate dob) {
	        this.dob = dob;
	    }

		
		public College(String firstname, String lastname, String username, Gender gender, String address, LocalDate dob) {
	        super();
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.Username = username;
	        this.gender = gender;
	        this.address = address;
	        this.dob = dob;
	    }

		public College() {
			super();
		}

		@Override
	    public String toString() {
	        return "College [rollno=" + rollno + ", firstname=" + firstname + ", lastname=" + lastname +
	                ", Username=" + Username + ", gender=" + gender + ", address=" + address + ", dob=" + dob + "]";
	    }
	    
	    
	    
}
