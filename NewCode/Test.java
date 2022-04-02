import java.util.Arrays;
import java.util.Scanner;

/**
 * Test
 */
public class Test {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int[] a=new int[n+10];
            for (int i = 0; i < n ; i++) {
                a[i]=sc.nextInt();
            }

            Arrays.sort(a,0,n);
            
            boolean flag=false;
            for (int i = 0; i < n; i ++) {
                for (int j = 0; a[j] < a[i]/2; j++) {
                    for (int k = 0; a[k] < a[i]; k++) {
                        if(i!=j&&j!=k&&a[i]==a[j]*2+a[k]){
                            System.out.println(a[i]+" "+a[j]+" "+a[k]);
                            flag=true;
                        }
                            
                    }
                }
            }

            if(!flag) System.out.println(0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}