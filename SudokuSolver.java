public class SudokuSolver {
    public static void main(String[] args) {
        int[][]board=new int[][]{
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };
        if(solve(board)){
            display(board);
        }
        else{
            System.out.println("Cannot solve");
        }
    }
    public static boolean solve(int[][] board){
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean empty=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    empty=false;
                    break;
                }
            }
            if(!empty) break;
        }
        if(empty) return true;
        for(int number=1;number<=9;number++){
            if(isSafe(board,row,col,number)){
                board[row][col]=number;
                if(solve(board)) return true;
                board[row][col]=0; // backtrack
            }
        }
        return false;
    }
    private static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("---------------------");
            for (int j = 0; j < board[0].length; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int[][] board, int row, int col, int num){
        for (int i=0;i<board.length;i++){
            if(board[row][i]==num) return false;
        }
        for (int[] nums: board){
            if(nums[col]==num) return false;
        }
        int sqrt=(int)Math.sqrt(board.length);
        int start=row-row%sqrt;
        int end=col-col%sqrt;
        for(int r=start;r<start+sqrt;r++){
            for (int c=end;c<end+sqrt;c++){
                if(board[r][c]==num) return false;
            }
        }
        return true;
    }
}
