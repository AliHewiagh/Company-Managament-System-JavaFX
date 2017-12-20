/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;


import cd.Products;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
 

public class DBInfo {
	
	

	public static Connection getConnection(){
	
		Connection conn = null;
        try{
                       

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
        
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
                   return conn;
	
	
	}
	
	
	
	public static int save(Employee emp){
		
		int st = 0;
		
		try {
			 
			Connection conn = DBInfo.getConnection();

			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO `Employee` (`ID`, `FName`, `LName`, `Nationality`, `Salary`, `DateOfBirth`) VALUES (?,?,?,?,?,?)");
                        
                        preparedStatement.setInt(1, emp.getId());
			preparedStatement.setString(2, emp.getFname());
			preparedStatement.setString(3, emp.getLname());
                        preparedStatement.setString(4, emp.getNationality());
			preparedStatement.setFloat(5, emp.getSalary());
                        preparedStatement.setString(6, emp.getDateofbirth());
			
                        
                        System.out.println("ssdddssssss");
			System.out.println(st);
 			
			//st = preparedStatement.executeUpdate();
                        
			  st = preparedStatement.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
		
	}
	
	
        
        
        
        public static int savePro(Products pro){
		
		int st = 0;
		
		try {
			
			Connection conn = DBInfo.getConnection();
                      
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO `Products` (`ID`, `Type`, `Size`, `Power`, `countryofmade` , `dateofmade` ) VALUES (?,?,?,?,?,?)");
                        
                        preparedStatement.setInt(1, pro.getId());
			preparedStatement.setString(2, pro.getType());
			preparedStatement.setString(3, pro.getSize());
                        preparedStatement.setString(4, pro.getPower());
			preparedStatement.setString(5, pro.getCountryOfmade());
                        preparedStatement.setString(6, pro.getDateOfmade());
			
			System.out.print("dddddd "+st);
 			
			st = preparedStatement.executeUpdate();
                       
			System.out.print("dddddd "+st);
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return st;
		
	}
	
public static int update(Employee emp){
		
		int st = 0;
		
		try {
                    
                    
			
			Connection conn = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("UPDATE `Employee` SET `FName`=?,`LName`=?,`Nationality`=?,`Salary`=?,`DateOfBirth`=? WHERE ID = ?");
                        
                        
                        
                       
			preparedStatement.setString(1, emp.getFname());
			preparedStatement.setString(2, emp.getLname());
                        preparedStatement.setString(3, emp.getNationality());
			preparedStatement.setFloat(4, emp.getSalary());			
						
			preparedStatement.setString(5, emp.getDateofbirth());
                         preparedStatement.setInt(6, emp.getId());
			
			st = preparedStatement.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(st);
		return st;
		
	}
	
	
public static int delete(int id){
	
	int st = 0;
	
	try {
		
		Connection conn = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM `Employee` WHERE ID=?");
		 
		preparedStatement.setInt(1, id);
		
		st = preparedStatement.executeUpdate();
		
		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return st;
	
}
	
	
	
public static Products  getProductsId(int id){
	
	Products mac = new Products();
	System.out.println("ggggg555");
	try {
		System.out.println("ggggg3g");
		Connection conn = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT * FROM `Products` WHERE ID=?");
		
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
  		
			
			mac.setId(resultSet.getInt(1));
                        mac.setType(resultSet.getString(2));
                        mac.setSize(resultSet.getString(3));
                        mac.setPower(resultSet.getString(4));
                        mac.setCountryOfmade(resultSet.getString(5));
                        
			mac.setDateOfmade(resultSet.getString(6));
			
			
			
		}

		
		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return mac;
	
}



public static Employee  getEmployeeId(int id){
	
	Employee emp = new Employee();
	
	try {
		
		Connection conn = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT * FROM `Employee` WHERE ID=?");
		
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
  			
			emp.setId(resultSet.getInt(1));
			emp.setFname(resultSet.getString(2));
			emp.setLname(resultSet.getString(3));
                        emp.setNationality(resultSet.getString(4));
			emp.setSalary(resultSet.getFloat(5));
			
			
			
			emp.setDate_of_birth(resultSet.getString(6));
			
			
			
		}

		
		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return emp;
	
}





public static int updateMac(Products pro){
		
		int st = 0;
		
		try {
                    
                   
			Connection conn = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("UPDATE `Products` SET `Type`=?,`Size`=?,`Power`=?,`countryofmade`=?,`dateofmade`=? WHERE ID = ?");
   
			preparedStatement.setString(1, pro.getType());
			preparedStatement.setString(2, pro.getSize());
                        preparedStatement.setString(3, pro.getPower());
			preparedStatement.setString(4, pro.getCountryOfmade());			
						
			preparedStatement.setString(5, pro.getDateOfmade());
                         preparedStatement.setInt(6, pro.getId());
			
			st = preparedStatement.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(st);
		return st;
		
	}



 public static int saveCus(CustomerClass cus){
     
     
     int st = 0;
		
		try {
			
			Connection conn = DBInfo.getConnection();
             
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO `Customer` (`ID`, `Fname`, `Sname`, `Pnumber`) VALUES (?,?,?,?)");
                        
                        preparedStatement.setString(1, cus.getId());
			preparedStatement.setString(2, cus.getFname());
			preparedStatement.setString(3, cus.getSname());
                        preparedStatement.setString(4, cus.getPnumber());
              
			st = preparedStatement.executeUpdate();
                       
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return st;
		
     
     
 }





	public static int saveMa(Machine ma){
		
		int st = 0;
		
		try {
			
			Connection conn = DBInfo.getConnection();
             
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO `Product2` (`ID`, `Name`, `Price`) VALUES (?,?,?)");
                        
                        preparedStatement.setInt(1, ma.getId());
			preparedStatement.setString(2, ma.getName());
			preparedStatement.setFloat(3, ma.getPrice());
              
			st = preparedStatement.executeUpdate();
                       
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return st;
		
	}
	

	public static Machine  getMachineId(int id){
	
            
         
        Machine ma = new Machine();
	//System.out.println("ggggg555");
	try {
		
		Connection conn = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT * FROM `Product2` WHERE ID=?");
		
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {

			ma.setId(resultSet.getInt(1));
                        ma.SetName(resultSet.getString(2));
                        ma.setPrice(resultSet.getFloat(3));
                    
		}

		
		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return ma;
	
}
	
public static int updatePro(Machine ma){
		
		int st = 0;
		//System.out.println("ffffffffjfjf");
		try {
                    
                    System.out.println(st);
			
			Connection conn = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("UPDATE `Product2` SET `Name`=?,`Price`=? WHERE ID = ?");
               
			preparedStatement.setString(1, ma.getName());
			preparedStatement.setFloat(2, ma.getPrice());
                  
                         preparedStatement.setInt(3, ma.getId());
			
			st = preparedStatement.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(st);
		return st;
		
	}	
	
	public static int deletePr(int id){
	
	int st = 0;
	
	try {
		
		Connection conn = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM `Product2` WHERE ID=?");
		 
		preparedStatement.setInt(1, id);
		
		st = preparedStatement.executeUpdate();
		
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return st;
	
}

	
}
