## 题目描述

给定一个n个点m条边的无向图，图中可能存在重边和自环，边权可能为负数。

求最小生成树的树边权重之和，如果最小生成树不存在则输出`impossible`。

给定一张边带权的无向图`G=(V, E)`，其中`V`表示图中点的集合，`E`表示图中边的集合，`n=|V|`，`m=|E|`。

由`V`中的全部`n`个顶点和`E`中`n-1`条边构成的无向连通子图被称为`G`的一棵生成树，其中边的权值之和最小的生成树被称为无向图`G`的最小生成树。

## 输入格式

第一行包含两个整数`n`和`m`。

接下来`m`行，每行包含三个整数`u，v，w`，表示点`u`和点`v`之间存在一条权值为`w`的边。

## 输出格式

共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出`impossible`。

## 数据范围
$1≤n≤500,$
$1≤m≤105,$
图中涉及边的边权的绝对值均不超过`10000`。


## 样例
```c++
输入样例：

4 5
1 2 1
1 3 2
1 4 3
2 3 2
3 4 4

输出样例：

6
```

### 

## 分析
![](https://s4.ax1x.com/2022/02/01/HFKsoT.png)
最小生成树是指由一张带权无向图求出的权值最小的连通图。
```c++
朴素prim:
d[i][j]=IN//所有距离初始化成无穷
集合s: 表示已经在连通块中的点
for(i->n)
    t=找到集合s外距离最小的点
    用t来更新其他点到集合s的距离
    st[t]=true//把t加到s集合中去
```
堆优化prim就是把`t=找到集合s外距离最小的点`用小根堆实现存取

## 模板
```c++
O(mlogm)
const int MAXN = 510, MAXM = 2 * 1e5 + 10, INF = 0x3f3f3f3f;
typedef pair<int, int> PII;
int h[MAXM], e[MAXM], w[MAXM], ne[MAXM], idx;
bool vis[MAXN];
int n, m;

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx ++ ;
}

int Prim()
{
    memset(vis, false, sizeof vis);
    int sum = 0, cnt = 0;
    priority_queue<PII, vector<PII>, greater<PII>> q;
    q.push({0, 1});

    while (!q.empty())
    {
        auto t = q.top();
        q.pop();
        int ver = t.second, dst = t.first;
        if (vis[ver]) continue;
        vis[ver] = true, sum += dst, ++cnt;

        for (int i = h[ver]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (!vis[j]) {
                q.push({w[i], j});
            }
        }
    }

    if (cnt != n) return INF;
    return sum;
}
```

## 解答
```c++
#include <cstring>
#include <iostream>
#include <queue>
using namespace std;

const int MAXN = 510, MAXM = 2 * 1e5 + 10, INF = 0x3f3f3f3f;
typedef pair<int, int> PII;
int h[MAXM], e[MAXM], w[MAXM], ne[MAXM], idx;
bool vis[MAXN];
int n, m;

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx ++ ;
}

int Prim()
{
    memset(vis, false, sizeof vis);
    int sum = 0, cnt = 0;
    priority_queue<PII, vector<PII>, greater<PII>> q;
    q.push({0, 1});

    while (!q.empty())
    {
        auto t = q.top();
        q.pop();
        int ver = t.second, dst = t.first;
        if (vis[ver]) continue;
        vis[ver] = true, sum += dst, ++cnt;

        for (int i = h[ver]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (!vis[j]) {
                q.push({w[i], j});
            }
        }
    }

    if (cnt != n) return INF;
    return sum;
}

int main()
{
    cin >> n >> m;
    memset(h, -1, sizeof h);
    for (int i = 0; i < m; ++i)
    {
        int a, b, w;
        cin >> a >> b >> w;
        add(a, b, w);
        add(b, a, w);
    }

    int t = Prim();
    if (t == INF) cout << "impossible" << endl;
    else cout << t << endl; 
}
```