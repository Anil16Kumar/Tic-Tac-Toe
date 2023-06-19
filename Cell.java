package TicTacToe;

public class Cell {
	private MarkType mark;

    public Cell() {
        mark = MarkType.EMT;
    }

    public boolean isEmpty() {
        return mark == MarkType.EMT;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) throws CellAlreadyMarkedException {
        if (isEmpty()) {
            this.mark = mark;
        } else {
            throw new CellAlreadyMarkedException("Cell already marked!");
        }
    }

    public String toString() {
        return mark.toString();
    }
}
