import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int max = 0;
		int min = 0;
		int[] arr = new int[a];
		for(int i=1; i<=a; i++) {
			int b = sc.nextInt();
			arr[(i-1)] = b;
		}
		OptionalInt max2 = Arrays.stream(arr).max();
		max = max2.getAsInt();
		OptionalInt min2 = Arrays.stream(arr).min();
		min = min2.getAsInt();
		
		System.out.println(min);
		System.out.println(max);
	}

}