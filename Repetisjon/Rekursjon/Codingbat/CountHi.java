public class CountHi {

    public static void main(String[] args) {
        System.out.println(countHi("hihixx"));
    }

    static int countHi(String str) {
        if (str.length() <= 1){
            return 0;
        }
        int count = 0;
        if (str.substring(0, 2).equals("hi")) {
            count = 1;  // could use startsWith(;
        }
        return count + countHi(str.substring(1));
    }
}