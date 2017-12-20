/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class InsertCusController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     */
    
    @FXML
	private TextField id;
	@FXML
	private TextField fname;
	@FXML
	private TextField sname;
	@FXML
	private TextField pnumber;
    
    
    @FXML 
    private void InsertCus(){
        
      
        String id1  =  id.getText();
	String fname1  =   fname.getText();
	String sname1  = sname.getText();
	String pnumber1 = pnumber.getText();
        
        
        CustomerClass cus = new CustomerClass();
        
        cus.setId(id1);
        cus.setFname(fname1);
        cus.setSname(sname1);
        cus.setPnumber(pnumber1);
        
        int status=  DBInfo.saveCus(cus);
        
        
        
         if(status>0){  
		  
		  
		  Alert alert = new Alert(Alert.AlertType.INFORMATION);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("Information Dialog");
		  alert.setContentText("Record saved successfully!");

		  alert.showAndWait();
	
		  
         //System.out.println("  successfully! ");  
           
      }else{  
    	  
    	  
		 Alert alert = new Alert(Alert.AlertType.ERROR);
		 alert.setTitle("Data Insert");
		 alert.setHeaderText("ERROR Dialog");
	         alert.setContentText("Sorry! unable to save record");

		  alert.showAndWait();
    	  
    	  
    	// System.out.println("Sorry! unable to save record");  
      }  
        
        
    }
    
    @FXML 
    private void BackToCustomer(ActionEvent event) throws Exception{
        
         ((Node) (event.getSource())).getScene().getWindow().hide();
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Customer.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                stage.setTitle("Customers");
                stage.show();
        
    }
    
    @FXML 
    private void Exit(){
        
        System.exit(0);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
