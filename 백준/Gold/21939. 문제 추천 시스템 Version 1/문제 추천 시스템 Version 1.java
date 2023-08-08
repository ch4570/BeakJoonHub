
import java.io.*;
import java.util.*;

public class Main {

    static TreeSet<Problem> problems = new TreeSet<>();
    static Map<Integer, Problem> problemTreeMap = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(tokenizer.nextToken());

        for (int i=0; i<N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(tokenizer.nextToken());
            int L = Integer.parseInt(tokenizer.nextToken());

            Problem problem = new Problem(L, P);
            problems.add(problem);
            problemTreeMap.put(P, problem);
        }

        tokenizer = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(tokenizer.nextToken());

        for (int i=0; i<M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "add" :
                    add(tokenizer);
                    break;
                case "recommend" :
                    Problem problem = recommend(tokenizer);
                    sb.append(problem.getNumber()).append("\n");
                    break;
                default :
                    remove(tokenizer);
                    break;
            }

        }
    }

    private static void remove(StringTokenizer tokenizer) {

        int P = Integer.parseInt(tokenizer.nextToken());
        Problem problem = problemTreeMap.get(P);
        problems.remove(problem);
    }

    private static void add(StringTokenizer tokenizer) {
        int P = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());

        Problem problem = new Problem(L, P);
        problems.add(problem);
        problemTreeMap.put(P, problem);
    }

    private static Problem recommend(StringTokenizer tokenizer) {

        int J = Integer.parseInt(tokenizer.nextToken());

        if (J > 0) {
            return problems.last();
        } else {
            return problems.first();
        }
    }
}

class Problem implements Comparable<Problem> {
    private int level;
    private int number;

    public Problem(int level, int number) {
        this.level = level;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Problem o) {
        int result = Integer.compare(level, o.level);
        if (result == 0) result = Integer.compare(number, o.number);
        return result;
    }
}
