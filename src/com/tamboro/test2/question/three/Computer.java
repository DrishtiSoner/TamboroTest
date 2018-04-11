package com.tamboro.test2.question.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.tamboro.test2.question.two.TicTacToe;

/**
 *
 * @author drishti
 */
public class Computer {
	private static int maxOfMove = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of grid  matrix (N*N):");
		int gridSize = scanner.nextInt();
		while (gridSize < 3) {
			System.out.println("select valid grid");
			gridSize = scanner.nextInt();
		}
		System.out.println("Enter the name of the player");
		scanner = new Scanner(System.in);
		String playerName = scanner.nextLine();

		TicTacToe game = new TicTacToe(gridSize);
		game.createMatrix();
		int i = 0;

		int row = -1;
		int col = -1;
		boolean isContinue = false;
		do {
			game.showMatrix();
			System.out.println(
					"Player " + playerName + ",its your turn enter your move (like :- (1,1) , your code is " + i);

			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			String inputArray[] = input.split(",");

			try {
				row = Integer.parseInt(inputArray[0]);
				col = Integer.parseInt(inputArray[1]);

				char player = game.move(row, col, (char) (i + '0'));

				if (player == 'x') {

					do {
						isContinue = true;
						List<Integer> move = Computer.move();
						player = game.move(move.get(0), move.get(1), (char) (1 + '0'));
						if (player == 'i') {

							isContinue = false;
						}

					} while (!isContinue);

					if (player == 'x') {
						isContinue = true;
					} else if (player == 'y') {
						game.showMatrix();
						System.out.println("Game has drawn");
						System.exit(0);
					} else if (player == 'i') {
						System.out.println("invaid move.. ");
						System.out.println("please enter valid move");

						isContinue = true;
					} else {
						System.out.println("Current board layout:");
						game.showMatrix();
						System.out.println(playerName + " has Won !");
						System.exit(0);
					}

				} else if (player == 'y') {
					game.showMatrix();
					System.out.println("Game has drawn");
					System.exit(0);
				} else if (player == 'i') {
					System.out.println("invaid move.. ");
					System.out.println("please enter valid move");
					isContinue = true;
				} else {
					System.out.println("Current board layout:");
					game.showMatrix();
					System.out.println(playerName + " has Won !");
					System.exit(0);
				}

			} catch (Exception e) {
				isContinue = false;
				i--;
				System.out.println("error" + e.getMessage());
			}

		} while (isContinue);

	}

	private static List<Integer> move() {
		List<Integer> computerMoves = new ArrayList<>();
		computerMoves.add(firstMove());
		computerMoves.add(secondMove());
		return computerMoves;
	}

	private static int firstMove() {
		Random r = new Random();
		return r.nextInt(maxOfMove + 1);
	}

	private static int secondMove() {
		Random r = new Random();
		return r.nextInt(maxOfMove + 1);
	}
}
