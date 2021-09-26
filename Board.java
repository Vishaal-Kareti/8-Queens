public class Board {

    private int[] board = new int[8];
    private boolean isDefault;
    private boolean firstRun;
    private static int boardNumber = 0;

    Board(int length) {
        this.board = new int[length];
        for (int i = 0; i < board.length; i++) {
            board[i] = board.length + 1;
        }
        isDefault = true;
        firstRun = false;
    }
    Board(int[] board) {
        this.board = board;
        isDefault = false;
        firstRun = true;
    }

    public int[] getBoard() {
        return board;
    }

    public int placeQueen(int row) {
        // System.out.println("[" + row + ", " + board[row] + "]");

        if (!isDefault && firstRun) {
            int startRow = 0;
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j] != board.length - 1) {
                    startRow = j;
                    firstRun = false;
                    break;
                }
            }
            //System.out.println(setback);
            board[startRow] += 1;
            //reset future rows
            for (int j = startRow + 1; j < board.length; j++) {
                board[j] = board.length + 1;
            }
            return startRow;
        }

        //if board row default, start with the queen at the 0th column for each row
        if (board[row] == board.length + 1) {
            board[row] = 0;
        }


        //shows board state
        // generateDisplay();

        if (row < board.length) {
            //check col
            for (int i = row - 1; i >= 0; i--) {
                if (board[row] == board[i] + 1 * (row - i) || board[row] == board[i] || board[row] == board[i] - 1 * (row - i)) {
                    board[row] = board[row] + 1;

                    //check how many rows back u need to go
                    if (board[row] == board.length) {

                        //check how many rows back u can go
                        int minRow = 0;
                        for (int j = 0; j < board.length; j++) {
                            if (board[j] != board.length) {
                                minRow = j;
                                break;
                            }
                        }

                        int setback = 1;
                        for (int j = row - 1; j >= minRow; j--) {
                            if (board[j] != board.length - 1) {
                                setback = row - j;
                                break;
                            }
                        }
                        // System.out.println(minRow + " " + setback);
                        board[row - setback] += 1;
                        
                        //reset future rows
                        for (int j = row - setback + 1; j < board.length; j++) {
                            board[j] = board.length + 1;
                        }
                        return row - setback;
                    }
                    return row;
                }
            }
        }

        //if row exceeds board, done
        if (row + 1 == board.length) {
            boardNumber += 1;
            System.out.println("_______________________________________________________________________________________________________________"); 
            System.out.println("Board Number: " + boardNumber); 
            this.generateDisplay();
            if (!isDefault) {
                firstRun = true;
            }
            return -1;
        }

        //go to next row once all previous rows are placed correctly
        return row + 1;
    }

    public void generateDisplay() {
        String display = "";

        for (int i = 0; i < this.board.length; i++) {
            display += "|";
            if (this.board[i] < this.board.length) {
                for (int k = 0; k < this.board[i]; k++) {
                    display += "\t|";
                }
                display += "   Q\t|";
                for (int k = 0; k < this.board.length - this.board[i] - 1; k++) {
                    display += "\t|";
                }
            } else {
                for (int k = 0; k < this.board.length; k++) {
                    display += "\t|";
                }
            }
            display += "\n\n\n";
        }

        System.out.println(display);
    }

}
