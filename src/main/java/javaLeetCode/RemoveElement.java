package javaLeetCode;

/**
 * “Go Further进无止境” <br>
 * 〈给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。  不要使用额外的数组空间，你必须仅使用 O(1)
 * 额外空间并 原地 修改输入数组。  元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。〉
 *
 * @author Luoxun
 * @create 2020/3/31
 * @since 1.0.0
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arrays = new int[]{3,1, 1,3};
        System.out.println(removeElement(arrays,3));
    }
    public static int removeElement(int[] nums, int val) {
        if (null == nums || nums.length < 1){
            return 0;
        }
        if (nums.length == 1 && nums[0]!= val){
            return 1;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
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
