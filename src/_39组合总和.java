import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _39组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        kSumCore(candidates, list, target, 0, stack);
        return list;
    }
    private static void kSumCore(int[] nums, List<List<Integer>> res, int target, int start, Stack<Integer> stack){
        if(target <= 0){
            if(target == 0)
                res.add(new ArrayList<>(stack));
            return;
        }
        // 组合就不能再往当前的前面取，比如1,2和2,1是重复的
        // 按顺序选取无需判断是否已经取过
        for (int i = start; i < nums.length; i++) {
            // 因为nums是经过排序的，为了避免将负数传递到下一个分支，这里进行剪枝，减掉后面无用的分支搜索
            // 剪枝的关键步骤
            if(target - nums[i] < 0)
                break;
            stack.push(nums[i]);
            kSumCore(nums, res, target - nums[i], i, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        _39组合总和 solution = new _39组合总和();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
