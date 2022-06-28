public class ProduktTilN {

    public static void main(String[] args) {
        System.out.println(produktTilN(5));
    }

    static int produktTilN(int n){
        if (n == 1){
            return 1;
        }
        return n * produktTilN(n-1);
    }
}
