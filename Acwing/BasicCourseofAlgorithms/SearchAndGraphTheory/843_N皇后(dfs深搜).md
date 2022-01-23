## **题目**
n− 皇后问题是指将 n 个皇后放在 n×n 的国际象棋棋盘上，使得皇后不能相互攻击到，即任意两个皇后都不能处于同一行、同一列或同一斜线上。

![](./../../pics/N皇后.png)

现在给定整数 n，请你输出所有的满足条件的棋子摆法。

## **输入格式**
共一行，包含整数 n。

## **输出格式**
每个解决方案占 n 行，每行输出一个长度为 n 的字符串，用来表示完整的棋盘状态。

其中 . 表示某一个位置的方格状态为空，Q 表示某一个位置的方格上摆着皇后。

每个方案输出完成后，输出一个空行。

注意：行末不能有多余空格。

输出方案的顺序任意，只要不重复且没有遗漏即可。

## **数据范围**
$1≤n≤9$

## **输入样例**
```c++
4
```

## **输出样例**
```c++
.Q..
...Q
Q...
..Q.

..Q.
Q...
...Q
.Q..
```

## **解答**
```c++
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 20;

char g[N][N];
bool v[N],vl[N],vr[N];
//v[N]同一列是否存在
//vl[N]同一反对角线
//vr[N]同一正对角线
int n;

void dfs(int u){
    if(u==n) {
        for (int i = 0; i < n; i ++ )
            printf("%s\n",g[i]);
        printf("\n");
        return;
    }
    for (int i = 0; i < n; i ++ ){
        if(v[i]||vl[i+u]||vr[i-u+n]) continue;
        g[u][i]='Q';
        v[i]=vl[i+u]=vr[i-u+n]=true;
        dfs(u+1);
        v[i]=vl[i+u]=vr[i-u+n]=false;
        g[u][i]='.';
    }
}

int main()
{
    scanf("%d", &n);
    
    for (int i = 0; i < n; i ++ )
        for (int j = 0; j < n; j ++ )
            g[i][j]='.';
    
    dfs(0);
    
    return 0;
}
```