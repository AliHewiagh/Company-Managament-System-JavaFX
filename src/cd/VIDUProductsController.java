/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import cd.Products;
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
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 * 
 * 
 * 
 */


public class VIDUProductsController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
	private TextField id;
	@FXML
	private TextField type;
	@FXML
	private TextField size;
	@FXML
	private TextField power;
	@FXML
	private TextField countryofmade;
        @FXML
	private DatePicker dateofmade;
    
        
        
    @FXML
    private void Exit(){
        
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
    @FXML
    private void insertProduct(ActionEvent event) throws Exception {
    
       
        LocalDate datebirth = dateofmade.getValue();
        
        
	String ID   = id.getText();
	String typee  =  type.getText();
	String sizee  = size.getText();
	String powerr  = power.getText();
	String countryoffmade = countryofmade.getText();
	String dateoffmade = datebirth.toString() ;

	int IDn = Integer.parseInt(ID);

	Products pro = new Products(); 
        pro.setId(IDn);
	pro.setType(typee);
	pro.setSize(sizee);
        pro.setPower(powerr);
        pro.setCountryOfmade(countryoffmade);
        pro.setDateOfmade(dateoffmade);
	
	
	int status =  DBInfo.savePro(pro);
	
         //System.out.print(status);
	if(status>0){  
		  
		 
		  Alert alert = new Alert( AlertType.INFORMATION);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("Information Dialog");
		  alert.setContentText("Record saved successfully!");
		  alert.showAndWait();
		  
		  
		  
        // System.out.println("successful ");  
           
      }else{  
    	  
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("ERROR Dialog");
		  alert.setContentText("Unable to save record");
		  alert.showAndWait();
    	  
    	// System.out.println("Sorry! unable to save record");  
      }  
    
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
