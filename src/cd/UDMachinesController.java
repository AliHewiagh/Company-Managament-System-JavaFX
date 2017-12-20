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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class UDMachinesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField id1;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    
    
     @FXML
        public void BackEm(ActionEvent e) throws IOException{
            
            ((Node) (e.getSource())).getScene().getWindow().hide();
    
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/MachinesSet.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);

                stage.setTitle("Product");
                stage.show();
	 
            
        }
        @FXML
        public void Exit(ActionEvent e){
            
            System.exit(0);
            
        }
    
    public void getProById(ActionEvent e) throws IOException, ParseException{
		
		
		String sid=id1.getText();  
	        int id=Integer.parseInt(sid);   

              Machine ma = DBInfo.getMachineId(id);

	      name.setText(ma.getName());
              price.setText(String.valueOf(ma.getPrice()));

    }
	
 @FXML
 private void UpdatePr(ActionEvent event) {
            
        
            String sid=id1.getText();  
	    int id=Integer.parseInt(sid);  
	    String textName  =  name.getText();
	    float textPrice  =     Float.parseFloat(price.getText());
        
	   
         Machine ma = new Machine();
	    
	    ma.setId(id);
            ma.SetName(textName);
            ma.setPrice(textPrice);
                
	
	 
	    int status=DBInfo.updatePro(ma);
           
        if(status>0){  
        	
        	
  		  Alert alert = new Alert(Alert.AlertType.INFORMATION);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("Information Dialog");
  		  alert.setContentText("Record updated successfully!");

  		  alert.showAndWait();
        	
        	
        	// System.out.println(" Record saved successfully! ");
        }else{ 
        	
  		  Alert alert = new Alert(Alert.AlertType.ERROR);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("ERROR Dialog");
  		  alert.setContentText("Sorry! unable to update record");

  		  alert.showAndWait();
        	
        	//System.out.println("Sorry! unable to update record");  
        }  
     
	}	

   
 @FXML
 private void DeletePr(ActionEvent event) {
        
        
            String sid=id1.getText();  
	    int id=Integer.parseInt(sid);   
 
	     
	     int status=  DBInfo.deletePr(id) ;
	        if(status>0){  
	        	
	        	
	  		  Alert alert = new Alert(AlertType.INFORMATION);
	  		  alert.setTitle("Data delete");
	  		  alert.setHeaderText("Information Dialog");
	  		  alert.setContentText("Record deleted successfully!");

	  		  alert.showAndWait();
	        	
	        	
	       //	 System.out.println(" successfull ");
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
