import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal A = sc.nextBigDecimal();
        BigDecimal B = sc.nextBigDecimal();

        System.out.println(A.add(B));
    }
}