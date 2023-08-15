import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> answer = new ArrayList<>();
    static boolean[][][] check = new boolean[201][201][201];
    static int[] Limit;

    public static void main(String[] args) throws IOException {
        input();
        BFS(0, 0, Limit[2]);
        output();
    }

    static void BFS(int a, int b, int c) {
        Queue<State> Q = new LinkedList<>();
        check[a][b][c] = true;
        Q.add(new State(new int[] {a, b, c}));

        while(!Q.isEmpty()) {
            State state = Q.poll();
            if (state.X[0] == 0) answer.add(state.X[2]);

            for (int from=0; from<3; from++) {
                for (int to=0; to<3; to++) {
                    if (from == to) continue;
                    State newState = state.move(from, to, Limit);
                    if (!check[newState.X[0]][newState.X[1]][newState.X[2]]) {
                        Q.add(newState);
                        check[newState.X[0]][newState.X[1]][newState.X[2]] = true;
                    }
                }
            }
        }

    }


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        Limit = new int[] {A, B, C};

        br.close();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Collections.sort(answer);

        for (int x : answer) sb.append(x).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}

class State {

    int[] X;

    public State(int[] _X) {
        this.X = _X.clone();
    }

    public State move(int from, int to, int[] Limit) {
        int[] X1 = X.clone();

        if (X[from] + X[to] >= Limit[to]) {
            X1[from] -= Limit[to] - X1[to];
            X1[to] = Limit[to];
        } else {
            X1[to] += X1[from];
            X1[from] = 0;
        }

        return new State(X1);
    }
}