#include "bits/stdc++.h"

using namespace std;

const int N = 1e5;

#define l first
#define r second


typedef pair<int, int> PII;

int nums[N];
int num;

// 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用：
int bsearch_1(int l, int r)
{
    while (l < r)
    {
        int mid = (l + r) >> 1;
        if (nums[mid]>=num) r = mid;    // check()判断mid是否满足性质
        else l = mid + 1;
    }
    return r;
}
// 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用：
int bsearch_2(int l, int r)
{
    while (l < r)
    {
        int mid = (l + r + 1) >> 1;
        if (nums[mid]<=num) l = mid;
        else r = mid - 1;
    }
    return r;
}

int main()
{
    int n,q;
    int l,r;
    while(~scanf("%d%d",&n,&q)){
        for(int i=0;i<n;i++)
            cin>>nums[i];
        
        for(int i=0;i<q;i++){
            cin>>num;
            l=bsearch_1(0,n-1);
            if(nums[l]!=num){
                cout<<"-1 -1"<<endl;
            }else{
                r=bsearch_2(0,n-1);
                cout<<l<<" "<<r<<endl;
            }
        }
    }
    return 0;
}