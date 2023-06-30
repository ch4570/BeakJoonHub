import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        System.out.println(solution(word));
    }

    static String solution(String s) {

        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i<sb.length(); i++) {
            if (Character.isLowerCase(sb.charAt(i))) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            } else {
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            }
        }

        return sb.toString();
    }
}