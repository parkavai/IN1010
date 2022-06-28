import java.util.*;

public class Aapning extends HvitRute {

    public Aapning(int rad, int kolonne, Labyrint labyrintRef){
        super(rad, kolonne,  labyrintRef);
    }
    
    // Legger til stien i arraylist av utveier skulle den stien komme frem til en åpning.
    @Override
    public void gaa(Rute komFra, ArrayList<Tuppel> sti) {
        komFra = null;
        super.gaa(komFra, sti);
        labyrintRef.leggTilSti(sti);
        return;
    }
    
    @Override
    public void finnUtvei(){
        return;
    }

    @Override
    public char tilTegn(){
        return '.'; 
    }   
}
