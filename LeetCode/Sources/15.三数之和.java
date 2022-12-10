import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {//O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i!=0&&nums[i]==nums[i-1]) continue;//去重i
            
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r&&nums[l]==nums[l+1]) l++;//去重l，l只取最左边的
                    while(l<r&&nums[r]==nums[r-1]) r--;//去重r，r只取最右边的
                    l++;
                    r--;
                }else if(sum>0){
                    r--;
                }else if(sum<0){
                    l++;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

