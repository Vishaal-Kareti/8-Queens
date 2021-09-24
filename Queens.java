//import java.util.*;

public class Queens {

    public static void placeQueen(int[] board, int row) {
        System.out.println("[" + row + ", " + board[row] + "]");

        //if board default, start with 1 queen at [0, 0]
        if (board[row] == board.length + 1) {
            board[row] = 0;
        }

        //shows board state
        //generateDisplay(board);

        if (row < board.length) {
            //check col
            for (int i = row - 1; i >= 0; i--) {
                if (board[row] == board[i] + 1 * (row - i) || board[row] == board[i] || board[row] == board[i] - 1 * (row - i)) {
                    board[row] = board[row] + 1;
                    if (board[row] == board.length) {
                        board[row - 1] += 1;
                        placeQueen(board, row - 1);
                        return;
                    }
                    //System.out.println(row + ",," + board[row] + ",," + board.length + ",," + (board[row] == board.length));
                    placeQueen(board, row);
                    return;
                }
            }
        }

        //if row exceeds board, done
        if (row + 1 == board.length) {
            System.out.println("OWO DONE or failed..."); 
            generateDisplay(board);
            return;
        }

        //go to next row once all previous rows are placed correctly
        placeQueen(board, row + 1);
        return;
        
    }

    public static void generateDisplay(int[] board) {
        String display = "";

        for (int i = 0; i < board.length; i++) {
            display += "|";
            if (board[i] < board.length) {
                for (int k = 0; k < board[i]; k++) {
                    display += "\t|";
                }
                display += "   O\t|";
                for (int k = 0; k < board.length - board[i] - 1; k++) {
                    display += "\t|";
                }
            } else {
                for (int k = 0; k < board.length; k++) {
                    display += "\t|";
                }
            }
            display += "\n\n";
        }

        System.out.println(display);
    }

    public static void main(String[] args) {
        
        //the board is formatted as board[row] = column
        int[] board = new int[8];
        
        // final int length = 5

        // if (args != null && args.length == length) {
        //     for (int i = 0; i < board.length; i++) {
        //         board[i] = Integer.parseInt(args[i]);
        //     }
        // } else {
        //     for (int i = 0; i < board.length; i++) {
        //         board[i] = board.length + 1;
        //     }
        // }

        for (int i = 0; i < board.length; i++) {
            board[i] = board.length + 1;
        }

        //System.out.println(Arrays.toString(board));
        
        //board[0] = 0;
        //generateDisplay(board);

        //System.out.println(board[0]);

        placeQueen(board, 0);

    }
}