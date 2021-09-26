import java.util.Scanner;

public class QueensNoRec {
    
    public static void main(String[] args) {
        
        int boardLength = 8;
        boolean tooMany = false;

        Scanner input = new Scanner(System.in);

        System.out.println("How many cases from the default do you want? (1 or more)"); 
        int loops = input.nextInt();
        input.close();

        if (loops > 92 && boardLength == 8) {
            loops = 92;
            tooMany = true;
        }

        Board b = new Board(boardLength); 
        
        int startRow = 0;
        
        while (startRow != -1) {
            startRow = b.placeQueen(startRow);
        }
        
        Board b2 = new Board(b.getBoard());

        for (int i = 0; i < loops - 1; i++) {
            startRow = 0;

            while (startRow != -1) {
                startRow = b2.placeQueen(startRow);
            }
        }
        if (tooMany) {
            System.out.println("There are only 92 boards!");
        }
    }
}
