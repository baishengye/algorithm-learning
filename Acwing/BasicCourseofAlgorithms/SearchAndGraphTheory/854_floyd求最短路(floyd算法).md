## **题目描述**

给定一个n个点m条边的有向图，图中可能存在重边和自环，边权可能为负数。

再给定k个询问，每个询问包含两个整数x和y，表示查询从点x到点y的最短距离，如果路径不存在，则输出“impossible”。

数据保证图中不存在负权回路。

## **输入格式**

第一行包含三个整数n，m，k

接下来m行，每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。

接下来k行，每行包含两个整数x，y，表示询问点x到点y的最短距离。

## **输出格式**

共k行，每行输出一个整数，表示询问的结果，若询问两点间不存在路径，则输出“impossible”。

## **数据范围**

$1≤n≤200,$
$1≤k≤n^2$
$1≤m≤20000,$
图中涉及边长绝对值均不超过10000。

## **样例**
```c++
输入样例：
3 3 2
1 2 1
2 3 2
1 3 1
2 1
1 3

输出样例：
impossible
1
```

## **分析**
### 算法分析
`(y总真言，简单易懂)`

- `f[i, j, k]`表示从i走到j的路径上除i和j点外只经过1到k的点的所有路径的最短距离。
  那么`f[i, j, k] = min(f[i, j, k - 1), f[i, k, k - 1] + f[k, j, k - 1]`。
  因此在计算第`k`层的`f[i, j]`的时候必须先将第`k - 1`层的所有状态计算出来，所以需要把`k`放在最外层。

- 读入邻接矩阵，将次通过动态规划装换成从`i到j`的最短距离矩阵

- 在下面代码中，判断从a到b是否是无穷大距离时，需要进行`if(t > INF/2)`判断，而
  非是`if(t == INF)`判断，原因是`INF`是一个确定的值，并非真正的无穷大，会随着其
  他数值而受到影响，t大于某个与INF相同数量级的数即可
 
### **文字性复习**
#### $Dijkstra-朴素$ &nbsp; $O(n2)$
1. 初始化距离数组, dist[1] = 0, dist[i] = inf;
2. for n次循环 每次循环确定一个min加入S集合中，n次之后就得出所有的最短距离
3. 将不在S中dist_min的点->t
4. t->S加入最短路集合
5. 用t更新到其他点的距离

#### $Dijkstra-堆优化$ &nbsp; $O(mlogm)$
1. 利用邻接表，优先队列
2. 在priority_queue<PII,vector<PII>,greater<PII>> heap;中将返回堆顶
3. 利用堆顶来更新其他点，并加入堆中类似宽搜

#### $Bellman-ford$ &nbsp; $O(nm)$
1. 注意连锁想象需要备份, struct Edge{int a,b,c} Edge[M];
2. 初始化dist, 松弛 dist[x.b] = min(dist[x.b], backup[x.a]+x.w);
3. 松弛k次，每次访问m条边

#### $Spfa$ &nbsp; $O(n)∼O(nm)$
1. 利用队列优化仅加入修改过的地方
2. ```c++
   for k次
        for 所有边利用宽搜模型去优化bellman_ford算法
            更新队列中当前点的所有出边
    ```

$Floyd$ &nbsp; $O(n3)$
1. 初始化d
2. k, i, j 去更新d

## **模板**
```c++
时间复杂度是 O(n3)O(n3), nn 表示点数
初始化：
    for (int i = 1; i <= n; i ++ )
        for (int j = 1; j <= n; j ++ )
            if (i == j) d[i][j] = 0;
            else d[i][j] = INF;

// 算法结束后，d[a][b]表示a到b的最短距离
void floyd()
{
    for (int k = 1; k <= n; k ++ )
        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= n; j ++ )
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
}
```

## **解答**
```c++
#include <iostream>
using namespace std;

const int N = 210, M = 2e+10, INF = 1e9;

int n, m, k, x, y, z;
int d[N][N];

void floyd() {
    for(int k = 1; k <= n; k++)
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
}

int main() {
    cin >> n >> m >> k;
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= n; j++)
            if(i == j) d[i][j] = 0;//去除自环
            else d[i][j] = INF;
    while(m--) {
        cin >> x >> y >> z;
        d[x][y] = min(d[x][y], z);
        //注意保存最小的边
    }
    floyd();
    while(k--) {
        cin >> x >> y;
        if(d[x][y] > INF/2) puts("impossible");
        //由于有负权边存在所以约大过INF/2也很合理
        else cout << d[x][y] << endl;
    }
    return 0;
}
```