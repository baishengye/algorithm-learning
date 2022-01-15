/*## 题目描述

维护一个集合，支持如下几种操作：

- “I x”，插入一个数x；
- “Q x”，询问数x是否在集合中出现过；

现在要进行N次操作，对于每个询问操作输出对应的结果。

## **输入格式**

第一行包含整数N，表示操作数量。

接下来N行，每行包含一个操作指令，操作指令为”I x”，”Q x”中的一种。

##  **输出格式**

对于每个询问指令“Q x”，输出一个询问结果，如果x在集合中出现过，则输出“Yes”，否则输出“No”。

每个结果占一行。

## **数据范围**

$1≤N≤10^5$

$−10^9≤x≤10^9$

## **输入样例**
```c++
5
I 1
I 2
I 3
Q 2
Q 5
```

## **输出样例**
```c++
Yes
No
```
## **模板**
### **拉链法**
```c++
    int h[N], e[N], ne[N], idx;
    //h[N]是指余数为k的拉链的表头下标为h[k],
    //e[N]是指数组中下标为k的地方存放着链表的val
    //ne[N]是指下标为k的点的next节点的下标为ne[k]

    // 向哈希表中插入一个数
    void insert(int x)
    {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx ++ ;
    }

    // 在哈希表中查询某个数是否存在
    bool find(int x)
    {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i])
            if (e[i] == x)
                return true;

        return false;
    }
```
### **开放寻址法**
```c++
    int h[N];

    // 如果x在哈希表中，返回x的下标；如果x不在哈希表中，返回x应该插入的位置
    int find(int x)
    {
        int t = (x % N + N) % N;
        while (h[t] != null && h[t] != x)
        {
            t ++ ;
            if (t == N) t = 0;
        }
        return t;
    }
```

## **解答**
### **拉链法**
```c++
#include "bits/stdc++.h"

using namespace std;

const int N = 1e5 + 10;//这个值应该是大于的第一个质数2e5

int h[N], e[N], ne[N], idx = 0;
//h[N]是指余数为k的拉链的表头下标为h[k],
//e[N]是指数组中下标为k的地方存放着链表的val
//ne[N]是指下标为k的点的next节点的下标为ne[k]

int n;

void insert(int x)
{
    int t = (x % n + n) % n; //数学上的%结果一定是负数，c++上的则不一定，所以需要把%的结果一定变成正数
    e[idx] = x;
    ne[idx] = h[t];
    h[t] = idx;
}

bool query(int x)
{
    int t = (x % n + n) % n;

    for (int i = h[t]; i != -1; i = ne[i])
        if (e[i] == x)
            return true;

    return false;
}

int main()
{
    int t;
    scanf("%d", &n);
    t = n;

    memset(ne, -1, N);
    memset(h, -1, sizeof h);

    char ch[2];
    int x;
    while (t--)
    {
        scanf("%s%d", ch, &x);
        if (ch[0] == 'I')
        {
            insert(x);
        }
        else if (ch[0] == 'Q')
        {
            bool f = query(x);
            if (f)
                puts("Yes");
            else
                puts("No");
        }
    }
    return 0;
}
```

### **开放寻址法**
```c++
#include "bits/stdc++.h"

using namespace std;

//开放寻址法需要的数组空间大约是原数组空间的2~3倍
const int N = 2e5 + 3; //这个值应该是大于的第一个质数2e5

int h[N], null = 0x3f3f3f3f; 
//把null规定成一个大于数据范围的值，如果数组中遍历到这个null就表示数组中第一个没有x的空位是这个。

int n;

int find(int x)
{
    int t = (x % n + n) % n;

    while (h[t] != null && h[t] != x)
    { //找到坑位是空的或者自己已经在坑位里了
        t++;
        if (t == N)
            return 0; 
            //模拟找坑位，从第i个开始找坑，一直找到最后一个坑位也没找着，就又从第一个开始找
    }
    return t;
}

int main()
{
    int t;
    scanf("%d", &n);
    t = n;

    memset(h, 0x3f, N);
    //memset是按字节来填充的，一个int是4B,所以每个B都填充0x3f,4个就相当于0x3f3f3f3f了

    char ch[2];
    int x;
    while (t--)
    {
        scanf("%s%d", ch, &x);

        int k = find(x);
        if (ch[0] == 'I')
            h[k] = x;
        else if (ch[0] == 'Q')
        {
            bool f = h[k] == x ? 1 : 0;
            if (f)
                puts("Yes");
            else
                puts("No");
        }
    }
    return 0;
}
```