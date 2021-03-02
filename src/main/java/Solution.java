import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        if (n == 0) {
            return list;
        }
        fds(list,n,n,"");
        return list;
    }

    public static void fds(List<String> list, int left, int right, String path){
        if(left == 0 && right==0){
            list.add(path);
        }
        if(left > 0){
            fds(list,left -1,right,path+"(");
        }
        if(right>0 && left<right){
            fds(list,left ,right-1,path+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(3));
    }
}
