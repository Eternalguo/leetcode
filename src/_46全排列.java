import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, stack, nums, visited, 0);
        return res;
    }

    /**
     *  回溯算法=深度优先（不撞南墙不回头）+状态重置（撞了南墙就回头）+剪枝
     * @param res
     * @param stack
     * @param nums
     * @param visited 记录当前数组中哪些已经取出，排列不能重复取数
     * @param count 统计当前的已经处理好的个数
     */
    private void helper(List<List<Integer>> res, Stack<Integer> stack, int[] nums, boolean[] visited, int count){
        if(count == nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                stack.push(nums[i]);
                helper(res, stack, nums, visited, count + 1);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        _46全排列 solution = new _46全排列();
        List<List<Integer>> res = solution.permute(arr);
        System.out.println(res);
    }
}
