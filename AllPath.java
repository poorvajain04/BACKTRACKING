import java.util.*;
public class AllPath {
    public static void main(String[] args) {
        boolean [][] board={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        System.out.println(paths("",board,0,0));

    }
    public static List<String> paths(String p, boolean [][]maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<>();
        if(!maze[r][c]) return new ArrayList<>();
        maze[r][c] = false;
        if(r<maze.length-1) list.addAll(paths(p+'D',maze,r+1,c));
        if(c<maze[0].length-1) list.addAll(paths(p+'R',maze,r,c+1));
        if(r>0) list.addAll(paths(p+'U',maze,r-1,c));
        if(c>0) list.addAll(paths(p+'L',maze,r,c-1));
        maze[r][c]=true;
        return list;
    }
}
