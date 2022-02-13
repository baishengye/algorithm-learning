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

## 模板
```c++
时间复杂度是 O(n2+m)O(n2+m), nn 表示点数，mm 表示边数
int n;      // n表示点数
int g[N][N];        // 邻接矩阵，存储所有边
int dist[N];        // 存储其他点到当前最小生成树的距离
bool st[N];     // 存储每个点是否已经在生成树中


// 如果图不连通，则返回INF(值是0x3f3f3f3f), 否则返回最小生成树的树边权重之和
int prim()
{
    memset(dist, 0x3f, sizeof dist);

    int res = 0;
    for (int i = 0; i < n; i ++ )
    {
        int t = -1;
        for (int j = 1; j <= n; j ++ )
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;

        if (i && dist[t] == INF) return INF;

        if (i) res += dist[t];
        st[t] = true;

        for (int j = 1; j <= n; j ++ ) dist[j] = min(dist[j], g[t][j]);
    }

    return res;
}
```

## 解答
```c++
#include "bits/stdc++.h"

using namespace std;

const int N = 510, INF = 0x3f3f3f3f;

int n, m;
int g[N][N]; //稠密图用邻接矩阵存储
int d[N];    //d[i]表示i这个点到集合s的最短距离
bool st[N];  //是否已经加到连通图中

int prim()
{
    memset(d, 0x3f, sizeof d);

    int res = 0; //最小生成树中权值之和

    for (int i = 0; i < n; i++)
    {
        int t = -1; //编号没有-1的，-1就把表示没找到
        for (int j = 1; j <= n; j++)
        {
            if (!st[j] && (t == -1 || d[t] > d[j]))
            {
                t = j;
            }
        } //遍历整个集合s,找到集合s外距离最小的点

        //==========为防止有负权自环出现，最好按以下顺序===========
        
        if (i && d[t] == INF)
            return INF; //如果t找不到到达集合s的路径那么t到集合s的距离就是INF,就是不存在最小生成树
        if (i)
            res += d[t];
        for (int j = 1; j <= n; j++)
            d[j] = min(d[j], g[t][j]);//用t来更新其他点到集合s的距离,实际上就是找出集合s中距离t这个点最近的点的边的距离。
        //=========================================================
        st[t] = true;
    }
    return res;
}

int main()
{
    scanf("%d%d",&n,&m);

    memset(g, 0x3f, sizeof g); //把边的距离初始化成无穷

    while (m--)
    {
        int a, b, c;
        scanf("%d%d%d",&a,&b,&c);
        if (a != b)                              //去除自环
            g[a][b] = g[b][a] = min(g[a][b], c); //无向图就是双向图，可能有重边，只取最短一条计算
        else
            g[a][b] = g[b][a] = 0;
    }

    int t = prim();
    if (t == INF)
        puts("orz"); //没有连通图那么距离肯定就是大于INF/2的(有负权边)
    else
        cout << t << endl;
    return 0;
}
```