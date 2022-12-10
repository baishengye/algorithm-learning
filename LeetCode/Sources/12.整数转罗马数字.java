/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        int values[]={//所有没有规律的数
            1000,//千位
            900,500,400,100,//百位
            90,50,40,10,//十位
            9,5,4,1//个位
        };

        //与values对应
        String reps[]={
            "M",
            "CM","D","CD","C",
            "XC","L","XL","X",
            "IX","V","IV","I"
        };
        
        StringBuilder ans=new StringBuilder();
        //从最大开始检测，一旦有大于等于的就减去
        for (int i = 0; i < 13; i++) {
            while(num>=values[i]){
                num-=values[i];
                ans.append(reps[i]);
            }
        }

        return ans.toString();

    }
}
// @lc code=end

