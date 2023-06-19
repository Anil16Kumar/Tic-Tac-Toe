package TicTacToe;

import java.util.Scanner;

public class TicTacToeMain {

	private Board board;

    public TicTacToeMain() {
        board = new Board();
    }

    public void playGame() {
        int currentPlayer = 1;
        Scanner scanner = new Scanner(System.in);
        
        String player1,player2;
        System.out.println("enter name of player 1:");
        player1=scanner.next();
        System.out.println("enter name of player 2:");
        player2=scanner.next();
        System.out.println();
        board.displayBoard();//<--
        while (!board.isBoardFull()) {
        	if(currentPlayer==1)
             System.out.print(  player1 + "(X) Turn, enter cell number (1-9): ");
        	else if(currentPlayer==2)
                System.out.print(  player2 + "(O) Turn, enter cell number (1-9): ");
               
        	int cellNumber; 
            while(true)
            {
            	cellNumber = scanner.nextInt();
            	if(cellNumber<1 || cellNumber>9)
            		System.out.println("enter number in between 1 to 9");
            	else
            		break;
            }
            cellNumber=cellNumber-1;
            try {
                board.setCellMark(cellNumber, currentPlayer == 1 ? MarkType.X : MarkType.O);
            } catch (CellAlreadyMarkedException e) {
                System.out.println("bhai wo wali Cell already marked hai, phirse Try Karo...");
                System.out.println();
                continue;
            }

            board.displayBoard();

            if (board.hasWon(currentPlayer == 1 ? MarkType.X : MarkType.O)) {
            	if(currentPlayer==1)
            		System.out.println(player1+" wins");
            	else
            		System.out.println(player2+" wins");
                //System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            currentPlayer = currentPlayer == 1 ? 2 : 1;
        }

        if (board.isBoardFull() && !board.hasWon(MarkType.X) && !board.hasWon(MarkType.O)) {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToeMain game = new TicTacToeMain();
        game.playGame();
    }

}
