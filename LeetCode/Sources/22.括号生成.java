import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
/**
 * 
(直接生成合法的括号序列) O(Cn2n)
使用递归。
每次可以放置左括号的条件是当前左括号的数目不超过 n。
每次可以放置右括号的条件是当前右括号的数目不超过左括号的数目。
时间复杂度
时间复杂度就是答案的个数，乘上保存答案的 O(n)计算量，该问题是经典的卡特兰数。
总时间复杂度为 O(1n+1Cn2n)=O(Cn2n)O(1n+1C2nn)=O(C2nn)。
 */

class Solution {
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();

        dfs(n,0,0,"");

        return ans;
    }
    private void dfs(int n, int lc, int rc, String path) {
        if(lc==n&&rc==n){//如果左括号和右括号都有了n个就返回结果
            ans.add(path);
            return;
        }

        if(lc<n) //左括号的条件是当前左括号的数目不超过 n
            dfs(n, lc+1, rc, path+'(');
        if(rc<n&&rc<lc) //当前右括号的数目不超过左括号的数目
            dfs(n, lc, rc+1, path+')');
    }
}
// @lc code=end

