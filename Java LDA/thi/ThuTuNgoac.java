package thi;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringJoiner;

public class ThuTuNgoac{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while(t-- >0){
            String s = scanner.nextLine();
            int thuTu = 1;

            StringJoiner result = new StringJoiner(" ");

            for(int i = 0; i < s.length(); i++){
                switch (s.charAt(i)){
                    case '(': 
                        stack.push(thuTu);
                        result.add(Integer.toString(thuTu++));
                        break;
                    case ')': 
                        Integer n = stack.pop();
                        result.add(Integer.toString(n));
                        break;
                    default: break;
                }
            }

            System.out.println(result);
        }

        scanner.close();
    }
}