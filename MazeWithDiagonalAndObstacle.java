import java.util.*;
public class MazeWithDiagonalAndObstacle {
    public static void main(String[] args) {
        boolean[][]board={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        System.out.println(obstructedPath("",board,0,0));

    }
    public static List<String> obstructedPath(String p, boolean[][]maze, int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String>list=new ArrayList<>();
        if(!maze[r][c]) return new ArrayList<>();
        if(r<maze.length-1) list.addAll(obstructedPath(p+'V',maze,r+1,c));
        if(c<maze[0].length-1) list.addAll(obstructedPath(p+'H',maze,r,c+1));
        if(r<maze.length-1 && c<maze[0].length-1) list.addAll(obstructedPath(p+'D',maze,r+1,c+1));
        return list;
    }
}
