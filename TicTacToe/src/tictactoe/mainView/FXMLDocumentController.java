/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.mainView;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import tictactoe.boardView.GameControl;
import tictactoe.saveGame.Save_gameController;

/**
 *
 * @author stine
 */
public class FXMLDocumentController extends BorderPane implements Initializable {

  private GameControl gc;
  private Save_gameController sgc;

  public FXMLDocumentController() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

    fxmlLoader.setController(this);
    fxmlLoader.setRoot(this);

    try {
      fxmlLoader.load();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }

  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    gc = new GameControl();
  }

  @FXML
  private void startGame(ActionEvent event) {
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
  private void saveMenu(ActionEvent event) {
    Save_gameController sgc = new Save_gameController(this);
    this.setCenter(sgc);
  }

  @FXML
  private void search(ActionEvent event) {

  }

  @FXML
  private void statistic(ActionEvent event) {

  }

  public GameControl getGc() {
    return gc;
  }

  public void setGc(GameControl gc) {
    this.gc = gc;
  }
}
