package Week1;
/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    /**
     * 
     * 找规律：发现第一行和最后一行是一个等差数列
     * 中间几行都可以看成是两个等差数列
     * @param s
     * @param n
     * @return
     */
    public String convert(String s, int n) {
        if(n==1) return s;//当n=1的时候特判一下，防止j死循环

        StringBuilder ans=new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i==0||i==n-1){
                for (int j = i; j < s.length(); j+=2*n-2) {//第一行和第n行一个数列,公差是2*n-2
                    ans.append(s.charAt(j));
                }
            }else{
                for (int j = i,k=2*n-2-i; j < s.length()||k < s.length(); j+=2*n-2,k+=2*n-2) {
                    //其他行有两个数列
                    if(j<s.length()) ans.append(s.charAt(j));//第一个
                    if(k<s.length()) ans.append(s.charAt(k));//第二个
                }
            }
        }

        return ans.toString();
    }
}
// @lc code=end

