package Lab6.student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		if (this.row == Node.N-1) {
			this.row = 0;
		} else {
			this.row++;
		}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		if (Math.abs(this.row - q.row) == Math.abs(this.column - q.column)) return true;
		if (this.row == q.row) return true;
		if (this.column == q.column) return true;
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
