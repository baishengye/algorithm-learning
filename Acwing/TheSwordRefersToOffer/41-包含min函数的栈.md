---
title: 41-包含min函数的栈
author: Bob
top: true
toc: true
mathjax: true
categories: 算法
tags:
  - Acwing
date: 2022-03-11 23:34:41
summary:
abbrlink:
---
题目来源于[Acwing](https://www.acwing.com/),感谢y总。

## 题目
设计一个支持push，pop，top等操作并且可以在O(1)时间内检索出最小元素的堆栈。
- push(x)–将元素x插入栈中
- pop()–移除栈顶元素
- top()–得到栈顶元素
- getMin()–得到栈中最小元素


## 数据范围
操作命令总数 `[0,100]`。

## 样例
```java
MinStack minStack = new MinStack();
minStack.push(-1);
minStack.push(3);
minStack.push(-4);
minStack.getMin();   --> Returns -4.
minStack.pop();
minStack.top();      --> Returns 3.
minStack.getMin();   --> Returns -1.
```

## 分析
```java
弄一个数据栈和一个单调栈
想要进入单调栈就必须要比栈顶元素还要小才能入栈
然后获取最小值的时候直接查询单调栈顶就可
```

## 解答
```java

class MinStack {

    /** initialize your data structure here. */
    public Deque<Integer> stk;
    public Deque<Integer> stkMin;
    
    public MinStack() {
        stk=new ArrayDeque<>();
        stkMin=new ArrayDeque<>();
    }
    
    public void push(int x) {
        stk.push(x);
        if(stkMin.isEmpty() || stkMin.peek()>=x)
            stkMin.push(x);
    }
    
    public void pop() {
        if(stk.peek()==stkMin.peek())
            stkMin.pop();
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return stkMin.peek();
    }
}
```
