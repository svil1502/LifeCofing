import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {6,7,3,2,1};
        //System.out.println(Arrays.toString(rotate(nums, 3)));
        int k = 2;
        reverse(nums, k);
        System.out.println(Arrays.toString(nums));
    }
    public static void reverse(int[] nums, int k){
        k = k % nums.length;
        rotate(nums, 0,nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    };
    public static int[] rotate(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;

    }
}
