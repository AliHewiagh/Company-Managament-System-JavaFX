/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;




/**
 * FXML Controller class
 *
 * @author alihewaigh
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button employee;
     @FXML
    private Button products;
      @FXML
    private Button machines;
       @FXML
    private Button customers;
        @FXML
    private Button expenses;
        @FXML
    private Button PDF;
        
        
        
     @FXML
     private void toPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException, BadElementException, IOException{
         
         Connection conn = AdminDB.getConnection();
        Statement st = conn.createStatement();
         ResultSet query_set = st.executeQuery("Select * from Employee");
         Document my_pdf_report = new Document();
         PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
         my_pdf_report.open();
         
          
          
          Image img = Image.getInstance("mmu.png");
          my_pdf_report.add(img);
          
          
	  my_pdf_report.add(new Paragraph(new Date().toString()));
         
	            my_pdf_report.addCreationDate();
	            my_pdf_report.addCreator("JavaBeat");
	            my_pdf_report.addTitle("Sample PDF");

	            //Create Paragraph
	            Paragraph paragraph = new Paragraph("Title 1",new Font(Font.FontFamily.TIMES_ROMAN, 18,
	            	      Font.BOLD));
                    paragraph.setAlignment(5);
         my_pdf_report.add(paragraph);
         
         PdfPTable my_report_table = new PdfPTable(6);
         PdfPCell table_cell;
         
        my_report_table.addCell("ID");
        my_report_table.addCell("First Name");
        my_report_table.addCell("Last Name");
        my_report_table.addCell("Nationality");
        my_report_table.addCell("Salary");
        my_report_table.addCell("Date of Birth");
         
         while (query_set.next()) {            
             
                   
                                    String dept_id = query_set.getString("id");
                                    table_cell= new PdfPCell(new Phrase(dept_id));
                                    my_report_table.addCell(table_cell);
                                    
                                    String dept_name=query_set.getString("fname");
                                    table_cell=new PdfPCell(new Phrase(dept_name));
                                    my_report_table.addCell(table_cell);
                                    
                                    String sec_name=query_set.getString("lname");
                                    table_cell=new PdfPCell(new Phrase(sec_name));
                                    my_report_table.addCell(table_cell);
                                    
                                    
                                    String nat =query_set.getString("nationality");
                                    table_cell=new PdfPCell(new Phrase(nat));
                                    my_report_table.addCell(table_cell);
                                    
                                    String sal = query_set.getString("salary");
                                    
                                    table_cell=new PdfPCell(new Phrase(sal));
                                    my_report_table.addCell(table_cell);
                                    
                                    
                                    
                                    String da =query_set.getString("dateofbirth");
                                    table_cell=new PdfPCell(new Phrase(da));
                                    my_report_table.addCell(table_cell);
                               
                                    
                                    }
         
         
         
                    /* Attach report table to PDF */
                    my_pdf_report.add(my_report_table); 
                   
                    my_pdf_report.close();
                    /* Close all DB related objects */
                   
                    query_set.close();
                    st.close(); 
                    conn.close(); 
                
              
	    
         
     }
    
     @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
     
        String a = ((Button)event.getSource()).getText();

        if("Exit".equals(a))
        {
            System.exit(0);
        }else if("Empolyee".equals(a)){

           
                ((Node) (event.getSource())).getScene().getWindow().hide();
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Empolyee.fxml"));
    
                
                Stage stage = new Stage(); 
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                stage.setTitle("Empolyee");
                stage.show();
                
                
        }
        else if("Machines".equals(a)){

                ((Node) (event.getSource())).getScene().getWindow().hide();
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Product.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                stage.setTitle("Machines");
                stage.show();
                
                
        }
        
        
        else if("Products".equals(a)){

           
            
                ((Node) (event.getSource())).getScene().getWindow().hide();
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/MachinesSet.fxml"));

                Stage stage = new Stage();
                
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);

                stage.setTitle("Products");
                stage.show();
         
        }
        else if("Customers".equals(a)){

                ((Node) (event.getSource())).getScene().getWindow().hide();
                
                 Parent parent = FXMLLoader.load(getClass().getResource("/cd/Customer.fxml"));
    
                
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                 scene.getStylesheets().add(CD.class.getResource("makeup.css").toExternalForm());
                stage.setScene(scene);
               

                stage.setTitle("Customers");
                stage.show();
                
                
        }
            else{
               // check.setVisible(true);
            }
            
        }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    
    
}
