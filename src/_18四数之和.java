import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _18四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            //多个负数会越加越小,只需去重
            //if(nums[i] > target)
            //    break;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                int start = j + 1, end = nums.length - 1;
                while(start < end){
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum > target)
                        while(start < end && nums[end] == nums[--end]);
                    else if(sum < target)
                        while(start < end && nums[start] == nums[++start]);
                    else{
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
                        while(start < end && nums[start] == nums[++start]);
                        while(start < end && nums[end] == nums[--end]);
                    }
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> kSum(int[] nums, int target, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        kSumCore(nums, list, target, 0, k, stack);
        return list;
    }
    private static void kSumCore(int[] nums, List<List<Integer>> res, int target, int start, int k, Stack<Integer> stack){
        if(k <= 0){
            if(k == 0 && target == 0)
                res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            stack.push(nums[i]);
            while(i < nums.length && nums[i] == nums[++i]);
            kSumCore(nums, res, target - nums[i], i, k-1, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3,-2,-1,0,0,1,2,3};
//        List<List<Integer>> res = fourSum(arr, -11);
        List<List<Integer>> res = kSum(arr, 0, 4);
        System.out.println(res);
    }
}
