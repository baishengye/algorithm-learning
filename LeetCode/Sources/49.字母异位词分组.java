import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //想要直接把几个字符串比较很困难
        //所以可以先把字符串排序，当排完序了之后字母异位词就会使一个相同的字符串

        Map<String,List<String>> hash=new HashMap<>();
        for (String str : strs) {
            char[] cs=str.toCharArray();
            Arrays.sort(cs);

            String nstr=new String(cs);
            if(!hash.containsKey(nstr)){
                hash.put(nstr, new ArrayList<>());
            } 
            hash.get(nstr).add(str);
        }

        List<List<String>> ans=new ArrayList<>();
        for (List<String> it:hash.values()) {
            ans.add(it);
        }

        return ans;
        
    }
}
// @lc code=end

