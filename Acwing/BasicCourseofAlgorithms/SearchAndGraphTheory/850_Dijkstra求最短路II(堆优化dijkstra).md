## **题目**
给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，所有边权均为非负值。

请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 −1。

## **输入格式**
第一行包含整数 n 和 m。

接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

## **输出格式**
输出一个整数，表示 1 号点到 n 号点的最短距离。

如果路径不存在，则输出 −1。

## **数据范围**
$1≤n,m≤1.5×10^5,$
$图中涉及边长均不小于 0，且不超过 10000。$

## **样例**
```c++
输入样例:
3 3
1 2 2
2 3 1
1 3 4

输出样例：
3
```

## **分析**
大致过程和朴素版一致，但找寻最小距离点用小根堆找

## **模板**
```c++
int g[N][N];  // 存储每条边
int dist[N];  // 存储1号点到每个点的最短距离
bool st[N];   // 存储每个点的最短路是否已经确定

// 求1号点到n号点的最短路，如果不存在则返回-1
int dijkstra()
{
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0;

    for (int i = 0; i < n - 1; i ++ )
    {
        int t = -1;     // 在还未确定最短路的点中，寻找距离最小的点
        for (int j = 1; j <= n; j ++ )
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;

        // 用t更新其他点的距离
        for (int j = 1; j <= n; j ++ )
            dist[j] = min(dist[j], dist[t] + g[t][j]);

        st[t] = true;
    }

    if (dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];
}

```

## **解答**
```c++
#include "bits/stdc++.h"

using namespace std;

typedef pair<int, int> PII;//pair<到源点的距离，节点编号>

const int N = 160000;

int h[N],e[N],ne[N],w[N],idx=0;
bool st[N];//访问过没
int s[N];//确定了最短距离的点
int d[N];//距离集合

int n,m;//n个点,m个边

void add(int a,int b,int c){
    e[idx]=b,w[idx]=c,ne[idx]=h[a],h[a]=idx++;
}

int Dijkstra(){
    memset(d,0x3f,sizeof d);//把距离初始化成无穷
    d[1]=0;//起点到起点距离是0
    priority_queue<PII, vector<PII>, greater<PII>> heap;//小根堆(优先队列)
    heap.push({0,1});

    while(heap.size()){//只要小根堆里没空就继续
        auto t=heap.top();
        heap.pop();
        
        int u=t.first,k=t.second;//u是距离,k是点
        if(st[k]) continue;//如果k这个点已经访问过了，就不访问了
        
        st[k]=true;
        
        //由t来计算出t的邻接点到起点的距离更新
        for (int i = h[k]; i != -1; i = ne[i] ){
            if(d[e[i]]>u+w[i]){
                d[e[i]]=u+w[i];
                heap.push({d[e[i]],e[i]});
                //直接把e[i]点到源点的距离插入堆中，不需要把原来比较远的距离剔除，因为堆之后拿出堆顶元素
            }
        }
    }    
    
    
    
    if(d[n]==0x3f3f3f3f) return -1;//如果找不到路径从起点到终点的话
    return d[n];
}

int main()
{
    memset(h, -1, sizeof h);
    
    scanf("%d%d", &n, &m);
    
    for (int i = 0; i < m; i ++ ){
        int a,b,c;
        scanf("%d%d%d", &a, &b,&c);
        add(a, b, c);
    }
    
    
    printf("%d",Dijkstra());
    return 0;
} 
```