import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Test 케이스의 수를 입력
        int testCnt = Integer.parseInt(br.readLine());

        // 출력할 문자열의 결과 초기화
        String result = "";


        for(int i=0; i<testCnt; i++){
            // 반복횟수와 문자열 입력
            String[] arr = br.readLine().split( " ");
            int cnt = Integer.parseInt(arr[0]);
            char[] charArr = arr[1].toCharArray();
            int loop = 0;
            for(int j=0; j< charArr.length; j++){
                for(int k=0; k< cnt; k++){
                    result += charArr[loop];
                }
                loop++;
                if(loop > charArr.length-1){
                    loop = charArr.length-1;
                }
            }
            System.out.println(result);
            result = "";
        }

    }
}
