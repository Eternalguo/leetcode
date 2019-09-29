public class _704二分查找 {
    /**
     *初始化为right = length -1，找到一个索引立即返回
     * 搜索区间为[left, right],所以使用while(left <= right)，left = mid + 1和right = mid - 1
     * 因为mid已经判断过
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] ==target)
                return mid;
            else if(nums[mid] > target)
                high = mid  - 1;
            else if(nums[mid] < target)
                low = mid + 1;
        }
        return -1;
    }
}
