import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		OptionalInt opt = Arrays.stream(arr).max();
		int max = opt.getAsInt();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == max) {
				result = (i+1);
			}
		}
		System.out.println(max);
		System.out.println(result);
		
	}

}
