/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class ViewMachinesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
	private TableView<Machine> table;
	@FXML 
	private TableColumn<Machine,Integer> id;
	@FXML 
	private TableColumn<Machine,String> name;
	@FXML 
	private TableColumn<Machine,Float> price;
    
    
        @FXML
        public void Back(ActionEvent e) throws IOException{
            
            ((Node) (e.getSource())).getScene().getWindow().hide();
                
                
                Parent parent = FXMLLoader.load(getClass().getResource("/cd/MachinesSet.fxml"));
                Stage stage = new Stage();
                
                Scene scene = new Scene(parent);
                scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("Main");
                stage.show();
	 
            
        }
        @FXML
        public void Exit(ActionEvent e){
            
            System.exit(0);
            
        }
        
        public	ObservableList<Machine> data = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
       try {
			
		       Connection conn = AdminDB.getConnection();
			
	               Statement st = conn.createStatement();
        
                       ResultSet rs = st.executeQuery("Select * from Product2");
			
			
			while (rs.next()) {
				 
		
				data.add(new Machine(rs.getInt(1), rs.getString(2), rs.getFloat(3) ));
				 
				
			}

			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		id.setCellValueFactory(new PropertyValueFactory<Machine,Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<Machine,String>("name"));
		price.setCellValueFactory(new PropertyValueFactory<Machine,Float>("price"));
                
		
 
		
 	table.setItems(data);
 	
 	
	}
 
    }    
    

