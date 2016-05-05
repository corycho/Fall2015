package com.oose2015.hcho34.hareandhounds;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Game g = new Game();
		String piece_str;
		String player_name;
		PieceType p;
		Scanner s = new Scanner(System.in);
		
		// Add Player 1
		System.out.println("What is your name?(Player 1)");
		player_name  = s.next();
		System.out.println("What piece would you want to play? (Hare:[A], Hounds:[B])");
		piece_str = s.next();
		if (piece_str.equals("A") || piece_str.equals("a")) {
			p = PieceType.HARE;
		} else {
			p = PieceType.HOUND;
		}	
		Player p_1 = new Player(player_name, p);
		
		if (g.players.size() < 2) {
			g.AddPlayer(p_1);
		}
		
		// Add Player 2
		System.out.println("What is your name?(Player 2)");
		player_name  = s.next();
		System.out.println("What piece would you want to play? (Hare:[A], Hounds:[B])");
		piece_str = s.next();
		if (piece_str.equals("A") || piece_str.equals("a")) {
			p = PieceType.HARE;
		} else {
			p = PieceType.HOUND;
		}	
		Player p_2 = new Player(player_name, p);
		if (g.players.size() < 2) {
			g.AddPlayer(p_2);
		}
		for (int i = 0; i < g.players.size(); i++) {
			System.out.println(g.players.get(i).getPlayerID());
			System.out.println(g.players.get(i).getPieceType());
		}
		
		//Start Game!
		System.out.println("Let's Start");
		g.printBoard();
		
		
		boolean isEnded = false;
		boolean ret = true;
		while(isEnded == false) {
			System.out.println("Which player would you like to move?");
			player_name = s.next();
			System.out.println("Where do you want to move your piece? (fromX: , fromY: , toX: , toY: )");
			int from_x = Integer.parseInt(s.next());
			int from_y = Integer.parseInt(s.next());
			int to_x = Integer.parseInt(s.next());
			int to_y = Integer.parseInt(s.next());
			ret = g.MakeMove(player_name, from_x, from_y, to_x, to_y);
			g.printBoard();
			isEnded = g.isEnded();
		}
		
	}

}
