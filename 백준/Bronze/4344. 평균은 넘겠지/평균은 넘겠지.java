import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 0;
		int c = 0;
		int[] arr = new int[a];
		double[] arr2 = new double[a];
		double[] arr3 = new double[a];
		double[] arr4 = new double[a];
		int count = 0;
		for (int i = 0; i < a; i++) {
			b = sc.nextInt();
			arr = new int[b];
			for (int j = 0; j < b; j++) {
				c = sc.nextInt();
				arr[j] = c;
				arr2[i] += (double) arr[j];
				arr3[i] = (double) (arr2[i] / b);
				
			}

			for(int k=0; k<arr.length; k++) {
				if(arr[k] > arr3[i]) {
					count++;
				}
				double per = (double)100/b*count;
				arr4[i] = per;
			}
			count = 0;
		}
		for(int i=0; i<arr4.length; i++) {
			System.out.printf("%.3f%%\n",arr4[i]);
		}

	}

}