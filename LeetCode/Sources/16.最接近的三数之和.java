import java.util.Arrays;

import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int ans=nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length;i++){
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];

                if(Math.abs(ans-target)>Math.abs(sum-target)){//如果当前的和距离target更近就更新结果
                    System.out.println(sum);
                    ans=sum;
                }

                if(sum>target){//如果和大于target就右端点减一,使得sum变小
                    r--;
                }else if(sum<target){
                    l++;
                }else if(sum==target){
                    return sum;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

