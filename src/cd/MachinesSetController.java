/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class MachinesSetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private void ViewPro(ActionEvent event) throws Exception {
        
        //System.out.println("ffff");
        
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/cd/ViewMachines.fxml"));
    
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("View Products");
                stage.show();

    }
    
    
    @FXML
    private void InsertPro(ActionEvent event) throws Exception {
        
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/cd/InsertMachines.fxml"));
    
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("Insert 5655Machines");
                stage.show();

    }
    
    @FXML
    private void UPPro(ActionEvent event) throws Exception {
        
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/cd/UDMachines.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("Delete and Update");
                stage.show();

    
    }
    
    
    @FXML
    private void BackMain(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Main.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);

                stage.setTitle("Main");
                stage.show();
        
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
