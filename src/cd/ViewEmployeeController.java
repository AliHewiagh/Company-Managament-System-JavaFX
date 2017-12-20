/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewEmployeeController implements Initializable{


	
	@FXML 
	private TableView<Employee> table;
	@FXML 
	private TableColumn<Employee,Integer> id;
	@FXML 
	private TableColumn<Employee,String> fname;
	@FXML 
	private TableColumn<Employee,String> lname;
	@FXML 
	private TableColumn<Employee,Float> salary;
	
	@FXML 
	private TableColumn<Employee,String> nationality;
	
	@FXML 
	private TableColumn<Employee,String> dateofbirth;
 
 
	@FXML
        public void BackEm(ActionEvent e) throws IOException{
            
            ((Node) (e.getSource())).getScene().getWindow().hide();
                
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Empolyee.fxml"));
    
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);

                stage.setTitle("Main");
                stage.show();
	 
            
        }
        @FXML
        public void Exit(ActionEvent e){
            
            
            
        }
 public	ObservableList<Employee> data = FXCollections.observableArrayList();
	  
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	
		
		try {
			
			Connection conn = AdminDB.getConnection();
			
			Statement st = conn.createStatement();
        
                        ResultSet rs = st.executeQuery("Select * from Employee");
			
			
			while (rs.next()) {
				 
		
				data.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), 
					              rs.getString(4), rs.getFloat(5), rs.getString(6) ));
				
			}

			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	 	

                
		id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
		fname.setCellValueFactory(new PropertyValueFactory<Employee,String>("fname"));
		lname.setCellValueFactory(new PropertyValueFactory<Employee,String>("lname"));
                nationality.setCellValueFactory(new PropertyValueFactory<Employee,String>("nationality"));
		salary.setCellValueFactory(new PropertyValueFactory<Employee,Float>("salary"));
                dateofbirth.setCellValueFactory(new PropertyValueFactory<Employee,String>("dateofbirth"));
		
 
		
 	table.setItems(data);
 	
 	
	}
 
	
	
}
