## **题目**
给出一个电话列表，如果列表中存在其中一个号码是另一个号码的前缀这一情况，那么就称这个电话列表是不兼容的。

假设电话列表如下：
```c++
Emergency 911
Alice 97 625 999
Bob 91 12 54 26
```
在此例中，报警电话号码（911）为 Bob 电话号码（91 12 54 26）的前缀，所以该列表不兼容。

## **输入格式**
第一行输入整数 t，表示测试用例数量。

对于每个测试用例，第一行输入整数 n，表示电话号码数量。

接下来 n 行，每行输入一个电话号码，号码内数字之间无空格，电话号码不超过 10 位。

## **输出格式**
对于每个测试用例，如果电话列表兼容，则输出 YES。

否则，输出 NO。

## **数据范围**
$1≤t≤40,$

$1≤n≤10000$

## **输入样例**
```c++
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346
```

## **输出样例**
```c++
NO
YES
```

## **解答**
```c++
#include<iostream>
#include<algorithm>
#include<cstring>
#include<unordered_map>

using namespace std;

const int N=100010;
string str[N];
int cnt[N];
int son[N][10],idx;

void add(string a)
{
    int p=0;
    for(int i=0;i<a.size();i++)
    {
        int k=a[i]-'0';
        if(!son[p][k]) son[p][k]=++idx;
        p=son[p][k];
    }
    cnt[p]++;
}

bool query(string a)
{
    int p=0;
    for(int i=0;i<a.size();i++)
    {
        int k=a[i]-'0';
        if(cnt[p]) return 1;//查询前缀有一样的
        p=son[p][k];
    }
    if(cnt[p]>=2) return 1;//查询两个字符串一样
    return 0;
}

int main()
{
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(0);
    
    int T;
    cin>>T;
    while(T--)
    {
        idx=0;//注意初始化 要不然会段错误
        memset(cnt,0,sizeof cnt);
        memset(son,0,sizeof son);
        int n;
        cin>>n;
        bool flag=true;
        for(int i=1;i<=n;i++)
        {
            cin>>str[i];
            add(str[i]);
        }
        for(int i=1;i<=n;i++)
        {
            if(query(str[i]))
            {
                flag=false;
                break;
            }
        }
        if(flag) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }
}
```