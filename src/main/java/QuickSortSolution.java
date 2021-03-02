import java.util.Random;

public class QuickSortSolution {

    public static int[] sort(int[] nums){
        if (nums.length <= 1){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public static void quickSort(int[] num,int l,int r){
        if(l<r){
            swap(num,l+((int)(Math.random()*(r-l+1))),r);
            int[] p = partition(num,l,r);
            quickSort(num,l,p[0]-1);
            quickSort(num,p[1]+1,r);
        }
    }

    public static int[] partition(int[] num,int l,int r){
        int less = l-1;
        int more = r ;
        int cur = l;
        while (cur<more){
            if(num[cur]<num[r]){
                swap(num,++less,cur++);
            }else if(num[cur]>num[r]){
                swap(num,--more,cur);
            }else {
                cur++;
            }
        }
        swap(num,more,r);
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,42,56,34,62,66,78,3,7,9,2,1,0,8,9,2,88,45,65,3};
        QuickSortSolution.sort(nums);
        for (int i : nums) {
            System.out.print(i+",");
        }

//        System.out.println(QuickSortSolution.uniquePaths(7,3));

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for(int i = 1;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i<n;i++){
            dp[0][i] = 1;
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
