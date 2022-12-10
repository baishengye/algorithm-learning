import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] c, int target) {
        ans=new ArrayList<>();
        path=new ArrayList<>();

        dfs(c,0,target);

        return ans;
    }
    private void dfs(int[] c, int u, int target) {
        if(target==0){
            List<Integer> t=new ArrayList<>(path);
            ans.add(t);
            return;
        }

        if(u==c.length) return;

        for (int i = 0; c[u]*i<=target; i++) {
            dfs(c, u+1, target-c[u]*i);//c[u]取i个
            path.add(c[u]);
        }

        //回复现场
        for (int i = 0; c[u]*i<=target; i++) {
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

