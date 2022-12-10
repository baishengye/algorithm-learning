import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int n=num1.length(),m=num2.length();

        //把字符串转化成数组
        List<Integer> a=new ArrayList<>();
        for (int i = n-1; i >= 0; i--)     
            a.add(num1.charAt(i)-'0');

        List<Integer> b=new ArrayList<>();
        for (int i = m-1; i >= 0; i--)     
            b.add(num2.charAt(i)-'0');

        //计算出c,此时的c的每一个元素都可能不是个位数
        int[] c=new int[n+m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i+j]+=a.get(i)*b.get(j);
            }
        }

        //把每一位变成个位数
        for (int i = 0,t = 0; i < c.length; i++) {
            t+=c[i];
            c[i]=t%10;
            t/=10;//进位
        }

        //除去前导0
        int k=c.length-1;
        while(k>=1&&c[k]==0) k--;

        //变成字符串返回
        StringBuilder ans=new StringBuilder();
        for (int i = k; i >= 0; i--) {
            ans.append(c[i]);
        }

        return ans.toString();
    }
}
// @lc code=end

