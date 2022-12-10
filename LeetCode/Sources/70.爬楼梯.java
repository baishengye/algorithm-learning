/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int i1=1,i0=1;
        if(n<=1) return 1;

        for (int i = 2; i <= n; i++) {
            int t=i1+i0;
            i0=i1;
            i1=t;
        }

        return i1;
    }
}
// @lc code=end

