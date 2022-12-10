import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk=new ArrayDeque<>();//双端队列模拟栈

        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                stk.push(s.charAt(i));
            }else{
                if(!stk.isEmpty() && Math.abs(stk.peek()-ch)<=2){
                    //查表后发现[和]，{和}，(和)的ascll值查不超过2
                    stk.pop();
                }else{
                    return false;
                }
            }
        }

        if(stk.isEmpty()) return true;

        return false;
    }
}
// @lc code=end

