import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean st[];
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        path=new ArrayList<>();
        st=new boolean[nums.length];

        dfs(nums,0);

        return ans;
    }

    private void dfs(int[] nums, int u) {
        if(u==nums.length){
            List<Integer> t=new ArrayList<>(path);
            ans.add(t);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(st[i]) continue;

            path.add(nums[i]);
            st[i]=true;

            dfs(nums, u+1);

            st[i]=false;
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

