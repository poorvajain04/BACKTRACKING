import java.util.*;
public class MazeWithObstacle {
    public static void main(String[] args) {
        boolean[][] board={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        System.out.println(obstructedPath("",board,0,0));

    }
    public static List<String> obstructedPath(String p, boolean[][]maze,int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        if(maze[r][c]==false) return new ArrayList<>();
        List<String> list=new ArrayList<>();
        if(r<maze.length-1) list.addAll(obstructedPath(p+'D',maze,r+1,c));
        if(c<maze[0].length-1) list.addAll(obstructedPath(p+'R',maze,r,c+1));
        return list;
    }
}
