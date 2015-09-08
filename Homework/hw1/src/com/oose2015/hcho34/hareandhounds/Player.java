package com.oose2015.hcho34.hareandhounds;
import java.util.*;

public class Player {
	private String playerID;
	protected List<Piece> pieces;
	private String pieceType;

	public Player(String name, PieceType type) {
		this.playerID = name;
		this.pieces = new ArrayList<Piece>();
		if (type == PieceType.HARE) {
			Hare hare = new Hare(4,1);
			this.pieces.add(hare);
			this.pieceType = "HARE";
		} else {
			Hound hound_a = new Hound(1,0);
			Hound hound_b = new Hound(0,1);
			Hound hound_c = new Hound(1,2);
			this.pieces.add(hound_a);
			this.pieces.add(hound_b);
			this.pieces.add(hound_c);
			this.pieceType = "HOUND";
		}
	}
	
	public String getPlayerID() {
		return this.playerID;
	}
	
	public int getPiecesLength() {
		return this.pieces.size();
	}
	
	public String getPieceType() {
		return this.pieceType;
	}
	
	public boolean movePiece(int fromX, int fromY, int toX, int toY) {
		boolean ret = false;
		if (toX - fromX < 2 && fromX - toX < 2 && toY - fromY < 2 && fromY- toY < 2) {
			int index = 0;
			//case where type is "HARE"
			if (this.pieceType == "HARE") {
				if (fromY != toY && fromY % 2 == 1 && fromX % 2 == 1) {
					if (toY % 2 != 0) {
						ret = true;
					} else if (fromX == toX) {
						ret = true;
					}
				} else {
					ret = true;
				}
				if (ret == true) {						
					this.pieces.get(index).move(toX, toY);
				}
			} 
			//case where type is "HOUND"
			else {
				if (fromX <= toX) {
					if (fromX < toX) {
						if (fromY % 2 == 1 && fromX % 2 == 1) {
							if (toY == fromY) {
								ret = true;
							}
						} else if(fromX == 2 && fromY != 1 && toX == 3) {
							if (toY != 1) {
								ret = true;
							}
						} else {
							ret = true;
						}
					} else {
						ret = true;
					}
					if (ret == true) {						
						index = findIndex(fromX, fromY);
						this.pieces.get(index).move(toX, toY);
					}
//				if ((toX == fromX && toY >= fromY) || (toY == fromY && toX >= fromX) ) {
//					index = findIndex(fromX, fromY);
//					this.pieces.get(index).move(toX, toY);
//					ret = true;
				}
			}
		}
		return ret;
	}
	
	public int findIndex(int fromX, int fromY){
		int index = 0;
		for (int i = 0; i < 3; i++) {
			if (this.pieces.get(i).x == fromX && this.pieces.get(i).y == fromY) {
				index = i;
			}
		}
		return index;
	}
	
	public boolean hasIndex(int turn, int fromX, int fromY) {
		boolean ret = false;
		if (turn == 1) {
			if (this.pieces.get(0).x == fromX && this.pieces.get(0).y == fromY) {
				ret = true;
			}
		} else {
			for (int i = 0; i < 3; i++) {
				if (this.pieces.get(i).x == fromX && this.pieces.get(i).y == fromY) {
					ret = true;
				}
			}
		}	
		return ret;
	}
}
