import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[][] score) {
        
        int[] rankArr = new int[score.length];
        Double[] scoreAverage = new Double[score.length];



        for (int i=0; i<score.length; i++) {
            double average = 0;
            for (int j=0; j<score[i].length; j++) {
                average += score[i][j];
            }
            scoreAverage[i] = average / 2.0;
        }

        Double[] reverseArr = scoreAverage.clone();

        System.out.println(Arrays.toString(scoreAverage));


        Arrays.sort(reverseArr, Collections.reverseOrder());

        for (int i=0; i<scoreAverage.length; i++) {
            for (int j=0; j<scoreAverage.length; j++) {
                if (scoreAverage[i].equals(reverseArr[j])) {
                    rankArr[i] = (j + 1);
                    break;
                }
            }
        }


        return rankArr;
    }
}