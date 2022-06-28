import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class TesteFil {

    public static void main(String[] args) throws Exception {
        Scanner fil = new Scanner(new File("Fil2.txt"));
        ArrayList<String> liste = new ArrayList<>();

        String linje = "";
        while(fil.hasNextLine()) {
            linje = fil.nextLine();
            int lengde = linje.length();
            for (int i = 0; i < lengde; i++){
                if (i == (lengde-1) || i == (lengde-2)) {
                    System.out.println("Kan ikke lage substring nå. ");
                }
                else {
                    String nySubStreng = linje.substring(i, (i+3));
                    if (!(liste.contains(nySubStreng))){
                        liste.add(nySubStreng);
                    }
                }
            }
        }
        System.out.println(liste);
    }
    
}
