package javaLeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * “Go Further进无止境” <br>
 * 〈两数之和〉
 *
 * @author Luoxun
 * @create 2020/3/26
 * @since 1.0.0
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>(0);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complment = target - nums[i];
            if(map.containsKey(complment) && map.get(complment) != i){
                return new int[]{i, map.get(complment)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public int[] twoSum3(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<Integer, Integer>(0);
        for (int i = 0; i < nums.length; i++) {
            int complment = target - nums[i];
            if(map.containsKey(complment)){
                return new int[]{i, map.get(complment)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
