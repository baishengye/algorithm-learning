import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans=new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i!=0&&nums[i]==nums[i-1]) continue;

            for (int j = i+1; j < nums.length; j++) {
                if(j!=i+1&&nums[j]==nums[j-1]) continue;

                int l=j+1,r=nums.length-1;
                while(l<r){
                    int sum=nums[i]+nums[j]+nums[l]+nums[r];

                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<r&&nums[l]==nums[l+1]) l++;
                        while(l<r&&nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum>target){
                        r--;
                    }else if(sum<target){
                        l++;
                    }
                }
            }
        }

        return ans;
    }
}
// @lc code=end

