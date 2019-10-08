import java.util.Arrays;

public class _377组合总数4 {
    /**
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     * 因为题目不要求求出组合内容，只需要组合数量，则使用动态规划来求解
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[target+1];
        // dp[0] = 1表示如果那个值刚好是要凑的值，则刚好有一种组合方式
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        _377组合总数4 solution = new _377组合总数4();
        System.out.println(solution.combinationSum4(arr, 4));
    }
}
