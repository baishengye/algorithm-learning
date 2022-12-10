/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans=new StringBuilder();

        String str=strs[0];
        for (int i = 0; i < str.length(); i++) {
            char u=str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length()<=i||strs[j].charAt(i)!=u){
                    return ans.toString();
                }
            }
            ans.append(u);
        }

        return ans.toString();
    }
}
// @lc code=end

