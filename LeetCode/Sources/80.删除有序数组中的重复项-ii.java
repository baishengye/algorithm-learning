/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        for (int x : nums) {
            if(k<2||nums[k-1]!=x||nums[k-2]!=x){
                //看前两个数是不是和x一样，不一样就填入
                nums[k]=x;
                k++;
            }
        }

        return k;
    }
}
// @lc code=end

