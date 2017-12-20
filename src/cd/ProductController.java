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
public class ProductController implements Initializable {

    @FXML
    Button View;
     @FXML
    Button add;
      @FXML
    Button exit;
       @FXML
    Button UpdateDelete;
    
    
    
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
    private void ViewPr(ActionEvent event) throws Exception {
    
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource("/cd/InsertPoduct.fxml"));
    
                
                Stage stage = new Stage();
                
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                stage.setTitle("Insertyy");
                stage.show();

    }
    
    
    
    
     @FXML
    private void ViewMachines(ActionEvent event) throws Exception {
    
    ((Node) (event.getSource())).getScene().getWindow().hide();
   
     Parent parent = FXMLLoader.load(getClass().getResource("/cd/ViewProducts.fxml"));
    
                
                Stage stage = new Stage();
                
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);

                stage.setTitle("View");
                stage.show();

    }
    
    
    
    
     @FXML
    private void UPMac(ActionEvent event) throws Exception {
    
    ((Node) (event.getSource())).getScene().getWindow().hide();
   
     Parent parent = FXMLLoader.load(getClass().getResource("/cd/UpdateDeleteMachines.fxml"));
    
                
                Stage stage = new Stage();
                
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);

                stage.setTitle("U/P Machines");
                stage.show();

    
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}