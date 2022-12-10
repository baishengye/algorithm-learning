import java.util.Scanner;

public class T785_quickSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        q_sort(a,0,n-1);

        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%d ", a[i]));
        }
    }

    private static void q_sort(int[] a, int l, int r) {
        if(l>=r) return;

        int i=l-1,j=r+1,x=a[((r-l)>>1)+l];
        while(i<j){
            do i++;while(a[i]<x);
            do j--;while(a[j]>x);
            if(i<j){
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }

        q_sort(a, l, j);
        q_sort(a, j+1, r);
    }
}