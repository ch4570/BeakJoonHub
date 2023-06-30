import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String maxString = "";
        int maxLength = 0;

        while(true) {
            String sentence = br.readLine();
            String[] words = sentence.trim().toLowerCase().split("[^a-z-]");

            for (int i=0; i<words.length; i++) {
                if (words[i].equals("e-n-d")){
                    System.out.println(maxString);
                    return;
                }

                if(maxLength < words[i].length()) {
                    maxLength = words[i].length();
                    maxString = words[i];
                }
            }
        }
    }


}
