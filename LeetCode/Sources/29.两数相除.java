import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int x, int y) {
        boolean is_minus=false;
        if((x<0&&y>0)||(x>0&&y<0)) is_minus=true;

        List<Long> exp=new ArrayList<>();
        long a=Math.abs((long)x),b=Math.abs((long)y);
        for (long i = b; i <= a; i=i+i) exp.add(i);
        
        long ans=0;
        for(int i=exp.size()-1;i>=0;i-- ){
            long t=exp.get(i);
            if(a>=t){
                a-=t;
                ans+=(long)1<<i;
            }
        }

        if(is_minus) ans=-ans;

        if(ans>Integer.MAX_VALUE||ans<Integer.MIN_VALUE) return Integer.MAX_VALUE;

        return (int)ans;
    }
}
// @lc code=end

