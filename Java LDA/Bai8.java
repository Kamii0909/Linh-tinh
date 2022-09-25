import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class Bai8 {
    private static int[] s;
    private static int m;
    private static int[][] check;

    public static void main(String[] args) {
        Reader reader = new InputStreamReader(System.in);

        s = new int[5000];
        int i = 0;
        int t;



        try {
            while(true){
                t = reader.read();
                if(t == 10) {
                    reader = null;
                    break;
                }
                else {
                    s[++i] = t - 48;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        check = new int[i + 1][i + 1];

        for(int[] x: check){
            Arrays.fill(x, -1);
        }

        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();

        while(m-- > 0){
            String string = check(scanner.nextInt(), scanner.nextInt()) == 1 ? "YES" : "NO";
            System.out.println(string);
        }


        scanner.close();
    }

    private static int check(int l, int r){
        if(check[l][r] != -1) 
            return check[l][r];
        int result;
        if( r - l < 1) result = 1;
        else if(s[l] == s[r]){
            result = check(l + 1, r - 1);
        }
        else result = 0;
        check[l][r] = result;
        return result;
    }
}
