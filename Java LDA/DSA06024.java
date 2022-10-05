import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Cho một xâu ký tự str bao gồm nhiều từ trong xâu. Hãy đảo ngược từng từ trong
 * xâu?
 * 
 * Input:
 * 
 * Dòng đầu tiên đưa vào số lượng bộ test T;
 * Những dòng tiếp theo mỗi dòng đưa vào một bộ test. Mỗi bộ test là một dòng
 * ghi lại nhiều từ trong xâu str.
 * Output:
 * 
 * Đưa ra kết quả mỗi test theo từng dòng.
 * Ràng buộc:
 * 
 * T, str thỏa mãn ràng buộc: 1≤T≤100; 2≤length(str)≤106.
 */

public class DSA06024 {
    private static Scanner scanner = new Scanner(System.in);

    private static int t;

    private static StringJoiner resultString = new StringJoiner("\n");

    public static void main(String[] args) {
        t = Integer.parseInt(scanner.nextLine());

        while(t-- > 0){
            StringJoiner sj = new StringJoiner(" ");
            Arrays.asList(scanner.nextLine().split(" ")).stream().forEach(s -> sj.add(new StringBuilder(s).reverse()));
            resultString.add(sj.toString());
        }
        System.out.println(resultString.toString());
    }
}
