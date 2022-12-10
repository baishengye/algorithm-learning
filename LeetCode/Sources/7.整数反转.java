

// @lc code=start
class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            if(ans>0&&ans>(Integer.MAX_VALUE-x%10)/10) return 0;
            //由于不能使用long long，所以需要提前判断ans有没有可能超过int的最大值
            if(ans<0&&ans<(Integer.MIN_VALUE-x%10)/10) return 0;

            ans=ans*10+x%10;
            x/=10;
        }

        return ans;
    }
}
// @lc code=end

