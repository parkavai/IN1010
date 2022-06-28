import java.util.ArrayList;
import java.util.Arrays;

public class SubArray {

    public static void main(String[] args) {
        
        int[] array = new int[100];
        ArrayList<ArrayList<Integer>> liste = new ArrayList<>(); 
        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }
        int teller = 1;
        for (int i = 0; i < 10; i++){
            ArrayList<Integer> tall = new ArrayList<>();
            for (int s = 0; s <= array.length; s++){
                tall.add(s);
                if((s/10) == teller){
                    liste.add(tall);
                    teller++;
                    tall = new ArrayList<>();
                }   
            }
        }

        System.out.println(liste);
      


    }
    
}
