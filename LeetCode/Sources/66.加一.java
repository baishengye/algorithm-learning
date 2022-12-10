import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]+=1;
        List<Integer> ans=new LinkedList<>();
        int t=0;
        for (int i = digits.length-1; i >= 0; i --) {
            t+=digits[i];
            ans.add(0, t%10);;
            t/=10;
        }

        if(t>0) ans.add(0, t);

        int res[]=new int[ans.size()];
        for (int i=0;i<ans.size();i++) {
            res[i]=ans.get(i);
        }

        return res;
    }
}
// @lc code=end

