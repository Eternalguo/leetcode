import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _77组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        helper(res, stack, n, k, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, Stack<Integer> stack, int n, int k, int start){
        if(stack.size() == k){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            // n-i+1 < k - stack.size()即剩下的元素已经不够装满符合条件的容器则剪枝
            if(n - i + 1 + stack.size() < k)
                break;
            stack.push(i);
            helper(res, stack, n, k, i+1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        _77组合 solution = new _77组合();
        System.out.println(solution.combine(4, 2));
    }
}
