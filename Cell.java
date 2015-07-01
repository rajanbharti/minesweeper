public class Cell {
	private boolean mine;
	private char adjacentMines;

	public Cell() {
		super();
		this.mine = false;
		this.adjacentMines = '*';
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public char getVal() {
		return adjacentMines;
	}

	public void setVal(char val) {
		this.adjacentMines = val;
	}

	public boolean isMine() {
		return mine;
	}

}
