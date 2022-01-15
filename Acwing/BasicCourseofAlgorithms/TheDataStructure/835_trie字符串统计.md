## **题目**
维护一个字符串集合，支持两种操作：

1. “I x”向集合中插入一个字符串x；
2. “Q x”询问一个字符串在集合中出现了多少次。

共有N个操作，输入的字符串总长度不超过 $10^5$，字符串仅包含小写英文字母。

## **输入格式**

第一行包含整数N，表示操作数。

接下来N行，每行包含一个操作指令，指令为”I x”或”Q x”中的一种。

## **输出格式**

对于每个询问指令”Q x”，都要输出一个整数作为结果，表示x在集合中出现的次数。

每个结果占一行。

## **数据范围**

$1 ≤ N ≤ 2 ∗ 10^4$

## **输入样例**
```c++
5
I abc
Q abc
Q ab
I ab
Q ab
```

## **输出样例**
```c++
1
0
1

```

## **模板**
```c++

```
## **解答** 
```c++
#include <iostream>

using namespace std;

const int N = 100010;
//son[][]存储子节点的位置，分支最多26条；
//cnt[]存储以某节点结尾的字符串个数（同时也起标记作用）
//idx表示当前要插入的节点是第几个,每创建一个节点值+1
int son[N][26], cnt[N], idx;
char str[N];

void insert(char *str)
{
    int p = 0;  //类似指针，指向当前节点
    for(int i = 0; str[i]; i++)
    {
        int u = str[i] - 'a'; //将字母转化为数字
        if(!son[p][u]) son[p][u] = ++idx;   //该节点不存在，创建节点
        p = son[p][u];  //使“p指针”指向下一个节点
    }
    cnt[p]++;  //结束时的标记，也是记录以此节点结束的字符串个数
}

int query(char *str)
{
    int p = 0;
    for(int i = 0; str[i]; i++)
    {
        int u = str[i] - 'a';
        if(!son[p][u]) return 0;  //该节点不存在，即该字符串不存在
        p = son[p][u]; 
    }
    return cnt[p];  //返回字符串出现的次数
}

int main()
{
    int m;
    cin >> m;

    while(m--)
    {
        char op[2];
        scanf("%s%s", &op, &str);

        if(*op == 'I') insert(str);
        else printf("%d\n", query(str));
    }

    return 0;
}
```