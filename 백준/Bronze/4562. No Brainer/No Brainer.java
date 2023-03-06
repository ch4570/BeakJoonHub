import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String strNum = br.readLine();
		int num = Integer.parseInt(strNum);
		String result = "";
		
		for(int i=0; i<num; i++) {
			String[] brains = br.readLine().split(" ");
			int brain1 = Integer.parseInt(brains[0]);
			int brain2 = Integer.parseInt(brains[1]);
			
			if(brain1 >= brain2) {
				result += "MMM BRAINS\n";
			}else {
				result += "NO BRAINS\n";
			}
			
		}
		
		System.out.println(result);
	}

}