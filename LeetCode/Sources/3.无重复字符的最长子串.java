

// @lc code=start
class Solution {
    /**
     * 滑动窗口+map解决
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int hash[]=new int[128];

        int i=0,j=0,ans=0;;
        while(i<s.length()&&j<s.length()){
            hash[s.charAt(i)]++;
            while(j<s.length()&&hash[s.charAt(i)]>1){
                hash[s.charAt(j)]--;
                j++;
            }

            ans=Math.max(ans, i-j+1);
            i++;
        }
        return ans;

    }
}
// @lc code=end

