import java.util.ArrayList;

public class SortRute extends Rute{

    public SortRute(int rad, int kolonne, Labyrint labyrintRef){
        super(rad, kolonne,  labyrintRef);
    }
    
    // Skjører du gaa() metoden i en sortrute så skal du gå ut av metoden
    @Override
    public void gaa(Rute komFra, ArrayList<Tuppel> sti) {
        return;
    }

    @Override
    public void finnUtvei(){
        return;
    }

    @Override
    public char tilTegn(){
        return '#'; // returnerer tegnrepresentasjon for sorte ruter som er da punktum: "#"
    }
    
}
