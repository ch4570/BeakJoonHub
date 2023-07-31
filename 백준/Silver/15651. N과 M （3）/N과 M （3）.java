import java.io.*;

public class Main {

    static int[] arr, answer;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        M = Integer.parseInt(inputArr[1]);

        arr = new int[N];
        answer = new int[M];

        for (int i=0; i<N; i++) {
            arr[i] = i+1;
        }


        DFS(0);

        bw.write(sb.toString());
        bw.flush();
    }

    static void DFS(int L) {
        if (L == M) {
            for (int x : answer) sb.append(x).append(" ");
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            answer[L] = arr[i];
            DFS(L + 1);
        }
    }
}
