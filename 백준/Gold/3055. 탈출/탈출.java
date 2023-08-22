

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] hedgehog, distWater;
    static String[][] map;
    static int R, C;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        waterBFS();
        hedgeHogBFS();


        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j].equals("D")) {
                    if (hedgehog[i][j] == -1) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(hedgehog[i][j]);
                    }
                }
            }
        }
    }

    static void hedgeHogBFS() {

        Queue<Integer> Q = new LinkedList<>();

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j].equals("S")) {
                    hedgehog[i][j] = 0;
                    visit[i][j] = true;
                    Q.offer(i);
                    Q.offer(j);
                } else {
                    hedgehog[i][j] = -1;
                    visit[i][j] = false;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (!map[nx][ny].equals(".") && !map[nx][ny].equals("D")) continue;
                if (distWater[nx][ny] != -1 && hedgehog[x][y] + 1 >= distWater[nx][ny]) continue;
                if (visit[nx][ny]) continue;


                hedgehog[nx][ny] = hedgehog[x][y] + 1;
                visit[nx][ny] = true;
                Q.offer(nx);
                Q.offer(ny);
            }
        }
    }

    static void waterBFS() {

        Queue<Integer> Q = new LinkedList<>();

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
               if (map[i][j].equals("*")) {
                   distWater[i][j] = 0;
                   visit[i][j] = true;
                   Q.offer(i);
                   Q.offer(j);
               } else {
                   distWater[i][j] = -1;
                   visit[i][j] = false;
               }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (!map[nx][ny].equals(".")) continue;
                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                distWater[nx][ny] = distWater[x][y] + 1;
                Q.offer(nx);
                Q.offer(ny);
            }
        }
    }

    static void input() throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        hedgehog = new int[R][C];
        distWater = new int[R][C];
        visit = new boolean[R][C];
        map = new String[R][C];

        for (int i=0; i<R; i++) {
            String mapWord = br.readLine();
            for (int j=0; j<C; j++) {
                map[i][j] = String.valueOf(mapWord.charAt(j));
            }
        }
    }
}
