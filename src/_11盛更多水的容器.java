public class _11盛更多水的容器 {
    // 每次移动两个高度较低的那个
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left <= right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right])
                ++ left;
            else
                -- right;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
