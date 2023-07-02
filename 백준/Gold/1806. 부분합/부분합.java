

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");

        int numberCount = Integer.parseInt(arr[0]);
        int compositionNumber = Integer.parseInt(arr[1]);

        int[] numArr = new int[numberCount + 1];

        for (int i=0; i<numberCount; i++) {
            numArr[i] = Integer.parseInt(arr2[i]);
        }

        System.out.println(solution(numberCount, compositionNumber, numArr));
    }

    static int solution(int numberCount, int compositionNumber, int[] numArr) {

        int lt = 0, rt = 0, answer = Integer.MAX_VALUE;
        int sum = numArr[rt];

        while (lt < numberCount && rt < numberCount) {

            if (sum >= compositionNumber) {
                answer = Math.min(rt - lt + 1, answer);
                sum -= numArr[lt++];
            } else {
                rt++;
                sum += numArr[rt];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
