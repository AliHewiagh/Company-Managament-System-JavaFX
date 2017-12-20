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
public class Products {
    
    
    
        private   int      id;
	private   String   type;
	private   String   size;
	private   String   power;
	private   String   countryofmade;
	private   String   dateofmade;
	
	public Products() {
		super();
		
	}

	public Products(int id, String type, String size,String power, String countryofmade, String dateofmade) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
		this.power = power;
		this.countryofmade = countryofmade;
		this.dateofmade = dateofmade;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
        
        
	public String getType() {
		return type;
	}
	public void setType(String fname) {
		this.type = fname;
	}
        
        
        
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
        
        
        
        
	public String getPower() {
		return power;
	}
        
	public void setPower(String power) {
		this.power = power;
	}
        
        
        public String getCountryOfmade() {
		return countryofmade;
	}
	public void setCountryOfmade(String countryofmade) {
		this.countryofmade = countryofmade;
	}
        
        
        
        
        public String getDateOfmade() {
		return dateofmade;
	}
	public void setDateOfmade(String dateofmade) {
		this.dateofmade = dateofmade;
	}
        
        
    
}
