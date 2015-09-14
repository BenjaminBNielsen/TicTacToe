/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.saveGame;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import tictactoe.boardView.GameControl;
import tictactoe.mainView.FXMLDocumentController;
import tictactoe.model.Piece;

/**
 * FXML Controller class
 *
 * @author Andreas
 */
public class Save_gameController extends BorderPane {

  @FXML
  private TextField nameField;
  @FXML
  private TableView saveTable;

  private FXMLDocumentController dc;
  private GameControl gc;

  public Save_gameController(FXMLDocumentController dc) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("save_game.fxml"));

    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    this.dc = dc;
    gc = dc.getGc();

    try {
      fxmlLoader.load();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @FXML
  private void saveGame(ActionEvent event) {
    writeToFile();
    this.setCenter(gc);

  }

  @FXML
  private void useText(MouseEvent event) {
    nameField.setText(saveTable.getSelectionModel().getSelectedItem().toString());
  }

  @FXML
  private void cancel(ActionEvent event) {
    this.setCenter(dc.getCenter());
  }

  public TextField getNameField() {
    return nameField;
  }

  private void writeToFile() {
    String player1 = dc.getGc().getPlayer1().getName();
    String player2 = dc.getGc().getPlayer2().getName();
    Piece[] pieces = dc.getGc().getGame().getBoard().getPieces();
    try {
      String fileName = nameField.getText() + ".txt";
      File file = new File("C:\\Users\\Andreas\\Documents\\NetBeansProjects\\TicTacToe\\TicTacToe\\saved games" + fileName);
      PrintWriter pw = new PrintWriter(file);
      pw.println(player1);
      pw.println(player2);

      for (int i = 0; i < pieces.length; i++) {
        pw.println(pieces[i].getType());
      }

      pw.close();
    } catch (IOException ex) {
      System.out.println("Det var ikke muligt at skrive til filen. " + ex.getMessage());
    }
  }

}
