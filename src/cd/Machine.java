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
public class Machine {
    
    
    
        private int id;
	private   String  name;
	private   float  price;
	
	
	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Machine(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
        
        
	public String getName() {
		return name;
	}
	public void SetName(String name) {
		this.name = name;
	}
        
        
        
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

    
}
