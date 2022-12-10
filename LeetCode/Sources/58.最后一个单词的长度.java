/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();

        int ans=0;
        for (int i = s.length()-1; i >= 0; i--,ans++) {
            if(s.charAt(i)==' ') break;
        }

        return ans;
    }
}
// @lc code=end

