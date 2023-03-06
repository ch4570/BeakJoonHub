import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] arr = new int[a];
		double[] arr2 = new double[a];
		double total = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = (double)arr[i];
		}
		
		OptionalInt opt = Arrays.stream(arr).max();
		int max = opt.getAsInt();
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = (arr2[i]/max)*100;
			total += arr2[i];
		}
		
		
		System.out.println(total/a);
		
	}
}