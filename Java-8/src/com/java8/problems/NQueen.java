package com.java8.problems;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

	public static void main(String[] args) {

		NQueen nQueen = new NQueen();
		nQueen.placeNQueens(4);

	}

	public void placeNQueens(int n) {
		List<List<String>> allSolutions = new ArrayList<List<String>>();
		char[][] chessBoard = new char[n][n];
		solveNQueens(allSolutions, chessBoard, 0);
		printSolutions(allSolutions);
	}

	private void solveNQueens(List<List<String>> allSolutions, char[][] chessBoard, int col) {

		if (col == chessBoard.length) {
			saveSolution(allSolutions, chessBoard);
			return;
		}

		for (int row = 0; row < chessBoard.length; row++) {
			if (isSafe(chessBoard, row, col)) {
				chessBoard[row][col] = 'Q';
				solveNQueens(allSolutions, chessBoard, col + 1);
				chessBoard[row][col] = '.';
			}
		}
	}

	private void printSolutions(List<List<String>> allSolutions) {

		System.out.println(allSolutions.toString());
	}

	private void saveSolution(List<List<String>> allSolutions, char[][] chessBoard) {
		List<String> solution = new ArrayList<String>();
		String row = "";

		for (int i = 0; i < chessBoard.length; i++) {
			row = "";
			for (int j = 0; j < chessBoard[0].length; j++) {
				if (chessBoard[i][j] == 'Q') {
					row = row + 'Q';
				} else {
					row = row + '.';
				}
			}
			solution.add(row);
		}

		allSolutions.add(solution);
	}

	private boolean isSafe(char[][] chessBoard, int row, int col) {

		// horizontal
		for (int j = 0; j < chessBoard.length; j++) {
			if (chessBoard[row][j] == 'Q')
				return false;
		}

		// vertical
		for (int j = 0; j < chessBoard.length; j++) {
			if (chessBoard[j][col] == 'Q')
				return false;
		}

		// upper left
		int r = row;
		for (int c = col; c >= 0 && r >= 0; r--, c--) {
			if (chessBoard[r][c] == 'Q')
				return false;
		}

		// upper right
		r = row;
		for (int c = col; c < chessBoard.length && r >= 0; r--, c++) {
			if (chessBoard[r][c] == 'Q')
				return false;
		}

		// lower right
		r = row;
		for (int j = col; r < chessBoard.length && j >= 0; r++, j--) {
			if (chessBoard[r][j] == 'Q')
				return false;
		}

		// lower right
		r = row;
		for (int j = col; r < chessBoard.length && j < chessBoard.length; r++, j++) {
			if (chessBoard[r][j] == 'Q')
				return false;
		}

		return true;
	}

}
