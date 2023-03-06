import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arr = br.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		
		int[] intArr = new int[a];
		String[] StrArr = br.readLine().split(" ");
		
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(StrArr[i]);
		}
		
		for(int i=0; i<intArr.length; i++) {
			if(intArr[i] < b) {
				bw.write(intArr[i] + " ");
			}
			bw.flush();
		}

	}

}