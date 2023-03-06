import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
		String result = String.valueOf((a*b*c));
		int[] arr = new int[10];
		String str = "0123456789";
		
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<result.length(); j++) {
				if(str.charAt(i) == result.charAt(j)) {
					arr[i] += 1;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}