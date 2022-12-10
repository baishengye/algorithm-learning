import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        if(a.length()<b.length()) return addBinary(b,a);

        List<Integer> alist=new LinkedList<>();
        for (int i = a.length()-1; i >= 0; i--) {
            alist.add(a.charAt(i)-'0');
        }
        List<Integer> blist=new LinkedList<>();
        for (int i = b.length()-1; i >= 0; i--) {
            blist.add(b.charAt(i)-'0');
        }

        int t=0;
        for (int i = 0; i < alist.size(); i++) {
            t+=alist.get(i);
            if(i<blist.size()) t+=blist.get(i);

            alist.set(i, t%2);
            t=t/2;
        }
        if(t>0) alist.add(t);


        StringBuilder ans=new StringBuilder();
        for (int i=alist.size()-1;i>=0;i--) {
            ans.append(alist.get(i));
        }

        return ans.toString();
        
    }
}
// @lc code=end

