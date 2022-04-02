#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 5e4+10,K=1e5+10;

int p[N][2];
bool f[N];

int find(int x){
    if(p[x][0]!=x) p[x]=find(p[x][0]);
    return p[x];
}

int main()
{
    int n,k;
    scanf("%d%d", &n,&k);
    
    for (int i = 1; i <= n; i ++ ) p[i]=i;
    
    int d,x,y;
    int res=0;
    while(k--){
        scanf("%d%d%d", &d,&x,&y);
        if(x>n||y>n){
            res++;
            continue;
        }
        if(d==1){
            p[find(x)]=find(y);
        }else if(d==2){
            if(p[find(x)]==p[find(y)]) res++;
        }
    }
    
    printf("%d",res);
    return 0;
}