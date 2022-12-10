/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;

        int fi_1=nums[0];

        int ans=fi_1;
        for (int i = 1; i < len; i++) {
            int t=Math.max(fi_1+nums[i], nums[i]);
            ans=Math.max(ans, t);
            fi_1=t;
        }

        return ans;
    }
}
// @lc code=end

