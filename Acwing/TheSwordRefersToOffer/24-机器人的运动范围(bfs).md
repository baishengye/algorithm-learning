## 题目
地上有一个 `m` 行和 `n` 列的方格，横纵坐标范围分别是 `0∼m−1` 和 `0∼n−1`。

一个机器人从坐标 `(0,0)` 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。

但是不能进入行坐标和列坐标的数位之和大于 k 的格子。

请问该机器人能够达到多少个格子？

**注意:**
1. 0<=m<=50
2. 0<=n<=50
3. 0<=k<=100

## 样例
```c++
样例1
输入：k=7, m=4, n=5

输出：20
样例2
输入：k=18, m=40, n=40

输出：1484

解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
      但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
```

## 分析
### 算法
$(BFS) O(nm)$
这是一个典型的宽度优先搜索问题，我们从 `(0, 0)` 点开始，每次朝上下左右四个方向扩展新的节点即可。

扩展时需要注意新的节点需要满足如下条件：
- 之前没有遍历过，这个可以用个`bool`数组来判断；
- 没有走出边界；
- 横纵坐标的各位数字之和小于 `k`；
最后答案就是所有遍历过的合法的节点个数。

### 时间复杂度
每个节点最多只会入队一次，所以时间复杂度不会超过方格中的节点个数。
最坏情况下会遍历方格中的所有点，所以时间复杂度就是 `O(nm)`

## 解答
```c++
class Solution {
public:
    int get_num(int a,int b)
    {
        int sum=0;
        while(a)
        {
            sum+=a%10;
            a/=10;
        }
        
        while(b)
        {
            sum+=b%10;
            b/=10;
        }
        return sum;
    }

    int movingCount(int threshold, int rows, int cols)
    {
        if(rows==0||cols==0) return 0;
        
        int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
        
        int ans=0;
        queue<pair<int,int>> q;
        vector<vector<bool>> st(rows,vector<bool>(cols,false));
        
        q.push({0,0});
        ans++;
        st[0][0]=true;
        
        while(q.size())
        {
            auto t=q.front();
            q.pop();
            
            for (int i = 0; i < 4; i ++ )
            {
                int a=t.first+dx[i],b=t.second+dy[i];
                if(a>=0&&a<=rows-1&&b>=0&&b<=cols-1&&!st[a][b]&&get_num(a,b)<=threshold)
                {
                    q.push({a,b});
                    ans++;
                    st[a][b]=true;
                }
            }
        }
        
        return ans;
    }
};
```