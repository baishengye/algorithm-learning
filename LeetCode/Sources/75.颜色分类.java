/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    /**
     * 把nums分成三段，0~i-1,i~j-1,j~k;
     * 当j指向的是0就把他换到左端
     * 当j指向的是2就把他换到右端
     * 当j指向的是1就保持原样
     * @param nums
     */
    public void sortColors(int[] nums) {
        for(int i=0,j=0,k=nums.length-1;j<=k;){
            if(nums[j]==0){
                swap(nums,i,j);
                i++;
                j++;
            }else if(nums[j]==2){
                swap(nums,j,k);
                k--;
            }else{
                j++;
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
// @lc code=end

