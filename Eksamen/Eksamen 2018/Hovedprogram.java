import java.util.ArrayList;

public class Hovedprogram {

    public static void main(String[] args) {
        String monster = args[0];
        MistenkeligPersoner monitor = new MistenkeligPersoner();
        for(Flygning f: alleFlygninger()){
            Thread traad = new Thread(new Forstelinjevokter(f, monster, monitor));
            traad.start();
        }
        for(int i = 0; i < 100; i++){
            Thread traad = new Thread(new Andrelinjevokter(monitor);
            traad.start();
        }

        
    }
    
}
