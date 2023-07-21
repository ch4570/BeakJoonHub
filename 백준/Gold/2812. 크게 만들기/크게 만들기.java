import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);
        String number = br.readLine();

        System.out.println(solution(N, K, number));
    }

    static String solution(int N, int K, String number) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        // 숫자의 길이를 카운팅하는 변수
        int count = 0;
        // 숫자가 전부 들어가지 않았을때, Stack에 push 해주기위해 만든 변수
        int i;

        for (i=0; i<number.length(); i++) {
                // Stack이 비어있지 않고, number.charAt(i)가 Stack의 맨 위 자료보다 클때까지 pop을 수행
                while (!stack.isEmpty() && (number.charAt(i) - 48) > (stack.peek() - 48) && count < K) {
                    stack.pop();
                    // 카운트 증가
                    count++;
                }

            // pop이 끝나고나면 stack에 현재 위치의 문자를 넣어준다.
            stack.push(number.charAt(i));
            // 삭제하려고 한 숫자의 개수만큼 삭제하면 반복문 종료
            if (count == K) break;
        }

        // 스택의 사이즈가 만들려고 한 숫자의 길이보다 작으면, 숫자가 덜 push 되었다는 뜻
        if (stack.size() < (N - K)) {
            // 숫자가 덜 들어갔을 경우 덜 들어간 길이만큼 스택에 다시 넣어준다.
            for (int k=i+1; k<number.length(); k++) {
                stack.push(number.charAt(k));
            }
        }

        /*
        *   스택의 사이즈가 숫자의 길이보다 크다면, 숫자의 삭제가 앞에서 이루어지지 않았으므로
        *   길이가 더 긴만큼 스택에서 pop을 해준다.
        * */
        if (stack.size() > (N - K)) {
            while (stack.size() > (N-K)) stack.pop();
        }

        for (int j=0; j<stack.size(); j++)
            builder.append(stack.get(j));

        return builder.toString();
    }
}
