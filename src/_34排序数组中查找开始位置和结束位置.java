public class _34排序数组中查找开始位置和结束位置 {
    public int[] searchRange(int[] nums, int target) {
        /**
         * 寻找左边界，搜索区间为[left, right),决定了left = mid + 1, right = mid,while(left < right)
         * 在nums[mid] == target时，不是立即返回，而是缩紧右边界
         */
        int[] res = new int[2];
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                right = mid;
            else if(nums[mid] > target)
                right = mid;
            else if(nums[mid] < target)
                left = mid + 1;
        }
        if(left == nums.length)
            res[0] = -1;
        else
            res[0] = nums[left] == target ? left : -1;
        /**
         * 寻找右边界，搜索区间为[left, right)，决定了left = mid + 1, right = mid,while(left < right)
         * 在nums[mid] == target时，不是立即返回，而是缩紧左边界
         */
        left = 0;
        right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                left = mid + 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid;
        }
        if(left == 0)
            res[1] = -1;
        else
            res[1] = nums[left-1] == target ? left - 1 : -1;
        return res;
    }
}
