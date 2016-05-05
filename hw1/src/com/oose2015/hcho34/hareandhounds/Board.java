package com.oose2015.hcho34.hareandhounds;

public class Board {
	public int grid[][]; 
	
	public Board() {
		this.grid = new int[3][5];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				this.grid[i][j] = 0;
			}
		}
		this.grid[0][1] = 1;
		this.grid[1][0] = 1;
		this.grid[2][1] = 1;
		this.grid[1][4] = 3;
		this.grid[0][0] = 9;
		this.grid[0][4] = 9;
		this.grid[2][0] = 9;
		this.grid[2][4] = 9;
	}
	
	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(this.grid[i][j] + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public boolean isMovable(int toX, int toY){
		boolean ret = false;
		if (this.grid[toY][toX] == 0) {
			ret = true;
		}
		return ret;
	}
	
	public void updateBoard(int turn, int fromX, int fromY, int toX, int toY) {
		this.grid[fromY][fromX] = 0;
		if (turn == 0) {	
			this.grid[toY][toX] = 1;
		} else {
			this.grid[toY][toX] = 3;
		}
	}
	
	public boolean wonByHound() {
		boolean ret = false;
		if (this.grid[2][2] == 3) {
			if (this.grid[2][1] == 1 && this.grid[1][2] == 1 && this.grid[2][3] == 1) {
				ret = true;
			}
		} else if (this.grid[0][2] == 3) {
			if (this.grid[0][1] == 1 && this.grid[1][2] == 1 && this.grid[0][3] == 1) {
				ret = true;
			}
		} else if (this.grid[1][4] == 3) {
			if (this.grid[0][3] == 1 && this.grid[1][3] == 1 && this.grid[2][3] == 1){
				ret = true;
			}
		}
		return ret;
	}
	
	public boolean wonByHare() {
		boolean ret = false;
		int left_hound_x = 0;
		int hare_x = 0;
		for (int j = 4; j >= 0; j--) {
			for (int i = 2; i >= 0; i--) {
				if (this.grid[i][j] == 1) {
					left_hound_x = j;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if (this.grid[i][j] == 3) {
					hare_x = j;
				}
			}
		}
		if (left_hound_x == hare_x) {
			ret = true;
		}
		return ret;
	}
	
}
