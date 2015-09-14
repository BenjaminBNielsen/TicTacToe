/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.mainView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import tictactoe.boardView.GameControl;

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
    
    @FXML
    private void startGame(ActionEvent event){
        GameControl gc = new GameControl();
        this.setCenter(gc);
    }
    
    @FXML
    private void toHome(ActionEvent event) {
      FXMLDocumentController dc = new FXMLDocumentController();
      this.setCenter(dc.getCenter());
    }
    
    @FXML
    private void loadGame(ActionEvent event) {
      
    }
    
    @FXML
    private void saveGame(ActionEvent event) {
      
    }
    
    @FXML
    private void search(ActionEvent event) {
      
    }
    
    @FXML
    private void statistic(ActionEvent event) {
      
    }
}
