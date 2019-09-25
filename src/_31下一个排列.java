public class _31下一个排列 {
    /**思想就是，找到最短后缀序列的最小字典序，比如：1，5，8，4，7，6，5，3，1
     * 先从后向前找到第一个i，使得nums[i]<nums[i+1],即找到需要反转的最小后缀数组，
     * 再从后向前找到第一个比nums[i]大的数nums[j]，交换nums[i]和nums[j]，即找到nums[i]的下一个排列字符
     * 反转i+1到nums.length-1的数组使之成为升序，即为字典序最小
     * @param nums
     */
    public void nextPermutation(int[] nums){
        int i = nums.length - 2;
        for (; i > -1; i--) {
            if(nums[i] < nums[i+1])
                break;
        }
        if(i == -1){
            reverse(nums, 0, nums.length - 1);
        }else {
            int j = nums.length - 1;
            for (; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            reverse(nums, i + 1, nums.length - 1);
        }
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,8,4,7,6,5,3,1};
        new _31下一个排列().nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
