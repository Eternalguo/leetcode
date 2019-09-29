import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _47全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(res, stack, nums, 0, visited);
        return res;
    }

    /**
     * 数组去重可直接使用哈希表，当数组中有重复元素时，排序后可很方便的发现重复，当发现重复时跳过这个分支（剪枝）
     * @param res
     * @param stack
     * @param nums
     * @param count
     * @param visited
     */
    private void helper(List<List<Integer>> res, Stack<Integer> stack, int[] nums, int count, boolean[] visited){
        if(count == nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                //重复元素一定是从第一号位置开始的
                if(i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
                    // 减掉当前分支
                    continue;
                }
                visited[i] = true;
                stack.push(nums[i]);
                helper(res, stack, nums, count+1, visited);
                stack.pop();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        _47全排列2 solution = new _47全排列2();
        System.out.println(solution.permuteUnique(arr));
    }
}
