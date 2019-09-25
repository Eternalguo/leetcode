public class _33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;//防止溢出
            if(nums[mid] == target)
                return mid;
            // mid前为升序，target比mid的值大或者比0的值小都在后面
            else if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
                left = mid + 1;
            // mid前发生旋转，target在0和mid值之间时才在后面查找
            else if(nums[0] > nums[mid] && target > nums[mid] && target < nums[0])
                left = mid + 1;
            else
                right = mid;
        }
        return (left == right && nums[left] == target)? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3};
        System.out.println(new _33搜索旋转排序数组().search(arr, 2));
    }
}
