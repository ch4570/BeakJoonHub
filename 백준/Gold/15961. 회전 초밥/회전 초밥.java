
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int D = Integer.parseInt(strArr[1]);
        int K = Integer.parseInt(strArr[2]);
        int C = Integer.parseInt(strArr[3]);

        int[] arr = new int[N];

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(arr, K, C, N));
    }
    static int solution(int[] arr, int K, int C, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        int rt = K;
        int max = Integer.MIN_VALUE;
        while (lt < N) {
            if (max <= map.size()) {
                if (!map.containsKey(C)) {
                    max = map.size() + 1;
                } else {
                    max = map.size();
                }
            }

            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            rt++;

            if (rt == N) {
                rt = 0;
            }

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }


        return max;
    }
}
