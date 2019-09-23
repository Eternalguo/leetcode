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
        for (int i = start; i < nums.length; i++) {
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
