

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int[][] blank;
    static int answer, N, M, B = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        proc();
        output();
    }


    static void proc() {
        /*
        *  배열을 순회하면서 벽을 세울 수 있는 위치를 전부 저장해둔다.
        * */

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (map[i][j] == 0) {
                    B++; // 벽의 개수 증가
                    blank[B][0] = i; // 벽의 좌표 x
                    blank[B][1] = j; // 벽의 좌표 y
                }
            }
        }

        DFS(1, 0);
    }


    static void DFS(int idx, int select_cnt) {

        if (select_cnt == 3) {
            // select_cnt가 3이 되었을 경우 정답을 갱신한다.
            BFS();
            return;
        }

        if (idx > B) return;

        // 벽을 세운다
        map[blank[idx][0]][blank[idx][1]] = 1;
        DFS(idx + 1, select_cnt + 1);

        // 벽을 세우지 않은 경우도 모두 탐색
        map[blank[idx][0]][blank[idx][1]] = 0;
        DFS(idx + 1, select_cnt);
    }

    static void BFS() {

        Queue<Integer> Q = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                // 방문 배열을 초기화
                visit[i][j] = false;
                if (map[i][j] == 2) {
                    // 바이러스가 있는 좌표를 모두 저장
                    Q.offer(i);
                    Q.offer(j);
                    visit[i][j] = true;
                }
            }
        }


        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();


            for (int i=0; i<4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];

                if (x1 < 1 || y1 < 1 || x1 > N || y1 > M) continue;
                if (map[x1][y1] != 0) continue;
                if (visit[x1][y1]) continue;
                visit[x1][y1] = true;
                Q.add(x1);
                Q.add(y1);
            }
        }


        int cnt = 0;

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                // 좌표에 벽이 있을 수도 있으므로 0일때만 카운팅
                if (!visit[i][j] && map[i][j] == 0) cnt++;
            }
        }


        answer = Math.max(cnt, answer);
    }





    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        blank = new int[N * M + 1][2];

        for (int i=1; i<=N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        br.close();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(answer));
        bw.flush();

        bw.close();
    }
 }
