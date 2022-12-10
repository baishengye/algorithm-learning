/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;

        int l=0,r=nums.length-1;
        while(l<r){//找到最后一个比第一个数大 的数
            int mid=(l+r+1)>>1;
            if(nums[mid]<nums[0]) r=mid-1;
            //如果中点的数比左端点数小，就说明最后一个比左端点的数大的数是在中点左边
            else l=mid;
        }

        if(target>=nums[0]) l=0;//如果在左半段
        else{//如果在右半段
            l=r+1;
            r=nums.length-1;
        }

        while(l<r){
            int mid=(l+r)>>1;
            if(nums[mid]>=target) r=mid;
            else l=mid+1;
        }

        if(nums[r]!=target) return -1;

        return r;
    }
}
// @lc code=end

