/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

/**
 *
 * @author Benjamin
 */
public class Board {

    private int state;
    private Piece[] pieces = new Piece[9];

    public Board() {
        state = 0;
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = new Piece(0);
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

}
