import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _40组合总数2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        // 有重复时，排序方便处理重复
        Arrays.sort(candidates);
        helper(candidates, res, stack, target, 0);
        return res;
    }
    // 加入去重的思想
    private void helper(int[] candidates, List<List<Integer>> res, Stack<Integer> stack, int target, int start){
        if(target <= 0){
            if(target == 0){
                res.add(new ArrayList<>(stack));
            }
            return;
        }
        // 组合就不能再往当前的前面取，比如1,2和2,1是重复的
        //相同的两个数被当作了不同的那个数，比如1,1,7中的第一个1,7和第二个1,7是不同的，其实是相同的
        for (int i = start; i < candidates.length; i++) {
            // 减掉为负数的分支，防止将负数传递到后面的分支，剪枝的关键步骤
            if(target - candidates[i] < 0)
                // 减掉后面所有的分支
                break;
            // i > start很关键，不是i>0，i>0表示只要是重复的就丢弃，相当于只选取数组中重复元素的第一个
            // i > start则表示当前开始下标之后，如果已经选取某一个值，则不再选择这个值
            if(i > start && candidates[i] == candidates[i-1])
                // 减掉当前分支
                continue;
            stack.push(candidates[i]);
            helper(candidates,res,stack,target-candidates[i],i+1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        _40组合总数2 solution = new _40组合总数2();
        List<List<Integer>> res = solution.combinationSum2(arr, 8);
        System.out.println(res);
    }
}
