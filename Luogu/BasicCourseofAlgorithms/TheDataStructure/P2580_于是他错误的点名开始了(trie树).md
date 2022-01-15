题目背景
XS中学化学竞赛组教练是一个酷爱炉石的人。

他会一边搓炉石一边点名以至于有一天他连续点到了某个同学两次，然后正好被路过的校长发现了然后就是一顿欧拉欧拉欧拉（详情请见已结束比赛 CON900）。
## **题目描述**
这之后校长任命你为特派探员，每天记录他的点名。校长会提供化学竞赛学生的人数和名单，而你需要告诉校长他有没有点错名。（为什么不直接不让他玩炉石。）

## **输入格式**
第一行一个整数 nn，表示班上人数。

接下来 nn 行，每行一个字符串表示其名字（互不相同，且只含小写字母，长度不超过 5050）。

第 n+2n+2 行一个整数 mm，表示教练报的名字个数。

接下来 mm 行，每行一个字符串表示教练报的名字（只含小写字母，且长度不超过 5050）。

## **输出格式**
对于每个教练报的名字，输出一行。

如果该名字正确且是第一次出现，输出 OK，如果该名字错误，输出 WRONG，如果该名字正确但不是第一次出现，输出 REPEAT。

## **样例**
### **输入**
```c++
5  
a
b
c
ad
acd
3
a
a
e
```
### **输出**
```c++
OK
REPEAT
WRONG
```

## **说明/提示**
对于 $40\% $的数据，$n\le 1000，m\le 2000$。

对于 $70\% $的数据，$n\le 10^4$，$m\le 2\times 10^4$。

对于 $100\%$ 的数据，$n\le 10^4,m≤10^5。$

## **解答**
```c++
#include <cstdio>

const int N = 1e6 + 10;

int son[N][26], idx = 0;
bool flag[N];
char str[N];

void insert(char* str)
{
    int p = 0;
    for (int i=0;str[i];i++)
    {
        int u = str[i] - 'a';
        if (!son[p][u])
            son[p][u] = ++idx;
        p = son[p][u];
    }
}
//P2580_于是他错误的点名开始了(trie树)
char query(char* str)
{
    int p = 0;
    for (int i=0;str[i];i++)
    {
        int u = str[i] - 'a';
        if (!son[p][u])
            return '0';
        p = son[p][u];
    }
    if (!flag[p])
    {
        flag[p] = 1;
        return '1';
    }
    return '2';
}

int main()
{
    int n;

    scanf("%d", &n);
    while (n--)
    {
        scanf("%s",str);
        insert(str);
    }

    scanf("%d", &n);
    while (n--)
    {
        scanf("%s",str);
        char ch=query(str);
        if (ch == '0')
            printf("WRONG\n");
        else if (ch == '2')
            printf("REPEAT\n");
        else if (ch == '1')
            printf("OK\n");
    }

    return 0;
}
```