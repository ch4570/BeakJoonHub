import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
	
			for (int i = 1; i <= a; i++) {

				for (int j = a - 1; j >= i; j--) {
					bw.write(" ");
				}

				for (int k = 1; k <= i; k++) {
					bw.write("*");
					bw.flush();
				}
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}

	
	}