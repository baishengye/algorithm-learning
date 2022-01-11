# 算法学习记录
Acwing:基础的学习

LeetCode:对Acwing中学习内容的复习
&nbsp; 
&nbsp;
&nbsp;
## 由数据范围反推算法复杂度以及算法内容
一般ACM或者笔试题的时间限制是1秒或2秒。

在这种情况下，C++代码中的操作次数控制在 $10^7∼10^8$ 为最佳。

下面给出在不同数据范围下，代码的时间复杂度和算法该如何选择：

1. $n≤30n≤30,$ 指数级别, dfs+剪枝，状态压缩dp
&nbsp;
2. $n≤100n≤100$ => $O(n^3)O(n^3)$，floyd，dp，高斯消元
&nbsp;
3. $n≤1000n≤1000$ => $O(n^2)O(n^2)，O(n^2logn)O(n^2logn)$，dp，二分，朴素版Dijkstra、朴素版Prim、Bellman-Ford$
&nbsp;
4. $n≤10000n≤10000$ => $O(n∗n√)O(n∗n)$，块状链表、分块、莫队$
&nbsp;
5. $n≤100000n≤100000$ => $O(nlogn)O(nlogn) $=> 各种sort，线段树、树状数组、set/map、heap、拓扑排序、dijkstra+heap、prim+heap、Kruskal、spfa、求凸包、求半平面交、二分、CDQ分治、整体二分、后缀数组、树链剖分、动态树
&nbsp;
6. $n≤1000000n≤1000000$ => $O(n)O(n)$, 以及常数较小的 $O(nlogn)O(nlogn)$ 算法 => 单调队列、 hash、双指针扫描、并查集，kmp、AC自动机，常数比较小的 $O(nlogn)O(nlogn)$ 的做法：sort、树状数组、heap、dijkstra、spfa
&nbsp;
7. $n≤10000000n≤10000000$ => $O(n)O(n)$，双指针扫描、kmp、AC自动机、线性筛素数
&nbsp;
8. $n≤109n≤109$ => $O(\sqrt{n})O(n)$，判断质数
&nbsp;
9. $n≤1018n≤1018$ => $O(logn)O(logn)$，最大公约数，快速幂，数位DP
&nbsp;
10. $n≤101000n≤101000$ => $O((logn)2)O((logn)2)$，高精度加减乘除
&nbsp;
11. $n≤10^100000n≤10^100000$ => $O(logk×loglogk)$，k表示位数$O(logk×loglogk)$，k表示位数，高精度加减、FFT/NTT

&nbsp; 
&nbsp;
&nbsp;

## 输入输出加速
输入尽量用scanf(),输出尽量用printf(),
如果一定想用cin和cout,那么在程序开头加上
```c++
cin.tie(0);
ios::sync_with_stdio(false);
cout.tie(0);
```
但是加上之后是无法使用printf()和scanf()的。