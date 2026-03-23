public class NQueens {
    public static void main(String[] args) {
        int n=5;
        boolean[][]board = new boolean[n][n];
        queens(board,0);
        int count =queens(board,0);
        System.out.println(count);
    }
    public static int queens(boolean[][] board, int row){
        if(row==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                count+=queens(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }
    public static boolean isSafe(boolean[][]board, int row,int col){
        for(int i=0;i<row;i++) {
            if (board[i][col]) return false;
        }
        int Left=Math.min(row,col);
        for(int i=1;i<=Left;i++){
            if(board[row-i][col-i]) return false;
        }
        int Right=Math.min(row,board.length-col-1);
        for(int i=1;i<=Right;i++){
            if(board[row-i][col+i]) return false;
        }
        return true;
    }
    public static void display(boolean[][] board){
        for(boolean[] row:board){
            for(boolean element:row){
                if(element) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
