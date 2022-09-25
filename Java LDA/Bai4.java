
import java.util.*;

public class Bai4{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //n = so bo test
        int t = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> arr = new ArrayList<>();
            for(int j = 0; j < n; j++){
                arr.add(scanner.nextInt());
            }
            scanner.nextLine();
            System.out.println(rank(arr));
        }

        scanner.close();

    }

    private static int rank(List<Integer> list){
        int rank = 1;
        List<Integer> order = new ArrayList<>(list);
        Collections.sort(order);

        while(!list.isEmpty()){
            rank += order.indexOf(list.get(0)) * fact(list.size() - 1);
            order.remove(list.get(0));
            list.remove(0);
        }
        
        
        return rank;

    }


    private static int fact(int n){
        if(n < 2) return 1;
        return fact(n - 1) *n ;
    }

        
}