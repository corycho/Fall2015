package com.oose2015.hcho34.hareandhounds;

enum PieceType{	HOUND ,HARE	}
public abstract class Piece {
	protected PieceType pieceType;
	public int x;
	public int y;
	
	public PieceType getPieceType() {
		return pieceType;
	}
	
	public void move(int toX, int toY) {
		this.x = toX;
		this.y = toY;
	}
	
}