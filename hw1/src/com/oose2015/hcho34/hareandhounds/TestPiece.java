package com.oose2015.hcho34.hareandhounds;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPiece {

	@Test
	public void testPiece() {
		Hare a = new Hare(1,2);
		assertEquals(1,a.x);
		assertEquals(2,a.y);
		System.out.println(PieceType.HOUND);
		System.out.println(PieceType.HOUND.getClass().getName());
		
		
		Hound b = new Hound(2,2);
		assertEquals(2,b.x);
		assertEquals(2,b.y);
		assertEquals(PieceType.HOUND, b.pieceType);
	}
	
	@Test
	public void testPlayer() {
		Player player_1 = new Player("Josh", PieceType.HOUND);
		Player player_2 = new Player("Emily", PieceType.HARE);
		
		String player1_ID;
		player1_ID= player_1.getPlayerID();
		assertEquals("Josh", player1_ID);
		String player2_ID;
		player2_ID = player_2.getPlayerID();
		assertEquals("Emily", player2_ID);
		
		Piece hound_a;
		Piece hound_b;
		Piece hound_c;
		hound_a = player_1.pieces.get(0);
		hound_b = player_1.pieces.get(1);
		hound_c = player_1.pieces.get(2);
		
		assertEquals(PieceType.HOUND, hound_a.pieceType);
		assertEquals(PieceType.HOUND, hound_b.pieceType);
		assertEquals(PieceType.HOUND, hound_c.pieceType);
		
		Piece hare;
		hare = player_2.pieces.get(0);
		assertEquals(PieceType.HARE, hare.pieceType);
	}

	@Test
	public void testGame() {
		Player player_1 = new Player("Josh", PieceType.HOUND);
		Player player_2 = new Player("Emily", PieceType.HARE);
		Game g = new Game();
		g.AddPlayer(player_1);
		g.AddPlayer(player_2);
		int count = g.GetPlayerLength();
		System.out.println(count);
	}
	
}




