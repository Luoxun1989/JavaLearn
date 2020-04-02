package javaLeetCode;

/**
 * “Go Further进无止境” <br>
 * 〈删除排序数组中的重复项〉
 *
 * @author Luoxun
 * @create 2020/3/30
 * @since 1.0.0
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arrays = new int[]{1, 1,2, 3,3,4,4, 5,6};
        System.out.println(removeDuplicates(arrays));
    }
    public static int removeDuplicates(int[] nums) {
        if (null == nums || nums.length < 1){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int j = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
            }else{
                nums[j] = nums[i];
                j += 1;
            }
        }
        nums[j] = nums[nums.length-1];
        j += 1;
        for (int i = 0; i < j; i++){
            System.out.println(nums[i]);
        }
        return j;
    }
}
