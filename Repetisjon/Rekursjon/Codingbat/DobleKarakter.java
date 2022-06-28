public class DobleKarakter {

    public static void main(String[] args) {
        System.out.println(doubleChar("The"));
    }

    static String doubleChar(String str) {
      String nyStr = "";
      String[] liste = str.split("");
      for(int i = 0; i < liste.length; i++){
        String tegn = liste[i];
        tegn += tegn;
        nyStr += tegn;
      }
      return nyStr;
    }

    /*
    public String doubleChar(String str) {
      String result = "";
      for (int i = 0; i < str.length(); i++) {
        result = result + str.charAt(i) + str.charAt(i);
        // Alternately:
        // result = result + str.substring(i, i+1) + str.substring(i, i+1);
      }
      return result
    }


    */
    
}
