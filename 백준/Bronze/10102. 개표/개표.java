
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        String s = sc.next();

        System.out.println(solution(s));
    }

    static String solution(String s) {
        Map<Character, Integer> result = new HashMap<>();
        String answer = "";

        for (int i=0; i<s.length(); i++) {
            result.put(s.charAt(i), result.getOrDefault(s.charAt(i), 0) + 1);
        }

        int a = result.get('A') == null ? 0 : result.get('A');
        int b = result.get('B') == null ? 0 : result.get('B');

        if (a > b) {
            answer += "A";
        } else if (b > a) {
            answer += "B";
        } else {
            answer += "Tie";
        }

        return answer;
    }
}
