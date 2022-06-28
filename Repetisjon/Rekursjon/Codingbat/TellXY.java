import java.util.ArrayList;

public class TellXY {

    public static void main(String[] args) {
        System.out.println(countYZ("ddddxxy"));
    }

    static int countYZ(String str) {
        int teller = 0;
        ArrayList<String> liste = new ArrayList<>();
        String ny = "";
        for(int i = 0; i < str.length(); i++){
            char tegn = str.charAt(i);
            if(Character.isLetter(tegn)){
            ny += tegn;
              if(i+1 == str.length()){
                liste.add(ny);
              }
            }
            else {
            liste.add(ny);
            ny = "";
            }
        }
        for(String s: liste){
            if(s.length() != 0){
               char tegn = s.charAt(s.length()-1);
                if(tegn == 'y' || (tegn == 'z')){
                  teller++;
                }
                else if(tegn == 'Y' || (tegn == 'Z')){
                  teller++;
                }
            }
        }
        return teller;
    }
    
}
