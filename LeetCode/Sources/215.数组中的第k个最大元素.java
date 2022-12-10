import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    private int[] nums;

    void q_sort(int l, int r, int k){
        if(l==r) return;

        int i=l-1,j=r+1,x=nums[l];
        while(i<j){
            do i++;while(nums[i]<x);
            do j--;while(nums[j]>x);
            if(i<j){
                swap(i,j);
            }
        }

        if(k<=j) q_sort(l, j, k);
        else q_sort(j+1, r, k);
    }

    private void swap(int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public int findKthLargest(int[] _nums, int k) {
        nums=_nums;

        q_sort(0,nums.length-1,k-1);

        return nums[k-1];
    }
}
// @lc code=end

