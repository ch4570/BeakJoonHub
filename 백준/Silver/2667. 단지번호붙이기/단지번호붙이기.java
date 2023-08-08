
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int N, GROUND;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    GROUND++;
                    DFS(i, j);
                    answer.add(GROUND);
                    GROUND = 0;
                }
            }
        }
    }

    static void DFS(int x, int y) {

        for (int i=0; i<4; i++) {
            int lx = x + dx[i];
            int ly = y + dy[i];

            if (lx >= 0 && lx < N && ly >= 0 && ly < N && board[lx][ly] == 1) {
                board[lx][ly] = 0;
                GROUND++;
                DFS(lx, ly);
            }
        }

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        board = new int[N][N];

        for (int i=0; i<N; i++) {
            String map = br.readLine();
            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(map.charAt(j)));
            }
        }

    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Collections.sort(answer);

        sb.append(answer.size()).append("\n");
        for (int x : answer) sb.append(x).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }


}
