/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.loadGame;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import tictactoe.boardView.GameControl;
import tictactoe.mainView.FXMLDocumentController;
import tictactoe.model.Piece;

/**
 * FXML Controller class
 *
 * @author stine
 */
public class Load_gameController extends BorderPane {

  private FXMLDocumentController dc;
  @FXML
  private TableView table;
  @FXML
  private TableColumn<File,String> gameName;

  /**
   * Initializes the controller class.
   */
  public Load_gameController(FXMLDocumentController dc) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("load_game.fxml"));

    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException ex) {
      System.out.println("IOException: " + ex.getMessage());
      System.out.println(Arrays.toString(ex.getStackTrace()));
    }
    this.dc = dc;

    loadFiles();


  }

  @FXML
  private void loadGame(ActionEvent event) {
    String[] params = showGame();
    GameControl gc = new GameControl();
    gc.getGame().getPlayers()[0].setName(params[0]);
    gc.getGame().getPlayers()[1].setName(params[1]);
    for (int i = 2; i < params.length; i++) {      
//      gc.getGame().getBoard().setPiece(new Piece(Integer.parseInt(params[i])), i);
    }
    
    this.setCenter(gc);
  }

  @FXML
  private void cancel(ActionEvent event) {
    this.setCenter(dc.getCenter());
  }

  private String[] showGame() {
    String fileName = table.getSelectionModel().getSelectedItem().toString();

    String[] params = new String[10];
    Scanner scan = new Scanner(fileName);

    int count = 0;

    while (scan.hasNext() && count < 10) {
      params[count] = scan.nextLine().trim();
      count++;
    }
    return params;
  }

  private void loadFiles() {
    File dir = new File("C:\\Users\\Andreas\\Documents\\NetBeansProjects\\TicTacToe\\TicTacToe\\saved games\\");
    System.out.println("Mappe: " + dir.toString());
    File[] files = dir.listFiles();
    System.out.println("Filer: " + Arrays.toString(files));
    for (int i = 0; i < files.length; i++) {
      System.out.println("Fil: " + files[i]);
      table.getItems().add(files[i]);
//      gameName.setCellValueFactory((CellDataFeatures<File, String> p) ->  new SimpleStringProperty(p.getValue().getValue().toString()));
//      gameName.setCellValueFactory(new Callback<CellDataFeatures<File>, ObservableValue<String>>() {
//     @Override
//     public ObservableValue<String> call(CellDataFeatures<File> p) {
//         // p.getValue() returns the Person instance for a particular TableView row
//         return new SimpleStringProperty(p.getValue().getValue().toString());
//     }
//  });
    }
  }
}
