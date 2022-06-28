public class Stringhjelper {

    public static void main(String[] args) {
        System.out.println(string("stein", "tei"));
        
    }
    
    static int string (String s, String t){
        int start = 0;
        int teller = 0;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(0)){
                start = i;
            }
            for(int l = 0; l < t.length(); l++){
                if(s.charAt(i) == t.charAt(l)) {
                    teller ++;
                    i++;
                }
                else {
                    break;
                }
            }
        }
        if(teller == t.length()){
            return start;
        }
        return -1;
    }
}
