/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.loadGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javax.swing.table.TableColumn;
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
  private TableView tableLoad;
  @FXML
  private TableColumn gameName;

  /**
   * Initializes the controller class.
   */
  public Load_gameController(FXMLDocumentController dc) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("load_game.fxml"));

    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    this.dc = dc;

    loadFiles();

    try {
      fxmlLoader.load();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @FXML
  private void loadButton(ActionEvent event) {
    String[] params = loadGame();
    GameControl gc = new GameControl();
    gc.getGame().getPlayers()[0].setName(params[0]);
    gc.getGame().getPlayers()[1].setName(params[1]);
    for (int i = 2; i < params.length; i++) {
      gc.getGame().getBoard().setPiece(new Piece(Integer.parseInt(params[i])), i);
    }

    this.setCenter(gc);
  }

  @FXML
  private void cancel(ActionEvent event) {
    this.setCenter(dc.getCenter());
  }

  private String[] loadGame() {
    String fileName = tableLoad.getSelectionModel().getSelectedItem().toString();

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
    try {
      Files.walk(Paths.get("C:\\Users\\Andreas\\Documents\\NetBeansProjects\\TicTacToe\\TicTacToe\\saved games")).forEach(filePath -> {
        if (Files.isRegularFile(filePath)) {
          ObservableList files = FXCollections.observableArrayList(filePath);
          tableLoad.setItems(files);
        
        }
      });
    } catch (IOException ex) {
      System.out.println("Fejl under indlæsning " + ex.getMessage());
    }
  }

}
