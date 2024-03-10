import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> waitQ = new LinkedList<>();
        Queue<Integer> speedsQ = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            waitQ.offer(progresses[i]);
            speedsQ.offer(speeds[i]);
        }

        int deployCnt = 0;

        while (!waitQ.isEmpty()) {

            if (!(waitQ.peek() >= 100)) {
                int size = waitQ.size();
                for (int i=0; i<size; i++) {
                    int progress = waitQ.poll();
                    int speed = speedsQ.poll();

                    waitQ.offer(progress + speed);
                    speedsQ.offer(speed);
                }
            } else {
                boolean isBreak = false;

                while (!waitQ.isEmpty() && waitQ.peek() >= 100) {

                    waitQ.poll();
                    speedsQ.poll();
                    deployCnt++;
                }
            }


            if (deployCnt != 0) {
                answer.add(deployCnt);
                deployCnt = 0;
            }

        }

        return answer;
    }
}