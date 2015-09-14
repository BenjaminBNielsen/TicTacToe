/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Benjamin
 */
public class GameTest {

    public GameTest() {
    }

    /**
     * Tester første mulige horisontale win condition.
     */
    @Test
    public void testHWin() {
        Game game = new Game(null, null);
        Player p1 = new Player("Olga", "");
        Player p2 = new Player("Jens", "");
        game.setPlayers(new Player[]{p1, p2});
        game.placePiece(0);
        game.placePiece(3);
        game.placePiece(1);
        game.placePiece(4);
        Player actualWinner = game.placePiece(2);
        Player expectedWinner = p1;
        assertEquals("Den forventede vinder vandt ikke ved en række: ", expectedWinner, actualWinner);
    }

    /**
     * Tester første mulige vertikale win condition.
     */
    @Test
    public void testVerticalWin() {
        Game game = new Game(null, null);
        Player p1 = new Player("Olga", "");
        Player p2 = new Player("Jens", "");
        game.setPlayers(new Player[]{p1, p2});
        game.placePiece(0);
        game.placePiece(1);
        game.placePiece(3);
        game.placePiece(2);
        Player actualWinner = game.placePiece(6);
        Player expectedWinner = p1;
        assertEquals("Den forventede vinder vandt ikke ved en række: ", expectedWinner, actualWinner);
    }

    /**
     * Tester venstre diagonale win condition.
     */
    @Test
    public void testLeftDiagonalWin() {
        Game game = new Game(null, null);
        Player p1 = new Player("Olga", "");
        Player p2 = new Player("Jens", "");
        game.setPlayers(new Player[]{p1, p2});
        game.placePiece(0);
        game.placePiece(1);
        game.placePiece(4);
        game.placePiece(2);
        Player actualWinner = game.placePiece(8);
        Player expectedWinner = p1;
        assertEquals("Den forventede vinder vandt ikke ved en række: ", expectedWinner, actualWinner);
    }

    /**
     * Tester venstre diagonale win condition.
     */
    @Test
    public void testRightDiagonalWin() {
        Game game = new Game(null, null);
        Player p1 = new Player("Olga", "");
        Player p2 = new Player("Jens", "");
        game.setPlayers(new Player[]{p1, p2});
        game.placePiece(2);
        game.placePiece(0);
        game.placePiece(4);
        game.placePiece(1);
        Player actualWinner = game.placePiece(6);
        Player expectedWinner = p1;
        assertEquals("Den forventede vinder vandt ikke ved en række: ", expectedWinner, actualWinner);
    }
}
