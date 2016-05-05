package com.oose2015.hcho34.hareandhounds;

import java.util.*;

public class Game {
	private String gameID;
	private int turn;
	public List<Player> players;
	public State gameState;
	public Board board;
	public boolean isEnded;
	
	public Game() {
		this.gameID = "";
		this.players = new ArrayList<Player>(2);
		this.board = new Board();
		this.turn = 0; //starts with hound's turn
	}
	
	public void StartGame(String gameID) {
		this.setGameID(gameID);
	}
	
	public void setGameID(String gameID) {
		this.gameID = gameID;
	}
	
	public String getGameID() {
		return this.gameID;
	}
	
	public void setTurn(int num) {
		this.turn = num;
	}

	public int getTurn(){
		return this.turn;
	}
	
	public void AddPlayer(Player player) {
		if (player.getPieceType().equals("HOUND")){
			this.players.add(0, player);
		} else {
			this.players.add(1, player);
		}
	}
	
	public boolean MakeMove(String playerID, int fromX, int fromY, int toX, int toY) {
		boolean ret = false;
		boolean turn_ret = CheckTurn(playerID);
		if (turn_ret != false) { 
			boolean board_ret = this.board.isMovable(toX, toY);
			//update & move the piece
			if (board_ret != false) {
				boolean has_index = this.players.get(this.turn).hasIndex(this.turn, fromX, fromY);
				if (has_index != false) {
					ret = this.players.get(this.turn).movePiece(fromX, fromY, toX, toY);
					if (ret != false) {
						//update board
						this.board.updateBoard(this.turn, fromX, fromY, toX, toY);
						
						//update turn
						if (this.turn == 0) {
							this.turn = 1;
						} else {
							this.turn = 0;
						}
										
					} else {
						System.out.println("ILLEGAL_MOVE_1");
					}
				} else {
					System.out.println("ILLEGAL_MOVE_2");
				}
			} else {
				System.out.println("ILLEGAL_MOVE_3");
			}
		} else {
			System.out.println("INCORRECT_TURN");
		}
		return ret;
	}
	
	public boolean CheckTurn(String playerID) {
		boolean ret = false;
		if (this.players.get(this.turn).getPlayerID().equals(playerID)) {
			ret = true;
		}
		return ret;
	}
	
	public int GetPlayerLength() {
		return this.players.size();
	}
	
	public void printBoard() {
		this.board.printBoard();
	}
	
	public boolean isEnded() {
		boolean ret = false;
		boolean wonByHare = this.board.wonByHare();
		boolean wonByHound = this.board.wonByHound();
		if (wonByHare != false || wonByHound != false) {
			if (wonByHare) {
				System.out.println("WIN_HARE_BY_ESCAPE");
			} else {
				System.out.println("WIN_HOUND");
			}
			ret = true;
		}
		return ret;
	}
}
