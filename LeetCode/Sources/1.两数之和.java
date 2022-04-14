package Week1;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int t=target-nums[i];
            if(hash.containsKey(t)){
                int[] ans={hash.get(t),i} ;
                return ans; 
            }
            else hash.put(nums[i], i);
        }

        return new int[2];
    }
}
// @lc code=end

