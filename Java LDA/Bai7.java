import java.util.Arrays;
import java.util.Scanner;

public class Bai7 {
    private static int t;
    private static int n;
    private static double[] a,b;
    private static int[] lis, lds;

    private static int lisMax, ldsMax;
    
    public static void main(String[] args) {
        lis = new int[500];
        lds = new int[500];

        Arrays.fill(lis, 0);
        System.arraycopy(lis, 0, lds, 0, lis.length);
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        
        lisMax = 0;
        ldsMax = 0;

        while(t-- > 0){
            n = scanner.nextInt();
            a = new double[n];
            b = new double[n];
            for(int i = 0; i < n; i++){
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
                lisMax = Math.max(lis(i), lisMax);
                ldsMax = Math.max(lds(i), ldsMax);
            }

            System.out.println(lisMax + "\n" + ldsMax);
        }

        scanner.close();
    }

    private static int lis(int i){
        if(lis[i] != 0) 
            return lis[i];
        
        int result = 1;
        if(i != 0){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]){
                    result = Math.max(lis(j) + 1, result);
                }
            }
        }
        return result;
    }

    private static int lds(int i){
        if(lds[i] != 0) 
            return lds[i];
        
        int result = 1;
        if(i != 0){
            for(int j = 0; j < i; j++){
                if(a[i] < a[j]){
                    result = Math.max(lds(j) + 1, result);
                }
            }
        }
        return result;
    }

}
