/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.mainView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author stine
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLDocumentController fdc = new FXMLDocumentController();
        
        Scene scene = new Scene(fdc);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
