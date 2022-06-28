import java.util.*;
public class Test {

    public static void main(String[] args) {
        les(5);

    }

    static void les(int tall){
        ArrayList<Integer> liste = new ArrayList<>();
        if (tall < 0) {
            return;
        }
        les(tall-1);
        liste.add(tall);
        System.out.println(liste);
    }
    
}
