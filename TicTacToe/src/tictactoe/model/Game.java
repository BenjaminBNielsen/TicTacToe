/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Benjamin
 */
public class Game {

    private Date date;
    private String name;
    private Board board;
    private Player[] players = new Player[2];
    private int turn = 1;
    private boolean hasWinner = false;

    public Game(Date date, String name) {
        this.date = date;
        this.name = name;
        board = new Board();
    }

    public Game() {
        board = new Board();
    }

    /**
     * Denne metode håndterer logikken for at placere en knap på spillepladen. Klienten vil tilgå denne metode når der skal placeres en knap.
     *
     * @param spot den plads hvorpå spillebrikken skal placeres.
     * @return vinderen af spillet, eller null hvis der endnu ikke er nogen vinder.
     */
    public Player placePiece(int spot) {
        if (!hasWinner) {
            Piece toPlace = new Piece(turn);
            int playersTurn = (turn == 1) ? 0 : 1;
            maxThreeControl(players[playersTurn].getPlacedPieces(), toPlace);
            if (board.getPieces()[spot].getType() == 0) {
                board.getPieces()[spot] = toPlace;
                Player winner = checkWin();
                if (winner != null) {
                    hasWinner = true;
                    return winner;
                }
                swapTurn();
            }
        }
        return null;
    }

    private void maxThreeControl(ArrayList<Piece> pieces, Piece toPlace) {
        if(pieces.size() < 3){
            pieces.add(toPlace);
        }else{
            board.getPieces()[board.indexOf(pieces.get(0))] = new Piece(0);
            pieces.remove(0);
            pieces.add(toPlace);
        }
    }

    /**
     * Flipper turen sådan at hvis den før var 3 er den nu 1 og omvendt. Der bruges 1 og 3 fordi at de skal være ulige i forhold til hinanden for at win conditions ikke skal kunne fejle. Hvis de var 1 og 2 ville 0+1+2 give 3 og dermed vinde spillet, selvom det i virkeligheden var en tom plads, et kryds og en bolle.
     */
    private void swapTurn() {
        turn = (turn == 1) ? 5 : 1;
        //Send UDP pakke til spilleren at han må placere en brik.
    }

    /**
     * Tjekker om det foretagne træk har afsluttet spillet. Hvis det har vil der sendes en pakke til begge spillere.
     *
     * @return spilleren der har vundet.
     */
    private Player checkWin() {
        Piece[] pieces = board.getPieces();

        int[] logicSums = new int[8];
        //tjek horisontale rækker
        logicSums[0] = pieces[0].getType() + pieces[1].getType() + pieces[2].getType();
        logicSums[1] = pieces[3].getType() + pieces[4].getType() + pieces[5].getType();
        logicSums[2] = pieces[6].getType() + pieces[7].getType() + pieces[8].getType();
        //tjek vertikale rækker
        logicSums[3] = pieces[0].getType() + pieces[3].getType() + pieces[6].getType();
        logicSums[4] = pieces[1].getType() + pieces[4].getType() + pieces[7].getType();
        logicSums[5] = pieces[2].getType() + pieces[5].getType() + pieces[8].getType();
        //tjek de 2 diagonale rækker
        logicSums[6] = pieces[0].getType() + pieces[4].getType() + pieces[8].getType();
        logicSums[7] = pieces[2].getType() + pieces[4].getType() + pieces[6].getType();
        for (int i = 0; i < logicSums.length; i++) {
            if ((turn == 1 && logicSums[i] == 3) || (turn == 5 && logicSums[i] == 15)) {
                System.out.println("vinder på : " + i + " med værdien: " + logicSums[i] + " og turn er: " + turn);
                return (turn == 1) ? players[0] : players[1];
            }
        }
        return null;
    }

    /**
     * Contains the behaviour for ending a game.
     */
    private void endGame() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

}
