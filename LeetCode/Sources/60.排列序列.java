/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
/**
 * 如果当前是在计算第i位，那么第i位就有fact=(n-i-1)!的可能
 * 如果fact<k(没有达到第k个)就继续往后找数字
 * 直到k<=fact就说明这一位可以填充这个数字
 */
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder ans=new StringBuilder();
        boolean st[]=new boolean[n+1];

        for (int i = 0; i < n; i++) {
            
            //计算阶乘
            int fact=1;
            for (int j = 1; j <= n-i-1; j++) {
                fact*=j;
            }

            //计算当前位能填充几
            for (int j = 1; j <= n; j++) {
                if(!st[j]){
                    if(fact<k){
                        k-=fact;
                    }else{
                        ans.append(j);
                        st[j]=true;
                        break;
                    }
                }
            }
        }

        return ans.toString();
    }
}
// @lc code=end

