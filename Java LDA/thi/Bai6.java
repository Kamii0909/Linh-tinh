package thi;
import java.util.Arrays;
import java.util.Scanner;

public class Bai6 {
    private static int[] fib;
    private static int[][] func;
    private static int t, n, k;

    public static void main(String[] args){
        fib = new int[45];
        func = new int[45][45];

        Arrays.fill(fib, 0);
        for(int[] x: func){
            Arrays.fill(x, -1);
        }

        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        while(t-- > 0) {
            k = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println(func(k, n));
        }

        scanner.close();
    }

    private static int fib(int n){
        if(fib[n] != 0) return fib[n];
        int result;
        if(n < 2) 
            result = 1;
        else 
            result =  fib(n - 1) + fib(n - 2);
        fib[n] = result;
        return result;
    }

    private static int func(int k, int n){
        if(k >= 0 && k <= fib(n) && func[k][n] != -1)
            return func[k][n];
        int result;
        if(k <= 0) {
            k = 0;
            result = 0;
        }
        else if(k > fib(n)) {
            k = fib(n);
            result = func(fib(n), n);
        }
        else {
            if(n < 1) result = 0;
            else if(n == 1) result = 1;
            else result = func(k, n - 1) + func(k - fib(n-1), n - 2);
        }

        func[k][n] = result;
        return result;
    }

}
