public class sort {

    public static int[] sort(int[] num){
        if(num.length <= 1){
            return num;
        }
        quickSort(num,0,num.length-1);
        return num;
    }


    public static void quickSort(int[] num,int l,int r){
        if(l<r){
            int[] p = partition(num,l,r);
            quickSort(num,l,p[0]-1);
            quickSort(num,p[1]+1,r);
        }
    }

    public static int[] partition(int[] num,int l,int r){
        int more = r;
        int less = l-1;
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
        nums = sort.sort(nums);
        for (int i : nums) {
            System.out.print(i+",");
        }
//        System.out.println(QuickSortSolution.uniquePaths(7,3));

    }
}
