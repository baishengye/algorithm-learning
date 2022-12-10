/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {        
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=-1;

        if(nums.length==0) return ans;

        int l=search_left(nums, target);
        int r=search_right(nums, target);

        if(nums[l]!=target||nums[r]!=target){
            return ans;
        }

        ans[0]=l;
        ans[1]=r;
        return ans;
    }   

    private static int search_left(int[] nums,int target){
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)>>1;
            if(nums[mid]>=target) r=mid;
            else l=mid+1;
        }

        return l;
    }

    private static int search_right(int[] nums,int target){
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r+1)>>1;
            if(nums[mid]>target) r=mid-1;
            else l=mid;
        }

        return r;
    }
}
// @lc code=end

