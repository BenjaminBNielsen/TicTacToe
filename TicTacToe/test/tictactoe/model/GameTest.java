/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

import java.util.Arrays;
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
        game.setPlayers(new Player[]{p1,p2});
        game.placePiece(0);
        game.placePiece(3);
        game.placePiece(1);
        game.placePiece(4);
        Player actualWinner = game.placePiece(2);
        Player expectedWinner = p1;
        assertEquals("Den forventede vinder vandt ikke ved en række: ", expectedWinner, actualWinner);
        
        
    }
    /**
     * 
     */
    @Test
    public void testSecondHWin() {
    }
    /**
     * 
     */
    @Test
    public void testThirdHWin() {
    }
    @Test
    public void testFirstVWin() {
    }
    @Test
    public void testSecodVWin() {
    }
    @Test
    public void testThirdVWin() {
    }
    @Test
    public void testLeftDiagWin() {
    }
    @Test
    public void testRightDiagWin() {
    }

    @Test
    public void testGetDate() {
    }

    @Test
    public void testSetDate() {
    }

    @Test
    public void testGetName() {
    }

    @Test
    public void testSetName() {
    }

    @Test
    public void testGetBoard() {
    }

    @Test
    public void testSetBoard() {
    }

    @Test
    public void testGetPlayers() {
    }

    @Test
    public void testSetPlayers() {
    }
    
}
