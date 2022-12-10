

// @lc code=start
class Solution {
    /**
     * 双指针找法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            int l=i-1,r=i+1;//字符串是奇数长度
            while(l>=0&&r<=s.length()-1&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(ans.length()<r-l-1) ans=s.substring(l+1, r);

            l=i;//字符串是偶数长度
            r=i+1;
            while(l>=0&&r<=s.length()-1&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(ans.length()<r-l-1) ans=s.substring(l+1, r);
        }

        return ans;
    }
}
// @lc code=end

