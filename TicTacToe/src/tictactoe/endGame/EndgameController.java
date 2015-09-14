/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.endGame;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import tictactoe.model.Player;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class EndgameController extends BorderPane{

    @FXML
    private Label winnerLabel;
    
    public EndgameController(Player winner){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("end_game.fxml"));
        
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        
        try{
            fxmlLoader.load();
            
        }catch(IOException ex){
            
        }
        
        winnerLabel.setText(winner.getName().toUpperCase() + " VINDER");
    }   
    
}
