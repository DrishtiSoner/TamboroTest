package com.tamboro.test2.question.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author drishti
 */
public class TicTacMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of grid  matrix (N*N):");
		int gridSize = scanner.nextInt();
		while (gridSize < 3) {
			System.out.println("select valid grid");
			gridSize = scanner.nextInt();
		}
		System.out.println("Enter the number of players");
		int playerSize = scanner.nextInt();
		while (playerSize < 2 || playerSize > gridSize) {
			if (playerSize < 2) {
				System.out.println("Select two or more player to  play ");
			} else {
				System.out.println("Too many players please select less number of players");
			}
			playerSize = scanner.nextInt();
		}
		System.out.println("Enter player names");
		List<String> playersNames = new ArrayList<>();
		for (int i = 0; i < playerSize; i++) {
			scanner = new Scanner(System.in);
			String playersName = scanner.nextLine();
			playersNames.add(playersName);
		}

		TicTacToe game = new TicTacToe(gridSize);
		game.createMatrix();
		int i = -1;

		int row = -1;
		int col = -1;
		boolean isMove = false;
		do {
			game.showMatrix();
			i++;
			if (i == playerSize) {
				i = 0;
			}
			System.out.println("Player " + playersNames.get(i)
					+ ",its your turn enter your move (like :- (1,1) , your code is " + i);

			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			String[] inputArray = input.split(",");

			try {
				row = Integer.parseInt(inputArray[0]);
				col = Integer.parseInt(inputArray[1]);

				char player = game.move(row, col, (char) (i + '0'));

				if (player == 'x') {
					isMove = true;
				} else if (player == 'y') {
					game.showMatrix();
					System.out.println("Game has drawn");
					System.exit(0);
				} else if (player == 'i') {
					System.out.println("invaid move.. ");
					System.out.println("please enter valid move");
					i--;
					isMove = true;
				} else {
					System.out.println("Current board layout:");
					game.showMatrix();
					System.out.println(playersNames.get(i) + " has Won !");
					System.exit(0);
				}

			} catch (Exception e) {
				isMove = false;
				i--;
				System.out.println("error" + e.getMessage());
			}

		} while (isMove);

	}

}