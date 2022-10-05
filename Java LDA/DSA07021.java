import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * Cho một xâu chỉ gồm các kí tự ‘(‘ và ‘)’. Một dãy ngoặc đúng được định nghĩa
 * như sau:
 * 
 * - Xâu rỗng là 1 dãy ngoặc đúng.
 * 
 * - Nếu A là 1 dãy ngoặc đúng thì (A) là 1 dãy ngoặc đúng.
 * 
 * - Nếu A và B là 2 dãy ngoặc đúng thì AB là 1 dãy ngoặc đúng.
 * 
 * Cho một xâu S. Nhiệm vụ của bạn là hãy tìm dãy ngoặc đúng dài nhất xuất hiện
 * trong xâu đã cho.
 * 
 * Input: Dòng đầu tiên là số lượng bộ test T (T ≤ 20).
 * 
 * Mỗi test gồm một xâu S có độ dài không vượt quá 105 kí tự.
 * 
 * Output: Với mỗi test in ra một số nguyên là độ dài dãy ngoặc đúng dài nhất
 * tìm được.
 */
public class DSA07021 {
    private static Scanner scanner = new Scanner(System.in);

    private static int t;

    private static StringJoiner resultString = new StringJoiner("\n");

    public static void main(String[] args) {
        t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String s = scanner.nextLine();
            if(s.isEmpty()){
                resultString.add(Integer.toString(0));
                continue;
            }
            TreeMap<Integer, Integer> map = new TreeMap<>((x, y) -> Integer.compare(x, y));

            int index = s.indexOf(')', 1);

            if (index == -1) {
                resultString.add(Integer.toString(0));
                continue;
            } else {
                if (s.charAt(index - 1) == '(')
                    map.put(index, 2);
            }

            while (true) {
                index = s.indexOf(')', index + 1);
                if (index == -1)
                    break;
                if (map.lastKey() == index - 1) {
                    if (s.charAt(map.lastEntry().getValue()) == '(')
                        map.put(index, map.lastEntry().getValue() + 2);
                } else if (map.lastKey() == index - 2) {
                    map.put(index, map.lastEntry().getValue() + 2);
                } else
                    map.put(index, 2);
            }
            resultString.add(Integer.toString(map.values().stream().max((x, y) -> Integer.compare(x, y)).get()));
        }

        System.out.println(resultString);
        scanner.close();
    }
}
