/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        boolean is_minus=false;
        if(n<0) is_minus=true;//标记n为负数

        double ans=1;
        for (long k = Math.abs((long)n); k!=0 ; k>>=1) {//快速幂
            if((k&1)==1) ans*=x;//每次是奇数的时候就先把1个x放到ans中，使得所有x中只存储偶数个次方
            x*=x;
        }

        if(is_minus) ans=1/ans;

        return ans;
    }
}
// @lc code=end

