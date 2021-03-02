package dp;

import java.util.ArrayList;
import java.util.List;

/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标
相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，
那么下一步可以移动到下一行的下标 i 或 i + 1 。

 

示例 1：

输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
*
* */
public class 三角形最小路径和 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i =0;i<triangle.get(n-1).size();i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> triangle1 = new ArrayList<>();
        List<Integer> triangle2 = new ArrayList<>();
        List<Integer> triangle3 = new ArrayList<>();
        List<Integer> triangle4 = new ArrayList<>();
        triangle1.add(2);
        triangle2.add(3);
        triangle2.add(4);
        triangle3.add(6);
        triangle3.add(5);
        triangle3.add(7);
        triangle4.add(4);
        triangle4.add(1);
        triangle4.add(8);
        triangle4.add(3);
        triangle.add(triangle1);
        triangle.add(triangle2);
        triangle.add(triangle3);
        triangle.add(triangle4);
        System.out.println(三角形最小路径和.minimumTotal(triangle));
    }
}
