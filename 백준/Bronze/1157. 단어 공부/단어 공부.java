

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : word.toUpperCase().toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = 0;
        char answer = ' ';

        for (char ch : map.keySet()) {
            if (max < map.get(ch)) {
                max = map.get(ch);
                answer = ch;
            }
        }

        int count = 0;
        for (char ch : map.keySet()) {
            if (max == map.get(ch)) {
                count++;
            }

            if (count == 2) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
