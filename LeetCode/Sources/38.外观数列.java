/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        StringBuilder ans=new StringBuilder("1");
        for (int i = 0; i < n-1; i++) {//本身初始化赋值"1"的时候就算是一次了
            StringBuilder t=new StringBuilder();
            for (int j = 0; j < ans.length(); ) {
                int k=j+1;
                while(k<ans.length()&&ans.charAt(k)==ans.charAt(j)) //只要是重复的就k++;
                    k++;
                t.append(Integer.toString(k-j)+ans.charAt(j));//k-j就是连续重复的字符个数
                j=k;
            }
            ans=t;
        }

        return ans.toString();
    }
}
// @lc code=end

