
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println(solution(number));
    }

    static int solution(int number) {

        int cnt = 0;
        int rt = 0;
        int lt = 0;

        List<Integer> prime = getPrimeNumbers(number);

        if (number < 2) {
            return 0;
        }
        
        int sum = prime.get(rt);
        while (rt < prime.size() && lt < prime.size()) {

            if (sum == number) {
                cnt++;
                sum -= prime.get(lt++);
            } else if (sum > number) {
                sum -= prime.get(lt++);
            } else {
                rt++;
                if (rt >= prime.size()) break;
                sum += prime.get(rt);
            }
        }

        return cnt;

    }

    static List<Integer> getPrimeNumbers(int number) {

        List<Integer> primeNumbers = new ArrayList<>();

        for (int i=2; i<=number; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }


        return primeNumbers;
    }

    static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i=2; i<=sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
