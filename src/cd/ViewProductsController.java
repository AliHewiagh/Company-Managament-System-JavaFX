/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

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
public class ViewProductsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        @FXML 
	private TableView<Products> table;
	@FXML 
	private TableColumn<Products,Integer> id;
	@FXML 
	private TableColumn<Products,String> Type;
	@FXML 
	private TableColumn<Products,String> size;
	@FXML 
	private TableColumn<Products,String> power;
	@FXML 
	private TableColumn<Products,String> countryofmade;
	@FXML 
	private TableColumn<Products,String> dateofmade;
        
 
    @FXML 
    private void ExitfromMachineTable(){
        
        System.exit(0);
        
    }
    
    @FXML 
    private void backtoMachine(ActionEvent event) throws Exception {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Product.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                stage.setTitle("Machines");
                stage.show();
        
    }

    
    public	ObservableList<Products> data = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
			
                       Connection conn = AdminDB.getConnection();
			
                       Statement st = conn.createStatement();
        
                       ResultSet rs = st.executeQuery("Select * from Products");
			
			while (rs.next()) {	 
                            
				
                            
                         data.add(new Products(rs.getInt(1), rs.getString(2), rs.getString(3), 
			      rs.getString(4),rs.getString(5),rs.getString(6)));
				 
				
			}

			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	 	
    		
                
		id.setCellValueFactory(new PropertyValueFactory<Products,Integer>("id"));
		Type.setCellValueFactory(new PropertyValueFactory<Products,String>("type"));
		size.setCellValueFactory(new PropertyValueFactory<Products,String>("size"));
                power.setCellValueFactory(new PropertyValueFactory<Products,String>("power"));
                countryofmade.setCellValueFactory(new PropertyValueFactory<Products,String>("countryofmade"));
                dateofmade.setCellValueFactory(new PropertyValueFactory<Products,String>("dateofmade"));
		
 
		
 	table.setItems(data);
 	
 	
	
        // TODO
    }    
    
}
