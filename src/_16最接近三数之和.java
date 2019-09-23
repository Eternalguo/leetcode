import java.util.Arrays;

public class _16最接近三数之和 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k+1,j=nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(Math.abs(target-ans) > Math.abs(target-sum))
                    ans = sum;
                if(sum == target)
                    return sum;
                else if(sum > target)
                    j --;
                else
                    i ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,2, 1,-4};
        System.out.println(threeSumClosest(arr, 1));
    }
}
