/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.mainView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author stine
 */
public class FXMLDocumentController extends BorderPane implements Initializable {
    
    public FXMLDocumentController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        
        try{
            fxmlLoader.load();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
             
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
