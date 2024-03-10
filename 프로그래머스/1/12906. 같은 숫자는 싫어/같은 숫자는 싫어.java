import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();

        for (int number : arr) Q.offer(number);

        Integer prevNumber = null;

        while (!Q.isEmpty()) {
            int number = Q.poll();
            
            if (prevNumber == null) {
                answer.add(number);
                prevNumber = number;
            } else {
                if (prevNumber != number) {
                    prevNumber = number;
                    answer.add(number);
                }
            }
        }

        return answer;
    }
}