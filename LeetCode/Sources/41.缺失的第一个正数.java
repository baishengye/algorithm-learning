import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    /**
     * 如果没有时间和空间的限制就可有用哈希表
     */
    // public int firstMissingPositive(int[] nums) {
    //     Map<Integer,Integer> hash=new HashMap<>();
    //     for (int x : nums){
    //         hash.put(x, 1);
    //     }

    //     int ans=1;
    //     while(hash.containsKey(ans)){
    //         ans++;
    //     }

    //     return ans;
    // }

    /**
     * 可惜时间要O(n),空间要O(1)
     * 题解:https://www.acwing.com/solution/content/88/
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;

        for (int i = 0; i < n; i++) {//把每个元素和他的下标+1对应起来，比如1在下标0处,2在下标1处
            while(nums[i]>=1&&nums[i]<=n&&nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }

        //遍历整个数组，如果元素没有和下标对应起来就表明这个是缺少的第一个整个
        for (int i = 0; i < n; i++) {
            if(nums[i]!=i+1)
                return i+1;
        }

        return n+1;//如果不缺，就是最后一个下标+1
    }

    private void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
// @lc code=end

