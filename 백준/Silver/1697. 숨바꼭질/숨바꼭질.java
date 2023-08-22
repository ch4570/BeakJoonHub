
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, ANSWER;
    static boolean[] visit = new boolean[100002];

    public static void main(String[] args) throws IOException {
        input();
        BFS();
        output();
    }

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();

        Q.offer(N);
        Q.offer(0);
        visit[N] = true;

        while(!Q.isEmpty()) {
            int point = Q.poll();
            int level = Q.poll();

            if (point == K) {
                ANSWER = level;
                break;
            }
            if (point + 1 <= 100000 && !visit[point + 1]) {
                Q.offer(point + 1);
                visit[point + 1] = true;
                Q.offer(level + 1);
            }

            if (point - 1 >= 0 && !visit[point - 1]) {
                Q.offer(point - 1);
                visit[point - 1] = true;
                Q.offer(level + 1);
            }

            if (point * 2 <= 100000 && !visit[point * 2]) {
                Q.offer(point * 2);
                visit[point * 2] = true;
                Q.offer(level + 1);
            }
        }

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ANSWER));
        bw.flush();
    }
}

