
import java.io.*;
import java.util.Arrays;

public class Main {

    static int N, ANSWER;
    static int[] QUEEN;

    public static void main(String[] args) throws IOException {
        input();
        solution(1);
        output();
    }

    static boolean attackAble(int row1, int col1, int row2, int col2) {
        if (col1 == col2) return true;
        if (row1 + col1 == row2 + col2) return true;
        if (row1 - col1 == row2 - col2) return true;
        return false;
    }

    static void solution(int row) {
        if (row == N + 1) {
            ANSWER++;
            return;
        }

        for (int i=1; i<=N; i++) {
            // Queen 을 놓을 수 있는지 검사

            boolean isValid = true;
            for (int j=1; j<=row-1; j++) {
                if (attackAble(row, i, j, QUEEN[j])) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                QUEEN[row] = i;
                solution(row + 1);
                QUEEN[row] = 0;
            }

        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        QUEEN = new int[N + 1];
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ANSWER));
        bw.flush();
    }
}
