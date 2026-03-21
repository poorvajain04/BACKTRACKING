import java.util.*;
public class AllPathWithMatrix {
    public static void main(String[] args) {
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path=new int[maze.length][maze[0].length];
        paths("",maze,0,0,path,1);
    }
    public static void paths(String p, boolean[][] maze, int r, int c, int[][]path,int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]) return;
        maze[r][c]=false;
        path[r][c]=step;
        if(r<maze.length-1) paths(p+'D',maze,r+1,c,path,step+1);
        if(c<maze[0].length-1) paths(p+'R',maze,r,c+1,path,step+1);
        if(r>0) paths(p+'U',maze,r-1,c,path,step+1);
        if(c>0) paths(p+'L',maze,r,c-1,path,step+1);
        maze[r][c]=true;
        path[r][c]=0;
    }
}
