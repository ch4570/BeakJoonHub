import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // command 배열의 길이 만큼 정답 배열의 길이를 잡아준다.
        int[] answer = new int[commands.length];

        for (int i=0; i<commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int index = commands[i][2] - 1;

            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);

            answer[i] = arr[index];

        }

        return answer;
    }
}