
import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] arr = new String[count];

        for (int i=0; i<arr.length; i++) {
            arr[i] = br.readLine();
        }

        bw.write(solution(arr));
        bw.flush();
        br.close();
        bw.close();
    }

    static String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++) {
            String answer = isRight(arr[i]);
            sb.append(answer + "\n");
        }

        return sb.toString();
    }

    static String isRight(String str) {
        Stack<Character> stack = new Stack<>();
        String answer = "YES";
        for (int i=0; i<str.length(); i++) {
            // 여는 괄호를 만나면 넣어준다.
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (stack.empty()) {
                    answer = "NO";
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.empty()) answer = "NO";

        return answer;
    }
}
