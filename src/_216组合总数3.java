import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _216组合总数3 {
    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * 这类题目，要么搜索要么动态规划，因为需要求出具体的总和内容，所以使用搜索
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combinationSum3(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if(k > n)
            return res;
        helper(res, stack, 1, n, k);
        return res;
    }
    private void helper(List<List<Integer>> res, Stack<Integer> stack, int start, int n, int k){
        if(stack.size() == k){
            if(n == 0)
                res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if(10-i+stack.size() < k)
                break;
            stack.push(i);
            helper(res, stack, i+1, n-i, k);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        _216组合总数3 solution = new _216组合总数3();
        System.out.println(solution.combinationSum3(9, 3));
    }
}
