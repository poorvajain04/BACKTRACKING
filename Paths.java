import java.util.*;
public class Paths {
    public static void main(String[] args) {
        path("",3,3);
        System.out.println(paths("",3,3));
    }
    public static void path(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1) path(p+'D',r-1,c);
        if(c>1) path(p+'R',r,c-1);
    }
    public static List<String> paths(String p, int r, int c){
        if(r==1 && c==1){
            List<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<>();
        if(r>1) list.addAll(paths(p+'D',r-1,c));
        if(c>1) list.addAll(paths(p+'R',r,c-1));
        return list;
    }
}
