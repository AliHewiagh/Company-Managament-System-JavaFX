/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;


import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author alihewaigh
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label check;
    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;
  
    
    @FXML
    private Label conndb;
    @FXML
    private Button check2;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
        
       if(!AdminDB.getConnection().isClosed()){
           
           conndb.setText("Connected");
       } 
       else{
           
           
           conndb.setText("Not Connected");
       }
        
    }
    
    
    public void enterCP(ActionEvent e) throws IOException, SQLException{
	
	
	 List<Admin> list=AdminDB.getAdmins(); 
	 
 
	 Map<String, String> map = new HashMap<String, String>();
	 
	 for(Admin a:list){
	 
		 map.put(a.getUsername(), a.getPassword());
	 }
	 
	 
	

if (map.containsKey(username.getText())) {
	
	String val2=map.get(username.getText());
	
	if( val2.equals(pass.getText()) ){

		check.setVisible(true);
		check.setText("Success");
		
		 
		AdminDB.getConnection();
		((Node) (e.getSource())).getScene().getWindow().hide();
    
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Main.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);

                stage.setTitle("Main");
                stage.show();
	 
                
	}else{
                check.setVisible(true);
		check.setText("Failed try again");
	}

	
}else{
        check.setVisible(true);
	check.setText("Failed try again");
}
	
	}

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
