
import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> list;
    static boolean[] visit;
    static int X, ANSWER = 0;

    public static void main(String[] args) throws IOException {
        input();
        DFS(X);
        output();
    }

    static void DFS(int x) {
       List<Integer> pointerList = list.get(x);
       visit[x] = true;
       if (pointerList.isEmpty()) return;


       for (int i=0; i<pointerList.size(); i++) {
           if (!visit[pointerList.get(i)]) {
               visit[pointerList.get(i)] = true;
               ANSWER++;
               DFS(pointerList.get(i));
           }
       }

    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ANSWER));

        bw.flush();
    }


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        visit = new boolean[N + 1];
        list = new ArrayList<>(N + 1);

        // 빈 리스트를 넣어준다.
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int prevNum = Integer.parseInt(tokenizer.nextToken());
            int workNum = Integer.parseInt(tokenizer.nextToken());

            list.get(workNum).add(prevNum);
        }


        tokenizer = new StringTokenizer(br.readLine());
        X = Integer.parseInt(tokenizer.nextToken());

    }
}

