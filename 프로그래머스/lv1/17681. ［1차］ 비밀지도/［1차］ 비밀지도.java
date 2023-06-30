class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 정답을 담을 배열 생성
        String[] answerArr = new String[n];
        String format = "%0" + n + "d";

        for (int i=0; i<n; i++) {
            // 첫번째 지도와 두번째 지도의 각 원소를 2진 문자열로 변환
            String firstMap = String.format(format, Long.parseLong(Long.toBinaryString(arr1[i])));
            String secondMap = String.format(format, Long.parseLong(Long.toBinaryString(arr2[i])));

            String answer = "";


            for (int j=0; j<firstMap.length(); j++) {
                if (firstMap.charAt(j) == '0' && secondMap.charAt(j) == '0') {
                    answer += " ";
                } else {
                    answer += "#";
                }
            }

            answerArr[i] = answer;
        }

        return answerArr;
    }
}