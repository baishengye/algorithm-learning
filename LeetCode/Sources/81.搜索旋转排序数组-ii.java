/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        //恐怕数组尾和数组头一样，所以需要把数组尾巴一样的去掉
        int len=nums.length-1;
        while(nums.length>0&&nums[len]==nums[0]) len--;

        int l=0,r=len;
        while(l<r){//找到最后一个比第一个数大 的数
            int mid=(l+r+1)>>1;
            if(nums[mid]>=nums[0]) l=mid;
            //如果中点的数比左端点数小，就说明最后一个比左端点的数大的数是在中点左边
            else r=mid-1;
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

        if(nums[r]==target) return true;

        return false;
    }
}
// @lc code=end

