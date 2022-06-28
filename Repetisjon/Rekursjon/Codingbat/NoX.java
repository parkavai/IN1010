public class NoX {
    
    public static void main(String[] args) {
        System.out.println(noX("xpix"));
    }

    static String noX(String str) {
        if(str.length() == 0){
            return str;
        }
        else if(str.charAt(0) == 'x'){
            return noX(str.substring(1));
        }
        else {
            char tegn = str.charAt(0);
            return tegn + noX(str.substring(1));
        }
    }
}
