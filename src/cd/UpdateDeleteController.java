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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class UpdateDeleteController implements Initializable {

    @FXML
    private TextField id1;
    @FXML
    private TextField fname1;
    @FXML
    private TextField lname1;
    @FXML
    private TextField nationality1;
    @FXML
    private TextField salary1;
    @FXML
    private  TextField dateofbirth1;
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
            
            System.exit(0);
            
        }
    
    public void getEmployeeById(ActionEvent e) throws IOException, ParseException{
		
		
		String sid=id1.getText();  
	    int id=Integer.parseInt(sid);   
		
	    Employee emp=DBInfo.getEmployeeId(id); 
 
	    fname1.setText(emp.getFname());
	    lname1.setText(emp.getLname());
	    salary1.setText(String.valueOf(emp.getSalary()));
	    nationality1.setText( emp.getNationality());
            dateofbirth1.setText( emp.getDateofbirth());

    }
	
    
    @FXML
    private void UpdateEm(ActionEvent event) {
            
        
            String sid=id1.getText();  
	    int id=Integer.parseInt(sid);  

	    String textfName  =  fname1.getText();
	    String textlName  =     lname1.getText();
 
             System.out.println(" Re! ");
	    float textsalary  =     Float.parseFloat(salary1.getText());

	    String textnation       =     nationality1.getText();
            String dateoffbirth     =     dateofbirth1.getText();

	    Employee emp=new Employee();  
	    
                emp.setId(id);
		emp.setFname(textfName);
		emp.setLname(textlName);
		emp.setSalary(textsalary);
		
		emp.setNationality(textnation);
		emp.setDate_of_birth(dateoffbirth);
		
	
	
	 
	    int status=DBInfo.update(emp);
           
        if(status>0){  
        	
        	
  		  Alert alert = new Alert(AlertType.INFORMATION);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("Information Dialog");
  		  alert.setContentText("Record updated successfully!");

  		  alert.showAndWait();
        	
        	
        	// System.out.println(" Record saved successfully! ");
        }else{ 
        	
  		  Alert alert = new Alert(AlertType.ERROR);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("ERROR Dialog");
  		  alert.setContentText("Sorry! unable to update record");

  		  alert.showAndWait();
        	
        	
        
        	
        	//System.out.println("Sorry! unable to update record");  
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
	        	
	        	
	       //	 System.out.println("successfull ");
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
