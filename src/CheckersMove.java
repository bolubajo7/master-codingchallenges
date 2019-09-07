public class CheckersMove {

    private char [][] checkersBoard;
    private int result = 0;
    public int solution(String[] B) {
        // write your code in Java SE 8

         checkersBoard = new char[B.length][B.length];
            for(int row = 0; row < B.length; row++) {
                char [] lines = B[row].toCharArray();
                for (int col = 0; col < B.length; col++) {

                    checkersBoard[row][col] = lines[col] ;
                }

            }
        result = solve(checkersBoard, B);

        return result;
    }

    private int solve(char[][] checkersBoard, String [] B) {

        for (int a = 2; a < B.length; a++) {
            for (int b = 0; b < B.length; b++)
                if (checkersBoard[a][b] == 'O') {

                    int tempRowIndex = a - 2;
                    int tempColIndex=0;
                    int prevRowIndex = a - 1;
                    int prevRowColIndex = 0;

                    if(b < B.length - 2) {
                         tempColIndex = b + 2;
                         prevRowColIndex = b + 1;

                    } else if (b >= 2){
                        tempColIndex = b - 2;
                        prevRowColIndex = b - 1;
                    }

                    if (checkersBoard[tempRowIndex][tempColIndex] == '.' && checkersBoard[prevRowIndex][prevRowColIndex] == 'X') {
                        result++;
                        checkersBoard[a][b] = '.';
                        checkersBoard[tempRowIndex][tempColIndex] = 'O';
                        solve(checkersBoard, B);
                    }
                }
        }
        return result;
    }

}
