## 题目描述

给定一个n个点m条边的无向图，图中可能存在重边和自环，边权可能为负数。

求最小生成树的树边权重之和，如果最小生成树不存在则输出`impossible`。

给定一张边带权的无向图`G=(V, E)`，其中`V`表示图中点的集合，`E`表示图中边的集合，`n=|V|，m=|E|`。

由`V`中的全部`n`个顶点和`E`中`n-1`条边构成的无向连通子图被称为`G`的一棵生成树，其中边的权值之和最小的生成树被称为无向图`G`的最小生成树。

## **输入格式**

第一行包含两个整数n和m。

接下来m行，每行包含三个整数u，v，w，表示点u和点v之间存在一条权值为w的边。

## **输出格式**

共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出impossible。

## **数据范围**

$1≤n≤10^5,$
$1≤m≤2∗10^5,$
图中涉及边的边权的绝对值均不超过1000。

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

## 分析
kruskal算法:
    1.先将所有边按照权重从小到大排序(快排就行)
    2.枚举每一条边a->b，权重是c
        if a和b不连通
            将这条边加入集合中

## 模板
```c++
时间复杂度是 O(mlogm)O(mlogm), nn 表示点数，mm 表示边数
int n, m;       // n是点数，m是边数
int p[N];       // 并查集的父节点数组

struct Edge     // 存储边
{
    int a, b, w;

    bool operator< (const Edge &W)const
    {
        return w < W.w;
    }
}edges[M];

int find(int x)     // 并查集核心操作
{
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

int kruskal()
{
    sort(edges, edges + m);

    for (int i = 1; i <= n; i ++ ) p[i] = i;    // 初始化并查集

    int res = 0, cnt = 0;
    for (int i = 0; i < m; i ++ )
    {
        int a = edges[i].a, b = edges[i].b, w = edges[i].w;

        a = find(a), b = find(b);
        if (a != b)     // 如果两个连通块不连通，则将这两个连通块合并
        {
            p[a] = b;
            res += w;
            cnt ++ ;
        }
    }

    if (cnt < n - 1) return INF;
    return res;
}
```

## 解答
```c++
#include "bits/stdc++.h"

using namespace std;

const int N=1e5+10,INF=0x3f3f3f3f;

int n,m;
int p[N];//并查集

struct Edge
{
    int a,b,w;
    const bool operator<(const Edge &W){//括号中的const表示参数a对象不会被修改，最后的const表明调用函数对象不会被修改!
        return w<W.w;
    }
}edges[N];

int find(int x){
    if(p[x]!=x) p[x]=find(p[x]);
    return p[x];
}

int kruskal(){
    sort(edges,edges+m);

    for(int i=1;i<=n;i++) p[i]=i;//初始化并查集

    int res=0;//res是权重之和
    int cnt=0;//cnt是连通块有多少个边

    for(int i=0;i<m;i++){//遍历所有的边
        int a=edges[i].a,b=edges[i].b,w=edges[i].w;
        a=find(a),b=find(b);
        if(a!=b){//如果a和b不连通
            p[a]=b;//把边加到集合里
            res+=w;
            cnt++;
        }
    }
    if(cnt<n-1) return INF;//如果最后连通块中边数小于点数-1说明不知一个连通块，那么就不存在最小生成树
    return res;
}

int main(){
    cin>>n>>m;

    for(int i=0;i<m;i++){
        int a,b,w;
        cin>>a>>b>>w;
        edges[i]={a,b,w};
    }

    int res=kruskal();

    if(res==INF) cout<<"impossible"<<endl;
    else cout<<res<<endl;

    return 0;
}
```