

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot=nums1.length+nums2.length;
        if((tot&1)==0){
            double left=find(nums1,0,nums2,0,tot/2);
            double right=find(nums1,0,nums2,0,tot/2+1);
            return (left+right)/2.0;
        }
        return find(nums1,0,nums2,0,tot/2+1);
    }

    /***
     * 
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @param k：求出nums1和nums2中的第k个数(k从1开始)
     * @return
     */
    private double find(int[] nums1, int i, int[] nums2, int j, int k) {
        if(nums1.length-i>nums2.length-j) return find(nums2, j, nums1, i, k);//始终让剩余数字少的数组作为num1
        if(nums1.length==i) return nums2[j+k-1];//如果num1没有剩余元素了,那么num1和num2中第k个数就是num2剩余元素中的第k个数
        if(k==1)  return Math.min(nums1[i], nums2[j]);//如果要求num1和num2中的第一个数，那么就是num1和num2中最小的数

        int si=Math.min(nums1.length, i+k/2);//第k个数可能不在nums1中,那么第k个数的下标完全有可能数组越界
        int sj=j+k/2;//找到num1中的第k/2个数和num2中的第k/2个数
        if(nums1[si-1]>nums2[sj-1]) return find(nums1, i, nums2, sj, k-(sj-j));
        //如果nums1剩余元素中的第k/2个数比num2剩余元素中的第k/2个数要大的话，
        //那么num2剩余元素中的第k/2个数肯定距离num1和num2中剩余元素的第k个数更远
        //就把nums2的前k/2个数去掉
        return find(nums1, si, nums2, j, k-(si-i));
    }
}
// @lc code=end

