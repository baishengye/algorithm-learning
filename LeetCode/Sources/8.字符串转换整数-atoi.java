package Week1;
/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int ans=0;
        int minus=1;
        int k=0;

        //排除空格
        while(k<s.length()&&s.charAt(k)==' ') k++;

        //判断正负
        if(k<s.length()&&s.charAt(k)=='-'){
            minus=-1;
            k++;
        }else if(k<s.length()&&s.charAt(k)=='+'){
            k++;
        }

        //计算
        for (int i = k; i < s.length()&&s.charAt(i)<='9'&&s.charAt(i)>='0'; i++) {
            int x=s.charAt(i)-'0';

            //正数边界
            if(minus>0&&ans>(Integer.MAX_VALUE-x)/10) return Integer.MAX_VALUE;

            //负数边界
            if(minus<0&&ans*-1<(Integer.MIN_VALUE+x)/10) return Integer.MIN_VALUE;
            //负数最小是-2^31,正数最大值是2^31-1,int的ans存不下，需要特判
            if(minus<0&&-1*ans*10-x==Integer.MIN_VALUE) return Integer.MIN_VALUE;

            ans=ans*10+x;
        }

        return minus*ans;
    }
}
// @lc code=end

