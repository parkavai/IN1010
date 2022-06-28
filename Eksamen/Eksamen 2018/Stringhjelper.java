public class Stringhjelper {

    public static void main(String[] args) {

        System.out.println(inneholder("stein", "n"));
        
    }

    static int inneholder(String streng, String forekommer){
        int startIndeks = 0;
        int teller = 0;
        int indeksForekommer = 0;
        int vanlig = 0;
        while(vanlig != streng.length()){
            if(streng.charAt(vanlig) == forekommer.charAt(0)){
                startIndeks = vanlig;
            }
            if(indeksForekommer == forekommer.length()){
                break;
            }
            if(streng.charAt(vanlig) == forekommer.charAt(indeksForekommer)){
                teller++;
                indeksForekommer++;
            }
            vanlig++;
        }
        if(teller != forekommer.length()){
            startIndeks = -1;
        }

        return startIndeks;
        
    }
    
}
    

/*

    class Stringhjelper {
        static int inneholder(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        for (int is = 0; is <= sLen-tLen; is++) {
            boolean eq = true;
            for (int it = 0; it < tLen; it++) {
                if (s.charAt(is+it) != t.charAt(it)) {
                eq = false; break;
                }
            }
        if (eq) {
            return is;
        }
        return -1;
        }
        }


*/