import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    List<Integer> path;

    public List<List<Integer>> combinationSum2(int[] c, int target) {
        ans=new ArrayList<>();
        path=new ArrayList<>();

        Arrays.sort(c);//先排序方便计算一段重复元素有多少个

        dfs(c,0,target);

        return ans;
    }

	private void dfs(int[] c, int u, int target) {
        if(target==0){
            //找到正确路径
            List<Integer> t=new ArrayList<>(path);
            ans.add(t);
            return;
        }

        if(u==c.length)//数据找完了也不符合要求
            return;

        int k=u+1;
        while(k<c.length&&c[u]==c[k]) k++;
        int cnt=k-u;//计算c[u]这个原元素有多少个

        for (int i = 0; c[u]*i<=target&&i<=cnt; i++) {//c[u]这个元素用了i个
            dfs(c, k, target-c[u]*i);//下一个dfs要从下一段的第一个元素开始
            path.add(c[u]);
        }

        //回复现场
        for (int i = 0; c[u]*i<=target&&i<=cnt; i++) {//c[u]这个元素用了i个
            path.remove(path.size()-1);
        }
	}
}
// @lc code=end

