/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int hash[]=new int[128];
        hash['I']=1;
        hash['V']=5;
        hash['X']=10;
        hash['L']=50;
        hash['C']=100;
        hash['D']=500;
        hash['M']=1000;

        int ans=0;
        //从高位往低位找，只要高位比地位小就减，否则就加
        for (int i = 0; i < s.length(); i++) {
            if(i+1<s.length()&&hash[s.charAt(i)]<hash[s.charAt(i+1)]){
                ans-=hash[s.charAt(i)];
            }else{
                ans+=hash[s.charAt(i)];
            }
        }

        return ans;
    }
}
// @lc code=end

