/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int ans=0;

        while(l<r){
            int t=Math.min(height[l], height[r]);
            ans=Math.max(ans, t*(r-l));

            if(height[l]>=height[r]) r--;
            else l++;
        }

        return ans;
    }
}
// @lc code=end

