import java.util.*;
public class PathDiagonal {
    public static void main(String[] args) {
        System.out.println(pathWithDiagonal("",3,3));
    }
    public static List<String> pathWithDiagonal(String p, int r, int c){
        if(r==1 && c==1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<>();
        if(r>1) list.addAll(pathWithDiagonal(p+"V",r-1,c));
        if(c>1) list.addAll(pathWithDiagonal(p+"H",r,c-1));
        if(r>1 && c>1) list.addAll(pathWithDiagonal(p+"D",r-1,c-1));
        return list;
    }
}
