package thi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bai5 {

    private static int n;
    private static String[] names;
    private static String lastOne;
    private static boolean[] available;
    private static int[] printed;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        List<String> nameList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        nameList.sort((a, b) -> a.compareTo(b));

        lastOne = scanner.nextLine();
        
        available = new boolean[n - 1];
        Arrays.fill(available, Boolean.valueOf(true));

        nameList.remove(lastOne);
        names = nameList.toArray(new String[n]);

        printed = new int[n];

        printAll(names, 0);

        scanner.close();

    }

    private static void printAll(String[] names, int curr){
        
        for(int i = 0; i < n - 1; i++){
            if(available[i] == true){

                printed[curr] = i;

                if(curr == n - 2){
                    print(printed);
                }
                else{
                    available[i] = false;
                    printAll(names, curr + 1);
                    available[i] = true;
                }
            }
        }
    }

    private static void print(int[] index) {
        for(int i = 0; i< n - 1; i++){
            System.out.print(names[index[i]] + " ");
        }
        System.out.print(lastOne + "\n");
    }
}
