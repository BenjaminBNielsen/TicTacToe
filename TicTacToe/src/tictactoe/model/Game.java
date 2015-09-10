/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

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
    private int turn = 0;

    public Game(Date date, String name) {
        this.date = date;
        this.name = name;
        board = new Board();
    }
    
    public Game(){
        board = new Board();
    }

    /**
     * Denne metode håndterer logikken for at placere en knap på spillepladen.
     * Klienten vil tilgå denne metode når der skal placeres en knap.
     * @param spot den plads hvorpå spillebrikken skal placeres.
     * @return true hvis spillebrikken succesfuldt blev placeres, false hvis
     * den ikke kunne placeres.
     */
    public boolean placePiece(int spot) {
        Piece toPlace = new Piece(turn);
        players[turn].getPlacedPieces().add(toPlace);
        turn = (turn > 0) ? 0 : 1;
        if (board.getPieces()[spot] == null) {
            board.getPieces()[spot] = toPlace;
            return true;
        }
        return false;
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
