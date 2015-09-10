/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.boardView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.model.Game;
import tictactoe.model.Player;

/**
 * FXML Controller class
 *
 * @author stine
 */
public class GameControl implements Initializable {

    @FXML
    private Label player1label;
    @FXML
    private Label player2label;
    @FXML
    private GridPane boardGrid;

    private Player player1;
    private Player player2;

    public GameControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("board_view.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1label.textProperty().bind(Bindings.format(player1.getName()));
        player2label.textProperty().bind(Bindings.format(player2.getName()));

        Game game = new Game();
        ObservableList boardButtons = boardGrid.getChildren();
        for (int i = 0; i < boardButtons.size(); i++) {
            game.placePiece(i);
        }

    }

    private void unClick(ActionEvent e1) {
        Game game = new Game();
        ObservableList boardButtons = boardGrid.getChildren();
        for (int i = 0; i < boardButtons.size(); i++) {
            game.placePiece(i);

            if (game.getTurn() == 0) {
                boardButtons.get(i);
            }
        }

    }
}
