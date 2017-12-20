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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class EmpolyeeController implements Initializable {

    @FXML
    Button View;
    
    
    
    @FXML
        public void BackMain(ActionEvent e) throws IOException{
            
            ((Node) (e.getSource())).getScene().getWindow().hide();
                
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Main.fxml"));
    
                
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
	
    
    
    
    @FXML
    
    private void ViewEm(ActionEvent event) throws Exception {
    
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource("/cd/ViewEmployee.fxml"));
    
                
                Stage stage = new Stage();
                
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                
                stage.setTitle("View Em");
                stage.show();

    }
    
    
    
    @FXML
    private void InsertEm(ActionEvent event) throws Exception {
    
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource("/cd/InsertEmployee.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                
                stage.setTitle("Insert");
                stage.show();

    }
    
    
    
     @FXML
    private void UpdateDeleteEm(ActionEvent event) throws Exception {
    
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource("/cd/UpdateDelete.fxml"));
    
                
                Stage stage = new Stage();
                
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
         
                stage.setTitle(" Update ");
                stage.show();

    }
    
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
