import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        if(num%4==0 && num%100!=0 || num%4==0 && num%400==0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}