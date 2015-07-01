import java.util.Scanner;
import java.lang.Math;

public class Board {
	private Cell[][] grid = new Cell[8][8];
	Scanner scanXY = new Scanner(System.in);

	Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid[i][j] = new Cell();
			}

		}
		placeAllMines();

	}

	private void displayBoard(int x, int y) {
		int num = 0;

		num = minesAround(x, y);

		if (num >= 0)
			grid[x][y].setVal((char) (num + 48));
		else {
			clearBoard(x, y);
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(grid[i][j].getVal());
			}
			System.out.println("");
		}
	}

	private void clearBoard(int x, int y) {
		for (int i = lowerBound(x); i <= upperBound(x); i++) {
			for (int j = lowerBound(y); j <= upperBound(y); j++) {
				if (minesAround(i, j) == 0)
					grid[i][j].setVal('0');
			}
		}
	}

	private void placeAllMines() {
		for (int i = 0; i < 8; i++) {
			placeMine();
		}
	}

	private int minesAround(int x, int y) {
		int num = 0;
		for (int i = lowerBound(x); i < upperBound(x); i++) {
			for (int j = lowerBound(y); j < upperBound(y); j++) {
				if (grid[i][j].isMine())
					num = num + 1;
			}
		}
		return num;
	}

	private void placeMine() {
		int x = (int) (Math.random() * 7);
		int y = (int) (Math.random() * 7);

		if (grid[x][y].isMine() == false) {
			grid[x][y].setMine(true);
		} else {
			placeMine();
		}

	}

	public void checkMines() {
		int x, y;
		x = getInput();
		y = getInput();

		if (grid[x][y].isMine() == true) {
			System.out.println("Game Over!");
		} else {
			int xcount = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (grid[i][j].getVal() != '*')
						xcount = xcount + 1;
				}
			}

			if (xcount == 54)
				System.out.println("You Win!");
			else {
				displayBoard(x, y);
				checkMines();
			}
		}

	}

	private int getInput() {
		System.out.println("Enter x");
		int x = Integer.parseInt(scanXY.next());
		if (x >= 0 && x < 8)
			return x;
		else
			return getInput();

	}

	private int lowerBound(int a) {
		if (a <= 0)
			return 0;
		else
			return a - 1;
	}

	private int upperBound(int b) {
		if (b >= 7)
			return 7;
		else
			return b + 1;
	}

}
