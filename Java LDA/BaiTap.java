import java.text.NumberFormat;
import java.util.Scanner;

public class BaiTap {
    private static final int DIEM_CHUAN = 24; 
    private static final String[] BANG_DIEM_UU_TIEN = new String[]{null, "0.5", "1.0", "2.5"};

    private static String maThiSinh;
    private static String hoTen;
    private static double tongDiem;
    private static NumberFormat formatter;

    public static void main(String[] args) {
        formatter = NumberFormat.getInstance();

        formatter.setMaximumFractionDigits(1);
        formatter.setMinimumIntegerDigits(0);

        java.util.Scanner scanner = new Scanner(System.in);

        maThiSinh = scanner.nextLine();
        hoTen = scanner.nextLine();
        tongDiem = scanner.nextDouble() * 2 + scanner.nextDouble() + scanner.nextDouble();

        scanner.close();

        inThiSinh();
    }

    private static void inThiSinh(){
        String ketQua = tongDiem >= DIEM_CHUAN ? "TRUOT" : "TRUNG TUYEN";
        System.out.println(
            maThiSinh + " "
            + hoTen + " "
            + BANG_DIEM_UU_TIEN[maThiSinh.charAt(2) - '0'] + " "
            + formatter.format(tongDiem) + " "
            + ketQua);
    }
}
