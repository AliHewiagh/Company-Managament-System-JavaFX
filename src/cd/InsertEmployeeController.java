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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class InsertEmployeeController implements Initializable {

        @FXML
	private TextField fname1;
	@FXML
	private TextField lname1;
	@FXML
	private TextField salary1;
	@FXML
	private TextField nationality1;
	@FXML
	private DatePicker dateofbirth1;
	
 
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
	
	public void insertData(ActionEvent e) throws IOException{
		
		 
		LocalDate datebirth = dateofbirth1.getValue();
	     
	  
		
	String firstName  =  fname1.getText();
	String lastName  =   lname1.getText();
	String textSalary  = salary1.getText();
	String textNationality = nationality1.getText();
	String dateOfBirth  =  datebirth.toString() ;
	
	
	float fSalary = Float.parseFloat(textSalary);
        
        
	Employee emp = new Employee();  
	
	emp.setFname(firstName);
	emp.setLname(lastName);
	emp.setSalary(fSalary);
	emp.setDate_of_birth(dateOfBirth);
	emp.setNationality(textNationality);
	
	
	
	 int status=  DBInfo.save(emp);
         System.out.print("efef");
         System.out.print(status);
	  if(status>0){  
		  
		  
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("Information Dialog");
		  alert.setContentText("Record saved successfully!");

		  alert.showAndWait();
		  
		  
		  
         //System.out.println("successfull ");  
           
      }else{  
    	  
    	  
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("ERROR Dialog");
		  alert.setContentText("Sorry! unable to save record");
                  alert.showAndWait();
    	  
   
    	  
    	// System.out.println("Sorry");  
      }  
		
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
