import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] numArr = new int[num];
		
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = sc.nextInt();
		}
		
		Arrays.sort(numArr);
		
		for(int a : numArr) {
			System.out.println(a);
		}

	}

}