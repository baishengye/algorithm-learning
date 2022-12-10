## **题目**
在给定的 N 个整数 $A_1，A_2……A_N$ 中选出两个进行 xor（异或）运算，得到的结果最大是多少？

## **输入格式**
第一行输入一个整数 N。

第二行输入 N 个整数 A1～AN。

## **输出格式**
输出一个整数表示答案。

## **数据范围**
$1≤N≤105,$
$0≤A_i<231$

## **输入样例**
```c++
3
1 2 3
```

## **输出样例**
```c++
3
```

## **解答**
```c++
#include <iostream>
#include <cstring>
#include <algorithm>
#include <climits>

using namespace std;

const int N = 100010;

int son[N*31][2],idx=0;
int a[N];

void insert(int x)  // 插入字符串
{
    int p = 0;
    for (int i = 30; ~i ; i -- )
    {
        int u=x>>i&1;
        if (!son[p][u]) son[p][u] = ++ idx;
        p = son[p][u];
    }
}

int query(int x){
    int p=0,res=0;
    for(int i=30;~i;i--){
        int u=x>>i&1;
        if(son[p][!u]){
            res+=1<<i;//1左移i个就是对应的那位贡献的值
            p=son[p][!u];
        }else
            p=son[p][u];
    }
    return res;
}

int main()
{
    int n;
    scanf("%d", &n);
    
    for (int i = 1; i <= n; i ++ ){
        scanf("%d", a+i);
        insert(a[i]);
    }
    
    int res=INT_MIN;
    for(int i=1;i<=n;i++)
        res=max(res,query(a[i]));
        
    printf("%d\n",res);
        
    return 0;
}
```