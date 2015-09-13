/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.boardView;

import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import tictactoe.endGame.EndgameController;
import tictactoe.model.Game;
import tictactoe.model.Player;

/**
 * FXML Controller class
 *
 * @author stine
 */
public class GameControl extends BorderPane {

    @FXML
    private Label player1label;
    @FXML
    private Label player2label;
    @FXML
    private GridPane boardGrid;
    @FXML
    private Button bZero, bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight;

    private ObservableList<Button> buttons = FXCollections.observableArrayList();

    private Game game = new Game();

    private Player player1 = new Player("Olga", "");
    private Player player2 = new Player("Jens", "");

    public GameControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("board_view.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        game.setPlayers(new Player[]{player1, player2});
        buttons.addAll(bZero, bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight);

        loadBindings();
        updateBoard();
    }

    /**
     * Inititializes the bindings needed for the board to reflect the actual state of the game.
     */
    private void loadBindings() {
        player1label.textProperty().bind(Bindings.format(player1.getName()));
        player2label.textProperty().bind(Bindings.format(player2.getName()));
        for (int i = 0; i < buttons.size(); i++) {
            int j = i;
            buttons.get(i).setOnAction(e -> {
                Player winner = game.placePiece(j);
                //if player is not null then game has finished
                if(winner != null){
                    EndgameController egc = new EndgameController(winner);
                    BorderPane bp = (BorderPane)this.getParent();
                    bp.setCenter(egc);
                }
                updateBoard();
            });
        }
    }

    /**
     * Updates the board, so that it reflects the contents of the board model object.
     */
    private void updateBoard() {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText("" + game.getBoard().getPieces()[i].getType());
        }
    }
}
