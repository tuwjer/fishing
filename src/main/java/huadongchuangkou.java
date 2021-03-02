public class huadongchuangkou {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int x =0;
        for(int i=0;i<nums.length - k+1;i++){
            if(x>i){
                if(nums[x]>nums[i+k-1]){
                    res[i] = nums[x];
                    x = i ;
                }else{
                    res[i] = nums[i+k-1];
                    x=i+k-1;
                }
            }else{
                int max = nums[i];
                for(int j=0;j<k;j++){
                    if(nums[i+j] >max){
                        max = nums[i+j];
                        x = i+j;
                    }
                }
                res[i] = max;
            }
        }
        for (int n : res){
            System.out.print(n+",");
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = new int[] {1,3,-1,-3,5,3,6,7};
        huadongchuangkou.maxSlidingWindow(n,3);
    }
}
