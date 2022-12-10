import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean st[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

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

            if(i!=0&&nums[i]==nums[i-1]&&!st[i-1]) continue;
            //判重的重点是要找到一个合适的顺序
            //这里规定顺序是在相同的数里前面的数没有用过的话就不能用后面的数
            //nums[i]==nums[i-1]:相同的数
            //st[i-1]:用过没有

            path.add(nums[i]);
            st[i]=true;

            dfs(nums, u+1);

            st[i]=false;
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

