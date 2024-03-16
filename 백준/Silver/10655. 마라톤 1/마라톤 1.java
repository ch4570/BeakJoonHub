import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] xArr, yArr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {
        // 모든 경로를 지났을때 가질 수 있는 가중치
        int totalSum = 0;

        for (int i=0; i<xArr.length-1; i++) {
            totalSum += Math.abs(xArr[i] - xArr[i+1]) + Math.abs(yArr[i] - yArr[i + 1]);
        }

        
        for (int i=1; i<xArr.length-1; i++) {
            /*
            *  전체 경로에서 한 체크포인트를 뛰어넘었을때 얼마나 비용이 드는지 확인
            *  -> (i-1) -> (i) + (i) -> (i+1) - (i-1) -> (i+1)
            * */
            int totalDiff = (Math.abs(xArr[i-1] - xArr[i]) + Math.abs(yArr[i-1] - yArr[i])) +
                    (Math.abs(xArr[i] - xArr[i+1]) + Math.abs(yArr[i] - yArr[i+1]))
                    - (Math.abs(xArr[i-1] - xArr[i+1]) + Math.abs(yArr[i-1]- yArr[i+1]));
            answer = Math.min(answer, totalSum - totalDiff);
        }

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받을 횟수
        int loopCnt = Integer.parseInt(br.readLine());

        // 좌표의 개수만큼 배열 초기화
        xArr = new int[loopCnt];
        yArr = new int[loopCnt];

        for (int i=0; i<loopCnt; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(tokenizer.nextToken());
            yArr[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}