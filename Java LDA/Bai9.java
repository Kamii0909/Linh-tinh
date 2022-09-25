import java.util.Arrays;
import java.util.Scanner;

public class Bai9 {
    private static int n;
    private static int x, y, z;
    private static int[] a, b;
    private static int aAdded, bAdded;
    private static int aAddedMax, bAddedMax;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();
        
        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(solve());
        System.out.println(aAddedMax);
        System.out.println(bAddedMax);



        scanner.close();
    }

    private static int solve(){
        int result = n * x;
        int max = result;

        while(true){
            if(aAdded == n) 
                break;
            
            switch(Integer.compare(a[aAdded], b[bAdded])){
                case 1: bAdded++; result += z - y; break;
                case -1: aAdded++; result += y - x; break;
                case 0: aAdded++;  bAdded++; result += z - x; break;
            }
            
            if(max < result){
                max = result;
                aAddedMax = aAdded;
                bAddedMax = bAdded;
            }
        }
        return max;
    }
}
