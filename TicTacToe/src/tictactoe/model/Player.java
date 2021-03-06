/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class Player {

  private String ipAddress;
  private String name;
  private int wonGames;
  private int lostGames;
  private ArrayList<Piece> placedPieces = new ArrayList<>();

  public Player(String name, String ipAddress) {
    this.name = name;
    this.ipAddress = ipAddress;
  }

  public ArrayList<Piece> getPlacedPieces() {
    return placedPieces;
  }

  public void setPlacedPieces(ArrayList<Piece> placedPieces) {
    this.placedPieces = placedPieces;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWonGames() {
    return wonGames;
  }

  public void setWonGames(int wonGames) {
    this.wonGames = wonGames;
  }

  public int getLostGames() {
    return lostGames;
  }

  public void setLostGames(int lostGames) {
    this.lostGames = lostGames;
  }

  public void addPiece(Piece toPlace) {
  }

  @Override
  public String toString() {
    return name;
  }

}
