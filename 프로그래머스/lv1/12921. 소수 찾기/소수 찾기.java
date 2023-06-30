class Solution {
    public int solution(int n) {
        int count = 0;

        for (int i=2; i<=n; i++) {
            boolean isPrime = isPrime(i);
            if (isPrime) {
                count++;
            }
        }

        return count;
    }
    
    static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);

        boolean isPrime = true;

        for (int i=2; i<=sqrt; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}