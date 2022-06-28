public class Telling {
    
    static void tellRekursivt(int n) {

        if (n == 0) System.out.println(n);
        else {
            tellRekursivt(n-1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        tellRekursivt(5);
    }
}