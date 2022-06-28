public class SumDigits {

    public static void main(String[] args) {
        System.out.println(sumDigits(123));
    }

    static int sumDigits(int n){
        if(n < 1){
            return 0;
        }
        else {
            return (n % 10) + sumDigits(n/10);

        }
    }
    
}
