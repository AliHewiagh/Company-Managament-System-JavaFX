/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

/**
 *
 * @author alihewaigh
 */
public class Employee {
    
    
        private int id;
	private   String  fname;
	private   String  lname;
	private   float  salary;
	private   String dateofbirth;
	private   String nationality;
	
	public Employee() {
		super();
		
	}

	
	public Employee(int id, String fname, String lname,String nationality, float salary, String dateofbirth) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.nationality = nationality;
		this.dateofbirth = dateofbirth;
	}

        public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
        
        
        
        public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFname() {
		return fname;
	}
	
        
        
        public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLname() {
		return lname;
	}
	
        
        
        
        public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getSalary() {
		return salary;
	}
        
	
        
        public void setDate_of_birth(String date_of_birth) {
		this.dateofbirth = date_of_birth;
	}
        public String getDateofbirth() {
		return dateofbirth;
	}
	
        
        
        
        public void setNationality(String nationality) {
		this.nationality = nationality;
	}
        
        public String getNationality() {
		return nationality;
	}
	
}
