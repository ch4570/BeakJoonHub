
import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        bw.write(solution(numbers));
        bw.flush();
        bw.close();
        br.close();

    }

    static String solution(String[] numbers) {
        Stack<Top> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        stack.push(new Top(Integer.parseInt(numbers[0]), 1));
        answer.append(0).append(" ");

        for (int i=1; i<numbers.length; i++) {
            Top top = new Top(Integer.parseInt(numbers[i]), (i+1));

            if (stack.peek().height >= top.height) {
                answer.append(stack.peek().order).append(" ");
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek().height >= top.height) {
                        answer.append(stack.peek().order).append(" ");
                        break;
                    }

                    stack.pop();
                }

                if (stack.isEmpty()) answer.append(0).append(" ");
            }

            stack.push(top);
        }

        return answer.toString();
    }

}

class Top {
    int height;
    int order;

    Top(int height, int order) {
        this.height = height;
        this.order = order;
    }
}


