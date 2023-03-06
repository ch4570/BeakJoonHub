import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int b = Integer.parseInt(a);
		String c = br.readLine();
		
		int sum = 0;
		
		for(int i=0; i<b; i++) {
			char k = c.charAt(i);
			int f = Character.getNumericValue(k);
			sum += f;
		}
		
		System.out.println(sum);
	}
}