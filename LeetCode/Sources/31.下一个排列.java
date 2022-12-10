import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    /**
     * 考察库函数next_permutation()
     * 逻辑:从右端开始找到第一个非降序的位置(比如：23541中的3和5）
     * 然后找到3后面最后一个比3大的数
     * 然后交换3和4
     * 然后把3后面的数升序
     * 如果整个序列都是降序，那么就是最后一个序列，返回第一个序列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int k=nums.length-1;
        while(k>0&&nums[k-1]>=nums[k]) k--;//找到的k对应的nums[k]=5

        if(k<=0){//整个序列都是降序
            reverser(nums,0,nums.length-1);
        }else{//k之后的是降序的
            int i=k-1;//nums[i]=3
            int j=nums.length-1;
            while(nums[j]<=nums[i]&&i<j) j--;//所以一旦有比nums[k-1]小的就是要找的数
            swap(nums, i, j);
            reverser(nums, i+1,nums.length-1);
        }
    }

    private static void reverser(int[] nums,int l,int r){
        while(l<r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int a=nums[l];
        nums[l]=nums[r];
        nums[r]=a;
    }
}
// @lc code=end

