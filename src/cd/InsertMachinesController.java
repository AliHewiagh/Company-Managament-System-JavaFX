/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class InsertMachinesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
     @FXML
	private TextField id;
	@FXML
	private TextField name;
	@FXML
	private TextField price;
        
        
        
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
        
        
        
        
        
        
        public void insertPro(ActionEvent e) throws IOException{
		
	
		
	String Id   = 	id.getText();
	String Name = 	name.getText();
	String Pricee = price.getText();
	
	float Price = Float.parseFloat(Pricee);
	
	Machine ma = new Machine();
      
        ma.SetName(Name);
        ma.setPrice(Price);
	
	
        
	 int status=  DBInfo.saveMa(ma);
	 
	  if(status>0){  
		  
		  
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("Information Dialog");
		  alert.setContentText("Record saved successfully!");

		  alert.showAndWait();
	
		  
         //System.out.println("  successfully! ");  
           
      }else{  
    	  
    	  
		 Alert alert = new Alert(AlertType.ERROR);
		 alert.setTitle("Data Insert");
		 alert.setHeaderText("ERROR Dialog");
	         alert.setContentText("Sorry! unable to save record");

		  alert.showAndWait();
    	  
    	  
    	// System.out.println("Sorry! unable to save record");  
      }  
		
	}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
