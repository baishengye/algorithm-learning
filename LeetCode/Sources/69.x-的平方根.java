/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        long l=0,r=x;
        while(l<r){
            long mid=(1+l+r)/2;
            if(mid*mid<=x) l=mid;
            else r=mid-1;
        }
        return (int)r;
    }
}
// @lc code=end

