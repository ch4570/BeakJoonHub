
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static List<List<Integer>> graph;
    static boolean[] checkArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.write("\n");
        bw.flush();

        sb = new StringBuilder();
    }

    static void solution() throws IOException {
        DFS(V);
        output();
        checkArr = new boolean[N + 1];
        BFS(V);
        output();
    }

    static void DFS(int L) {
        checkArr[L] = true;
        sb.append(L).append(" ");

        List<Integer> list = graph.get(L);

        for (int i=0; i<list.size(); i++) {
            int vertex = list.get(i);

            if (!checkArr[vertex]) {
                DFS(vertex);
            }
        }
    }

    static void BFS(int L) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(L);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            if (!checkArr[vertex])    {
                checkArr[vertex] = true;
                sb.append(vertex).append(" ");

                List<Integer> list = graph.get(vertex);

                for (int x : list) {
                    queue.offer(x);
                }
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        V = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList<>(N + 1);
        checkArr = new boolean[N + 1];

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(tokenizer.nextToken());
            int v2 = Integer.parseInt(tokenizer.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i=0; i<graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

    }


}
