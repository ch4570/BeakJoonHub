import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 금액 입력
        int total = Integer.parseInt(br.readLine());

        // 계산된 금액
        int finalTotal = 0;

        // 케이스 수 입력
        int caseCnt = Integer.parseInt(br.readLine());

        for(int i=0; i<caseCnt; i++){
            // 상품 금액과 수량
            String[] price = br.readLine().split(" ");

            int productPrice = Integer.parseInt(price[0]);
            int cnt = Integer.parseInt(price[1]);
            for(int j=0; j<cnt; j++){
                finalTotal += productPrice;
            }
        }

        if(total==finalTotal){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}