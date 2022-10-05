import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SinhVien {

    private static Scanner scanner;
    private static int n;


    private static int maSV;
    private static String hoTen;
    private static String lop;
    private static LocalDate ngaySinh;
    private static double gpa;

    private static DateTimeFormatter formatter;
    private static StringJoiner resultJoiner;

    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        resultJoiner = new StringJoiner("\n");


        n = scanner.nextInt(); scanner.nextLine();


        for(maSV = 1 ;maSV <= n; maSV++){
            input();
            output();
        }

        System.out.println(resultJoiner);

        scanner.close();
    }

    private static LocalDate parseTime(String string){
        int[] a = Stream.of(string.split("[\\D]+")).mapToInt(s -> Integer.parseInt(s)).toArray();
        return LocalDate.of(a[2], a[1], a[0]);
    }

    private static String parseName(String string){
        return Stream.of(string.trim().split("[ ]+"))
            .<String> map(s ->
                s.toLowerCase()
                .replaceFirst(".", s.substring(0,1).toUpperCase()))
            .collect(Collectors.joining(" "));
    }

    private static void input(){
        hoTen = parseName(scanner.nextLine());
        lop = scanner.nextLine();
        ngaySinh = parseTime(scanner.nextLine());
        gpa = scanner.nextDouble(); scanner.nextLine();
    }

    private static void output(){
        resultJoiner.add(
            new StringJoiner(" ")
            .add("B20DCCN" + String.format("%03d", maSV))
            .add(hoTen)
            .add(lop)
            .add(formatter.format(ngaySinh))
            .add(String.format("%.2f", gpa))
            .toString()
            );
    }
}
