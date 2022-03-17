---
title: 1113-红与黑
author: Bob
top: true
toc: true
mathjax: true
categories: 算法
tags:
  - Acwing
date: 2022-03-02 14:38:00
summary:
abbrlink:
---
题目来源于[Acwing](https://www.acwing.com/),感谢y总。

## 题目
有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。

你站在其中一块黑色的瓷砖上，只能向相邻（上下左右四个方向）的黑色瓷砖移动。

请写一个程序，计算你总共能够到达多少块黑色的瓷砖。

## 输入格式
输入包括多个数据集合。

每个数据集合的第一行是两个整数 `W 和 H`，分别表示 `x` 方向和 `y` 方向瓷砖的数量。

在接下来的 `H` 行中，每行包括 `W` 个字符。每个字符表示一块瓷砖的颜色，规则如下
- 1）‘.’：黑色的瓷砖；
- 2）‘#’：红色的瓷砖；
- 3）‘@’：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。

当在一行中读入的是两个零时，表示输入结束。

## 输出格式
对每个数据集合，分别输出一行，显示你从初始位置出发能到达的瓷砖数(记数时包括初始位置的瓷砖)。

## 数据范围
$1≤W,H≤20$

## 样例
```c++
输入样例：
6 9 
....#. 
.....# 
...... 
...... 
...... 
...... 
...... 
#@...# 
.#..#. 
0 0
输出样例：
45
```

## 分析
dfs和bfs，每向前一次就距离加一

## 解答
#### dfs
```c++
#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

#define x first
#define y second

using namespace std;

typedef pair<int, int> PII;

const int N = 25;

char g[N][N];
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
int ans;

void dfs(PII start)
{
    g[start.x][start.y]='#';
    ans++;
    
    for (int i = 0; i < 4; i ++ )
    {
        int a=start.x+dx[i],b=start.y+dy[i];
        if(g[a][b]!='#')
        {
            dfs({a,b});
        }
    }
}
int main()
{
    int w,h;
    
    while(scanf("%d%d",&w,&h))
    {
        if(w==0&&h==0) return 0;
        
        ans=0;
        memset(g,'#',sizeof g);
        
        PII start;
        for (int i = 1; i <= h; i ++ )
            for (int j = 1; j <= w; j ++ )
            {
                cin>>g[i][j];
                if(g[i][j]=='@')
                {
                    start.x=i;
                    start.y=j;
                }
            }
            
        dfs(start);
        printf("%d\n",ans);
    }
    
    return 0;
}
```
#### bfs
```c++
#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

#define x first
#define y second

using namespace std;

typedef pair<int, int> PII;

const int N = 25;

char g[N][N];
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
int ans;

void dfs(PII start)
{
    g[start.x][start.y]='#';
    ans++;
    
    for (int i = 0; i < 4; i ++ )
    {
        int a=start.x+dx[i],b=start.y+dy[i];
        if(g[a][b]!='#')
        {
            dfs({a,b});
        }
    }
}
int main()
{
    int w,h;
    
    while(scanf("%d%d",&w,&h))
    {
        if(w==0&&h==0) return 0;
        
        ans=0;
        memset(g,'#',sizeof g);
        
        PII start;
        for (int i = 1; i <= h; i ++ )
            for (int j = 1; j <= w; j ++ )
            {
                cin>>g[i][j];
                if(g[i][j]=='@')
                {
                    start.x=i;
                    start.y=j;
                }
            }
            
        dfs(start);
        printf("%d\n",ans);
    }
    
    return 0;
}
```