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
public class Piece {

    private int type;

    public Piece(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVisualType() {
        return (type == 1) ? "X" : (type == 5)? "O" : "";
    }

}
