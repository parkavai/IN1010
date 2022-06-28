public class StringClean {

    public static void main(String[] args) {
        System.out.println(stringClean("yyyxxxddd"));
    }

    static String stringClean(String str){
        if(str.length() <= 1){
            return str;
        }
        else if(str.charAt(0) == str.charAt(1)){
            return stringClean(str.substring(1));
        }
        else {
            return (str.charAt(0)) + stringClean(str.substring(1));
        }

    }

    /*
    static String stringClean(String str){
        String nystr = "";
        int indeks = 0;
        for(int i = 0; i < str.length(); i++){
            if(i == 0){
                nystr += str.charAt(i);
            }
            else if((nystr.charAt(indeks) != str.charAt(i))){
                nystr += str.charAt(i);
                indeks++;
            }  
        }
        return nystr;
    }
    */
    
}
