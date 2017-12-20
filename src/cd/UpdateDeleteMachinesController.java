/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */


public class UpdateDeleteMachinesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TextField id1;
    @FXML
    private TextField type;
    @FXML
    private TextField size;
    @FXML
    private TextField power;
    @FXML
    private TextField countryofmade;
    @FXML
    private  TextField dateofmade;
    @FXML
    private Button insert1;
    @FXML
    private Button insert11;

    @FXML
    private Button find;
    /**
     * Initializes the controller class.
     */
    
    @FXML
        public void BackEm(ActionEvent e) throws IOException{
            
            ((Node) (e.getSource())).getScene().getWindow().hide();
                
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Product.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
     
                stage.setTitle("Machines");
                stage.show();
	 
            
        }
        @FXML
        public void Exit(ActionEvent e){
            
            System.exit(0);
            
        }
    
    public void getProductById(ActionEvent e) throws IOException, ParseException{
		
		//System.out.println("ggggg1g");
            String sid=id1.getText();  
	    int id=Integer.parseInt(sid);   
	
          Products pro = DBInfo.getProductsId(id);
 
 
	    type.setText(pro.getType());
	    size.setText(pro.getSize());
            power.setText(pro.getPower());
	    countryofmade.setText(pro.getCountryOfmade());
            dateofmade.setText(pro.getDateOfmade());
	   
	 
    }
	
    
    @FXML
    private void UpdateMac(ActionEvent event) {
            
        
            String sid=id1.getText();  
	    int id=Integer.parseInt(sid);  
	    String textType  = type.getText();
	    String textSize  = size.getText();
            

         //  System.out.println(" check! ");

	    String textPower       =     power.getText();
            String countryOfmade     =     countryofmade.getText();
          //   String dateOfmade     =     dateofmade.getText();
     
            Products pro=new Products();
	     
                pro.setId(id);
		pro.setType(textType);
		pro.setSize(textSize);
		pro.setPower(textPower);
		pro.setCountryOfmade(countryOfmade);
                pro.setDateOfmade(" ");
	
	    int status=DBInfo.updateMac(pro);
           
        if(status>0){  
        	
        	
  		  Alert alert = new Alert(AlertType.INFORMATION);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("Information Dialog");
  		  alert.setContentText("Record updated successfully!");
  		  alert.showAndWait();
        	        	
        	// System.out.println("successfull ");
        }else{ 
        	
  		  Alert alert = new Alert(AlertType.ERROR);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("ERROR Dialog");
  		  alert.setContentText("Sorry! unable to update record");

  		  alert.showAndWait();
        
        	//System.out.println("Sorry!");  
        }  
          
	
	}	

    @FXML
    private void DeleteEm(ActionEvent event) {
        
        
            String sid=id1.getText();  
	    int id=Integer.parseInt(sid);   
 
	     
	     int status=  DBInfo.delete(id) ;
	        if(status>0){  
	        	
	        	
	  		  Alert alert = new Alert(AlertType.INFORMATION);
	  		  alert.setTitle("Data delete");
	  		  alert.setHeaderText("Information Dialog");
	  		  alert.setContentText("Record deleted successfully!");

	  		  alert.showAndWait();
	       
	       	// System.out.println(" successfull ");
	        }else{ 
	        	
	  		  Alert alert = new Alert(AlertType.ERROR);
	  		  alert.setTitle("Data update");
	  		  alert.setHeaderText("ERROR Dialog");
	  		  alert.setContentText("Sorry! unable to delete record");
                          alert.showAndWait();

	        	//System.out.println("Sorry");  
	        }  
	
	}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
