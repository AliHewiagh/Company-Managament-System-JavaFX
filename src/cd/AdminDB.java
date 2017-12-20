/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;
 

public class AdminDB {
	
 

	static Connection conn = null;
	
 
	
	public static Connection getConnection(){
		
		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//String url = "jdbc:mysql://localhost/muhammedessa";
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
	//		System.out.println("connected");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return conn;
	
	
	}
	

public static List<Admin>  getAdmins(){
	
	List<Admin> list = new ArrayList<Admin>();
	
	try {
		
		Connection conn = AdminDB.getConnection();
		
		Statement st = conn.createStatement();
		
                ResultSet re = st.executeQuery("Select * from Admin ");
		
		
		while (re.next()) {
			Admin adm = new Admin();
			
			
			adm.setUsername(re.getString(1));
			adm.setPassword(re.getString(2));
			 
			list.add(adm);
			
		}

		
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
}




}
	
	
	
	

	
