
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder builder = new StringBuilder();
    static int N, M;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        input();
        DFS(0);
        output();
    }


    private static void DFS(int L) {
        if (L == M) {
            for (int number : answer) builder.append(number).append(" ");
            builder.append("\n");
            return;
        }

        for (int i=1; i<=N; i++) {
            if (L == 0) {
                answer[L] = i;
                DFS(L + 1);
            } else {
                if (answer[L - 1] < i) {
                    answer[L] = i;
                    DFS(L + 1);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        answer = new int[M];
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(builder.toString());
        bw.flush();
    }
}
