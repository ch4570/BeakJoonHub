import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split( " ");
        int perCnt = Integer.parseInt(arr[0]);
        int medal = Integer.parseInt(arr[1]);
        String[] arr2 = br.readLine().split(" ");
        Integer[] arr3 = new Integer[arr2.length];
        for(int i=0; i<arr2.length; i++){
            arr3[i] = Integer.parseInt(arr2[i]);
        }


        Arrays.sort(arr3, Collections.reverseOrder());

        System.out.println(arr3[medal-1]);
    }
}