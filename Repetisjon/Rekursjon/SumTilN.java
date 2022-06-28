class SumTilN {

    public static void main(String[] args) {
        System.out.println(sumTilN(10));
    }


    static int sumTilN(int n){
        if(n == 0){
            return 0;
        }
        return n + (sumTilN(n-1));
    }
}