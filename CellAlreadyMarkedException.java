package TicTacToe;

public class CellAlreadyMarkedException extends Exception {
    public CellAlreadyMarkedException(String message) {
        super(message);
    }
}
