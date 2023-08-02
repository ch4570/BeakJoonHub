
import java.util.*;

public class Main {
    static int[][] board;
    static int M, N, count, groundWidth = 0;
    static List<Integer> ground = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt();

        board = new int[M][N];

        for (int i=0; i<K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int j=y1; j<y2; j++) {
                for (int k=x1; k<x2; k++) {
                    board[j][k] = 1;
                }
            }
        }

        solution(board);

        Collections.sort(ground);

        System.out.println(count);
        for (int x : ground) System.out.print(x + " ");

    }

    static void solution(int[][] board) {
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] == 0) {
                    groundWidth = 1;
                    count++;
                    board[i][j] = 1;
                    DFS(i, j, board);
                    ground.add(groundWidth);
                }
            }
        }
    }

    static void DFS(int x, int y, int[][] board) {
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                groundWidth++;
                DFS(nx, ny, board);
            }
        }
    }


}
