

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    /**
     * 做法一
     * @param x
     * @return
     */
    /*
    public boolean isPalindrome(int x) {
        String a=Integer.toString(x);
        String b=new StringBuffer(a).reverse().toString();
        if(a.equals(b)) return true;
        return false;
    }*/

    /**
     * 做法二
     * @param x
     * @return
     */
    /*
    public boolean isPalindrome(int x) {
        String a=Integer.toString(x);

        if(x<0) return false;

        StringBuilder b=new StringBuilder();
        if(x==0) b.append(x);
        while(x!=0){
            int t=x%10;
            b.append(t);
            x/=10;
        }

        if(b.toString().equals(a)) return true;
        return false;
    }*/

    /**
     * 做法三
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        
        //特判负数和0结尾的数
        if(x<0||x%10==0) return false;

        int s=0;
        //s存下x的后一半,x存下x的前一半
        while(s<=x){
            s=s*10+x%10;
            //s==x表示原来的x是偶数长度时
            //s==x/10表示原来的x是奇数长度时
            if(s==x||s==x/10) return true;
            x/=10;
        }

        return false;
    }

}
// @lc code=end

