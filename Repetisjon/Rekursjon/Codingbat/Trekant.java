public class Trekant {
    public static void main(String[] args) {
        System.out.println(trekant(2));
    }
    static int trekant(int rad){
        if(rad == 0){
            return 0;
        }
        return rad + trekant(rad-1);
    }

}