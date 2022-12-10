import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    List<String> ans;

    static String nums[]={
        "",
        "","abc","def",
        "ghi","jkl","mno",
        "pqrs","tuv","wxyz"
    };

    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<String>();
        if(digits.length()==0) return ans;

        dfs(digits,0,"");

        return ans;
    }

    private void dfs(String digits, int u, String path) {
        if(u==digits.length()){
            ans.add(path);
            return;
        }

        String t=nums[digits.charAt(u)-'0'];
        System.out.println(t);
        for(int i=0;i < t.length();i++){
            dfs(digits, u+1, path+t.charAt(i));
        }
    }
}
// @lc code=end

