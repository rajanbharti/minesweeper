public class MineSweeper {
	public static void main(String[] args) {
		Game g = new Game();
		g.start();
	}

}

class Game {

	Board b = new Board();

	public void start() {
		b.checkMines();

	}
}
