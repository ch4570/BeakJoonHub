
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        input();
        BFS();
        System.out.println(map[N][M]);
    }

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        Q.add(1);

        while (!Q.isEmpty()) {

            int x = Q.poll();
            int y = Q.poll();

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (map[nx][ny] != 1) continue;
                map[nx][ny] = map[x][y] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        map = new int[N + 1][M + 1];

        for (int i=1; i<=N; i++) {
            String line = br.readLine();
            for (int j=1; j<=M; j++) {
                map[i][j] = line.charAt(j - 1) - 48;
            }
        }

    }
}
