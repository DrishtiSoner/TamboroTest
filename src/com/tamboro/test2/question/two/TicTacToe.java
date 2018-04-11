package com.tamboro.test2.question.two;

/**
 *
 * @author drishti
 */
public class TicTacToe {
	private char[][] matrix;
	private int gridX;
	private int gridY;

	public TicTacToe(int girdSize) {
		this.gridX = girdSize;
		this.gridY = girdSize;
		matrix = new char[gridX][gridY];
		createMatrix();
	}

	// Set/Reset the matrix back to all empty values.
	public void createMatrix() {

		// Loop through rows
		for (int i = 0; i < gridX; i++) {

			// Loop through columns
			for (int j = 0; j < gridY; j++) {
				matrix[i][j] = '-';
			}
		}
	}

	// Print the current matrix
	public void showMatrix() {

		for (int i = 0; i < gridX; i++) {
			System.out.print("| ");
			for (int j = 0; j < gridY; j++) {
				System.out.print(matrix[i][j] + " | ");
			}
			System.out.println();
		}
	}

	// Loop through all cells of the matrix and if one is found to be empty
	// (contains char '-') then return false.
	// Otherwise the matrix is full.
	public boolean checkMatrixFull() {
		boolean isFull = true;

		for (int i = 0; i < gridX; i++) {
			for (int j = 0; j < gridY; j++) {
				if (matrix[i][j] == '-') {
					isFull = false;
				}
			}
		}
		return isFull;
	}

	// method for checking game status after every move.
	public char move(int row, int col, char player) {
		if ((row >= 0) && (row < gridX)) {
			if ((col >= 0) && (col < gridY)) {
				if (matrix[row][col] == '-') {
					matrix[row][col] = player;
				} else {
					return 'i';
				}
			} else {
				return 'i';
			}
		} else {
			return 'i';
		}
		// check row
		boolean win = true;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[row][i] != player) {
				win = false;
				break;
			}
		}

		if (win)
			return player;

		// check column
		win = true;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][col] != player) {
				win = false;
				break;
			}
		}

		if (win)
			return player;

		// check back diagonal
		win = true;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][i] != player) {
				win = false;
				break;
			}
		}

		if (win)
			return player;

		// check forward diagonal
		win = true;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][matrix.length - i - 1] != player) {
				win = false;
				break;
			}
		}

		if (win)
			return player;

		boolean isfull = checkMatrixFull();
		if (isfull)
			return 'y';
		else
			return 'x';
	}

}
