/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        StringBuilder res=new StringBuilder();//结果
        StringBuilder name=new StringBuilder();//两个反斜杠'/'之间的文件名

        if(path.charAt(path.length()-1)!='/') path += '/';//确保name是被两个'/'夹住的

        for (int i = 0; i < path.length(); i++) {
            char c=path.charAt(i);
            if(c!='/') name.append(c);
            else{
                String t=name.toString();
                if(t.equals("..")){
                    while(res.length()>0&&res.charAt(res.length()-1)!='/') 
                        res.deleteCharAt(res.length()-1);

                    if(res.length()>0) //res没空的话说明现在res最后一个字符是'/'
                        res.deleteCharAt(res.length()-1);
                }else if(!t.equals("")&&!t.equals(".")){
                    res.append('/'+t);
                }
                name.delete(0, name.length());
            }
        }
        if(res.length()==0)//如果最后发现是根目录(也就是空路径)，就需要添加'/'
            return "/";
        
        return res.toString();
    }
}
// @lc code=end

